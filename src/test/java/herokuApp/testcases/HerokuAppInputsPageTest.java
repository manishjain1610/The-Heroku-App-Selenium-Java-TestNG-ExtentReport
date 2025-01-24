package herokuApp.testcases;
import herokuApp.pages.HerokuAppInputsPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppInputsPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppInputsPage herokuAppInputsPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoInputsPage();
        herokuAppInputsPage = new HerokuAppInputsPage();
    }

    @Test
    public void verifyInputs() {
        try {
            Assert.assertTrue(herokuAppInputsPage.validateInput());
            logger.info("Inputs validation passed.");
        } catch (Exception e) {
            logger.info("Inputs validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
