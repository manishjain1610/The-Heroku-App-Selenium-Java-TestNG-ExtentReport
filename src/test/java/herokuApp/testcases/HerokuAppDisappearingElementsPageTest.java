package herokuApp.testcases;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppDisappearingElementsPage;

public class HerokuAppDisappearingElementsPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppDisappearingElementsPage herokuAppDisappearingElementsPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoDisappearingElementsPage();
        herokuAppDisappearingElementsPage = new HerokuAppDisappearingElementsPage();
    }

    @Test
    public void verifyAllButtonsPresent() {
        try {
            Assert.assertTrue(herokuAppDisappearingElementsPage.validateAllButtonsPresent());
            logger.info("All buttons presence validation passed.");
        } catch (Exception e) {
            logger.info("All buttons presence validation failed.");
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyGalleryButtonPresence() {
        try {
            Assert.assertTrue(herokuAppDisappearingElementsPage.validateGalleryButtonPresence());
            logger.info("Gallery button validation passed.");
        }
        catch (Exception e) {
            logger.info("Gallery button validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
