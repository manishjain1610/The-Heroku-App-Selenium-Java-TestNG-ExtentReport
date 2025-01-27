package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class HerokuAppKeyPressesPage extends HerokuAppTestBase {
    @FindBy (css = "#target")
    WebElement targetField;
    @FindBy (css = "#result")
    WebElement resultField;

    public HerokuAppKeyPressesPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateKeyPresses () throws InterruptedException {
        Robot robotKeys;
        try {
            robotKeys = new Robot();
            robotKeys.keyPress(KeyEvent.VK_H);
            robotKeys.delay(500);
            Assert.assertEquals(resultField.getText().substring(13),"H");
            robotKeys.keyPress(KeyEvent.VK_ENTER);
            robotKeys.keyRelease(KeyEvent.VK_ENTER);
            Assert.assertEquals(resultField.getText().substring(13),"ENTER");
            robotKeys.delay(500);
            robotKeys.keyPress(KeyEvent.VK_ESCAPE);
            robotKeys.keyRelease(KeyEvent.VK_ESCAPE);
            Assert.assertEquals(resultField.getText().substring(13),"ESCAPE");
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        targetField.sendKeys("Hello From Manish.");
        Thread.sleep(500);
        Assert.assertEquals(resultField.getText().substring(13),"PERIOD");
        return true;
    }
}
