package kaplanHealth;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;

public class Testclass {
	
	protected WebDriver driver = null;

	@BeforeMethod
	public void beforeMethod(){
		FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("browser.cache.disk.enable", false);
		driver = new FirefoxDriver(profile);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("http://www.google.com");
		
	}

	
	@Test
	public void testing() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}
