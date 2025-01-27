package herokuApp.testcases;
import herokuApp.pages.HerokuAppMultipleWindowsPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppMultipleWindowsPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppMultipleWindowsPage herokuAppMultipleWindowsPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoMultipleWindowsPage();
        herokuAppMultipleWindowsPage = new HerokuAppMultipleWindowsPage();
    }

    @Test
    public void verifyMultipleWindows() {
        try {
            Assert.assertTrue(herokuAppMultipleWindowsPage.validateMultipleWindows());
            logger.info("Multiple windows validation passed.");
        } catch (Exception e) {
            logger.info("Multiple windows validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
