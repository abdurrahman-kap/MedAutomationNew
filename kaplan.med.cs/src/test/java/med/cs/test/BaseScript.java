package med.cs.test;

import java.util.concurrent.TimeUnit;

import med.cs.controller.CSLoginPageController;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseScript {
	
	protected WebDriver driver = null;

	@BeforeMethod
	public void beforeMethod(){
		 /*if(driver==null){
	            driver = new FirefoxDriver();
	        }*/
		//FirefoxProfile profile = new FirefoxProfile(); //FirefoxDriver
		//profile.setPreference("browser.cache.disk.enable", false);
		//driver = new FirefoxDriver(profile); 
		//File chromeDriverFile = new File(System.getProperty("user.dir") +  "/drivers/32/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
		
		/*System.setProperty("webdriver.chrome.driver","C:\\DevTools\\Browser\\chromedriver.exe");// chromedriver
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

	public CSLoginPageController openLogon(){
		driver.navigate().to("http://step2cs.qa01.kaplan.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return new CSLoginPageController(driver);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	

}
