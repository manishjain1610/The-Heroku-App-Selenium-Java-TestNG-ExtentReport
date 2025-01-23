package herokuApp.testcases;
import herokuApp.pages.HerokuAppForgotPasswordPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppForgotPasswordPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppForgotPasswordPage herokuAppForgotPasswordPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoForgotPasswordPage();
        herokuAppForgotPasswordPage = new HerokuAppForgotPasswordPage();
    }

    @Test
    public void verifyPasswordRetrieval() {
        try {
            Assert.assertTrue(herokuAppForgotPasswordPage.validatePasswordRetrieval());
            logger.info("Forgot password validation passed.");
        } catch (Exception e) {
            logger.info("Forgot password validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
