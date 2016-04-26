package kaplan;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Step1Onlineprep{
//	 public static    XSSFWorkbook ExcelWBook;
//	 public static    XSSFSheet ExcelWSheet;
//	 public static    XSSFCell Cell;
//	 public static    XSSFRow Row;
    
	static int countglobal=0;

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException  {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		

		
		driver.get("https://qa-jasperwp.kaptest.com/loginv8.aspx");
		WebDriverWait waitFor = new WebDriverWait(driver, 20);
        
		
		//Login
		driver.manage().window().maximize();
		driver.findElement(By.id("userName")).sendKeys("sphadnis");
		driver.findElement(By.id("password")).sendKeys("sphadnis");
		driver.findElement(By.xpath(".//*[@id='productName_chosen']/a/span")).click();
		List <WebElement> prod= driver.findElements(By.xpath(".//*[@id='productName_chosen']/div/ul//li"));
		
		for(int i=0;i<prod.size();i++){
			if(prod.get(i).getText().equalsIgnoreCase("USMLESTEP1ONLINEPREP2010")){
			  prod.get(i).click();
			  break;
			  
			}
			
		}
		try{
			driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr[5]/td/input")).click();
			
			Alert aler=driver.switchTo().alert();
			System.out.println(aler.getText());
			Thread.sleep(2000);
			aler.accept();
		
			WebElement loadingIcon = driver.findElement(By.xpath("html/body/div[1]/img"));
			
			while (loadingIcon.isDisplayed()){
			
			}
			driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr[5]/td/input")).click();
			
		}
		catch(Exception e){
			
		}	
		//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/section[2]/section/ul/li[9]/ul/li[1]/a")));
		mouseOver(driver, "html/body/div[1]/div[1]/header/nav/ul/li[2]/a");
		mouseOver(driver, "html/body/div[1]/div[1]/header/nav/ul/li[2]/ul/li[1]/a");
		 List<WebElement> subContentLibAnatomy = driver.findElements(By.xpath(".//*[@id='nav']/li[2]/ul/li[1]/ul/li"));
		
		System.out.println(subContentLibAnatomy.size());
		
		for(int i=1;i<=subContentLibAnatomy.size();i++){
			WebElement subContentAnatomy= driver.findElement(By.xpath(".//*[@id='nav']/li[2]/ul/li[1]/ul/li["+i+"]/a"));
			subContentAnatomy.click();
			Thread.sleep(5000);
			//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='chapter-dashboard-paging-left']/ul/li[2]")));
			int count= getTitleCount(driver);
			compareTime(count,driver, waitFor);
			//driver.findElement(By.xpath("html/body/div[1]/div[1]/header/div/a")).click();
			driver.navigate().back();
			
			//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/section[2]/section/ul/li[9]/ul/li[1]/a")));
			//driver.navigate().refresh();
			//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/section[2]/section/ul/li[9]/ul/li[1]/a")));
			WebElement contentLib1= driver.findElement(By.xpath("html/body/div[1]/div[1]/header/nav/ul/li[2]/a"));
			Actions mouseOver1 = new Actions(driver);
			mouseOver1.moveToElement(contentLib1).build().perform();
			
			WebElement anatomyMO1= driver.findElement(By.xpath("html/body/div[1]/div[1]/header/nav/ul/li[2]/ul/li[1]/a"));
			mouseOver1.moveToElement(anatomyMO1).build().perform();
		}
		
		driver.quit();
	}
 
  
	private static void mouseOver(WebDriver driver, String mover) {
		WebElement mOverElement= driver.findElement(By.xpath(mover));
		Actions mouseOver = new Actions(driver);
		mouseOver.moveToElement(mOverElement).build().perform();
	}

	public static void compareTime(int count, WebDriver driver,WebDriverWait waitFor) throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		
		for (int i=1;i<=count;i++){
			WebElement displayTopicName =driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div["+i+"]/div[1]/a"));
			WebElement displayTime = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div["+i+"]/div[4]"));
			//System.out.println(displayTopicName.getText());
			String diplayTopic=displayTopicName.getText();
			String diplayTopicTime=displayTime.getText().trim();
			
			displayTopicName.click();
			Thread.sleep(5000);;
			String displayvideotime=videoTime(driver,waitFor);
			//System.out.println(videotime);
			Thread.sleep(3000);
			//writeToExcel(diplayTopic, diplayTopicTime,displayvideotime);
			System.out.println("topic name "+diplayTopic);
			
			SetCellData(diplayTopic,countglobal, 0, "test");
			SetCellData(diplayTopicTime,countglobal, 1, "test");
		    SetCellData(displayvideotime,countglobal, 2, "test");
		    Boolean diff=getTimeDiff(diplayTopicTime,displayvideotime);
		    	    
			if(diff==false){
				SetCellData("Pass",countglobal, 3, "test");
			}
			else{
				SetCellData("Fail",countglobal, 3, "test");
			}
		    
		    
			System.out.println("data written succesfully");
			countglobal=countglobal+1;
			System.out.println("global count "+countglobal);
			
			
			driver.navigate().back();
			//waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='chapter-dashboard-results']/div["+i+"]/div[1]/a")));
			
		}	
		
		
		
	}



	public static Boolean getTimeDiff(String diplayTopicTime,
			String displayvideotime) {
		long timedeff=0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        try
        {
            Date date = simpleDateFormat.parse(diplayTopicTime);
            Date date1 = simpleDateFormat.parse(displayvideotime);

       
            timedeff =Math.abs(((date1.getTime() - date.getTime())/1000));
            System.out.println("time difference:"+timedeff);
        }
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
        if (timedeff>=0 && timedeff<=2){
        	return false;
        }
        else
        	return true;
       		
	    
	}


	public static void SetCellData(String Result,  int RowNum, int ColNum, String SheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String path = "C:\\workspace\\TestScriptKaplan\\src\\kaplan\\Step1Onlineprep.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		
		Row row=sh.getRow(RowNum);
		if(row==null){
			row=sh.createRow(RowNum);
			
		}
		else{
			row=sh.getRow(RowNum);
			
		}
		Cell cell=row.createCell(ColNum);
		cell.setCellType(cell.CELL_TYPE_STRING);
		if(Result=="Fail"){
		CellStyle style =wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellValue(Result);
		cell.setCellStyle(style);
		}
		else{
			cell.setCellValue(Result);
		}
		
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		
	}
	

	public static String videoTime(WebDriver driver, WebDriverWait waitFor) throws InterruptedException {
		try{
        WebElement scrollBar=driver.findElement(By.xpath(".//*[@id='vp-scrubber']"));
		while(scrollBar.getAttribute("aria-disabled").equals("true")){
			Thread.sleep(1000);
			
		}
        Thread.sleep(2000);
		WebElement getVideotime= driver.findElement(By.xpath(".//*[@id='fullScreenContainer']/div[2]/div[1]/div/div[3]/div[3]/vp-timer/span"));
		String [] getTime= getVideotime.getText().split("/");
		return getTime[1];
		}
		catch(Exception e){
			return "not working";
		}
	}

	public static int getTitleCount(WebDriver driver){
		int topicCount;
        List <WebElement> topicsList = driver.findElements(By.className("video-title"));
		System.out.println(topicsList.size());
		return topicCount=topicsList.size();
    }	  
     

}

