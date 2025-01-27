package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppNestedFramesPage extends HerokuAppTestBase {
    @FindBy (xpath = "(//frame)[1]")
    WebElement leftFrame;
    @FindBy (xpath = "(//frame)[2]")
    WebElement middleFrame;
    @FindBy (xpath = "//frame[@name='frame-top']//frameset[@name='frameset-middle']//frame[@name='frame-right']")
    WebElement rightFrame;
    @FindBy (xpath = "//frame[@src='/frame_bottom']")
    WebElement bottomFrame;

    public HerokuAppNestedFramesPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateIndependentNestedFrames () {
        //driver.switchTo().defaultContent();
        //driver.switchTo().frame("frame-top");

        try {
            leftFrame(driver);
            middleFrame(driver);
        //    rightFrame(driver);
            bottomFrame(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void leftFrame(WebDriver driver ) throws InterruptedException {
        //Switch to Left Frame
        driver.switchTo().frame(leftFrame);
        driver.switchTo().defaultContent();
    }

    private void middleFrame(WebDriver driver ) {
        //Switch to Middle Frame
        driver.switchTo().frame(middleFrame);
        driver.switchTo().parentFrame();
    }

    private void rightFrame(WebDriver driver ) {
        //Switch to Right Frame

        driver.switchTo().frame(rightFrame);
        driver.switchTo().parentFrame();
    }

    private void bottomFrame(WebDriver driver ) {
        //Switch to Bottom Frame
        driver.switchTo().frame(bottomFrame);
        driver.switchTo().defaultContent();
    }
}
