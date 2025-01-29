package herokuApp.testcases;
import herokuApp.pages.HerokuAppShiftingContentPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppShiftingContentPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppShiftingContentPage herokuAppShiftingContentPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoShiftingContentPage();
        herokuAppShiftingContentPage = new HerokuAppShiftingContentPage();
    }

    @Test
    public void verifyShiftingContent() {
        try {
            Assert.assertTrue(herokuAppShiftingContentPage.validateShiftingContent());
            logger.info("Shifting content validation passed.");
        } catch (Exception e) {
            logger.info("Shifting content validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
