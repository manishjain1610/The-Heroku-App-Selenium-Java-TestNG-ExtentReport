package herokuApp.testcases;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;
import herokuApp.pages.HerokuAppAddRemoveElementsPage;

public class HerokuAppAddRemoveElementsPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppAddRemoveElementsPage herokuAppAddRemoveElementsPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoAddRemoveElementsPage();
        herokuAppAddRemoveElementsPage = new HerokuAppAddRemoveElementsPage();
    }

    @Test
    public void verifyAddRemoveElementsPageHeader(){
        try{
            Assert.assertEquals(herokuAppAddRemoveElementsPage.validateAddRemoveElementsPageHeader(),"Add/Remove Elements");
            logger.info("Add Remove Elements Page Header is correct.");
        } catch (Exception e) {
            logger.info("Add Remove Elements Page Header is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyElementAddition(){
        try{
            System.out.println("About to call add element function");
            Assert.assertTrue(herokuAppAddRemoveElementsPage.validateElementAddition());
            logger.info("Addition of element is correct.");
        } catch (Exception e) {
            logger.info("Addition of element is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyElementDeletion(){
        try{
            System.out.println("About to call del element function");
            Assert.assertTrue(herokuAppAddRemoveElementsPage.validateElementDeletion());
            logger.info("Deletion of element is correct.");
        } catch (Exception e) {
            logger.info("Deletion of element is incorrect.");
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }

}
