package herokuApp.testcases;
import herokuApp.pages.HerokuAppDynamicControlsPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppDynamicControlsPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppDynamicControlsPage herokuAppDynamicControlsPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoDynamicControlPage();
        herokuAppDynamicControlsPage = new HerokuAppDynamicControlsPage();
    }

    @Test
    public void verifyDynamicControls(){
        try {
            Assert.assertTrue(herokuAppDynamicControlsPage.validateDynamicControls());
            logger.info("Dynamic control validation passed.");
        } catch (Exception e) {
            logger.info("Dynamic controls validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }

}
