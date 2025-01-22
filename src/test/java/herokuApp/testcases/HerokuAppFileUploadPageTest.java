package herokuApp.testcases;
import herokuApp.pages.HerokuAppFileUploadPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppFileUploadPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppFileUploadPage herokuAppFileUploadPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoFileUploadPage();
        herokuAppFileUploadPage = new HerokuAppFileUploadPage();
    }

    @Test
    public void verifyFileUpload() {
        try {
            Assert.assertTrue(herokuAppFileUploadPage.validateFileUpload());
            logger.info("File upload validation passed.");
        } catch (Exception e) {
            logger.info("File upload validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
