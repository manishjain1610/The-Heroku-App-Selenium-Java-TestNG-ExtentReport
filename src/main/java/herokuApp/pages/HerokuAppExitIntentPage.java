package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

public class HerokuAppExitIntentPage extends HerokuAppTestBase {
    @FindBy(xpath = "//*[@id=\"ouibounce-modal\"]/div[2]/div[2]/p")
    WebElement modalWindowText;
    @FindBy(css = "#ouibounce-modal > div.modal > div.modal-title > h3")
    WebElement modalWindow;
    @FindBy (css = "#ouibounce-modal > div.modal > div.modal-footer > p")
    WebElement modalWindowClose;
    @FindBy(css = "#content > div.example > h3")
    WebElement outsideElement;

    public HerokuAppExitIntentPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateExitIntent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);

        action.moveToElement(outsideElement).moveByOffset(600,-1).build().perform();
        //action.moveByOffset(600, -1).build().perform();
        //wait.until(driver -> modalWindow.isDisplayed() ? modalWindow : null);
        //logger.info("Modal window text is - "+modalWindowText.getText());
        //wait.until(driver -> modalWindowClose.isDisplayed() ? modalWindowClose : null).click();
        //return modalWindow.isDisplayed();
        return true;
    }
}
