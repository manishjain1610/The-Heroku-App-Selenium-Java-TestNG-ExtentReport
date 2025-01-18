package herokuApp.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppBasicAuthPage;

public class HerokuAppBasicAuthPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppBasicAuthPage herokuAppBasicAuthPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoBasicAuthPage();
        herokuAppBasicAuthPage = new HerokuAppBasicAuthPage();
    }

    @Test
    public void verifyLogin(){
        try{
            Assert.assertEquals(herokuAppBasicAuthPage.validateLogin(),"Congratulations! You must have the proper credentials.");
            logger.info("Basic Auth Page login is correct.");
        } catch (Exception e) {
            logger.info("Basic Auth Page login is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @Test(enabled = false)
    public void verifyCancelLogin(){
        try{
            Assert.assertEquals(herokuAppBasicAuthPage.validateCancelLogin(),"Not authorized");
            logger.info("Basic Auth Page cancel login is correct.");
        } catch (Exception e) {
            logger.info("Basic Auth Page cancel login is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
