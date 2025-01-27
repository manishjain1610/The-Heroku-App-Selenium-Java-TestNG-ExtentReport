package herokuApp.testcases;
import herokuApp.pages.HerokuAppJSOnloadEventErrorPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppJSOnloadEventErrorPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppJSOnloadEventErrorPage herokuAppJSOnloadEventErrorPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoJavaScriptOnLoadEventErrorPage();
        herokuAppJSOnloadEventErrorPage = new HerokuAppJSOnloadEventErrorPage();
    }

    @Test
    public void verifyJSOnloadEventErrors() {
        try {
            Assert.assertTrue(herokuAppJSOnloadEventErrorPage.validateJSOnloadEventErrors());
            logger.info("JavaScript onload event error validation passed.");
        } catch (Exception e) {
            logger.info("JavaScript onload event error validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
