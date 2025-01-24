package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.IOException;

public class HerokuAppInputsPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > div > div > input[type=number]")
    WebElement inputField;


    public HerokuAppInputsPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateInput () throws InterruptedException, IOException, UnsupportedFlavorException {
        String fieldValue = "";
        //Send a number
        inputField.sendKeys("10");
        //Modify using arrow keys
        inputField.sendKeys(Keys.ARROW_UP);
        Thread.sleep(1000);

        //Select the new number
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
        //Copy the number
        inputField.sendKeys(Keys.CONTROL,"c");
        Thread.sleep(1000);

        // Get text from clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            fieldValue = (String) transferable.getTransferData(DataFlavor.stringFlavor);
        } else {
            fieldValue = "Clipboard content not available.";
        }

        return fieldValue.equals("11");
    }

}
