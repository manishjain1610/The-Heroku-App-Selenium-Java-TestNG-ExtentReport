package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HerokuAppShiftingContentPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > a:nth-child(3)")
    WebElement menuElementLink;
    @FindBy (css = "#content > div > a:nth-child(6)")
    WebElement imageLink;
    @FindBy (css = "#content > div > a:nth-child(9)")
    WebElement listLink;
    @FindBy (css = "#content > div > ul > li:nth-child(5) > a")
    WebElement galleryShiftingContent;
    @FindBy (css = "#content > div > img")
    WebElement imageShiftingContent;
    @FindBy (css = "#content > div > div > div")
    WebElement listShiftingContent;

    public HerokuAppShiftingContentPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateShiftingContent () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        menuElementLink.click();
        wait.until(ExpectedConditions.visibilityOf(galleryShiftingContent));
        if (!galleryShiftingContent.isDisplayed())
            return false;

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(imageLink));
        imageLink.click();
        wait.until(ExpectedConditions.visibilityOf(imageShiftingContent));
        if (!imageShiftingContent.isDisplayed())
            return false;

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(listLink));
        listLink.click();
        wait.until(ExpectedConditions.visibilityOf(listShiftingContent));
        return listShiftingContent.isDisplayed();
    }
}
