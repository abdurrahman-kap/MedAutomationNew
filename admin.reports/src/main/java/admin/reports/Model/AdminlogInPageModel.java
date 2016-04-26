package admin.reports.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminlogInPageModel {
protected WebDriver driver = null;
	
	public AdminlogInPageModel(WebDriver driver){
		this.driver= driver;
	}
	
	public void setUserName(String uName){
		WebElement setName = driver.findElement(By.name("Username"));
		setName.clear();
		setName.sendKeys(uName);
	}
	
	public void setPwd(String pwd){
		WebElement setName = driver.findElement(By.name("Password"));
		setName.clear();
		setName.sendKeys(pwd);
	}
	
	public void clickLogIn(){
		WebElement clickLogIn = driver.findElement(By.id("login_button"));
		clickLogIn.click();
	}

	public void clickSignOut() {
		WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='signOut']"));
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
