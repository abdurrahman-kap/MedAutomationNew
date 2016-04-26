package step3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class Main {
		
	static WebDriver driver;
	static WebDriverWait waitFor;
    @BeforeTest
    public void beforeTest(){
    	if(Utilties.browser.equalsIgnoreCase("Chrome")){
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
    	driver= new ChromeDriver();
    	}
    	else{
    		driver=new FirefoxDriver();
    	}
    	waitFor= new WebDriverWait(driver,60);
    	driver.get(Utilties.URL);
    	driver.manage().window().maximize();
    }
    

  @Test(priority=1)
  public void checkLoginPageTitle() {
	  
	  
	  Assert.assertEquals(Utilties.pageTile, driver.getTitle());
  }

  @Test(priority=2, enabled=false)
  public void invalidLogin() throws InterruptedException {
	  
	  String failureNotice ="Username, password, and/or instance incorrect. Please try again.";
	  Login.login(driver,"sphadnis",  "wagh");
	 
	  Thread.sleep(2000);
	  String actualfailureNotice =driver.findElement(By.xpath(".//*[@id='failureNotice']")).getText();
	  System.out.println(actualfailureNotice);
	  Assert.assertEquals(failureNotice,actualfailureNotice);
	  
		
	}
  
  
  
 /* @Test(priority=3)
  public void validLogin() throws InterruptedException {
  	  
  
  	  Login.login(driver,"mcroatto",  "mcroatto");
  	 
  	  waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/header/div/a")));
  	 WebElement logo =driver.findElement(By.xpath("html/body/div[1]/div[1]/header/div/a"));
  	  if(logo.isDisplayed()){
  		  Assert.assertTrue(true);
  	  }  	  
  	  else{
  		  Assert.assertTrue(false);
  	  }
  		
  	}*/

/*@Test(priority=4)
public void step3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
	waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='home-dashboard-table-txt']/li[11]/ul/li[1]/a")));
	if(driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[11]/ul/li[1]/a")).isDisplayed()){
		Step3.gotoStep3(driver);
	}
	else{
		Assert.assertTrue(false);
	}
	
}
*/





@AfterTest
public void afterTest(){
	driver.quit();
	
}


	
}


