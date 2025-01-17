package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.interactions.Actions;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.util.List;

public class HerokuAppBrokenImagesPage extends HerokuAppTestBase {
    @FindBy(css = "#content > div > h3")
    WebElement brokenImagesHeader;
    @FindBy(css = "#content > div > img:nth-child(2)")
    WebElement brokenImage1;
    @FindBy(css = "#content > div > img:nth-child(3)")
    WebElement brokenImage2;
    @FindBy(css = "#content > div > img:nth-child(4)")
    WebElement correctImage;


    public HerokuAppBrokenImagesPage()
    {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateIfImageIsBroken() {
//        Actions action = new Actions(driver);
//        action.contextClick(this.brokenImage1).perform();
//        String imgURL1 = this.brokenImage1.getDomAttribute("src");
//        System.out.println("imgURL is "+imgURL1);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement img : images) {
            String imageUrl = img.getDomAttribute("src");
            System.out.println("Validating image: " + imageUrl);
            try {
                assert imageUrl != null;
                HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode != 200) {
                    System.out.println("Broken image: " + imageUrl + " - Response code: " + responseCode);
                } else {
                    System.out.println("Valid image: " + imageUrl + " - Response code: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error checking image: " + imageUrl);
                e.getMessage();
            }
        }
        return true;
    }
}
