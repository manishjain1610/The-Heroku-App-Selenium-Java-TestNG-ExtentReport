package herokuApp.testcases;
import herokuApp.pages.HerokuAppInfiniteScrollPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppInfiniteScrollPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppInfiniteScrollPage herokuAppInfiniteScrollPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoInfiniteScrollPage();
        herokuAppInfiniteScrollPage = new HerokuAppInfiniteScrollPage();
    }

    @Test
    public void verifyInfiniteScroll() {
        try {
            Assert.assertTrue(herokuAppInfiniteScrollPage.validateInfiniteScroll());
            logger.info("Infinite scroll validation passed.");
        } catch (Exception e) {
            logger.info("Infinite scroll validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }

}
