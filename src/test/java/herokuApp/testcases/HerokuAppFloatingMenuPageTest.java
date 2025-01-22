package herokuApp.testcases;
import herokuApp.pages.HerokuAppFloatingMenuPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppFloatingMenuPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppFloatingMenuPage herokuAppFloatingMenuPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoFloatingMenuPage();
        herokuAppFloatingMenuPage = new HerokuAppFloatingMenuPage();
        }

    @Test
    public void verifyFloatingMenu() {
        try {
            Assert.assertTrue(herokuAppFloatingMenuPage.validateFloatingMenu());
            logger.info("Floating menu validation passed.");
        } catch (Exception e) {
            logger.info("Floating menu validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }

}
