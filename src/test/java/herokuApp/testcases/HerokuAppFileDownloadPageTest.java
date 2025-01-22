package herokuApp.testcases;
import herokuApp.pages.HerokuAppFileDownloadPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppFileDownloadPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppFileDownloadPage herokuAppFileDownloadPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoFileDownloadPage();
        herokuAppFileDownloadPage = new HerokuAppFileDownloadPage();
    }

    @Test
    public void verifyFileDownload() {
        try {
            Assert.assertTrue(herokuAppFileDownloadPage.validateFileDownload());
            logger.info("File download validation passed.");
        } catch (Exception e) {
            logger.info("File download validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }

}
