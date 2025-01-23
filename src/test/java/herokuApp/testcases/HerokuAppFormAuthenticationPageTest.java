package herokuApp.testcases;
import herokuApp.pages.HerokuAppFormAuthenticationPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppFormAuthenticationPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppFormAuthenticationPage herokuAppFormAuthenticationPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoFormAuthenticationPage();
        herokuAppFormAuthenticationPage = new HerokuAppFormAuthenticationPage();
    }

    @Test
    public void validateFormAuthentication() {
        try {
            Assert.assertTrue(herokuAppFormAuthenticationPage.validateFormAuthentication());
            logger.info("Form authentication validation passed.");
        } catch (Exception e) {
            logger.info("Form authentication validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
