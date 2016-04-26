package admin.reports.Model;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminReportPageModel {
protected WebDriver driver = null;
	
	public AdminReportPageModel(WebDriver driver){
		this.driver= driver;
	}
	
	public void clickOnReportType(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[1]/li/a"));
		setName.click();
	}
	
	public void clickOnStudentPerformance(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[1]/li/ul/li/a"));
		setName.click();
	}
	
	public void clickOnAdministrators(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[1]/a"));
		setName.click();
	}
	
	public void clickOnCreateAdministrator(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[1]/ul/li[1]/a"));
		setName.click();
	}
	
	public void clickOnListAdministrator(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[1]/ul/li[2]/a"));
		setName.click();
	}
	
	public void clickOnInstitution(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[2]/a"));
		setName.click();
	}
	
	public void clickOnCreateInstitution(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[2]/ul/li[1]/a"));
		setName.click();
	}
	
	public void clickOnListInstitution(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[2]/ul/li[2]/a"));
		setName.click();
	}
	
	public void clickOnManage(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[3]/a"));
		setName.click();
	}
	
	public void clickOnMapclasstoInstitution(){
		WebElement setName = driver.findElement(By.xpath(".//*[@id='Sidebar']/ul[2]/li[3]/ul/li/a"));
		setName.click();
		
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
