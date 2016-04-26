package med.cs.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSLoginPageModel {
	
protected WebDriver driver = null;
	
	public CSLoginPageModel(WebDriver driver){
		this.driver= driver;
	}
	
	public void setUserName(String uName){
		WebElement setName = driver.findElement(By.id("UserName"));
		setName.clear();
		setName.sendKeys(uName);
	}
	
	public void setPwd(String pwd){
		WebElement setName = driver.findElement(By.id("Password"));
		setName.clear();
		setName.sendKeys(pwd);
	}
	
	public void clickLogIn(){
		WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='legendMain']/fieldset[3]/input"));
		clickLogIn.click();
	}
//*************************************Utility**********************************
	public void waitFor(int sec){
		  try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	
}
