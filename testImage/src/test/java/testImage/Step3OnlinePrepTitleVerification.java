package testImage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

public class Step3OnlinePrepTitleVerification {
	static String fileName = System.getProperty("user.dir") +  System.getProperty("file.separator") +
	          "src" +  System.getProperty("file.separator")  + "test" +  System.getProperty("file.separator") +
	          "resources" +  System.getProperty("file.separator") + "testData" +  System.getProperty("file.separator") +
	          "NAPLEX Master Syllabus.xlsx";
	static String filena = "C:\\Users\\AbRahman\\Desktop\\Step 3 OLP Master.xlsx";
	static String executionFile = "C:\\Users\\AbRahman\\Desktop\\Step3Execution.xlsx";
	String sheetname = "Step 3 Master Syllabus";
	//*************
private static XSSFSheet ExcelWSheet; 
private static XSSFWorkbook ExcelWBook;
private static XSSFCell Cell;
private static XSSFRow Row;
static int rowNum = 0;
private WebDriver driver = null;
static int rowIndex = 2;
	String subName;
	String modName;
	String titleName;
	String titleString;
	String chapName;
	String timeVal;
	String DiscName;
	String xlDiscName;
	String xlChapternameName;
	String videotitleString;
	String xlValfromSeekpointText;
	 static int indexforWrite =1 ;
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

	public static String getDiscNameData(int RowNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(0);
			String CellData = Cell.getStringCellValue();
			String[] getDiscName = CellData.split("_");
			String getDiscNameVal=  getDiscName[2];
			//String getDiscNameVal=  getDiscName[2]+" "+getDiscName[3];
			return getDiscNameVal;
		}catch (Exception e){
	    	  return"";
	   }
	}

	private String getChapterNameData(int rowNum) {
		try{
			Cell = ExcelWSheet.getRow(rowNum).getCell(1);
			String CellData = Cell.getStringCellValue();
			String[] getDiscName = CellData.split("_");
			String getDiscNameVal=  getDiscName[1];
			return getDiscNameVal;
		}catch (Exception e){
    	  return"";
		}
	}
	
	private String getVideoNameText(int rowNum) {
		try{
			Cell = ExcelWSheet.getRow(rowNum).getCell(5);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}catch (Exception e){
    	  return"";
		}
	}
	
	private String getVideoTitle() {
		WebElement videoTitleText = driver.findElement(By
				.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
		return videoTitleText.getText();	
	}
	
	private String getSeekPpointTitleTextfromExcel(int rowNum) {
		try{
			Cell = ExcelWSheet.getRow(rowNum-1).getCell(6);
			 if (Cell != null) {
	                Cell.setCellType(Cell.CELL_TYPE_STRING);
			 }
			if (!Cell.getStringCellValue().equals("")) {
				String CellData = Cell.getStringCellValue();
				return CellData;
			}else{
				return null;				
			}
			
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
	
	public void getSeekpointNameText(int j, int k, String titleName2, String timeVal2,  Sheet sheetName2,Workbook workbook) throws Exception{
		
		String getVal = null;
		//rowIndex = 5811;
		for(int i=1;i<1500;i++){
			
			int nubEle = driver.findElements(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(2);
				WebElement getlecSlidesText = driver.findElement(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]"));
				//System.out.println("			Lecture Seek Point Title  : " + getlecSlidesText.getText());
				String getSeekpointtext = getlecSlidesText.getText();
				waitFor(5);
				
				xlValfromSeekpointText = getSeekPpointTitleTextfromExcel(rowIndex);
				System.out.println("			Seek Point Title fr Excel : " + xlValfromSeekpointText);
				
				if(xlValfromSeekpointText != null ){
					waitFor(2);
					String videoTitleText = getVideoTitle();
					waitFor(5);
					if(getSeekpointtext.equalsIgnoreCase(xlValfromSeekpointText)){
						System.out.println("				Seek point verification  :: PASS");						
						writeStudentsListToExcel(videoTitleText,xlValfromSeekpointText , getSeekpointtext,"Passed",workbook,sheetName2);
					}else{
						System.out.println("				Seek point verification  :: failed");						
						writeStudentsListToExcel(videoTitleText,xlValfromSeekpointText , getSeekpointtext,"Failed",workbook,sheetName2);											
					}
					
				}else{
					--i;
				}	
				
				getVal = getlecSlidesText.getText();
				rowIndex=  rowIndex + 1 ;
				//System.out.println("			rowIndex number  : "+ rowIndex);
			}else {
				System.out.println("		No More Element found !!!!" );
				driver.navigate().back();
				break;			
			}
			
		}
		//return getVal;
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
		      FileOutputStream fileOut = new FileOutputStream(filena);
		      ExcelWBook.write(fileOut);
		      fileOut.flush();
		      fileOut.close();
			}catch(Exception e){
				throw (e);
		}
	}
	
	public static void writeCellData(int ColNum,int RowNum, String Result) throws Exception	{
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
	}
	
	public static void writeStudentsListToExcel(String videoTitleText,String expectedValue ,String actualValue, String result ,Workbook workbook, Sheet studentsSheet) throws ParseException{

		Row row1 = studentsSheet.createRow(0);
		row1.createCell(0).setCellValue("Video Title");
        row1.createCell(1).setCellValue("Expected Seekpoint Title");
        row1.createCell(2).setCellValue("Actual Seekpoint Title");
        row1.createCell(3).setCellValue("Result");
       
        Row row = studentsSheet.createRow(indexforWrite);
        	row.createCell(0).setCellValue(videoTitleText);
            row.createCell(1).setCellValue(expectedValue);
            row.createCell(2).setCellValue(actualValue);
            row.createCell(3).setCellValue(result);
           /* if(expectedValue.trim().equalsIgnoreCase(actualValue.trim())){
            	row.createCell(2).setCellValue(result);
            	
            }else{
            	row.createCell(2).setCellValue("Fail");
            }*/
        try {
            FileOutputStream fos = new FileOutputStream(executionFile);
            workbook.write(fos);
            fos.close();
            //System.out.println("				"+executionFile + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        indexforWrite++;
    }
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

	public void clickOnPageIndex(){
		WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-paging-left']/ul/li[3]/button[2]"));
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
		
		Workbook workbook = new XSSFWorkbook();
        Sheet SeekpointSheet = workbook.createSheet("Step1HyOnlinePrepTitle");
        
		setExcelFile(filena,sheetname);
		//Workbook workbook = new XSSFWorkbook();
        //Sheet sheetName = workbook.createSheet("Step1HyOnlinePrepTitle");
		//Sheet sheetName = workbook.getSheet("Step1HyOnlinePrepTitle");
		for(int i=1;i<1500;i++){
			
			xlDiscName = getDiscNameData(rowIndex);
			System.out.println("Discipline name : "+xlDiscName);
			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if(subName>0){
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"+xlDiscName+"']"));
				DiscName = subNameText.getText();
				subNameText.click();
			}
			
			if(DiscName.equalsIgnoreCase(xlDiscName)){
				xlDiscName = DiscName;
				/* Row row = sheetName.getRow(rowIndex);
		            row.createCell(13).setCellValue("Pass");*/
				//setCellData("Pass",i,13);
				System.out.println("Discipline name matchwith excel : "+xlDiscName);
			}else{
				/*Row row = sheetName.createRow(rowIndex++);
					row.createCell(13).setCellValue("Failed");*/
					//setCellData("Failed",i,13);
				System.out.println("Discipline name not match with excel : "+xlDiscName);
			}	
			
			Cell= null;
			
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				
				xlChapternameName = getChapterNameData(rowIndex);
				System.out.println("	Chapter Name from excel : "+xlChapternameName);
				
				WebElement lecSlidesText = driver.findElement(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(3);
				
				if(modName.equalsIgnoreCase(xlChapternameName)){
					/*Row row = sheetName.createRow(rowIndex++);
						row.createCell(14).setCellValue("Pass");*/
					//setCellData("Pass",i,13);
					System.out.println("	Chapter name match with excel : "+modName);
					xlChapternameName = modName;
					
				}else{
					/*Row row = sheetName.createRow(rowIndex++);
					row.createCell(14).setCellValue("Failed");*/
					//setCellData("failed",i,13);
					System.out.println("	Chapter name not match with excel : "+modName);
				}	
				
				waitFor(5);
				clicVideoTitle(DiscName,modName,SeekpointSheet,workbook);
				waitFor(5);
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
	
	public void clicVideoTitle( String discName2, String modName2,Sheet sheetName,Workbook workbook) throws Exception{
		
		for(int i=1;i<1500;i++){
			
			clickOnPageIndex();
			waitFor(2);
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
				System.out.println("		Vidoe title Name : "+titleName);
				//videoTitleText.click();
				// call excel method -> compare the string in excel with title name -> teke the duration 
				// then assertion 
				String expected = discName2 +" - " + modName2 +" - " + titleName ;
				//System.out.println("		Expected Title String : "+ expected);
				waitFor(2);
				videoTitleText.click();
				
				String xlVideoName = getVideoNameText(rowIndex);
				
				if(titleName.equalsIgnoreCase(xlVideoName)){
					//System.out.println("		Dash video Title name match with excel : "+ xlVideoName);
				}else{
					//System.out.println("		video Title name not match with excel : "+modName);
					//System.out.println("		video Title name not match with excel : "+ xlVideoName);
				}	
				
				getSeekpointNameText(3,7,expected,timeVal,sheetName,workbook);
				//driver.navigate().back();
				
				//return titleName;
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
		//return titleName;
	}
	
	private void gettimefromexcel(int ColNum,int durColNum,String titleName,String timeval,String xlPath,Sheet sheetName) throws Exception {
		
		//setExcelFile(xlPath,sheetname);
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

	public void clickOnDiscipline() throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
        Sheet SeekpointSheet = workbook.createSheet("Step1HyOnlinePrepTitle");
        
		setExcelFile(filena,sheetname);

		for (int i = 1; i < 15000; i++) {
			
			xlDiscName = getDiscNameData(rowIndex);
			System.out.println("Discipline name : "+xlDiscName);

			int subName = driver.findElements(
					By.xpath(".//*[@id='home-dashboard-table-txt']/li[" + i
							+ "]/ul/li[1]/a")).size();
			if (subName > 0) {
				System.out.println("Value of Disciplines : " + i);
				waitFor(3);
				WebElement subNameText = driver.findElement(By
						.xpath(".//*[@id='home-dashboard-table-txt']/li[" + i
								+ "]/ul/li[1]/a"));
				//discName = subNameText.getText();
				//System.out.println("Home dashboard Disciplines name : "+ discName);
				//clickDisplayTime(xlDiscName,workbook,studentsSheet);
			} else {
				System.out.println("No More Disciplines found !!!!");
				break;
			}
		}
	}
	
	public void clickOnDisciplineName() throws Exception{
		
		Workbook workbook = new XSSFWorkbook();
        Sheet SeekpointSheet = workbook.createSheet("Step1HyOnlinePrepTitle");
		setExcelFile(filena,sheetname);
		
		for(int i=1;i<1500;i++){
			
			xlDiscName = getDiscNameData(rowIndex);
			System.out.println("Discipline name : "+xlDiscName);
			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if(subName>0){
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"+xlDiscName+"']"));
				DiscName = subNameText.getText();
				subNameText.click();
			}
			int chapterIndex = i;
			if(DiscName.equalsIgnoreCase(xlDiscName)){
				xlDiscName = DiscName;
				System.out.println("Discipline name matchwith excel : "+xlDiscName);
				clickOnChapterList(chapterIndex, xlDiscName,SeekpointSheet,workbook);
			}else{
				System.out.println("Discipline name not match with excel : "+xlDiscName);
				i=1;
				break;
			}			
		}	
	}
	
	public void clickOnChapterList(int chapterIndex,String DiscName,Sheet SeekpointSheet,Workbook workbook) throws Exception{
		
		Cell= null;
		for(int i=chapterIndex;i<1500;i++){
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				
				xlChapternameName = getChapterNameData(rowIndex);
				System.out.println("	Chapter Name from excel : "+xlChapternameName);
				
				WebElement lecSlidesText = driver.findElement(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(3);
				
				if(modName.equalsIgnoreCase(xlChapternameName)){
					//System.out.println("	Chapter name match with excel : "+modName);
					xlChapternameName = modName;
					
				}else{
					//System.out.println("	Chapter name not match with excel : "+modName);
				}	
				
				waitFor(5);
				clicVideoTitle(DiscName,modName,SeekpointSheet,workbook);
				waitFor(5);
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	
//*********************************************************************
	@Test
	public void readdata() throws Exception{
		System.out.println(fileName);
		setExcelFile(filena,sheetname);
		//getCellDataPara(3);	
		setCellData("pass",2,2);
	}
	
	@Test
	public void test1() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Ethics",filena);
	}
	
	@Test
	public void VerifyAllDescipline() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickOnDisciplineName();
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
