package herokuApp.util;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
//import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory 
{
	public static WebDriver checkBrowser(WebDriver driver,String current_project_dir,String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			HashMap<String, Object> chromePref = new HashMap<>();
			chromePref.put("download.default_directory", current_project_dir + "\\" +"test-downloads");	//Set download directory
			chromePref.put("download.prompt_for_download", false);  // Disable download prompt
			chromePref.put("download.directory_upgrade", true);  // Allow directory upgrade
			chromePref.put("safebrowsing.enabled", true);  // Enable safe browsing
			chromePref.put("profile.default_content_settings.popups", 0);  // Disable popups
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			chromeOptions.setExperimentalOption("prefs", chromePref);
			driver = new ChromeDriver(chromeOptions);
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", current_project_dir+"/src/main/java/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
