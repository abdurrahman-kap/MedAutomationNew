package health.med;

import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleLogintestclass {
	
	private WebDriver driver = null;
	
	public void login(String uname, String pwd) throws Exception{
		String URL = "https://" + uname + ":" + pwd + "@" + "docs.google.com/a/kaplan.com/spreadsheets/d/1z5LtmlPCsMh4otDMaPEMgqcIsI8XX0NtIM6X2M_2LoU/edit#gid=1159427575" ;

		System.out.println("The URL is : " + URL);//"https://" + uname + ":" + pwd + "@" + 
		driver.navigate().to(URL);
				
				//"https://docs.google.com/a/kaplan.com/spreadsheets/d/1z5LtmlPCsMh4otDMaPEMgqcIsI8XX0NtIM6X2M_2LoU/edit#gid=1159427575");
		//adelay(2);
	
		/*Alert al = driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("test");
		al.accept();*/
		
		//System.out.println(al.getText());
		
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 Alert al = wait.until(ExpectedConditions.alertIsPresent());
		 al.authenticateUsing(new UserAndPassword(uname,pwd));
		 
//		 al.sendKeys(keysToSend);
		
//		driver.switchTo().frame("Authentication Required");
//		driver.findElement(By.name("User Name:")).sendKeys(uname);
		
		
//        driver.switchTo().frame("Authentication Required.0.child");
//        driver.findElement(By.partialLinkText("Name:")).sendKeys(uname);
//        driver.findElement(By.partialLinkText("Password:")).sendKeys(pwd);
      
	}

	@Test
	public void testLogin() throws Exception{
		login("abrahman", "Cisco1234!");
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
			
			FirefoxProfile profile = new FirefoxProfile(); //FirefoxDriver
			//profile.setPreference("browser.cache.disk.enable", false);
			driver = new FirefoxDriver(profile); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
//			System.setProperty("webdriver.chrome.driver","C:\\DevTools\\Browser\\chromedriver.exe");// chromedriver
//			driver = new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			/*
			String baseUrl="https://docs.google.com/a/kaplan.com/spreadsheets/d/1z5LtmlPCsMh4otDMaPEMgqcIsI8XX0NtIM6X2M_2LoU/edit#gid=1159427575";;
			//driver.get(baseUrl + "/");// +"abrahman" + ":" + "password" + "@"
			
			driver.navigate().to(baseUrl);
			driver.switchTo().activeElement();
			RobotService robotService = RobotService.getInstance();
			robotService.type("loginname");
			robotService.keyPress(KeyEvent.VK_TAB);
			robotService.type("loginpwd");
			robotService.type(KeyEvent.VK_ENTER);
			delay(2);*/
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
			            Thread.sleep(3000);
			    		break;
			        }
			    }
			}
		}

		private void switchWindows() throws InterruptedException
		{
			Set<String> handlers = driver.getWindowHandles();
			if (driver.getWindowHandles().size()>= 1) {
				System.out.println("get new window name : "+ driver.getTitle());
			    for (String handler : handlers) {
			        driver.switchTo().window(handler);
			        if (driver.getTitle().contains("Authentication Required")) {
			            System.out.println("inside the switch window" + driver.getTitle());
			            Thread.sleep(5000);
			            WebElement clickBrowse = driver.findElement(By.id("file1"));
			    		clickBrowse.click();
			    		break;
			        }
			    }
			}
		}

}
