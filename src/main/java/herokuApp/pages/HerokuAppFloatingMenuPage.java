package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HerokuAppFloatingMenuPage extends HerokuAppTestBase {
    @FindBy (css = "#menu > ul > li:nth-child(1) > a")
    WebElement menuBar;

    public HerokuAppFloatingMenuPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateFloatingMenu () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get the initial Y position of the menubar
        //Point initialPosition = menuBar.getLocation();
        //int initialY = initialPosition.getY();

        // Scroll down the page
        js.executeScript("window.scrollBy(0, 250)");

        Thread.sleep(2000);
        // Get the menubar's position after scrolling
        //Point newPosition = menuBar.getLocation();
        //int newY = newPosition.getY();

        //System.out.println("Initial Y is "+initialY+" and new Y is "+newY);
        //return initialY == newY;

        return menuBar.getCssValue("position").equals("fixed");
    }
}
