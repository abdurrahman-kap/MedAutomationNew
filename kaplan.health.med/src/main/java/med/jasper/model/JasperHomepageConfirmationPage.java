package med.jasper.model;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JasperHomepageConfirmationPage{
	
	protected WebDriver driver = null;
	
	public JasperHomepageConfirmationPage(WebDriver driver){
		this.driver= driver;
	}
	
	public String getVideoStatus(){
		WebElement getVideoStatus = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[1]/div[2]/a/span"));
		waitFor(2);
		System.out.println("Getting somr thing : "+getVideoStatus.getText());
		return getVideoStatus.getText();
	}
	
	public String getlecHeaderText(){
			WebElement getlecSlides = driver.findElement(By.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
			System.out.println("Chk Value : " + getlecSlides.getText());
			return getlecSlides.getText();
	}
	
	public String getWelcomePageText(){
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("main");
		WebElement fndElement = driver.findElement(By.xpath("//html/body/div[1]/center//tr/td//tr[1]/td/div[1]/b"));
		return fndElement.getText();		
      }
	
	
	public String getlecSlidesText(){
		String getVal = null;
		for(int i=1;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				WebElement getlecSlidesText = driver.findElement(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]"));
				System.out.println("Lecture Slide : " + getlecSlidesText.getText());
				getVal = getlecSlidesText.getText();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
		return getVal;
	}
	
	public String getHomePagetitle() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='welcome-message-container']/div/h3"));
		System.out.println("Home Page Title : " + pagetitleText.getText());
		return pagetitleText.getText();
	}

	public String getTitleString() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
		System.out.println("Home Page Title : " + pagetitleText.getText());
		return pagetitleText.getText();
	}
	
	public String getQuizTitleString() {
		WebElement pagetitleText = driver.findElement(By.xpath("//div[1]/div/div[1]/ng-view/div[1]/h3"));
		return pagetitleText.getText();
	} 
	
	public String getUpdateDate() {
		WebElement pagetitleText = driver.findElement(By.xpath("question/explanation/para[9]/emphasis"));
		System.out.println("UpdateDate is : " + pagetitleText.getText());
		return pagetitleText.getText();
	}

	public String getContTime(int j) {
		WebElement pagetitleText = driver.findElement(By.xpath("html/body/div[1]/div[1]/section[1]/div[4]/div[2]/div["+j+"]/div[4]"));
		return pagetitleText.getText();
	}
	
	public String getVideoTime() {
		WebElement pagetitleText = driver.findElement(By.xpath("//div[3]/div[3]/vp-timer/span"));
		String som = pagetitleText.getText();
		String[] getTime = som.split("/");
		return getTime[1];
	}
//*******************************************Utility********************************************************
		public void waitFor(int sec){
			  try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		
		public void util(){
			/*List<WebElement> elx = driver.findElements(By.cssSelector("*"));

			for ( WebElement e : elx ) {
			  System.out.println("Tag Name BY cssSelector : " + e.getTagName());
			  System.out.println("Tag Name BY cssSelector : " + e.getText());
			}*/
			
			/*List<WebElement> el = driver.findElements(By.cssSelector("*"));

			for ( WebElement e : el ) {
			  System.out.println("Tag Name Before Frame : " + e.getTagName());
			  System.out.println(" Name Before Frame : " + e.getText());
			  
			}*/
		}
}
