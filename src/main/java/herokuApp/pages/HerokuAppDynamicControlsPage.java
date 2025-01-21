package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class HerokuAppDynamicControlsPage extends HerokuAppTestBase {
    @FindBy(css = "#checkbox-example > button")
    WebElement addRemoveButton;
    @FindBy(css = "#checkbox")
    WebElement checkbox;
    @FindBy(css = "#input-example > input[type=text]")
    WebElement enableDisableText;
    @FindBy(css = "#input-example > button")
    WebElement enableDisableButton;
    @FindBy (css = "#message")
    WebElement itsGoneMessage;

    public HerokuAppDynamicControlsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateDynamicControls(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> checkbox.isDisplayed() ? checkbox : null).click();
        wait.until(driver -> addRemoveButton.isDisplayed() ? addRemoveButton : null).click();

        wait.until(driver -> itsGoneMessage.isDisplayed() ? itsGoneMessage : null);
        Assert.assertFalse(enableDisableText.isEnabled());
        wait.until(driver -> enableDisableButton.isDisplayed() ? enableDisableButton : null).click();
        wait.until(driver -> enableDisableText.isEnabled() ? enableDisableText : null);
        return (enableDisableText.isEnabled());
    }
}
