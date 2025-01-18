package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HerokuAppContextMenuPage extends HerokuAppTestBase {

    @FindBy(css = "#hot-spot")
    WebElement contextMenu;
    @FindBy(css = "#checkboxes > input[type=checkbox]:nth-child(3)")
    WebElement checkBox2;

    public HerokuAppContextMenuPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateAlertForContextMenu() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(contextMenu).perform();
        act.contextClick().perform();
        Thread.sleep(1000);
        Alert popup;
        try {
            popup = driver.switchTo().alert();
            Thread.sleep(1000);
        }
        catch (NoAlertPresentException e){
            return false;
        }
        popup.accept();
        return true;
    }
}
