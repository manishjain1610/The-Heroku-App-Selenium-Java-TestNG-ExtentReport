package herokuApp.testcases;
import herokuApp.pages.HerokuAppFramesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppFramesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppFramesPage herokuAppFramesPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoFramesPage();
        herokuAppFramesPage = new HerokuAppFramesPage();
    }

    @Test
    public void verifyNestedFrames() {
        try {
            Assert.assertTrue(herokuAppFramesPage.validateNestedFrames());
            logger.info("Nested frame validation passed.");
        } catch (Exception e) {
            logger.info("Nested frame validation failed.");
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyiFrame() {
        try {
            Assert.assertTrue(herokuAppFramesPage.validateiFrame());
            logger.info("iFrame validation passed.");
        } catch (Exception e) {
            logger.info("iFrame validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
