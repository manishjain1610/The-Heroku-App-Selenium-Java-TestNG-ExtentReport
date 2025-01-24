package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class HerokuAppInfiniteScrollPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > h3")
    WebElement infiniteScrollHeader;

    public HerokuAppInfiniteScrollPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateInfiniteScroll () throws InterruptedException {
        Actions action = new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        return infiniteScrollHeader.isDisplayed();
    }
}
