package herokuApp.testcases;
import herokuApp.pages.HerokuAppCheckBoxesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppContextMenuPage;

public class HerokuAppContextMenuPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppContextMenuPage herokuAppContextMenuPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoContextMenuPage();
        herokuAppContextMenuPage = new HerokuAppContextMenuPage();
    }

    @Test
    public void verifyAlertForContextMenu() {
        try {
            Assert.assertTrue(herokuAppContextMenuPage.validateAlertForContextMenu());
            logger.info("Context Menu validation passed.");
        }
        catch (Exception e) {
            logger.info("Context Menu validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
