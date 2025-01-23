package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppForgotPasswordPage extends HerokuAppTestBase {
    @FindBy (css = "#email")
    WebElement emailField;
    @FindBy (css = "#form_submit > i")
    WebElement retrievePasswordButton;
    @FindBy (css = "body > h1")
    WebElement newPageBody;

    public HerokuAppForgotPasswordPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validatePasswordRetrieval () {
        String emailId = "test@gmail.com";
        emailField.sendKeys(emailId);
        retrievePasswordButton.click();
        return newPageBody.isDisplayed();
    }
}
