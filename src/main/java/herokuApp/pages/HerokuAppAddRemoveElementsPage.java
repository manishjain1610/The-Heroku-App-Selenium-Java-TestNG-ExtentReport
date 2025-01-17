package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HerokuAppAddRemoveElementsPage extends HerokuAppTestBase {
    @FindBy(css = "#content > h3")
    WebElement addRemoveElementsHeader;
    @FindBy(css = "#content > div > button")
    WebElement addRemoveElementsButton;
    @FindBy(css = "#elements > button")
    WebElement deleteButton;

    public HerokuAppAddRemoveElementsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String validateAddRemoveElementsPageHeader(){
        return this.addRemoveElementsHeader.getText();
    }

    public boolean validateElementAddition() throws InterruptedException {
        System.out.println("Inside ele add");
        Assert.assertTrue(this.addRemoveElementsButton.isEnabled());
        this.addRemoveElementsButton.click();
        System.out.println("ele added");
        Thread.sleep(1000);
        return (this.deleteButton.isDisplayed()) && (this.deleteButton.isEnabled());
    }

    public boolean validateElementDeletion() {
        System.out.println("inside ele del");
        Assert.assertTrue(this.addRemoveElementsButton.isEnabled());
        this.addRemoveElementsButton.click();
        System.out.println("Add element to be deleted");
        Assert.assertTrue(this.deleteButton.isEnabled());
        System.out.println("About to delete ele");
        this.deleteButton.click();
        System.out.println("Deleted button");
        return driver.findElements(By.cssSelector("#elements > button")).isEmpty();
    }
}
