package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;

public class HerokuAppDisappearingElementsPage extends HerokuAppTestBase {

    @FindBy(css = "#content > div > ul > li:nth-child(1) > a")
    WebElement HomeButton;
    @FindBy(css = "#content > div > ul > li:nth-child(2) > a")
    WebElement AboutButton;
    @FindBy(css = "#content > div > ul > li:nth-child(3) > a")
    WebElement ContactUsButton;
    @FindBy(css = "#content > div > ul > li:nth-child(4) > a")
    WebElement PortfolioButton;
    @FindBy(css = "#content > div > ul > li:nth-child(5) > a")
    WebElement GalleryButton;

    public HerokuAppDisappearingElementsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateAllButtonsPresent(){
        return HomeButton.isDisplayed() && AboutButton.isDisplayed() && PortfolioButton.isDisplayed() && ContactUsButton.isDisplayed();
    }

    public boolean validateGalleryButtonPresence() throws InterruptedException {
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        while (!GalleryButton.isDisplayed()){
            driver.navigate().refresh();
            Thread.sleep(1000);
    //        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > div > ul > li:nth-child(5) > a")));
        }
        return GalleryButton.isDisplayed();
    }
}
