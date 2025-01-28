package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.Objects;
import java.util.List;


public class HerokuAppSecureFileDownloadPage extends HerokuAppTestBase {
    @FindAll({@FindBy(xpath = "//a")})
    List<WebElement> links;
    @FindBy (css = "#content > div > h3")
    WebElement secureFilePage;

    public HerokuAppSecureFileDownloadPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateSecureFileDownload () throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokuapp.com/download_secure");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(secureFilePage));
        boolean fileDownloadCheck = false;
//        for (int i = 1; i < links.size()-1; i++){     // Use this line for all files. Below line to just test 2 files.
        for (int i = 1; i < 3; i++){
            links.get(i).click();
            Thread.sleep(2000);
            fileDownloadCheck = isFileDownloaded(current_project_dir+"\\"+"test-downloads", links.get(i).getText());
            if (!fileDownloadCheck)
                return false;
        }
        return true;
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                logger.info("File successfully downloaded "+fileName);
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }
}
