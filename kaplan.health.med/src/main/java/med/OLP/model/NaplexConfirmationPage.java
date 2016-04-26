package med.OLP.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NaplexConfirmationPage {
	
	protected WebDriver driver = null;
	
	public NaplexConfirmationPage(WebDriver driver){
		this.driver= driver;
	}
	
	public String getlecHeaderText(){
			WebElement getlecSlides = driver.findElement(By.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
			System.out.println("Chk Value : " + getlecSlides.getText());
			return getlecSlides.getText();
	}
	
	public String getWelcomePageText(){
		waitFor(5);
		WebElement fndElement = driver.findElement(By.xpath("//tr[4]/td/b"));
		return fndElement.getText();		
      }

	public void waitFor(int sec){
		  try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
}
