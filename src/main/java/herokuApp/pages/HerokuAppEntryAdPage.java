package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HerokuAppEntryAdPage extends HerokuAppTestBase {
    @FindBy(css = "#restart-ad")
    WebElement restartAdButton;
    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div[2]/p")
    WebElement modalWindowText;
    @FindBy(css = "#modal > div.modal > div.modal-title")
    WebElement modalWindow;
    @FindBy (css = "#modal > div.modal > div.modal-footer > p")
    WebElement modalWindowClose;

    public HerokuAppEntryAdPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateEntryAd(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> modalWindow.isDisplayed() ? modalWindow : null);
        logger.info("Modal window text is - "+modalWindowText.getText());
        wait.until(driver -> modalWindowClose.isDisplayed() ? modalWindowClose : null).click();
        return restartAdButton.isDisplayed();
    }
}
