package herokuApp.testcases;
import herokuApp.pages.HerokuAppChallengingDOMPage;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppChallengingDOMPageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;
    HerokuAppChallengingDOMPage herokuAppChallengingDOMPage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
        herokuAppHomePage.gotoChallengingDOMPage();
        herokuAppChallengingDOMPage = new HerokuAppChallengingDOMPage();
    }

    @Test
    public void verifyCanvasElement(){
       String output = herokuAppChallengingDOMPage.validateCanvasElement();
       System.out.println(output);
    }

    @AfterMethod
    public void goBack(){
        logger.info("Getting back home.");
        herokuAppHomePage.gotoHomePage();
    }
}
