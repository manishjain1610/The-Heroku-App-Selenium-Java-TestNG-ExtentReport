package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;
//import org.openqa.selenium.interactions.Actions;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.io.IOException;
//import java.util.List;

public class HerokuAppChallengingDOMPage extends HerokuAppTestBase {
    @FindBy(xpath = "//a[@class='button']")
    WebElement button;
    @FindBy(xpath = "//a[@class='button alert']")
    WebElement buttonAlert;
    @FindBy(xpath = "//a[@class='button success']")
    WebElement buttonSuccess;
    @FindBy(xpath = "//*[@id=\"canvas\"]")
    WebElement canvas;

    public HerokuAppChallengingDOMPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String validateCanvasElement(){
        button.click();
        buttonAlert.click();
        buttonSuccess.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script =
                "var canvas = arguments[0];" +
                        "var ctx = canvas.getContext('2d');" +
                        "var text = ''; " +
                        "if (ctx) { text = ctx.getImageData(0, 0, canvas.width, canvas.height); } " +
                        "return text;";

        return Objects.requireNonNull(js.executeScript(script, canvas)).toString();
        }
}
