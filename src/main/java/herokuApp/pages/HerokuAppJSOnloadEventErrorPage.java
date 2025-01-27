package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HerokuAppJSOnloadEventErrorPage extends HerokuAppTestBase {
    @FindBy (xpath = "/html/body/p")
    WebElement onloadErrorField;

    public HerokuAppJSOnloadEventErrorPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateJSOnloadEventErrors () {
        Assert.assertEquals(onloadErrorField.getText(), "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
        return true;
    }
}
