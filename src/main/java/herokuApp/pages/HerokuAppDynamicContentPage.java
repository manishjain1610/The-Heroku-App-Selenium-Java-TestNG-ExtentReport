package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HerokuAppDynamicContentPage extends HerokuAppTestBase {
    @FindBy(linkText = "click here")
    WebElement clickerButton;


    public HerokuAppDynamicContentPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateDynamicContent(){
        clickerButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement dynamicContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='large-10 columns']")));
        String initialText = dynamicContent.getText();

        clickerButton.click();
        // Wait for the page to reload again
        wait.until(ExpectedConditions.stalenessOf(dynamicContent));
        WebElement newDynamicContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='large-10 columns']")));

        // Store the text of the first paragraph after clicking the link
        String newText = newDynamicContent.getText();

        // Validate if the text has changed
        if (!initialText.equals(newText)) {
            logger.info("Content has changed successfully.");
            return false;
        } else {
            logger.info("Content did not change.");
            return true;
        }
    }
}
