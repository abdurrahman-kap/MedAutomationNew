package kaplan;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step1QbankOLP 
{
	 static int numquestion=0;
	 static int m=0;
	 static int avlQuestion1=0;
	 
	
	public static void screenshot(WebDriver driver) throws IOException
	{
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destionationFile= new File("C:\\workspace\\myproject\\bin\\mypackage\\ScreenshotsKaplan\\screenshot"+m+".jpg");
		FileUtils.copyFile(sourceFile, destionationFile);
		m=m+1;
					
	}

	public static void main(String[] args) throws Exception
	{
		WebDriver driver= new FirefoxDriver();
		driver.get("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(9L,TimeUnit.SECONDS);
		
		//Login
		driver.manage().window().maximize();
		driver.findElement(By.id("userName")).sendKeys("sphadnis");
		driver.findElement(By.id("password")).sendKeys("sphadnis");
		driver.findElement(By.xpath(".//*[@id='productName_chosen']/a/span")).click();
		List <WebElement> prod= driver.findElements(By.xpath(".//*[@id='productName_chosen']/div/ul//li"));
		
		for(int i=0;i<prod.size();i++)
		{
			if(prod.get(i).getText().equalsIgnoreCase("USMLESTEP1QBANKOLP"))
			{
			  prod.get(i).click();
			  break;
			  
			}
			
		}
		try{
			driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr[5]/td/input")).click();
			
			Alert aler=driver.switchTo().alert();
			System.out.println(aler.getText());
			Thread.sleep(2000);
			aler.accept();
			//screenshot(driver);
			//Thread.sleep(5000);
			WebElement loadingIcon = driver.findElement(By.xpath("html/body/div[1]/img"));
			
			while (loadingIcon.isDisplayed()){
			
			}
			driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr[5]/td/input")).click();
		
		}
		catch(Exception e){
			
		}	
		screenshot(driver);
		
		//Test creation
		WebDriverWait wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/a[1]/div/pre")));
		
		Thread.sleep(10000);
				
		do
		{
			driver.findElement(By.xpath("html/body/div[2]/div[3]/div/a[1]/div/pre")).click();
			/*driver.findElement(By.xpath(".//*[@id='testModeTableHolder']/table[2]/tbody/tr[3]/td[1]/input")).click();
			driver.findElement(By.xpath(".//*[@id='organSystem']")).click();
			driver.findElement(By.xpath(".//*[@id='disciplineWindow']/div[2]/table/tbody/tr[1]/td/label/input")).click();
			driver.findElement(By.xpath(".//*[@id='organSystemWindow']/div[2]/table/tbody/tr[8]/td/label/input")).click();
			driver.findElement(By.xpath(".//*[@id='disciplineWindow']/div[2]/table/tbody/tr[16]/td/label/input")).click();*/
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/input")).click();
			Thread.sleep(2000);
			String avlQuestion=driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr[2]/td[1]/input")).getAttribute("value");
			System.out.println(avlQuestion);
			avlQuestion1= Integer.parseInt(avlQuestion);
			System.out.println("Available Questions="+avlQuestion1);
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr[5]/td[1]/input")).clear();
			int randomnumb=RandomUtils.nextInt(2, 44);
			System.out.println("Random number is:"+randomnumb);
			String randomstring= Integer.toString(randomnumb);
			if(avlQuestion1<=44)
			{
				driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr[5]/td[1]/input")).sendKeys(avlQuestion);
				Thread.sleep(2000);
				int numquestiontemp=Integer.parseInt(driver.findElement(By.xpath(".//*[@id='createTest_TextBox']")).getAttribute("value"));
				numquestion=numquestiontemp;
				driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr[5]/td[3]/input")).click();
			}
			else
			{
				driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr[5]/td[1]/input")).sendKeys(randomstring);
				Thread.sleep(2000);
				int numquestiontemp=Integer.parseInt(driver.findElement(By.xpath(".//*[@id='createTest_TextBox']")).getAttribute("value"));
				numquestion=numquestiontemp;
				driver.findElement(By.xpath(".//*[@id='createTestWindowTable']/tbody/tr[5]/td[3]/input")).click();
			}
			
			System.out.println("Numquestion="+numquestion);
			
			
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nextBtnImg']")));
			//screenshot(driver);
			Thread.sleep(4000);
			for(int i=1;i<=numquestion;i++)
			{
				
				
				driver.navigate().refresh();
				
				//You were working here!
				List <WebElement> proceedToNext= driver.findElements(By.xpath(".//*[@id='proceedBtn']"));
				System.out.println("ProceedtoNext="+proceedToNext.size());
				if(proceedToNext.size()>0)
				{
					
					driver.findElement(By.xpath(".//*[@id='0']/td[2]/input")).click();
					driver.findElement(By.xpath(".//*[@id='proceedBtn']")).click();
					driver.findElement(By.xpath(".//*[@id='confirmProceedBtn']")).click();
				}	
				
				else
				{
					
					driver.findElement(By.xpath(".//*[@id='0']/td[2]/input")).click();
					//Thread.sleep(2000);
					driver.findElement(By.xpath(".//*[@id='nextBtnImg']")).click();
					Thread.sleep(2000);
				
				}
			}
			driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[4]/div[3]/table/tbody/tr[1]/td/img")).click();
			
			driver.findElement(By.xpath(".//*[@id='confirmEndBlockBtn']")).click();
			//driver.findElement(By.xpath(".//*[@id='confirmEndBlockBtn2']")).click();
			Thread.sleep(9000);
			screenshot(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pre-1']")));
			driver.findElement(By.xpath(".//*[@id='pre-1']")).click();
			Thread.sleep(4000);
			screenshot(driver);
			avlQuestion1=avlQuestion1-randomnumb;
			System.out.println("Available quesitons Before execution:"+avlQuestion1);
		}while(avlQuestion1>1);
		
		System.out.println("Available quesitons after execution:"+avlQuestion1);
		driver.close();
	}
		
}
