package herokuApp.testcases;

//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuApp.base.HerokuAppTestBase;
import herokuApp.pages.HerokuAppHomePage;

public class HerokuAppHomePageTest extends HerokuAppTestBase {
    HerokuAppHomePage herokuAppHomePage;

    @BeforeMethod
    public void set(){
        herokuAppHomePage = new HerokuAppHomePage();
        logger.info("Initiating HomePage Constructor.");
    }

    @Test
    public void verifyTitle(){
        try {
            Assert.assertEquals(herokuAppHomePage.validateHomePageTitle(),"The Internet");
            logger.info("Page Title Is Correct.");
        }
        catch (Exception e){
            logger.info("Page Title Is Incorrect.");
        }
    }

    @Test
    public void verifyHeader(){
        try {
            Assert.assertEquals(herokuAppHomePage.validateHomePageHeader(),"Welcome to the-internet");
            logger.info("Page Header Is Correct.");
        }
        catch (Exception e){
            logger.info("Page Header Is Incorrect.");
        }
    }
/*
    private WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void landingPage() {
        System.out.println("Hello world");
        driver.get("https://the-internet.herokuapp.com/");
    }

 */
}
