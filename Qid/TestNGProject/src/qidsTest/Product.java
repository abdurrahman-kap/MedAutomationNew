package qidsTest;

import java.awt.AWTException;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class Product {

   	
	
 static void product(WebDriver driver2, WebDriverWait waitFor2,String [] cmsCategoriesArray,String qIDcelldata, int rowNum) throws Exception{
	 int remainingQuestions=0;	 
	     
	   //Clear history		
		driver2.navigate().to(Utilities.historyMgr);
		WebElement historyMgr=driver2.findElement(By.xpath("//input[@value='Clear History']"));
		historyMgr.click();
		waitFor2.until(ExpectedConditions.alertIsPresent());
		Alert alert= driver2.switchTo().alert();
		alert.accept();
		driver2.navigate().back(); 
		waitFor2.until(ExpectedConditions.presenceOfElementLocated(By.id("tab-1")));

	  
	 	do {
			WebElement createTestTab = driver2.findElement(By.id("tab-2"));
			createTestTab.click();
		WebElement	createTestbutton=createTestbttn(driver2);
			
			waitFor2.until(
					ExpectedConditions.elementToBeClickable(createTestbutton))
					.isEnabled();
			
			
			List<WebElement> difficultyList = driver2
					.findElements(By
							.xpath(".//*[@id='testModeTableHolder']/table[8]/tbody/tr/td[3]"));
			selectCheckbox(driver2, cmsCategoriesArray, difficultyList,
					By.name("difficulty"), true);
			List<WebElement> questionTypeList = driver2
					.findElements(By
							.xpath(".//*[@id='testModeTableHolder']/table[11]/tbody/tr/td[3]"));
			selectCheckbox(driver2, cmsCategoriesArray, questionTypeList,
					By.name("mediaquestions"), true);
			List<WebElement> organSystemList = driver2
					.findElements(By
							.xpath(".//*[@id='organSystemWindow']/div[2]/table/tbody/tr/td/label"));
			selectCheckbox(
					driver2,
					cmsCategoriesArray,
					organSystemList,
					By.xpath(".//*[@id='organSystemWindow']/div[2]/table/tbody/tr/td/label/input"),
					false);
			List<WebElement> disciplineList = driver2
					.findElements(By
							.xpath(".//*[@id='disciplineWindow']/div[2]/table/tbody/tr/td/label"));
			selectCheckbox(
					driver2,
					cmsCategoriesArray,
					disciplineList,
					By.xpath(".//*[@id='disciplineWindow']/div[2]/table/tbody/tr/td/label/input"),
					false);
			WebElement createTest_calculate_Btn = driver2.findElement(By
					.name("calculateBtn"));
			WebElement createTest_calculate_txtBox = driver2.findElement(By
					.name("calculateBox"));
			WebElement createTest_createTest_txtBox = driver2.findElement(By
					.name("createTestBox"));
			createTest_calculate_Btn.click();
			Thread.sleep(2000);
			System.out.println("Caculatetxtbox="+createTest_calculate_txtBox.getAttribute("value"));
			
			int createTest_calculate_txtBox_int = Integer.parseInt(createTest_calculate_txtBox.getAttribute("value"));
			if (createTest_calculate_txtBox_int >= 44) {
				createTest_createTest_txtBox.clear();
				createTest_createTest_txtBox.sendKeys("44");
				remainingQuestions = createTest_calculate_txtBox_int - 44;
			}else {
				createTest_createTest_txtBox.clear();
				createTest_createTest_txtBox.sendKeys(Integer
						.toString(createTest_calculate_txtBox_int));
               remainingQuestions=0;			
			}
			
			WebElement	createTestbutton2=createTestbttn(driver2);
			createTestbutton2.click();
		
		   waitFor2.until(ExpectedConditions.presenceOfElementLocated(By.id("endBlock_img")));
			
		   waitForLoadingIcon(driver2);
			
		
			
			WebElement testPage_endBlock_btn=driver2.findElement(By.id("endBlock_img"));
			
			testPage_endBlock_btn.click();
			WebElement testPage_endBlock_popUp_btn=driver2.findElement(By.id("confirmEndBlockBtn"));
			testPage_endBlock_popUp_btn.click();
			WebElement testPage_endBlock_popUp_btn2=driver2.findElement(By.id("confirmEndBlockBtn2"));
			testPage_endBlock_popUp_btn2.click();
			
			waitFor2.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Test Review")));
			WebElement testReview_testReview_tab=driver2.findElement(By.linkText("Test Review"));
			waitForLoadingIcon(driver2);
			testReview_testReview_tab.click();
			
			List <WebElement> testReviewTab_QidsList=driver2.findElements(By.xpath(".//*[contains(@id,'td_qid')]"));
			
			System.out.println("Qid from CMS="+qIDcelldata);
			try {
				for(int qid=0;qid<testReviewTab_QidsList.size();qid++){
					String testReviewTab_Qid=testReviewTab_QidsList.get(qid).getText();
					System.out.println("Qid on review page="+testReviewTab_Qid);
					
					if(testReviewTab_Qid.equalsIgnoreCase(qIDcelldata)){
						WebElement testReviewTab_Explaination_Link=driver2.findElement(By.xpath(".//*[@id='td_expln"+qid+"']/a"));
						testReviewTab_Explaination_Link.click();
						break;
					}
				}
				WebDriverWait wait=new WebDriverWait(driver2,2);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exitButton")));
				WebElement exitButton=driver2.findElement(By.id("exitButton"));
				waitForLoadingIcon(driver2);
				Utilities.screenshots(driver2, qIDcelldata+"_web");
				Excel.SetCellData("Pass",  rowNum, 2);
				Thread.sleep(2000);
				exitButton.click();
			} catch (Exception e) {
				Excel.SetCellData("Qid Not found in product",  rowNum, 2);
				
				e.printStackTrace();
			}
			
		} while (remainingQuestions>0);
	     
	     
	     
	     
	}



 static WebElement createTestbttn(WebDriver driver2) {
	WebElement createTestButton = driver2.findElement(By
			.name("createTestBtn"));
	return createTestButton;
	
}



static void waitForLoadingIcon(WebDriver driver2) {
	
	WebElement LoadingIcon=driver2.findElement(By.id("ajaxBusy"));
	
	while(LoadingIcon.isDisplayed()){}
}


static void selectCheckbox(WebDriver driver2,String [] cmsCategoriesArray,List <WebElement> listName,By by, boolean flag2) throws InterruptedException {
	 Thread.sleep(2000);
	 String elementList;
		//elementListArray[0]=null; 
	 Boolean flag=false;
	List <WebElement> checkboxlist= driver2.findElements(by);
	
	if(checkboxlist.get(0).isSelected()){
		checkboxlist.get(0).click();
	}
	for(int i=0;i<listName.size();i++){
		elementList=listName.get(i).getText();
		System.out.println("elementlist="+elementList);
		for(int j=0;j<cmsCategoriesArray.length;j++){
			
			if(cmsCategoriesArray[j].trim().equalsIgnoreCase(elementList.trim())){
				if(flag2==true){
					checkboxlist.get(i+1).click();
					flag=true;
					System.out.println("Category selected= "+cmsCategoriesArray[j]);
					break;
				}
				else{
				checkboxlist.get(i).click();
				flag=true;
				System.out.println("Category selected= "+cmsCategoriesArray[j]);
				break;
				}
			}
		
			
		}
		if(flag==true){
			break;
		}
		
	}
	
}



static void productLogin(WebDriver driver2, WebDriverWait waitFor2) throws AWTException, InterruptedException{
	if(Utilities.productName.endsWith("OLP")){
	driver2.get(Utilities.olpURL);
	driver2.manage().window().maximize();
	Thread.sleep(5000);
		}
	else{
		driver2.get(Utilities.jasperURL);
		driver2.manage().window().maximize();
		Thread.sleep(5000);
		driver2.findElement(By.id("kecuserName")).sendKeys("swagh");
		driver2.findElement(By.id("kecpassword")).sendKeys("kaplan#5");
		
	}
	
	driver2.findElement(By.id("userName")).sendKeys(Utilities.username);
	driver2.findElement(By.id("password")).sendKeys(Utilities.password);
	driver2.findElement(By.xpath(".//*[@id='productName_chosen']/a/span")).click();
	List <WebElement> prod= driver2.findElements(By.xpath(".//*[@id='productName_chosen']/div/ul//li"));
	
	for(int i=0;i<prod.size();i++)
	{
		if(prod.get(i).getText().equalsIgnoreCase(Utilities.productName))
		{
		  prod.get(i).click();
		  break;
		  
		}
		
	}
	try{
		driver2.findElement(By.xpath("//input[@value='Login']")).click();
		
		Alert aler=driver2.switchTo().alert();
		System.out.println(aler.getText());
		Thread.sleep(2000);
		aler.accept();
		//screenshot(driver2);
		//Thread.sleep(5000);
		WebElement loadingIcon = driver2.findElement(By.xpath("html/body/div[1]/img"));
		
		while (loadingIcon.isDisplayed()){
		
		}
		driver2.findElement(By.xpath("//input[@value='Login']")).click();
		
		waitFor2.until(ExpectedConditions.presenceOfElementLocated(By.id("tab-1")));
		

		
	
	}
	catch(Exception e){
		
	}	
	
}

}