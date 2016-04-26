package health.med;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TitleVerify {
	
    private WebDriver driver = null;
    String subName;
	String modName;
	String titleName;
	String titleString;
	String chapName;
	String timeVal;
	
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

	public void clickOnContinue() {
		int fElement = driver.findElements(By.xpath("//div[1]/div/div/div/p[3]/a")).size();
		if(fElement != 0){
			WebElement clickOnSubName = driver.findElement(By.xpath("//div[1]/div/div/div/p[3]/a"));
			clickOnSubName.click();
		}
	}
	
	public void clickOnChapterClose(){
		WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='chapter-list']/button"));
		clickLogIn.click();
	}
	public void clickOnProduct(String prodName){
		WebElement getObject = driver.findElement(By.name("productName"));
		SelectElement(getObject, prodName);
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
	public void waitFor(int sec){
		  try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	//***********************************************************************************
	public void clickOnProducts()throws Exception {
		
		for(int i=3;i<1500;i++){

			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li["+i+"]/ul/li[1]/a")).size();
			if (subName > 0) {
				System.out.println(" Value of Disciplines : "+ i);
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath(".//*[@id='home-dashboard-table-txt']/li["+i+"]/ul/li[1]/a"));
				modName = subNameText.getText();
				System.out.println("Home dashboard Disciplines name : " + modName );
				clickDisplayTime(modName);
			}else {
				System.out.println("No More Disciplines found !!!!" );
				break;
			}	
		}
	}
	
	public void clickDisplayTime(String dispName) throws Exception{
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
				waitFor(2);
				
				WebElement lecSlidesText = driver.findElement(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(2);
				clicVideoTitle();
				waitFor(2);
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				clickOnChapterClose();
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
				String timeVal = (getContTime(m));//get the time from dashboards
				
				waitFor(5);
				WebElement videoTitleText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a"));
				titleName = videoTitleText.getText();//need Text Value
				//videoTitleText.click();
				waitFor(5);
				getVideoTime();
				waitFor(3);
				org.testng.Assert.assertEquals(timeVal.trim(), getVideoTime().trim());
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	public void clicVideoTitle() throws Exception{
		
		for(int i=1;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a")).size();
			waitFor(2);
			System.out.println("	Lecture title quentity : "+nubEle);
			if(nubEle>0){
				int m = i;
				waitFor(2);
				timeVal = (getContTime(m));
				System.out.println("	Dashbord time is  : " + timeVal);
				waitFor(2);
				WebElement videoTitleText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a"));
				titleName = videoTitleText.getText();
				System.out.println("	Lecture title Name : "+titleName);
				videoTitleText.click();
				waitFor(2);
				getlecSlidesText();
				waitFor(2);
				driver.navigate().back();
			}else {
				System.out.println("	No More Element found !!!!" );
				break;
			}
		}
		//return titleName;
	}
	
	public void getlecSlidesText(){
		String getVal = null;
		
		for(int i=1;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]")).size();
			waitFor(2);
			//System.out.println("		Lecture Slide number in Vedio page: "+ nubEle );
			if(nubEle>0){
				waitFor(2);
				WebElement getlecSlidesText = driver.findElement(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]"));
				System.out.println("		Lecture Slide : " + getlecSlidesText.getText());
				getVal = getlecSlidesText.getText();
			}else {
				System.out.println("		No More Element found !!!!" );
				break;			
			}
			
		}
		//return getVal;
	}
	//*********************************************************************
	@Test
	public void test1() throws Exception{
		waitFor(2);
		setUserName("abrahman");
		waitFor(2);
		setPwd("abrahman");
		waitFor(2);
		clickOnProduct("USMLEStep1HYOnlinePrepHTML");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickOnContinue();
		waitFor(2);
		clickOnProducts();
	}
	
	
	//*********************************************************************************************** 
	@BeforeMethod
	public void beforeMethod(){
		
		FirefoxProfile profile = new FirefoxProfile(); //FirefoxDriver
		//profile.setPreference("browser.cache.disk.enable", false);
		driver = new FirefoxDriver(profile); 
		driver.manage().window().maximize();
		driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
}
