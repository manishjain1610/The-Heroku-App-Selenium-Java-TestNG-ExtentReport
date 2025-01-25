package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppJQueryUIMenuPage extends HerokuAppTestBase {
    @FindBy (css = "#ui-id-3 > a")
    WebElement enabledOption;
    @FindBy (css = "#ui-id-1 > a")
    WebElement disabledOption;
    @FindBy (css = "body > h1")
    WebElement newPageBody;

    public HerokuAppJQueryUIMenuPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateJQueryUIMenu (){
        return true;
    }
}
