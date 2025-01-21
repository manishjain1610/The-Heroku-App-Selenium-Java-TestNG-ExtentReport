package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HerokuAppDynamicLoadingPage extends HerokuAppTestBase {
    @FindBy(css = "#content > div > a:nth-child(5)")
    WebElement example1Button;
    @FindBy(css = "#content > div > a:nth-child(8)")
    WebElement example2Button;
    @FindBy(css = "#start > button")
    WebElement startButton;
    @FindBy (css = "#finish > h4")
    WebElement helloWorldText;

    public HerokuAppDynamicLoadingPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateDynamicLoadingElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> example1Button.isDisplayed() ? example1Button : null).click();
        wait.until(driver -> startButton.isDisplayed() ? startButton : null).click();
        wait.until(driver -> helloWorldText.isDisplayed() ? helloWorldText : null);

        driver.navigate().back();
        wait.until(driver -> example2Button.isDisplayed() ? example2Button : null).click();
        wait.until(driver -> startButton.isDisplayed() ? startButton : null).click();
        wait.until(driver -> helloWorldText.isDisplayed() ? helloWorldText : null);
        return helloWorldText.isDisplayed();
    }
}
