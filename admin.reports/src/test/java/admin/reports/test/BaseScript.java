package admin.reports.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import admin.reports.controller.AdminLogInPageController;
public class BaseScript {
	
	protected WebDriver driver = null;

	@BeforeMethod
	public void beforeMethod(){
			
		/*FirefoxProfile profile = new FirefoxProfile(); //FirefoxDriver
		//profile.setPreference("browser.cache.disk.enable", false);
		driver = new FirefoxDriver(profile); */
		//File chromeDriverFile = new File(System.getProperty("user.dir") +  "/drivers/32/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
			
	/*	System.setProperty("webdriver.chrome.driver","C:\\DevTools\\Browser\\chromedriver.exe");// chromedriver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
			
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();//IEDriverServer
		System.setProperty("webdriver.ie.driver","C:\\DevTools\\Browser\\IEDriverServer.exe");
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability("requireWindowFocus",true);
		caps.setCapability("nativeEvents", false);
		driver = new InternetExplorerDriver(caps);
		driver.manage().window().maximize();
	}
	
	public AdminLogInPageController openLogInPage(){
			
		driver.navigate().to("https://qa-medreports.kaptest.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return new AdminLogInPageController(driver);
	}
		
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
		
}