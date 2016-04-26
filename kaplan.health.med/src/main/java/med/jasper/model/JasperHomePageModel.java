package med.jasper.model;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JasperHomePageModel {
	
	protected WebDriver driver = null;
	String subName;
	String modName;
	String titleName;
	String titleString;
	String chapName;
	public JasperHomepageConfirmationPage confmPage = null;
	
	public JasperHomePageModel(WebDriver driver){
		this.driver= driver;
		confmPage = new JasperHomepageConfirmationPage(driver);
	}
	
	public void clickOnSub(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnSub(String subbbbb){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[text()='"+subbbbb+"']"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnBiochemistry(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnPharmacology(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[3]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnImmunology(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[4]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnInfectiousDisease(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[5]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnEpidemiology(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[6]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	public void clickOnBehavioral (){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[7]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnNeuroscience(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[9]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnMusculoskeletal (){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[10]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnRespiratory (){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[11]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnCardiology(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[12]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnGastroenterology(){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[13]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnEndocrinology (){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[14]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnNephrology            (){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[15]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}
	
	public void clickOnReproductive (){
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li[16]/ul/li[1]/a"));
		waitFor(2);
		subName = clickOnSubName.getText();
		clickOnSubName.click();
	}	
	
	public void clickOnMol(String dispName){
			
		for(int i=1;i<1500;i++){
			
			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if(subName>0 && i>1){
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"+dispName+"']"));
				modName = subNameText.getText();
				
				boolean bst = isClickable(subNameText);
				System.out.println("mama paici ::: "+bst);
				if(bst== true){
					System.out.println("find the way ::::");
					waitFor(2);
					subNameText.click();
				}else {
					System.out.println("kos  ki momin");
				}
			}
			
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				WebElement lecSlidesText = driver.findElement(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(3);
				clickOnVideoTitle();
				waitFor(10);
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	public void clickOnChapterPage(String disName){
		
		for(int i=1;i<1500;i++){
			
			int subNum = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if(subNum>0){
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"+disName+"']"));
				subName = subNameText.getText();
				subNameText.click();
			}
			
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a")).size();
			waitFor(2);
			
			if(nubEle!=0){
				
				waitFor(3);
				WebElement lecSlidesText = driver.findElement(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(3);
				
				int j = getkQuizLineNum();
				waitFor(2);
				
				clickOnQuiz(j);
				waitFor(5);
				
			
				
				driver.navigate().back();
				waitFor(2);
				driver.navigate().back();
				waitFor(2);
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	private void clickOnQuiz(int elnumb) {
		
		int bQuiz = driver.findElements(By.xpath(".//*[@id='chapter-dashboard-results']/div["+elnumb+"]/div[3]/a")).size();
		
		if(bQuiz!=0){
			WebElement chapNameText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div["+elnumb+"]/div[1]/a"));
			chapName = chapNameText.getText();
			
			WebElement subNameText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div["+elnumb+"]/div[3]/a"));
			
			subNameText.click();
			int nubAnaChk = driver.findElements(By.xpath("html/body/div/div/div[1]/ng-view/div[1]/div[2]/table/tbody/tr[1]/td[4]/a")).size();
			waitFor(2);
			
			if(nubAnaChk==0){
				
				WebElement clickOnStart = driver.findElement(By.xpath("//div/div[2]/div[1]/a/span"));
				clickOnStart.click();
				waitFor(10);
				
				WebElement clickOnEndQuiz = driver.findElement(By.xpath("//div[3]/span/a/span"));
				clickOnEndQuiz.click();
				waitFor(3);
				
				WebElement clickConfEndQuiz = driver.findElement(By.xpath("//div[1]/div[2]/div/p[2]/a[2]"));
				clickConfEndQuiz.click();
				waitFor(3);
				
				clickOnAnalysis();
				String quizTitle ="Quiz Analysis: "+ subName +" - " + modName;
				System.out.println("Quiz Analysis Title : " +quizTitle);
				Assert.assertEquals(quizTitle, confmPage.getQuizTitleString());
				waitFor(5);
				driver.navigate().back();
				waitFor(2);
				driver.navigate().back();
				waitFor(2);
				driver.navigate().back();
				
			}else{
				clickOnAnalysis();
				String quizTitle ="Quiz Analysis: "+ subName +" - " + modName;
				System.out.println("Quiz Analysis Title : " +quizTitle);
				Assert.assertEquals(quizTitle, confmPage.getQuizTitleString());
				waitFor(5);
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
	
	public void clickOnNothing() {
		WebElement clickOnSubName = driver.findElement(By.xpath(".//*[@id='WebprepSyllabus']"));
		clickOnSubName.click();
	}
	
	public void clickOnVideoStatus(){
		WebElement clickVideo = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[1]/div[2]/a/span"));
		waitFor(2);
		clickVideo.click();
	}

	public void clickOnContinue() {
		int fElement = driver.findElements(By.xpath("//div[1]/div/div/div/p[3]/a")).size();
		if(fElement != 0){
			WebElement clickOnSubName = driver.findElement(By.xpath("//div[1]/div/div/div/p[3]/a"));
			clickOnSubName.click();
		}
	}
	
	public void clickOnAnalysis() {
		int fElement = driver.findElements(By.xpath("html/body/div/div/div[1]/ng-view/div[1]/div[2]/table/tbody/tr[1]/td[4]/a")).size();
		System.out.println("analysis is display : "+fElement);
		if(fElement != 0){
			WebElement clickOnAnalysis = driver.findElement(By.xpath("html/body/div/div/div[1]/ng-view/div[1]/div[2]/table/tbody/tr[1]/td[4]/a"));
			waitFor(1);
			clickOnAnalysis.click();
		}
	}
	
	public void clickOnVideoTitle(){
		
		/*WebElement clickVideo = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[1]/div[1]/a"));	
		waitFor(2);
		titleName = clickVideo.getText();
		clickVideo.click();*/
		
		for(int i=1;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				WebElement videoTitleText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a"));
				titleName = videoTitleText.getText();
				videoTitleText.click();
				waitFor(10);
				titleString = subName +" - " + modName +" - " + titleName ;
				System.out.println("Tile String : "+ titleString);
				confmPage.getlecSlidesText();
				Assert.assertEquals(titleString, confmPage.getTitleString());
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	public int getkQuizLineNum(){
		int lNum = 0;
		for(int i=1;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a")).size();
			waitFor(2);
			if(nubEle>0){
				 lNum = i;
			}else {
				System.out.println("No More Element found !!!!" );
				break;
				
			}
		}
		return lNum;
	}
	
	public String getTitleString(){
		titleString = subName +" - " + modName +" - " + titleName ;
		return titleString;
	}
	
	public void clickDisplayTime(String dispName){
		for(int i=1;i<1500;i++){
			
			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if(subName>0){
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"+dispName+"']"));
				modName = subNameText.getText();
				subNameText.click();
			}
			
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				
				WebElement lecSlidesText = driver.findElement(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				
				waitFor(10);
				clicVideoTime();
				waitFor(10);
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	public void clicVideoTime(){
		
		for(int i=1;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a")).size();
			waitFor(2);
			if(nubEle>0){
				int m = i;
				waitFor(3);
				String timeVal = (confmPage.getContTime(m));
				
				waitFor(10);
				WebElement videoTitleText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a"));
				titleName = videoTitleText.getText();
				videoTitleText.click();
				waitFor(10);
				confmPage.getVideoTime();
				waitFor(3);
				Assert.assertEquals(timeVal.trim(), confmPage.getVideoTime().trim());
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
//*************************************Utility**********************************
	public void waitFor(int sec){
		  try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	

	public boolean isClickable(WebElement webe)      
	{
		try
		{
		   WebDriverWait wait = new WebDriverWait(driver, 1);
		   //wait.until(ExpectedConditions.elementToBeClickable(webe));
		   wait.until(ExpectedConditions.visibilityOf(webe));
		   return true;
		}
		catch (Exception e)
		{
		  return false;
		}
	}
}