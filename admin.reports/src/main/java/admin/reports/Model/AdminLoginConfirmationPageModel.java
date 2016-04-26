package admin.reports.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginConfirmationPageModel {
protected WebDriver driver = null;
	
	public AdminLoginConfirmationPageModel(WebDriver driver){
		this.driver= driver;
	}
	
	public String getBlueBanner() {
		WebElement pagetitleText = driver.findElement(By.xpath("//div[1]/div/h1/a"));
		System.out.println("Home Page Title : " + pagetitleText.getText());
		return pagetitleText.getText();
	}

	public String getPageConfString() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='LowerNav']/div/div[1]/h3"));
		System.out.println(pagetitleText.getText());
		return pagetitleText.getText();
	}
	
	public String getFooterString() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='Footer']/div/div[1]/p[1]"));
		return pagetitleText.getText();
	} 
	
	public String getPageNavConf() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='Main']/div/h3"));
		System.out.println(pagetitleText.getText());
		return pagetitleText.getText();
	}

	public String geterrorMessageOne() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='Top']/div/form/div[1]/ul/li"));
		System.out.println(pagetitleText.getText());
		return pagetitleText.getText();
	}
	
	public String geterrorMessageUid() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='Top']/div/form/div[1]/ul/li[1]"));
		System.out.println(pagetitleText.getText());
		return pagetitleText.getText();
	}
	
	public String geterrorMessagePwd() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='Top']/div/form/div[1]/ul/li[2]"));
		System.out.println(pagetitleText.getText());
		return pagetitleText.getText();
	}

	public String getSignOutConf() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='LowerNav']/div/div[1]/h3"));
		System.out.println(pagetitleText.getText());
		return pagetitleText.getText();
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
