package herokuApp.testcases;
import herokuApp.pages.HerokuAppShadowDOMPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppShadowDOMPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppShadowDOMPage herokuAppShadowDOMPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoShadowDOMPage();
        herokuAppShadowDOMPage = new HerokuAppShadowDOMPage();
    }

    @Test
    public void verifyShadowDOM() {
        try {
            Assert.assertTrue(herokuAppShadowDOMPage.validateShadowDOM());
            logger.info("Shadow DOM validation passed.");
        } catch (Exception e) {
            logger.info("Shadow DOM validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
