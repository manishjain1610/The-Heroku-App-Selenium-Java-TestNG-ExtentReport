package herokuApp.testcases;
import herokuApp.pages.HerokuAppBrokenImagesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppBrokenImagesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppBrokenImagesPage herokuAppBrokenImagesPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoBrokenImagesPage();
        herokuAppBrokenImagesPage = new HerokuAppBrokenImagesPage();
    }

    @Test
    public void verifyIfImageIsBroken(){
        try{
            Assert.assertTrue(herokuAppBrokenImagesPage.validateIfImageIsBroken());
            logger.info("Broken image validation is correct.");
        } catch (Exception e) {
            logger.info("Broken image validation is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
