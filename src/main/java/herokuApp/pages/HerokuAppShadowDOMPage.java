package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppShadowDOMPage extends HerokuAppTestBase {
    @FindBy (css = "#content > my-paragraph:nth-child(4) > span")
    WebElement textField;
    @FindBy (css = "#content > my-paragraph:nth-child(5) > ul")
    WebElement textInList;

    public HerokuAppShadowDOMPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateShadowDOM () {
        if (!textField.getText().contains("Let's have some different text!"))
                return false;
        return textInList.getText().contains("Let's have some different text!\n" +
                "In a list!");
    }
}
