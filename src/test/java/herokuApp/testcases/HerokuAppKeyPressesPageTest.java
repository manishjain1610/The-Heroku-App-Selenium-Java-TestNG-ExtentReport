package herokuApp.testcases;
import herokuApp.pages.HerokuAppKeyPressesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppKeyPressesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppKeyPressesPage herokuAppKeyPressesPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoKeyPressesPage();
        herokuAppKeyPressesPage = new HerokuAppKeyPressesPage();
    }

    @Test
    public void verifyKeyPresses() {
        try {
            Assert.assertTrue(herokuAppKeyPressesPage.validateKeyPresses());
            logger.info("Key presses validation passed.");
        } catch (Exception e) {
            logger.info("Key presses validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
