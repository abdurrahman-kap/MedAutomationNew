package step3;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Step3 {
	
	public static void gotoStep3(WebDriver driver) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		WebDriverWait waitFor= new WebDriverWait(driver,10);
		
		List <WebElement> specialityList=driver.findElements(By.xpath(".//*[@id='nav']/li/ul/li"));
		
		int rowcnt=Excel.rowcount();
		System.out.println("row count is "+rowcnt);
		
		for(int i=Utilties.globalrowcount;i<=rowcnt;i++){
			try {
				 
				String specialityMover =".//*[@id='nav']/li/a";
				Utilties.mouseOver(driver,By.xpath(specialityMover));
				String specialityTitleExcel =Excel.readFromExcel(0);
				System.out.println(Utilties.globalrowcount);
				//System.out.println(specialityTitleExcel);
				
				Utilties.mouseOver(driver, By.linkText(specialityTitleExcel));
				String specialitySubTitleExcel =Excel.readFromExcel(1);
				Thread.sleep(2000);
				driver.findElement(By.linkText(specialitySubTitleExcel)).click();
				String topicExcel =Excel.readFromExcel(2);
				//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='chapter-dashboard-paging-left']/ul/li[2]")));
				
				//driver.findElement(By.xpath(".//*[@title='"+topicExcel+"']")).click();

					driver.findElement(By.xpath(".//*[contains(@title,'"+topicExcel+"')]")).click();
					
				
				verifyPageNumber(driver);
				
				Thread.sleep(2000);
			} catch (Exception e) {
				Utilties.globalrowcount=Utilties.globalrowcount+1;
				
				
					Utilties.screenshot(driver);
				e.printStackTrace();
			    
			}
			
			
		}
		
	}

	public static void verifyPageNumber(WebDriver driver) throws IOException {
		
		try {
			WebDriverWait waitFor= new WebDriverWait(driver,30);
			
				//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.className("ng-binding")));
				Thread.sleep(2000);
				List <WebElement> seekPointTitle=driver.findElements(By.xpath(".//*[@id='lecture-slides-focuser']/a"));
				System.out.println("slides count "+seekPointTitle.size());
				
				System.out.println("seekpoint size "+seekPointTitle.size());
				for(int i=1;i<=seekPointTitle.size();i++){
						String seekPointExcel =Excel.readFromExcel(4);
						int pageNumberExcel=Integer.parseInt(Excel.readFromExcel(7)); 
						
						
						Thread.sleep(2000);
						
						System.out.println("i="+i);
						while(i==1){
							Thread.sleep(15000);
							break;
						}
						int pageRefNumber=getPageRef(driver,i);
						String pageRefNumberString=Integer.toString(pageRefNumber);
						Excel.SetCellData(pageRefNumberString, Utilties.globalrowcount,8);
						
						if(pageNumberExcel==pageRefNumber){
							Excel.SetCellData("Pass", Utilties.globalrowcount,9);
							System.out.println(seekPointExcel+"Pass");
						}
						else{
							Excel.SetCellData("Fail", Utilties.globalrowcount,9);
							Utilties.screenshot(driver);
							System.out.println(seekPointExcel+"Fail");
						}
						Utilties.globalrowcount=Utilties.globalrowcount+1;
						
					}
				WebElement bannerLogo=driver.findElement(By.xpath("html/body/div[1]/div/header/div/a"));
				bannerLogo.click();
				//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='home-dashboard-table-txt']/li[11]/ul/li[1]/a")));
		} catch (Exception e) {
			Utilties.globalrowcount=Utilties.globalrowcount+1;
		    Utilties.screenshot(driver);
		    System.out.println(e.getMessage());
		    e.printStackTrace();
		}
			
			
		
		
	}

	public static int getPageRef(WebDriver driver, int slideno) throws IOException {
		
		try {
			int i=0;
			WebElement scrollBar=driver.findElement(By.xpath(".//*[@id='vp-scrubber']"));
			
			driver.findElement(By.xpath(".//*[@id='lecture-slides-focuser']/a["+slideno+"]")).click();
			while(scrollBar.getAttribute("aria-disabled").equals("true")){
				Thread.sleep(1000);
				System.out.println(i);
				i=i+1;
			}
			//Thread.sleep(2000);
				String pageRefText= driver.findElement(By.xpath(".//*[@id='scrollable-page-references']/p")).getText();
				System.out.println("ref no. "+pageRefText);
				if(pageRefText==null){
					return 0;
				}
				else{
					
				String [] pageRefArray=pageRefText.split(" ");
				int pageRefArrayLength= pageRefArray.length;
				
				for(String j: pageRefArray){
					System.out.println(j);
				}
				int pageRefNumber= Integer.parseInt(pageRefArray[pageRefArrayLength-1].trim());
				
				
				return pageRefNumber;
				}
		} catch (Exception e) {
			
			Utilties.screenshot(driver);
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			return 0;
		}
			
		}
		
		
			
	
		
		
		
}

	


