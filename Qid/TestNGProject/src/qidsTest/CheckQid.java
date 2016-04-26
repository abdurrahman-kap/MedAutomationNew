package qidsTest;

import java.io.IOException;
import java.util.List;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckQid {

	public static void checkQids(WebDriver driver,WebDriverWait waitFor, WebDriver driver2,WebDriverWait waitFor2) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		
		try {
			String cmsParentWindows =driver.getWindowHandle();
			//open Product URL
			
			System.out.println("parent window name="+cmsParentWindows);
			//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
			//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
			//driver.switchTo().window(cmsParentWindows);
			waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/center/div/table[1]/tbody/tr/td[3]/img")));
			
			Product.productLogin(driver2,waitFor2);
			
			WebElement contentSearch =driver.findElement(By.xpath("//tr[8]/td/a"));
			
			contentSearch.click();
			Thread.sleep(3000);
			
			System.out.println("After");
			int rowcount=Excel.rowcount();
			for(int i=Utilities.startFromRowinExcel;i<=rowcount;i++){
				try {
					driver.switchTo().frame(driver.findElement(By.id("frmSearchCriteria")));
						
					waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='btnSearch']")));

					
					WebElement qidName=driver.findElement(By.xpath(".//*[@id='txtNameFilter']"));
					
					String qIDcelldata=Excel.readFromExcel(0,i);
					//String reviewDate=Excel.readFromExcel(1, i);
					qidName.clear();
					qidName.sendKeys(qIDcelldata);
					driver.findElement(By.xpath(".//*[@id='btnSearch']")).click();
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.id("frmResults")));
					
					//Thread.sleep(3000);
					List <WebElement> results=driver.findElements(By.xpath("//td[1]/span"));
					
					System.out.println("no of qids found in CMS="+results.size());
					
					if(results.size()>0){    
						for(int j=0;j<results.size();j++){
							if(results.get(j).getText().equalsIgnoreCase(qIDcelldata)){
								results.get(j).click();
								break;
							}
						     
						}
						for(String windhadle : driver.getWindowHandles())	{
							driver.switchTo().window(windhadle);
							
						}
						driver.manage().window().maximize();
						
						Utilities.screenshots(driver,qIDcelldata);
						String cmsQuestionViewer=driver.getWindowHandle();
						System.out.println("windowshandle="+cmsQuestionViewer);
						
						//String[] cmsCategories=driver.findElement(arg0)
						String cmsCategoriesString=driver.findElement(By.xpath("//td[@colspan='3']")).getText().replace("Categories: ", "");
						System.out.println(cmsCategoriesString);
						String [] cmsCategoriesArray=cmsCategoriesString.split(",");
						for(int j=0;j<=cmsCategoriesArray.length-1;j++){
							System.out.println(cmsCategoriesArray[j]);
							if(cmsCategoriesArray[j].trim().equalsIgnoreCase("regular questions")){
								cmsCategoriesArray[j]=cmsCategoriesArray[j].replace("questions","");
								break;
							}
						}
						
						for(int k=0;k<=cmsCategoriesArray.length-1;k++){
							System.out.println(cmsCategoriesArray[k]);
							
						}
						
						driver.close();	
						driver.switchTo().window(cmsParentWindows);
						Thread.sleep(3000);
						
						Product.product(driver2,waitFor2,cmsCategoriesArray,qIDcelldata,i);
						
						/*driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
						driver.get("abc.xyz.com");
						*/
						
						System.out.println("parent window name="+cmsParentWindows);
					} 
					else{
						
						Excel.SetCellData("Qid not found in CMS",  i, 2);
					}
				} catch (Exception e) {
					
					Excel.SetCellData("Check Manually",  i, 2);
					e.printStackTrace();
				}
			
			
			
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
}
