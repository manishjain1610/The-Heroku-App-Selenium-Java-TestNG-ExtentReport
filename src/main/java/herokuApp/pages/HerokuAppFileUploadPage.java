package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HerokuAppFileUploadPage extends HerokuAppTestBase {
    @FindBy(css = "#file-upload")
    WebElement fileUpload;
    @FindBy (css = "#file-submit")
    WebElement fileSubmit;


    public HerokuAppFileUploadPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateFileUpload(){
        File upload_File = new File(current_project_dir+"\\"+"test-downloads"+"\\"+"testFile.png");
        fileUpload.sendKeys(upload_File.getAbsolutePath());
        fileSubmit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h3[.='File Uploaded!']"),"File Uploaded!"));
        return true;
    }
}
