package herokuApp.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppDigestAuthenticationPage;

public class HerokuAppDigestAuthenticationPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppDigestAuthenticationPage herokuAppDigestAuthenticationPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoBasicAuthPage();
        herokuAppDigestAuthenticationPage = new HerokuAppDigestAuthenticationPage();
    }

    @Test
    public void verifyDigestAuthLogin(){
        try{
            Assert.assertEquals(herokuAppDigestAuthenticationPage.validateDigestAuthLogin(),"Congratulations! You must have the proper credentials.");
            logger.info("Digest Auth Page login is correct.");
        } catch (Exception e) {
            logger.info("Digest Auth Page login is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
