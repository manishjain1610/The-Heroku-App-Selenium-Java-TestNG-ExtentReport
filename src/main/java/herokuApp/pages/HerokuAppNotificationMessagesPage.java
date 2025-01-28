package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppNotificationMessagesPage extends HerokuAppTestBase {
    @FindBy(css = "#flash")
    WebElement notificationMessage;

    public HerokuAppNotificationMessagesPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateNotificationMessage () {
        logger.info(notificationMessage.getText());
        return (notificationMessage.getText().contains("Action successful") || notificationMessage.getText().contains("Action unsuccesful, please try again"));
    }
}
