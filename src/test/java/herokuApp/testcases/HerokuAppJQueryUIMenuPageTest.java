package herokuApp.testcases;
import herokuApp.pages.HerokuAppForgotPasswordPage;
import herokuApp.pages.HerokuAppJQueryUIMenuPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppJQueryUIMenuPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppJQueryUIMenuPage herokuAppJQueryUIMenuPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoJQueryPage();
        herokuAppJQueryUIMenuPage = new HerokuAppJQueryUIMenuPage();
    }

    @Test
    public void verifyJQeryUIMenu() {
        try {
            Assert.assertTrue(herokuAppJQueryUIMenuPage.validateJQueryUIMenu());
            logger.info("JQuery UI Menu validation passed.");
        } catch (Exception e) {
            logger.info("JQuery UI Menu validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
