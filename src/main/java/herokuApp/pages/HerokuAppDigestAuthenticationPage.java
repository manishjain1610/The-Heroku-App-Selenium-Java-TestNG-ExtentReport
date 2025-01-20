package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppDigestAuthenticationPage extends HerokuAppTestBase {
    @FindBy(css = "#content > div > p")
    WebElement successfulLoginText;

    public HerokuAppDigestAuthenticationPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public String validateDigestAuthLogin ()
    {
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
        return successfulLoginText.getText();
    }
}
