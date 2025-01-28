package herokuApp.testcases;
import herokuApp.pages.HerokuAppNotificationMessagesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppNotificationMessagesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppNotificationMessagesPage herokuAppNotificationMessagesPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoNotificationMessagesPage();
        herokuAppNotificationMessagesPage = new HerokuAppNotificationMessagesPage();
    }

    @Test
    public void verifyPasswordRetrieval() {
        try {
            Assert.assertTrue(herokuAppNotificationMessagesPage.validateNotificationMessage());
            logger.info("Notification messages validation passed.");
        } catch (Exception e) {
            logger.info("Notification messages validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
