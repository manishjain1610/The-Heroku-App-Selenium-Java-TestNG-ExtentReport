package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HerokuAppSlowResourcesPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > h3")
    WebElement slowResourcesHeader;

    public HerokuAppSlowResourcesPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateSlowResources () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(slowResourcesHeader));
        return slowResourcesHeader.isDisplayed();
    }
}
