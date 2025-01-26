package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class HerokuAppJQueryUIMenuPage extends HerokuAppTestBase {
    @FindBy (css = "#ui-id-3 > a")
    WebElement enabledOption;
    @FindBy (css = "#ui-id-1 > a")
    WebElement disabledOption;
    @FindBy (css = "#ui-id-4 > a")
    WebElement downloadsOption;
    @FindBy (css = "#ui-id-5 > a")
    WebElement optionPDF;
    @FindBy (css = "#ui-id-6 > a")
    WebElement optionCSV;
    @FindBy (css = "#ui-id-7 > a")
    WebElement optionExcel;


    public HerokuAppJQueryUIMenuPage ()
    {
        PageFactory.initElements(driver, this);
    }

    public void getWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(enabledOption)).click();
        wait.until(ExpectedConditions.visibilityOf(downloadsOption)).click();
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public boolean checkFile(String directoryPath, String fileName) {
        try {
            Path filePath = Paths.get(directoryPath, fileName);
            Thread.sleep(2000);
            if (Files.exists(filePath)) {
                System.out.println("File found: " + filePath);

                // Attempt to delete the file
                Files.delete(filePath);
                System.out.println("File deleted successfully.");
                return true;
            } else {
                System.out.println("File "+fileName+" does not exist in the directory."+directoryPath);
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking/deleting the file: " + e.getMessage());
            return false;
        }
    }

    public boolean validateJQueryUIMenu () throws InterruptedException {
        boolean fileDownloadCheck = false;

        getWebElement(optionPDF);
        fileDownloadCheck = checkFile(current_project_dir+"\\"+"test-downloads", "menu.pdf");
        if (!fileDownloadCheck)
            return false;
        driver.navigate().refresh();
        getWebElement(optionCSV);
        fileDownloadCheck = checkFile(current_project_dir+"\\"+"test-downloads", "menu.csv");
        if (!fileDownloadCheck)
            return false;
        driver.navigate().refresh();
        getWebElement(optionExcel);
        fileDownloadCheck = checkFile(current_project_dir+"\\"+"test-downloads", "menu.xls");
        if (!fileDownloadCheck)
            return false;
        return true;
    }
}
