package herokuApp.testcases;
import herokuApp.pages.HerokuAppJSAlertsPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppJSAlertsPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppJSAlertsPage herokuAppJSAlertsPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoJavaScriptAlertsPage();
        herokuAppJSAlertsPage = new HerokuAppJSAlertsPage();
    }

    @Test
    public void verifyJSAlerts() {
        try {
            Assert.assertTrue(herokuAppJSAlertsPage.validateJSAlerts());
            logger.info("JavaScript alerts validation passed.");
        } catch (Exception e) {
            logger.info("JavaScript alerts validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
