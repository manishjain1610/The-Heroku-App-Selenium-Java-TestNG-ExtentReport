package herokuApp.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import herokuApp.util.BrowserFactory;
import herokuApp.util.TestUtil;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class HerokuAppTestBase {
    public static WebDriver driver;
    public static Properties prop= new Properties();
    public static String current_project_dir;
    public static Logger logger;

    public HerokuAppTestBase(){
        try{
            current_project_dir=System.getProperty("user.dir");
            File propFile = new File(current_project_dir+"\\src\\main\\java\\herokuApp\\config\\config.properties");
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        logger = LogManager.getLogger("HerokuApp Automation");
        //logger = LogManager.getLogger(HerokuAppTestBase.class);
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(true);
        try {
            File file = new File(current_project_dir + "/src/main/resources/log4j.properties");
            context.setConfigLocation(file.toURI());
        } catch (Exception e) {
            System.out.println("log4j2.properties file could not be loaded");
        }
        logger.info("Starting the application....");
//        PropertyConfigurator.configure(current_project_dir+"/src/main/resources/log4j2.properties");
        driver = BrowserFactory.checkBrowser(driver, current_project_dir,browserName);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }

    public void homePage(){
        driver.get(prop.getProperty("url"));
    }

    @BeforeSuite
    public void setUp()
    {

        initialization();
    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
