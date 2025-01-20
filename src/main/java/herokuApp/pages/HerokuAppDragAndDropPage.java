package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class HerokuAppDragAndDropPage extends HerokuAppTestBase {
    @FindBy(css = "#column-a")
    WebElement elementA;
    @FindBy(css = "#column-a > header")
    WebElement elementAHeader;

    @FindBy(css = "#column-b")
    WebElement elementB;

    public HerokuAppDragAndDropPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateDragAndDrop(){
        Actions action = new Actions(driver);

        logger.info("Initial first element's header is "+ elementAHeader.getText());
        action.dragAndDrop(elementA, elementB).perform();

        logger.info("After dragging and dropping the element header is "+ elementAHeader.getText());
        return elementAHeader.getText().equals("B");
    }
}
