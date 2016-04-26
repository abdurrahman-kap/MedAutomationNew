package med.OLP.model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OLPLogInPageModel {
	protected WebDriver driver = null;
	
	public OLPLogInPageModel(WebDriver driver){
		this.driver= driver;
	}
	
	public void setUserName(String uName){
		WebElement setName = driver.findElement(By.name("userName"));
		setName.clear();
		setName.sendKeys(uName);
	}
	
	public void setPwd(String pwd){
		WebElement setName = driver.findElement(By.name("password"));
		setName.clear();
		setName.sendKeys(pwd);
	}
	
	public void clickLogIn(){
		WebElement clickLogIn = driver.findElement(By.xpath("html/body/form//tr[1]/td//tr[5]/td/input"));
		clickLogIn.click();
	}

	public void clickOnProduct(String prodName){
		WebElement getObject = driver.findElement(By.name("productName"));
		SelectElement(getObject, prodName);
	}
		
	public void clickOnSyllabusPath(String pathValue){
		WebElement getObject = driver.findElement(By.name("syllabusPath"));
		SelectSyllabusPath(getObject, pathValue);
	}
	
//*************************************Utility**********************************
	public void waitFor(int sec){
		  try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	
	public void SelectElement(WebElement element, String item){
		Select combo = new Select(element);
		List<WebElement> list = combo.getOptions();
		for(WebElement e : list){
			if(e.getAttribute("value").contentEquals(item)){
				waitFor(3);
				WebElement clickOnProd = driver.findElement(By.xpath(".//*[@id='productName_chosen']/a/div/b"));
				clickOnProd.click();
				waitFor(3);
				WebElement setProd = driver.findElement(By.xpath(".//*[@id='productName_chosen']/div/div/input"));
				setProd.sendKeys(item);
				waitFor(3);
				WebElement clickProd = driver.findElement(By.xpath(".//*[@id='productName_chosen']/div/ul/li/em"));
				clickProd.click();
				waitFor(3);
			}
		}
	}

	public void SelectSyllabusPath(WebElement element, String item){
		Select combo = new Select(element);
		List<WebElement> list = combo.getOptions();
		for(WebElement e : list){
			System.out.println(e.getAttribute("value"));
			if(e.getAttribute("value").contentEquals(item)){
				waitFor(3);
				WebElement clickOnProd = driver.findElement(By.xpath(".//*[@id='syllabusPath_chosen']/a/div/b"));
				clickOnProd.click();
				waitFor(3);
				WebElement setProd = driver.findElement(By.xpath(".//*[@id='syllabusPath_chosen']/div/div/input"));
				setProd.sendKeys("/nbde/nbde1Diag2010_v2");
				waitFor(3);
				WebElement clickProd = driver.findElement(By.xpath(".//*[@id='syllabusPath_chosen']/div/ul/li/em"));
				clickProd.click();
				waitFor(3);
			}
		}
	}
	
	public void SelectElementPrint(){
		WebElement make = driver.findElement(By.name("productName"));
		Select combo = new Select(make);
		List<WebElement> list = combo.getOptions();
		for(WebElement e : list){
			System.out.println(e.getAttribute("value"));
		}
	}
}
