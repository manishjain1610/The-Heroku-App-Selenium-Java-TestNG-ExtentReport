package herokuApp.testcases;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppDynamicContentPage;

public class HerokuAppDynamicContentPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppDynamicContentPage herokuAppDynamicContentPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoDynamicContentPage();
        herokuAppDynamicContentPage = new HerokuAppDynamicContentPage();
    }

    @Test
    public void verifyDynamicContent() {
        try {
            Assert.assertTrue(herokuAppDynamicContentPage.validateDynamicContent());
            logger.info("Dynamic content validation passed.");
        } catch (Exception e) {
            logger.info("Dynamic content validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
