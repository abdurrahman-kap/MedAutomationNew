package Guru99TakeScreenshot;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99TakeScreenshot {
	private WebDriver driver = null;
	
	@Test
	public void testGuru99TakeScreenShot() throws Exception{
		
		driver.get("http://yahoo.com");
		this.takeSnapShot(driver, "c://test.png");
		
	}
	
	public  void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception{	
		/*FirefoxProfile profile = new FirefoxProfile(); //FirefoxDriver
		//profile.setPreference("browser.cache.disk.enable", false);
		driver = new FirefoxDriver(profile); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
		
		System.setProperty("webdriver.chrome.driver","C:\\DevTools\\Browser\\chromedriver.exe");// chromedriver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
}
