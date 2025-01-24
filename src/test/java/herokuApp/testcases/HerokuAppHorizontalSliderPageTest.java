package herokuApp.testcases;
import herokuApp.pages.HerokuAppHorizontalSliderPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppHorizontalSliderPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppHorizontalSliderPage herokuAppHorizontalSliderPage;

    @BeforeMethod
    public void set() {
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoHorizontalSliderPage();
        herokuAppHorizontalSliderPage = new HerokuAppHorizontalSliderPage();
    }
    @Test
    public void verifyHorizontalSlider(){
        try {
            Assert.assertTrue(herokuAppHorizontalSliderPage.validateHorizontalSlider());
            logger.info("Horizontal slider validation passed.");
        } catch (Exception e) {
            logger.info("Horizontal Slider validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
