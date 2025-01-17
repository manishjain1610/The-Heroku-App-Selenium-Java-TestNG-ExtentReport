package herokuApp.testcases;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppABTestingPage;

public class HerokuAppABTestingPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppABTestingPage herokuAppABTestingPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoABTestingPage();
        herokuAppABTestingPage = new HerokuAppABTestingPage();
    }

    @Test
    public void verifyABTestingPageURL(){
        try{
            Assert.assertEquals(herokuAppABTestingPage.validateABTestingPageURL(),"https://the-internet.herokuapp.com/abtest");
            logger.info("AB Testing Page URL is correct.");
        } catch (Exception e) {
            logger.info("AB Testing Page URL is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyABTestingPageHeader(){
        try {
            Assert.assertTrue(herokuAppABTestingPage.validateABTestingPage());
            logger.info("AB Testing Page Header is correct.");
        } catch (Exception e) {
            logger.info("AB Testing Page Header is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyABTestingPageMessage(){
        String abTestingMessageText = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
        try {
            Assert.assertEquals(herokuAppABTestingPage.validateABTestingMessage(),abTestingMessageText);
            logger.info("AB Testing Page Message is correct.");
        } catch (Exception e) {
            logger.info("AB Testing Page Message is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
