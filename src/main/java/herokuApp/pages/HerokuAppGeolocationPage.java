package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppGeolocationPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > button")
    WebElement whereAmIButton;
    @FindBy (css = "#lat-value")
    WebElement latitude;
    @FindBy (css = "#long-value")
    WebElement longitude;

    public HerokuAppGeolocationPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateGeolocationOutput (){
        whereAmIButton.click();
        logger.info("Latitude is "+latitude.getText()+ " and longitude is "+longitude.getText());
        return (latitude.isDisplayed() && longitude.isDisplayed());
    }
}
