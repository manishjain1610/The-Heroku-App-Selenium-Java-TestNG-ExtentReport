package herokuApp.testcases;
import herokuApp.pages.HerokuAppStatusCodesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppStatusCodesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppStatusCodesPage herokuAppStatusCodesPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoStatusCodesPage();
        herokuAppStatusCodesPage = new HerokuAppStatusCodesPage();
    }

    @Test
    public void verifyStatusCodes() {
        try {
            Assert.assertTrue(herokuAppStatusCodesPage.validateStatusCodes());
            logger.info("Status codes validation passed.");
        } catch (Exception e) {
            logger.info("Status codes validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
