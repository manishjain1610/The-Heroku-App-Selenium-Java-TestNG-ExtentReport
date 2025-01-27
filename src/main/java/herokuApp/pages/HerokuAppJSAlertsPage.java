package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;

public class HerokuAppJSAlertsPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > ul > li:nth-child(1) > button")
    WebElement jsAlert;
    @FindBy (css = "#content > div > ul > li:nth-child(2) > button")
    WebElement jsConfirm;
    @FindBy (css = "#content > div > ul > li:nth-child(3) > button")
    WebElement jsPrompt;

    public HerokuAppJSAlertsPage()
    {
        PageFactory.initElements(driver, this);
    }

    private void JSAlert(){
        jsAlert.click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
    }

    private void JSConfirm() throws InterruptedException {
        //Accept the popup
        jsConfirm.click();
        Thread.sleep(1000);
        Alert popup = driver.switchTo().alert();
        popup.accept();

        //Dismiss the popup
        jsConfirm.click();
        Thread.sleep(1000);
        Alert popup_again = driver.switchTo().alert();
        popup_again.dismiss();
    }

    private void JSPrompt () throws InterruptedException {
        jsPrompt.click();
        Thread.sleep(1000);
        Alert popup = driver.switchTo().alert();
        popup.sendKeys("Accept the popup!!!");
        popup.accept();

        //cancel the popup
        jsPrompt.click();
        Thread.sleep(1000);
        Alert popup_again = driver.switchTo().alert();
        popup_again.sendKeys("Don't Accept the popup!!!");
        popup_again.dismiss();
    }

    public boolean validateJSAlerts () throws InterruptedException {
        JSAlert();
        JSConfirm();
        JSPrompt();
        return true;
    }
}
