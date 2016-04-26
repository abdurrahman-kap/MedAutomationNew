package med.base;

import java.util.concurrent.TimeUnit;

import med.OLP.controller.NaplexMigrationPageController;
import med.OLP.controller.OLPHomePageController;
import med.jasper.controller.JasperHomePageController;
import med.jasper.controller.JasperLogInPageController;
import med.jasper.controller.JasperQAPageController;
import med.qbank.QBankHomePageController;
import med.shp.controller.OAMQALogInPageController;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		
		System.setProperty("webdriver.chrome.driver","C:\\DevTools\\Browser\\chromedriver.exe");// chromedriver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*DesiredCapabilities caps = DesiredCapabilities.internetExplorer();//IEDriverServer
		System.setProperty("webdriver.ie.driver","C:\\DevTools\\Browser\\IEDriverServer.exe");
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability("requireWindowFocus",true);
		caps.setCapability("nativeEvents", false);
		driver = new InternetExplorerDriver(caps);
		driver.manage().window().maximize();*/
	}
	
	
	public JasperHomePageController jasperhomepage(){
		return new JasperHomePageController(driver);
	}
	
	public OLPHomePageController olphomepage(){
		return new OLPHomePageController(driver);
	}
	
	public NaplexMigrationPageController naplexpage(){
		driver.navigate().to("http://jasperwp.kaplan.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return new NaplexMigrationPageController(driver);
	}
	
    public JasperLogInPageController openJasperLogInPage(){
		driver.navigate().to("http://jasperqa.kaplan.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return new JasperLogInPageController(driver);
	}
	
	public JasperLogInPageController openOPLLogInPage(){
		driver.navigate().to("https://qa-jasperwp.kaptest.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return new JasperLogInPageController(driver);
	}

	public JasperQAPageController openJasQALogInPage(){
		driver.navigate().to("http://qwjasweb02.kaplaninc.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return new JasperQAPageController(driver);
	}
	
	public OAMQALogInPageController openOMALogInPage(){
		driver.navigate().to("file://C:/Users/AbRahman/Desktop/workfldr/oam.html");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return new OAMQALogInPageController(driver);
	}
	
	public QBankHomePageController openQBankPage()
	{
		driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return new QBankHomePageController(driver);
	}

	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
}
