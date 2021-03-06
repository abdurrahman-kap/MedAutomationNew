package com.kaplan.med;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Step1HyOnlinePrepTimeVerification {
	/*static String fileName = System.getProperty("user.dir") +  System.getProperty("file.separator") +
	          "src" +  System.getProperty("file.separator")  + "test" +  System.getProperty("file.separator") +
	          "resources" +  System.getProperty("file.separator") + "testData" +  System.getProperty("file.separator") +
	          "TimeVerification.xlsx";
	static String filena = "C:\\Users\\AbRahman\\Desktop\\NAPLEX.xlsx";
	String sheetname = "TimeCom";*/
	//*************
  private static XSSFSheet ExcelWSheet; 
  private static XSSFWorkbook ExcelWBook;
  private static XSSFCell Cell;
  private static XSSFRow Row;
  static int rowNum = 0;
  private WebDriver driver = null;
  	
  	String subName;
	String modName;
	String titleName;
	String titleString;
	String chapName;
	String timeVal;
  
	
  public static void setExcelFile(String fileName,String SheetName) throws Exception {
	
		try{
			FileInputStream ExcelFile = new FileInputStream(fileName);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		    rowNum = ExcelWSheet.getLastRowNum();
		} catch (Exception e){
			throw (e);	
		}	
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}catch (Exception e){
	    	  return"";
	   }
	}

	public void getCellDataPara(int ColNum) throws Exception{
		
		try{
			for(int i = 1; i < rowNum; i++)
			{
				Row = ExcelWSheet.getRow(i);
				if (Row != null) {
					Cell = ExcelWSheet.getRow(i).getCell(ColNum);
					System.out.println( ExcelWSheet.getRow(i).getCell(ColNum));
					Cell.getStringCellValue();
				}
			}
			
		}catch (Exception e){
		}	
	}
	
//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
		try{
			Row  = ExcelWSheet.getRow(RowNum);	
			Cell = Row.createCell(ColNum);
			Cell = Row.createCell(ColNum);
				
			Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
			Cell.setCellValue(Result);
	     // Constant variables Test Data path and Test Data file name
		      FileOutputStream fileOut = new FileOutputStream("filena");
		      ExcelWBook.write(fileOut);
		      fileOut.flush();
		      fileOut.close();
			}catch(Exception e){
				throw (e);
		}
	}
	
	
	/*public static void writeCellData(int ColNum,int RowNum, String Result) throws Exception	{
		try{
			
			Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);	
			}
			 FileOutputStream fileOut = new FileOutputStream(filena);
		      ExcelWBook.write(fileOut);
		      fileOut.flush();
		      fileOut.close();
			}catch(Exception e){
				throw (e);
		}
	}*/
	//****************************************************************************** 
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
		WebElement pagetitleText = driver.findElement(By.xpath("html/body/div[1]/div[1]/section[1]/div[4]/div[2]/div["+j+"]/div[3]"));
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
	public void clickDisplayTime(String dispName,String xlPath) throws Exception{
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
				clicVideoTitle(xlPath);
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
	
	public void clicVideoTitle(String xlPath) throws Exception{
		for(int i=1;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a")).size();
			waitFor(2);
			if(nubEle>0){
				int m = i;
				waitFor(3);
				timeVal = (getContTime(m));//get the time from dashboards
				//System.out.println("Dashbord time is  : " + timeVal);
				waitFor(5);
				WebElement videoTitleText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a"));
				titleName = videoTitleText.getText();//need Text Value
				//System.out.println("Lecture title Name : "+titleName);
				//videoTitleText.click();
				// call excel method -> compare the string in excel with title name -> teke the duration 
				// then assertion 
				
				gettimefromexcel(3,7,titleName,timeVal,xlPath);
				//driver.navigate().back();
				
				//return titleName;
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	private void gettimefromexcel(int ColNum,int durColNum,String titleName,String timeval,String xlPath) throws Exception {
		
		setExcelFile(xlPath,"sheetname");
		try{
			for(int i = 1; i < rowNum; i++)
			{
				String CellData = null;
				Row = ExcelWSheet.getRow(i);
				if (Row != null) {
					Cell = ExcelWSheet.getRow(i).getCell(ColNum);
					CellData = Cell.getStringCellValue();
					/*CellDura=ExcelWSheet.getRow(i).getCell(durColNum);
					CellDuration =CellDura.getStringCellValue();*/
					
					if(CellData.equalsIgnoreCase(titleName)){
						System.out.println("Excle Value : "+CellData);
						
						Cell = ExcelWSheet.getRow(i).getCell(durColNum);
						CellData = Cell.getStringCellValue();
						System.out.println( "Duration  in XL Sheet : "+ CellData);
						
						if(CellData.equalsIgnoreCase(timeval)){
							//System.out.println("for writing inxl : "+timeval);
							setCellData("Pass",i,8);
							
						}else{
							System.out.println("Excel Sheet Duration : "+CellData +" : : "+ "Video DashBord Duration: "+timeval  );
							setCellData(timeval,i,8);
						}		
						Cell= null;
					}
				}
			}
		}catch (Exception e){
		}	
	}

	//*********************************************************************
	@Test
	public void readdata() throws Exception{
		//System.out.println(fileName);
		//setExcelFile(fileName,sheetname);
		//getCellDataPara(3);	
		setCellData("pass",2,8);
	}
	
	
	public void test1(String ProdName, String DisName,String xlpath) throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct(ProdName);
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime(DisName,xlpath);
	}
		
	//*********************************************************************************************** 
	
	@BeforeMethod
	public void beforeMethod(){
		
		//FirefoxProfile profile = new FirefoxProfile(); //FirefoxDriver
		//profile.setPreference("browser.cache.disk.enable", false);
		driver = new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		/*DesiredCapabilities caps = DesiredCapabilities.internetExplorer();//IEDriverServer
		System.setProperty("webdriver.ie.driver","C:\\DevTools\\Browser\\IEDriverServer.exe");
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability("requireWindowFocus",true);
		caps.setCapability("nativeEvents", false);
		driver = new InternetExplorerDriver(caps);
		driver.manage().window().maximize();
		*/	
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
}
