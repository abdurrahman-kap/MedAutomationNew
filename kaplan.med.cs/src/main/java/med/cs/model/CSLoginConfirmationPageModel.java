package med.cs.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSLoginConfirmationPageModel {
	protected WebDriver driver = null;
	
	public CSLoginConfirmationPageModel(WebDriver driver){
		this.driver=driver;
	}

	public String getLogOff(){
		WebElement getLogText = driver.findElement(By.id("logoff"));
		waitFor(2);
		return getLogText.getText() ;
	}
	//**************************************************************** 
	public void waitFor(int sec){
		  try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
}
