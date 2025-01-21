package herokuApp.testcases;
import herokuApp.pages.HerokuAppExitIntentPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppExitIntentPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppExitIntentPage herokuAppExitIntentPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoExitInternalPage();
        herokuAppExitIntentPage = new HerokuAppExitIntentPage();
    }

    @Test
    public void verifyExitIntent() {
        try {
            Assert.assertTrue(herokuAppExitIntentPage.validateExitIntent());
            logger.info("Exit intent validation passed.");
        } catch (Exception e) {
            logger.info("Exit intent validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
