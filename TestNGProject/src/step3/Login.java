package step3;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Login {

	public static void login(WebDriver driver,String userName, String password) throws InterruptedException{
		//WebDriverWait waitFor= new WebDriverWait(driver,10000);
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='productName_chosen']/a/span")).click();
		List <WebElement> prodList = driver.findElements(By.xpath(".//*[@id='productName_chosen']/div/ul//li"));
		
		for(int i=1;i<=prodList.size();i++){
			
			if(prodList.get(i).getText().equalsIgnoreCase(Utilties.product)){
				prodList.get(i).click();
				break;		
			}
			
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr[5]/td/input")).click();
		Thread.sleep(2000);
		try{
		Alert loginAlert = driver.switchTo().alert();
		loginAlert.accept();
		WebElement loadingIcon = driver.findElement(By.xpath("html/body/div[1]/img"));
		while (loadingIcon.isDisplayed()){
		
		}
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr[5]/td/input")).click();
		}
		catch(Exception e){}
	}
}
