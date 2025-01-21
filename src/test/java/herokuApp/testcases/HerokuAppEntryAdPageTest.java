package herokuApp.testcases;
import herokuApp.pages.HerokuAppEntryAdPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppEntryAdPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppEntryAdPage herokuAppEntryAdPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoEntryAdPage();
        herokuAppEntryAdPage = new HerokuAppEntryAdPage();
    }

    @Test
    public void verifyEntryAd() {
        try {
            Assert.assertTrue(herokuAppEntryAdPage.validateEntryAd());
            logger.info("Entry Ad validation passed.");
        } catch (Exception e) {
            logger.info("Entry Ad validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
