package qidsTest;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;



public class Main {
	
	WebDriver driver;
	WebDriver driver2;
	WebDriverWait waitFor;
	WebDriverWait waitFor2;
 
  @BeforeTest
  public void beforeTest() {
	  
	  if(Utilities.browser.equalsIgnoreCase("chrome")){
	    	System.setProperty("webdriver.chrome.driver","C:\\browser driver\\chromedriver.exe");
	    	driver= new ChromeDriver();
	    	driver2= new ChromeDriver();
	    	}
	    	else if(Utilities.browser.equalsIgnoreCase("Firefox")){
	    		driver=new FirefoxDriver();
	    		driver2= new FirefoxDriver();
	    	}
	    	else{
	    		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	    		capabilities.setCapability("ignoreZoomSetting", true);
	    		File file = new File("C:\\browser driver\\IEDriverServer.exe");
	    		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	    		driver = new InternetExplorerDriver(capabilities);
	    		driver2= new InternetExplorerDriver(capabilities);
	    		    		
	    		/*
	    		System.setProperty("webdriver.ie.driver","C:\\browser driver\\IEDriverServer.exe");
		    	driver= new InternetExplorerDriver();
		    	driver2= new InternetExplorerDriver();*/
	    	} 
	  
	  waitFor= new WebDriverWait(driver, 60);
	  driver.get(Utilities.url);
	  
	  waitFor2= new WebDriverWait(driver2, 60);
	  //driver2.get(Utilities.productUrl);
	 
	  driver.manage().window().maximize();
	  
  }

  @Test(priority=1)
  public void login() throws InterruptedException{
	  WebElement username= driver.findElement(By.id("userName"));
	  username.sendKeys("smuppidi");
	  WebElement password= driver.findElement(By.id("password"));
	  password.sendKeys("smuppidi");
	  password.submit();
	  Thread.sleep(3000);
	  
	  WebElement jasperLog= driver.findElement(By.xpath("html/body/center/div/table[1]/tbody/tr/td[3]/img"));
	  if(jasperLog.isDisplayed()){
		  Assert.assertTrue(true);
	  }
  }  

@Test(priority=2)
public void checkQidCorrect() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	CheckQid.checkQids(driver, waitFor,driver2,waitFor2);
	
}
	  
	  
 
  
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
	  driver2.quit();
  }

}
