package herokuApp.testcases;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppDragAndDropPage;

public class HerokuAppDragAndDropPageTest extends HerokuAppTestBase {

    HerokuAppHomePage herokuAppHomePage;
    HerokuAppDragAndDropPage herokuAppDragAndDropPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoDragAndDropElementsPage();
        herokuAppDragAndDropPage = new HerokuAppDragAndDropPage();
    }

    @Test
    public void verifyAllButtonsPresent() {
        try {
            Assert.assertTrue(herokuAppDragAndDropPage.validateDragAndDrop());
            logger.info("Drag and drop validation passed.");
        } catch (Exception e) {
            logger.info("Drag and drop validation failed.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
