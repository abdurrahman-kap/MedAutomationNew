package med.shp.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OAMStagingLogInModel {
	
	protected WebDriver driver = null;
	
	public OAMStagingLogInModel(WebDriver driver){
		this.driver= driver;
	}
	
	public void setUserName(String uName){
		WebElement setName = driver.findElement(By.xpath("html/body//tr[2]/td[2]/table[2]//tr[2]/td[2]/form//tr[1]/td[2]/input[1]"));
		setName.clear();
		setName.sendKeys(uName);
	}
	
	public void setPwd(String pwd){
		WebElement setName = driver.findElement(By.xpath("//tr[2]/td[2]/table[2]/tbody/tr[2]/td[2]//tr[2]/td[2]/input[1]"));
		setName.clear();
		setName.sendKeys(pwd);
	}
	public void clickInLogOut(){
		WebElement clickLogIn = driver.findElement(By.xpath("html/body//tr[1]/td//tr[2]/td[2]/a/img"));
		clickLogIn.click();
	}
	
	public void clickOnLogIn(){
		WebElement clickOnSubName = driver.findElement(By.xpath("html/body//tr[2]/td[2]/table[2]//tr[2]/td[2]//tr[4]/td[1]/input[1]"));
		clickOnSubName.click();
	}
}
