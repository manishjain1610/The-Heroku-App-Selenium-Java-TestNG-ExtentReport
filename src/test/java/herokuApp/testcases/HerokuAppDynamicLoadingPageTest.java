package herokuApp.testcases;
import herokuApp.pages.HerokuAppDynamicLoadingPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppDynamicLoadingPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppDynamicLoadingPage herokuAppDynamicLoadingPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoDynamicLoadingPage();
        herokuAppDynamicLoadingPage = new HerokuAppDynamicLoadingPage();
    }

    @Test
    public void verifyDynamicLoadingElements() {
        try {
            Assert.assertTrue(herokuAppDynamicLoadingPage.validateDynamicLoadingElements());
            logger.info("Dynamic Loading validation passed.");
        } catch (Exception e) {
            logger.info("Dynamic Loading validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
