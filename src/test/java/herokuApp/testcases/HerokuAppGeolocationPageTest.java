package herokuApp.testcases;
import herokuApp.pages.HerokuAppGeolocationPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppGeolocationPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppGeolocationPage herokuAppGeolocationPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoGeoLocationPage();
        herokuAppGeolocationPage = new HerokuAppGeolocationPage();
    }

    @Test
    public void verifyGeolocationOutput() {
        try {
            Assert.assertTrue(herokuAppGeolocationPage.validateGeolocationOutput());
            logger.info("Geolocation validation passed.");
        } catch (Exception e) {
            logger.info("Geolocation validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
