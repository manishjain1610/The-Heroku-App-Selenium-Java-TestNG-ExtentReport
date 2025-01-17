package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.regex.Pattern;


public class HerokuAppABTestingPage extends HerokuAppTestBase {
    @FindBy(css = "#content > div > h3")
    WebElement abTestingHeader;
    @FindBy(css = "#content > div > p")
    WebElement abTestingMessage;
    String regex = "A/B Test Variation 1|A/B Test Control";


    public HerokuAppABTestingPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String validateABTestingPageURL(){
        return driver.getCurrentUrl();
    }

    public boolean validateABTestingPage()
    {
        //const regex = new RegExp(`${abTestingHeaderTextA}|${abTestingHeaderTextB}`);
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        String resultHeader = this.abTestingHeader.getText();
        System.out.println("The AB Testing header is - "+resultHeader);
        return pattern.matcher(resultHeader).matches();
    }

    public String validateABTestingMessage()
    {
        return this.abTestingMessage.getText();
    }
}
