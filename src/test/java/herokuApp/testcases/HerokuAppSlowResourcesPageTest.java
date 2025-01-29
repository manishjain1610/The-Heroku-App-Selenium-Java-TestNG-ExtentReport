package herokuApp.testcases;
import herokuApp.pages.HerokuAppSlowResourcesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppSlowResourcesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppSlowResourcesPage herokuAppSlowResourcesPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoSlowResourcesPage();
        herokuAppSlowResourcesPage = new HerokuAppSlowResourcesPage();
    }

    @Test
    public void verifySlowResources() {
        try {
            Assert.assertTrue(herokuAppSlowResourcesPage.validateSlowResources());
            logger.info("Slow resources validation passed.");
        } catch (Exception e) {
            logger.info("Slow resources validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
