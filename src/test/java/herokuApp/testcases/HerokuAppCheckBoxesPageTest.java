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

public class HerokuAppCheckBoxesPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppCheckBoxesPage herokuAppCheckBoxesPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoCheckboxesPage();
        herokuAppCheckBoxesPage = new HerokuAppCheckBoxesPage();
    }

    @Test
    public void verifyCheckBoxesStatus (){
        try {
            Assert.assertTrue(herokuAppCheckBoxesPage.validateCheckBoxesStatus());
            logger.info("Check Box validation passed.");
        }
        catch (Exception e) {
            logger.info("Check Box validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
