package herokuApp.testcases;
import herokuApp.pages.HerokuAppSecureFileDownloadPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppSecureFileDownloadPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppSecureFileDownloadPage herokuAppSecureFileDownloadPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
    //    herokuAppHomePage.gotoSecureFileDownloadPage();
        herokuAppSecureFileDownloadPage = new HerokuAppSecureFileDownloadPage();
    }

    @Test
    public void verifySecureFileDownload() {
        try {
            Assert.assertTrue(herokuAppSecureFileDownloadPage.validateSecureFileDownload());
            logger.info("Secure file download validation passed.");
        } catch (Exception e) {
            logger.info("Secure file download validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
