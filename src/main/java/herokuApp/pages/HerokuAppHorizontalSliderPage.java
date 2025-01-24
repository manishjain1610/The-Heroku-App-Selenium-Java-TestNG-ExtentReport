package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppHorizontalSliderPage extends HerokuAppTestBase {
    @FindBy (css = "#content > div > div > input[type=range]")
    WebElement horizontalSlider;
    @FindBy (css = "#range")
    WebElement sliderValue;


    public HerokuAppHorizontalSliderPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateHorizontalSlider() throws InterruptedException {
        horizontalSlider.click();
        for (int i = 1; i <=10 ; i++) {
            Thread.sleep(500);
            horizontalSlider.sendKeys(Keys.ARROW_RIGHT);
        }
        logger.info("Slider value is "+sliderValue.getText());
        return sliderValue.getText().equals("5");
    }
}
