package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class HerokuAppMultipleWindowsPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > a")
    WebElement clickHereButton;
    @FindBy (css = "#form_submit > i")
    WebElement retrievePasswordButton;
    @FindBy (css = "body > h1")
    WebElement newPageBody;

    public HerokuAppMultipleWindowsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateMultipleWindows () throws InterruptedException {

        String parentWindow = driver.getWindowHandle();
        clickHereButton.click();
        Thread.sleep(1000);
        Set<String> childWindows = driver.getWindowHandles();

        for (String child_window : childWindows) {
            if (!parentWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
                logger.info("Opened New Window titled - " + driver.switchTo().window(child_window).getTitle());
            }
        }
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(parentWindow);
        return true;
    }
}
