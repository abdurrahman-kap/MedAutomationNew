package med.OLP.model;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OLPHomepageConfirmationPage{
	
	protected WebDriver driver = null;
	
	public OLPHomepageConfirmationPage(WebDriver driver){
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

	public String getAnalysisPageText() {
		waitFor(2);
		WebElement fndElement = driver.findElement(By.xpath("//thead/tr[1]/td/div"));
		return fndElement.getText();
	}
	
	public String getAnalysisString() {
		WebElement pagetitleText = driver.findElement(By.xpath("//tbody/tr/td[7]/a[1]"));
		return pagetitleText.getText();
	}
	
	public String getReviewString() {
		waitFor(2);
		WebElement fndElement = driver.findElement(By.xpath("//tr/td[7]/a[2]"));
		return fndElement.getText();
	}
	
	public void verifyColHeaderText() {
		String getVal = null;
		String colHeader[] = {"#","DATE & TIME","TYPE","STATUS","# of ?s","SCORE",""};
		for(int i=1;i<15;i++){
			int nubEle = driver.findElements(By.xpath("//table[2]/thead/tr[3]/td["+i+"]")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				WebElement getlecSlidesText = driver.findElement(By.xpath("//table[2]/thead/tr[3]/td["+i+"]"));
				System.out.println("Lecture Slide : " + getlecSlidesText.getText());
				getVal = getlecSlidesText.getText();
				if(getVal!= null){
						Assert.assertEquals(colHeader[i-1], getVal);
					}
			}else {
				break;
			}
		}
		
	}
	
	public void verifyReviewColHeaderText() {
		String getVal = null;
		String colHeader[] = {"Correct?","Correct Answer","Previous Answer","Seconds Used","Disciplines","Organ Systems","Q.Id",""};
		for(int i=5;i<25;i++){
			int nubEle = driver.findElements(By.xpath(".//*[contains(@id,'section')]/table/thead/tr[2]/td["+i+"]")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				WebElement getlecSlidesText = driver.findElement(By.xpath(".//*[contains(@id,'section')]/table/thead/tr[2]/td["+i+"]"));
				getVal = getlecSlidesText.getText();
				Assert.assertEquals(colHeader[i-5], getVal);
			}else {
				break;
			}
		}
		//"M","Q#",
	}
	
	public String getHomePagetitle() {
		WebElement pagetitleText = driver.findElement(By.xpath(".//*[@id='welcome-message-container']/div/h3"));
		System.out.println("Home Page Title : " + pagetitleText.getText());
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
	
	public String getDisciplineText() {
		WebElement pagetitleText = driver.findElement(By.xpath("//table[5]/tbody/tr/td/span"));
		return pagetitleText.getText();
	}

	public String getOrganSystemText() {
		WebElement pagetitleText = driver.findElement(By.xpath("//table[7]/tbody/tr/td/span"));
		return pagetitleText.getText();
	}
	
	public String getOVERALLPERFORMANCEText() {
		WebElement pagetitleText = driver.findElement(By.xpath("//table[3]/tbody/tr/td/span"));
		return pagetitleText.getText();
	}

	public boolean getExplanationLinkVal(){
		driver.switchTo().frame("main").switchTo().frame("sequenceContentFrame");	
		int subName = driver.findElements(By.name("btnExplanation")).size();
		if(subName>0){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean getCloseLinkVal(){
		WebElement subName = driver.findElement(By.xpath("//td/div/div[2]/div/div/div/span/img"));
		if(subName.isDisplayed()){
			return true;
		}else {
			return false;
		}
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
