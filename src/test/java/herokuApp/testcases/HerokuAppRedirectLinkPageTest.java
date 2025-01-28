package herokuApp.testcases;
import herokuApp.pages.HerokuAppRedirectLinkPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppRedirectLinkPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppRedirectLinkPage herokuAppRedirectLinkPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoRedirectLinkPage();
        herokuAppRedirectLinkPage = new HerokuAppRedirectLinkPage();
    }

    @Test
    public void verifyRedirectLink() {
        try {
            Assert.assertTrue(herokuAppRedirectLinkPage.validateRedirectLink());
            logger.info("Redirect link validation passed.");
        } catch (Exception e) {
            logger.info("Redirect link validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
