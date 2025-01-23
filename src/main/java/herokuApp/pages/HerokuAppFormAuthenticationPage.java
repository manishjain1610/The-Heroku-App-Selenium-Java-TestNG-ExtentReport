package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppFormAuthenticationPage extends HerokuAppTestBase {
    @FindBy (css = "#username")
    WebElement usernameField;
    @FindBy (css = "#password")
    WebElement passwordField;
    @FindBy (css = "#login > button > i")
    WebElement loginButton;
    @FindBy (css = "#content > div > h4")
    WebElement welcomeMessage;

    public HerokuAppFormAuthenticationPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateFormAuthentication(){
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        return welcomeMessage.isDisplayed();
    }
}
