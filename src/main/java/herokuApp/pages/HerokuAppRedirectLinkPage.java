package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HerokuAppRedirectLinkPage extends HerokuAppTestBase {
    @FindBy (css = "#redirect")
    WebElement redirectLink;
    @FindBy (css = "#content > div > ul > li:nth-child(1) > a")
    WebElement statusCode200;
    @FindBy (css = "#content > div > ul > li:nth-child(2) > a")
    WebElement statusCode301;
    @FindBy (css = "#content > div > ul > li:nth-child(3) > a")
    WebElement statusCode404;
    @FindBy (css = "#content > div > ul > li:nth-child(4) > a")
    WebElement statusCode500;
    @FindBy (css = "#content > div > p")
    WebElement statusCodeResponse;
    @FindBy (css = "#content > div > p > a")
    WebElement backToRedirectPage;

    public HerokuAppRedirectLinkPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateRedirectLink (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        redirectLink.click();

        //Check status code 200
        wait.until(ExpectedConditions.visibilityOf(statusCode200));
        statusCode200.click();
        wait.until(ExpectedConditions.visibilityOf(statusCodeResponse));
        logger.info(statusCodeResponse.getText());
        if (!statusCodeResponse.getText().contains("This page returned a 200 status code."))
            return false;
        backToRedirectPage.click();

        //Check status code 301
        wait.until(ExpectedConditions.visibilityOf(statusCode301));
        statusCode301.click();
        wait.until(ExpectedConditions.visibilityOf(statusCodeResponse));
        logger.info(statusCodeResponse.getText());
        if (!statusCodeResponse.getText().contains("This page returned a 301 status code."))
            return false;
        backToRedirectPage.click();

        //Check status code 404
        wait.until(ExpectedConditions.visibilityOf(statusCode404));
        statusCode404.click();
        wait.until(ExpectedConditions.visibilityOf(statusCodeResponse));
        logger.info(statusCodeResponse.getText());
        if (!statusCodeResponse.getText().contains("This page returned a 404 status code."))
            return false;
        backToRedirectPage.click();

        //Check status code 500
        wait.until(ExpectedConditions.visibilityOf(statusCode500));
        statusCode500.click();
        wait.until(ExpectedConditions.visibilityOf(statusCodeResponse));
        logger.info(statusCodeResponse.getText());
        return statusCodeResponse.getText().contains("This page returned a 500 status code.");
    }

}
