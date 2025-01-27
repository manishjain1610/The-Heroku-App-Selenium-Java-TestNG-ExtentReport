package herokuApp.testcases;
import herokuApp.pages.HerokuAppNestedFramesPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppNestedFramesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppNestedFramesPage herokuAppNestedFramesPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoNestedFramesPage();
        herokuAppNestedFramesPage = new HerokuAppNestedFramesPage();
    }

    @Test
    public void verifyIndepedentNestedFrames() {
        try {
            Assert.assertTrue(herokuAppNestedFramesPage.validateIndependentNestedFrames());
            logger.info("Nested frames validation passed.");
        } catch (Exception e) {
            logger.info("Nested frames validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
