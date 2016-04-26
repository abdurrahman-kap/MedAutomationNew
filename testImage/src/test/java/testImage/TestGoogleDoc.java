package testImage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGoogleDoc {
	
	private WebDriver driver = null;
	
	
	public void login(String uname, String pwd) throws Exception{
		//String URL = "https://" + uname + ":" + pwd + "@" + "docs.google.com/a/kaplan.com/spreadsheets/d/1z5LtmlPCsMh4otDMaPEMgqcIsI8XX0NtIM6X2M_2LoU/edit#gid=1159427575" ;

		//System.out.println("The URL is : " + URL);//"https://" + uname + ":" + pwd + "@" + 
		driver.navigate().to("https://docs.google.com/a/kaplan.com/spreadsheets/d/1z5LtmlPCsMh4otDMaPEMgqcIsI8XX0NtIM6X2M_2LoU/edit#gid=1159427575");
		delay(2);
	
        driver.switchTo().frame("Authentication Required.0.child");
        driver.findElement(By.partialLinkText("Name:")).sendKeys(uname);
        driver.findElement(By.partialLinkText("Password:")).sendKeys(pwd);
      
	}

	@Test
	public void testLogin() throws Exception{
		login("abrahman", "vfvfvfvf");
	}
	
	public void delay(int time){
		 try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
//*************************************************************************************
		@BeforeMethod
		public void beforeMethod() throws Exception{
			
			/*FirefoxProfile profile = new FirefoxProfile(); //FirefoxDriver
			//profile.setPreference("browser.cache.disk.enable", false);
			driver = new FirefoxDriver(profile); 
			driver.manage().window().maximize();
			//driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
			
			System.setProperty("webdriver.chrome.driver","C:\\DevTools\\Browser\\chromedriver.exe");// chromedriver
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String baseUrl="https://" + "docs.google.com/a/kaplan.com/spreadsheets/d/1z5LtmlPCsMh4otDMaPEMgqcIsI8XX0NtIM6X2M_2LoU/edit#gid=1159427575";;
			//driver.get(baseUrl + "/");// +"abrahman" + ":" + "password" + "@"
			
			driver.navigate().to(baseUrl);
			delay(2);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		
		@AfterMethod
		public void afterMethod(){
			driver.quit();
		}
		
		private void switchAttachWindows() throws InterruptedException
		{
			Set<String> handlers = driver.getWindowHandles();	
			if (driver.getWindowHandles().size()>= 1) {
				System.out.println("get new window name : "+ driver.getTitle());
			    for (String handler : handlers) {
			        driver.switchTo().window(handler);
			        if (driver.getCurrentUrl().contains("https://auth.kaplan.com")) {
			            System.out.println(driver.getTitle());
			            //driver.getWindowHandle();
			            Thread.sleep(3000);
			           // WebElement clickBrowse = driver.findElement(By.id("file1"));
			    		//clickBrowse.click();
			    		break;
			        }
			    }
			}
		}

}
