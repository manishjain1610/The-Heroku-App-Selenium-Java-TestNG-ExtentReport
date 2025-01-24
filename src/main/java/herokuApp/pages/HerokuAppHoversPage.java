package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HerokuAppHoversPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > div:nth-child(3) > img")
    WebElement firstImage;
    @FindBy (css = "#content > div > div:nth-child(3) > div > a")
    WebElement viewProfile;
    @FindBy (css = "#content > div > div:nth-child(3) > div > h5")
    WebElement name;

    public HerokuAppHoversPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateHovers () throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(firstImage).perform();
        Thread.sleep(500);
        Assert.assertTrue(viewProfile.isDisplayed());
        logger.info("First user's name is "+name.getText());
        return name.getText().equals("name: user1");
    }
}
