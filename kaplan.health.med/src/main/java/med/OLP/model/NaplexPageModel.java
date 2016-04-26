package med.OLP.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NaplexPageModel {

	protected WebDriver driver = null;
	
	public NaplexPageModel(WebDriver driver){
		this.driver= driver;
	}
	
	public String getlecHeaderText(){
			WebElement getlecSlides = driver.findElement(By.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
			System.out.println("Chk Value : " + getlecSlides.getText());
			return getlecSlides.getText();
	}
}
