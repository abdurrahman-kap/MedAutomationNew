package testImage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestImage {
	

	public WebDriver driver;
	
	@BeforeMethod
	public void beforemethod(){
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.vodafone.in/pages/home_kar.aspx?cid=kar");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void dynamiclychangingImages(){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='ctl00_PlaceHolderMain_Home_divBanner']/div[1]/div/div[4]/div/a/img")));
		
		if(driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_Home_divBanner']/div[1]/div/div[4]/div/a/img")).isDisplayed()){
			System.out.println("923201430138PM_HB(1).jpg Displayed");
		}else{
			System.err.println("Not displayed");
		}
	}

	@org.testng.annotations.Test
	public void test()
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		//WebElement listImages;
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		List<WebElement> images = driver.findElements(By.xpath(".//*[@id='ctl00_PlaceHolderMain_Home_divBanner']/div[1]/div/div/div/a"));
		 
		 for(int i = 0; i< images.size(); i++){
			 
			 String title  = images.get(i).getAttribute("title");
			 System.out.println("Image title is :"+ i +" :::" + title);
			 // String actualTitle = "Lumia 535 | Vodafone India"; 
			 if(title.contentEquals("Lumia 535 | Vodafone India")){
				 Assert.assertEquals("Lumia 535 | Vodafone India", title);   
			 }
			 
			//  String actualTitle2 = "Take the #VodafoneSpeedQuiz | Win T20 tickets and a chance to be a Vodafone SuperFan";
			 if(title.contentEquals("Take the #VodafoneSpeedQuiz | Win T20 tickets and a chance to be a Vodafone SuperFan")){
				 Assert.assertEquals("Take the #VodafoneSpeedQuiz | Win T20 tickets and a chance to be a Vodafone SuperFan", title);   
			 }
			  
			// String actualTitl3 = "Recharge for friends & family in just 30 sec";   
			if(title.contentEquals("Recharge for friends & family in just 30 sec")){
				Assert.assertEquals("Recharge for friends & family in just 30 sec", title);   
			}
			
			String actualTitle4= "Take the #VodafoneSpeedQuiz | Win T20 tickets and a chance to be a Vodafone SuperFan"; 
		    if(title.contentEquals(actualTitle4)){
		    	Assert.assertEquals(actualTitle4, title);   
		    }
		    
			String actualTitle5= "Recharge for friends & family in just 30 sec";
			if(title.contentEquals(actualTitle5)){
				Assert.assertEquals(actualTitle5, title);   
			}
			
			String actualTitle6= "Lumia 535 | Vodafone India";
		    if(title.contentEquals(actualTitle6)){
		    	Assert.assertEquals(actualTitle6, title);   
			} 
		   
		    //wait.until(ExpectedConditions.
		  
			  // Assert.assertEquals(actual, expected);
		 }
	}
}