package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppBasicAuthPage extends HerokuAppTestBase {
    @FindBy(css = "body")
    WebElement notAuthorizedText;
    @FindBy(css = "#content > div > p")
    WebElement successfulLoginText;

    public HerokuAppBasicAuthPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public String validateLogin ()
    {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        return successfulLoginText.getText();

    }

    public String validateCancelLogin () throws InterruptedException {
        driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        return notAuthorizedText.getText();
    }
}
