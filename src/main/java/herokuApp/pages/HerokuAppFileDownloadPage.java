package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.List;
import java.util.Objects;


public class HerokuAppFileDownloadPage extends HerokuAppTestBase {
    List<WebElement> links = driver.findElements(By.xpath("//a"));


    public HerokuAppFileDownloadPage()
    {
        PageFactory.initElements(driver, this);
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

    public boolean validateFileDownload() throws InterruptedException {
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
}
