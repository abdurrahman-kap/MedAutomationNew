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
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
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

public class Step3PageRefsVerification {
	
	static String filename = "C:\\Users\\AbRahman\\Desktop\\PageRefExcel.xlsx";
	static String executionFile = "C:\\Users\\AbRahman\\Desktop\\Step3PageRefExecution.xlsx";
	String sheetname = "Step 3 Page Refs";
	String sheetInternalMedicine = "Internal Medicine";
	String sheetNeurology = "Neurology";
	String sheetPsychiatry= "Psychiatry";
	String sheetEthics = "Ethics";
	String sheetPediatrics = "Pediatrics";
	String sheetObstetrics = "Obstetrics";
	String sheetGynecology = "Gynecology";
	String sheetSurgery = "Surgery";
	String sheetEpidemiology = "Epidemiology and Biostatistics";
	String sheetPatient = "Patient Safety";
	String sheetInterpretation = "Interpretation of Medical";
	//*************
private static XSSFSheet ExcelWSheet; 
private static XSSFWorkbook ExcelWBook;
private static XSSFCell Cell;
private static XSSFRow Row;
static int rowNum = 0;
private WebDriver driver = null;
static int rowIndex = 1;
static int sheetIndex = 0;
	String subName;
	String chapterTitle;
	String titleName;
	String titleString;
	String chapName;
	String deshBoardTimeVal;
	String DiscName;
	String xlsSeekPointTitle;
	String xlsPageRefTitle;
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

	public static String getSeekPointTitleFromExcel(int RowNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(1);
			String CellData = Cell.getStringCellValue();
			/*String[] getDiscName = CellData.split("_");
			String getDiscNameVal=  getDiscName[2];
			//String getDiscNameVal=  getDiscName[2]+" "+getDiscName[3];
*/			return CellData;
		}catch (Exception e){
	    	  return"";
	   }
	}

	public  String getPageRefFromExcel(int RowNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(4);
			 if (Cell != null) {
	                Cell.setCellType(Cell.CELL_TYPE_STRING);
			 }
			String CellData = Cell.getStringCellValue();
			/*String[] getDiscName = CellData.split("_");
			String getDiscNameVal=  getDiscName[2];
			//String getDiscNameVal=  getDiscName[2]+" "+getDiscName[3];
*/			return CellData;
		}catch (Exception e){
	    	  return null;
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
	
	private String getPageRef() {
		int pageRefDis = driver.findElements(By.xpath(".//*[@id='scrollable-page-references']/p")).size();
		String getPageRefVal ;
		if(pageRefDis>0){
			WebElement videopageRefText = driver.findElement(By
					.xpath(".//*[@id='scrollable-page-references']/p"));
			String getPageRefText = videopageRefText.getText();
			String[] getPageRef = getPageRefText.split(":");
			getPageRefVal=  getPageRef[2];
			//System.out.println("Verifying in page ref :"+ getPageRefVal);
			String[] getPageRefValue = getPageRefVal.split(" ");
			//getPageRefVal=  getPageRef[3];
			return getPageRefValue[2];
		}else{
			getPageRefVal = "No page ref";
		}
		return getPageRefVal;
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
	
	public void getSeekpointNameText( String titleName2,  Sheet sheetName2,Workbook workbook) throws Exception{
		
		String getVal = null;
		for(int i=1;i<1500;i++){
			
			int nubEle = driver.findElements(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]")).size();
			waitFor(2);
			
			if(nubEle>0){
				waitFor(2);
				
				WebElement getlecSlidesText = driver.findElement(By.xpath(".//*[@id='lecture-slides-focuser']/a["+i+"]"));
				System.out.println("	Lecture Seek Point Title : " + getlecSlidesText.getText());
				String getSeekpointtext = getlecSlidesText.getText();
				waitFor(6);
				
				xlsSeekPointTitle = getSeekPointTitleFromExcel(rowIndex);		
				System.out.println("	Excel Seek Point Title   : "+xlsSeekPointTitle);
				
				if(xlsSeekPointTitle != null ){
					waitFor(2);
					String videoTitleText = getVideoTitle();
					//System.out.println("	Video Title Verification : "+videoTitleText );
					waitFor(5);
					
					if(getSeekpointtext.equalsIgnoreCase(xlsSeekPointTitle))
					{
						System.out.println("	   Seek point verification  :: PASS");	
						waitFor(2);
						getlecSlidesText.click();
						waitFor(2);
						verifyPageRef(videoTitleText, xlsSeekPointTitle, getSeekpointtext, workbook,sheetName2);
					}else{
						System.out.println("	   Seek point verification  :: failed");	
						waitFor(2);
						getlecSlidesText.click();		
						waitFor(2);
						verifyPageRef(videoTitleText,xlsSeekPointTitle , getSeekpointtext,workbook,sheetName2);						
					}
				}else{
					System.out.println("			No Seek Point in Excel Sheet !!!");
				}
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
		      FileOutputStream fileOut = new FileOutputStream(filename);
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
			 FileOutputStream fileOut = new FileOutputStream(filename);
		      ExcelWBook.write(fileOut);
		      fileOut.flush();
		      fileOut.close();
			}catch(Exception e){
				throw (e);
		}
	}
	
	public void verifyPageRef(String videoTitleText,String expectedValue ,String actualValue, Workbook workbook, Sheet studentsSheet) throws Exception
	{
		waitFor(2);
		
			String getPageReftext = getPageRef();
			System.out.println("		Page Ref in Video : "+getPageReftext);
			waitFor(3);
			
			xlsPageRefTitle = getPageRefFromExcel(rowIndex);		
			System.out.println("		Page Ref in Excel : "+xlsPageRefTitle);
			
			if(xlsPageRefTitle != null ){
				waitFor(3);
				
				if(getPageReftext.trim().equalsIgnoreCase(xlsPageRefTitle.trim())){
					System.out.println("			Page Ref verification  : PASS");						
					writePageRefToExcel(videoTitleText, expectedValue, actualValue,xlsPageRefTitle,getPageReftext, "Passed",workbook,studentsSheet);
				}else{
					System.out.println("			Page Ref verification  : failed");						
					writePageRefToExcel(videoTitleText,expectedValue, actualValue,xlsPageRefTitle,getPageReftext,"Failed",workbook,studentsSheet);											
				}
				
			}/*else{
				--i;*/
			rowIndex=  rowIndex + 1 ;
		}	
		
		//System.out.println("			rowIndex number  : "+ rowIndex);
	/*else {
		System.out.println("		No More Element found !!!!" );
		driver.navigate().back();
		break;			
	}*/
	
	public static void writePageRefToExcel(String videoTitleText,String expectedValue ,String actualValue,String expectedPRef ,String actualPRef, String result ,Workbook workbook, Sheet studentsSheet) throws ParseException{

		Row row1 = studentsSheet.createRow(0);
		row1.createCell(0).setCellValue("Video Title");
        row1.createCell(1).setCellValue("Expected Seekpoint Title");
        row1.createCell(2).setCellValue("Actual Seekpoint Title");
        row1.createCell(3).setCellValue("Expected Page Ref");
        row1.createCell(4).setCellValue("Actual Page Ref");
        row1.createCell(5).setCellValue("Result");
       
        Row row = studentsSheet.createRow(indexforWrite);
        	row.createCell(0).setCellValue(videoTitleText);
            row.createCell(1).setCellValue(expectedValue);
            row.createCell(2).setCellValue(actualValue);
            row.createCell(3).setCellValue(expectedPRef);
            row.createCell(4).setCellValue(actualPRef);
            row.createCell(5).setCellValue(result);
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
	
	public void clickOnChapterListCloseIcon(){
		int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-list']/button")).size();
		waitFor(2);
			
		if(nubEle>0){
			WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='chapter-list']/button"));
			clickLogIn.click();
		}
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
	public void clickDisplayTime(String dispName,String xlPath,String xlSheetName,String resultShet) throws Exception{
		
		Workbook workbook = new XSSFWorkbook();
        Sheet SeekpointSheet = workbook.createSheet(resultShet);
       // WritableSheet  testSheet = workbook.creat
        
		setExcelFile(filename,xlSheetName);
		for(int i=1;i<1500;i++){
			
			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if(subName>0){
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"+dispName+"']"));
				DiscName = subNameText.getText();
				subNameText.click();
			}
			
			Cell= null;
			
			int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a")).size();
			waitFor(2);
			if(nubEle>0){
				waitFor(3);
				
				WebElement lecSlidesText = driver.findElement(By.xpath(".//*[@id='chapter-list']/ul/li[" +i +"]/a"));
				chapterTitle = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(3);
				
				clicVideoTitle(DiscName,chapterTitle,SeekpointSheet,workbook);
				waitFor(5);
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				clickOnChapterListCloseIcon();
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
	
	public void clicVideoTitle( String discName2, String modName2,Sheet ExSheetName,Workbook workbook) throws Exception{
		
		for(int i=1;i<1500;i++){
			
		clickOnPageIndex();
			
		waitFor(2);
		int nubEle = driver.findElements(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a")).size();
		waitFor(2);
			
		if(nubEle>0){
			int m = i;
			waitFor(3);
			deshBoardTimeVal = (getContTime(m));//get the time from dashboards
			System.out.println("Dashbord time is  : " + deshBoardTimeVal);
			waitFor(1);	
				
			WebElement videoTitleText = driver.findElement(By.xpath(".//*[@id='chapter-dashboard-results']/div[" +i +"]/div[1]/a"));
			titleName = videoTitleText.getText();//need Text Value
			videoTitleText.click();
			String expected = discName2 +" - " + modName2 +" - " + titleName ;
			System.out.println("Expected Video Title : "+ expected);
			waitFor(2);
				
			getSeekpointNameText(expected,ExSheetName,workbook);//deshBoardTimeVal need if wants verify desh board time time 
				//driver.navigate().back();				
				//return titleName;
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	public void clickOnDiscipline() throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
        Sheet SeekpointSheet = workbook.createSheet("Step1HyOnlinePrepTitle");
        
		setExcelFile(filename,sheetname);

		for (int i = 1; i < 15000; i++) {
			
			xlsSeekPointTitle = getSeekPointTitleFromExcel(rowIndex);
			System.out.println("Discipline name : "+xlsSeekPointTitle);

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
		setExcelFile(filename,sheetname);
		
		for(int i=1;i<1500;i++){
			
			xlsSeekPointTitle = getSeekPointTitleFromExcel(rowIndex);
			System.out.println("Discipline name : "+xlsSeekPointTitle);
			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if(subName>0){
				waitFor(3);
				WebElement subNameText = driver.findElement(By.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"+xlsSeekPointTitle+"']"));
				DiscName = subNameText.getText();
				subNameText.click();
			}
			int chapterIndex = 1;
			if(DiscName.equalsIgnoreCase(xlsSeekPointTitle)){
				xlsSeekPointTitle = DiscName;
				System.out.println("Discipline name matchwith excel : "+xlsSeekPointTitle);
				clickOnChapterList(chapterIndex, xlsSeekPointTitle,SeekpointSheet,workbook);
			}else{
				System.out.println("Discipline name not match with excel : "+xlsSeekPointTitle);
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
				chapterTitle = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(3);
				
				if(chapterTitle.equalsIgnoreCase(xlChapternameName)){
					//System.out.println("	Chapter name match with excel : "+modName);
					xlChapternameName = chapterTitle;
					
				}else{
					//System.out.println("	Chapter name not match with excel : "+modName);
				}	
				
				waitFor(5);
				clicVideoTitle(DiscName,chapterTitle,SeekpointSheet,workbook);
				waitFor(5);
				driver.navigate().back();
			}else {
				System.out.println("No More Element found !!!!" );
				break;
			}
		}
	}
	
	
//*********************************************************************
	/*@Test
	public void readdata() throws Exception{
		setExcelFile(filename,sheetname);
		//getCellDataPara(3);	
		setCellData("pass",2,2);
	}
	*/
	@Test
	public void verifyInternalMedicine() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Internal Medicine",filename,sheetInternalMedicine,"Internal Medicine Update");
	}
	
	@Test
	public void verifyNeurology() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Neurology",filename,sheetNeurology,"Neurology Update");
	}
	@Test
	public void verifyPsychiatry() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Psychiatry",filename,sheetPsychiatry,"Psychiatry Update");
	}
	
	@Test
	public void verifyEthics() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Ethics",filename,sheetEthics,"Ethics Update");
	}
	
	@Test
	public void verifyPatientSafety() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Patient Safety and Quality Improvement",filename,sheetPatient,"Patient Safety Update");
	}
	
	@Test
	public void verifyEpidemiologyandBiostatistics() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Epidemiology and Biostatistics",filename,sheetEpidemiology,"Epidemiology Update");
	}
	
	@Test
	public void verifyPediatrics() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Pediatrics",filename,sheetPediatrics,"Pediatrics Update");
		}
	@Test
	public void verifyObstetrics() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Obstetrics",filename,sheetObstetrics,"Obstetrics Update");
	}
	
	@Test
	public void verifySurgery() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Surgery",filename,sheetSurgery,"Surgery Update");
	}
	
	@Test
	public void verifyGynecology() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Gynecology",filename,sheetGynecology,"Gynecology Update");
	}
	
	@Test
	public void verifyInterpretationofMedical() throws Exception{
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct("USMLEStep3OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime("Interpretation Of Medical Literature",filename,sheetInterpretation,"Interpretation of Medical Update");
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
		//driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		//driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		//driver.navigate().to("https://stg-jasperwp.kaptest.com/loginv8.aspx");
		driver.navigate().to("https://preview-jasperwp.kaptest.com/loginv8.aspx");
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