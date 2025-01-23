package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HerokuAppFramesPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > ul > li:nth-child(1) > a")
    WebElement nestedFrames;
    @FindBy (css = "#content > div > ul > li:nth-child(2) > a")
    WebElement iFrame;
    @FindBy (css = "body")
    WebElement leftFrame;

    @FindBy (xpath = "/html/body/div[4]/div/div/button")
    WebElement iFrameButton;

    public HerokuAppFramesPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateNestedFrames (){
        nestedFrames.click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        return (leftFrame.getText().equals("LEFT"));
    }

    public boolean validateiFrame (){
        iFrame.click();
        return (iFrameButton.isDisplayed());
    }
}
