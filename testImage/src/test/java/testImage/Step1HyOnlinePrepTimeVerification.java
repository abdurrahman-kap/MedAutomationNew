package testImage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.DateTimeSyntax;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Step1HyOnlinePrepTimeVerification {
	/*
	 * static String fileName = System.getProperty("user.dir") +
	 * System.getProperty("file.separator") + "src" +
	 * System.getProperty("file.separator") + "test" +
	 * System.getProperty("file.separator") + "resources" +
	 * System.getProperty("file.separator") + "testData" +
	 * System.getProperty("file.separator") + "TimeVerification.xlsx"; static
	 * String filena = "C:\\Users\\AbRahman\\Desktop\\NAPLEX.xlsx"; String
	 * sheetname = "TimeCom";
	 */
	// *************
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	static int rowNum = 0;
	private WebDriver driver = null;
	private static final String FILE_PATH = "C:\\Users\\AbRahman\\Desktop\\TimeVerification.xlsx";
	static int rowIndex = 1;
	String subName;
	String modName;
	String titleName;
	String titleString;
	String chapName;
	String timeVal;

	public static void setExcelFile(String fileName, String SheetName)
			throws Exception {

		try {
			FileInputStream ExcelFile = new FileInputStream(fileName);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			rowNum = ExcelWSheet.getLastRowNum();
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public void getCellDataPara(int ColNum) throws Exception {

		try {
			for (int i = 1; i < rowNum; i++) {
				Row = ExcelWSheet.getRow(i);
				if (Row != null) {
					Cell = ExcelWSheet.getRow(i).getCell(ColNum);
					System.out.println(ExcelWSheet.getRow(i).getCell(ColNum));
					Cell.getStringCellValue();
				}
			}

		} catch (Exception e) {
		}
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public static void setCellData(String Result, int RowNum, int ColNum)
			throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.createCell(ColNum);
			Cell = Row.createCell(ColNum);

			Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
			Cell.setCellValue(Result);
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream("filena");
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	/*
	 * public static void writeCellData(int ColNum,int RowNum, String Result)
	 * throws Exception { try{
	 * 
	 * Row = ExcelWSheet.getRow(RowNum); Cell = Row.getCell(ColNum,
	 * Row.RETURN_BLANK_AS_NULL); if (Cell == null) { Cell =
	 * Row.createCell(ColNum); Cell.setCellValue(Result); } FileOutputStream
	 * fileOut = new FileOutputStream(filena); ExcelWBook.write(fileOut);
	 * fileOut.flush(); fileOut.close(); }catch(Exception e){ throw (e); } }
	 */
	// ******************************************************************************
	public void setUserName(String uName) {
		WebElement setName = driver.findElement(By.name("userName"));
		setName.clear();
		setName.sendKeys(uName);
	}

	public void setPwd(String pwd) {
		WebElement setName = driver.findElement(By.name("password"));
		setName.clear();
		setName.sendKeys(pwd);
	}

	public void clickLogIn() {
		WebElement clickLogIn = driver.findElement(By
				.xpath("html/body/form//tr[1]/td//tr[5]/td/input"));
		clickLogIn.click();
	}
	
	public void clickCloseSubLink() {
		WebElement clickLogIn = driver.findElement(By
				.xpath(".//*[@id='chapter-list']/button"));
		clickLogIn.click();
	}

	public void clickOnProduct(String prodName) {
		WebElement getObject = driver.findElement(By.name("productName"));
		SelectElement(getObject, prodName);
	}

	public void SelectElement(WebElement element, String item) {
		Select combo = new Select(element);
		List<WebElement> list = combo.getOptions();
		for (WebElement e : list) {
			if (e.getAttribute("value").contentEquals(item)) {
				waitFor(2);
				WebElement clickOnProd = driver.findElement(By
						.xpath(".//*[@id='productName_chosen']/a/div/b"));
				clickOnProd.click();
				waitFor(1);
				WebElement setProd = driver.findElement(By
						.xpath(".//*[@id='productName_chosen']/div/div/input"));
				setProd.sendKeys(item);
				waitFor(2);
				WebElement clickProd = driver.findElement(By
						.xpath(".//*[@id='productName_chosen']/div/ul/li/em"));
				clickProd.click();
				waitFor(2);
			}
		}
	}

	public String getContTime(int j) {
		WebElement pagetitleText = driver.findElement(By
				.xpath("html/body/div[1]/div[1]/section[1]/div[4]/div[2]/div["
						+ j + "]/div[4]"));
		String pageTitle =pagetitleText.getText();
		System.out.println("date formate : "+ pageTitle );
		return pagetitleText.getText();
	}

	public String getVideoTime() {
		WebElement pagetitleText = driver.findElement(By
				.xpath("//div[3]/div[3]/vp-timer/span"));
		String som = pagetitleText.getText();
		String[] getTime = som.split("/");
		return getTime[1];
	}

	public void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ***********************************************************************************
	public void clickDisplayTime(String dispName, String xlPath)
			throws Exception {
		for (int i = 1; i < 1500; i++) {

			int subName = driver
					.findElements(
							By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a"))
					.size();
			if (subName > 0) {
				waitFor(3);
				WebElement subNameText = driver
						.findElement(By
								.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"
										+ dispName + "']"));
				modName = subNameText.getText();
				subNameText.click();
			}

			int nubEle = driver.findElements(
					By.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a"))
					.size();
			waitFor(2);
			if (nubEle > 0) {
				waitFor(3);

				WebElement lecSlidesText = driver.findElement(By
						.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();

				waitFor(10);
				clicVideoTitle(xlPath);
				waitFor(10);
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				break;
			}
		}
	}

	public void veriftDisplayTime(String dispName,Workbook workbook, Sheet studentsSheet)throws Exception {		     
		for (int i = 1; i < 1500; i++) {	
			int subName = driver
					.findElements(
							By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a"))
					.size();
			if (subName > 0) {
				waitFor(2);
				WebElement subNameText = driver
						.findElement(By
								.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"
										+ dispName + "']"));
				modName = subNameText.getText();
				subNameText.click();
			}

			int nubEle = driver.findElements(
					By.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a"))
					.size();
			waitFor(2);
			if (nubEle > 0) {
				waitFor(2);
				WebElement lecSlidesText = driver.findElement(By
						.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(5);
				verifyVideoTitle(workbook, studentsSheet);
				waitFor(3);
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				clickCloseSubLink();
				break;
			}
		}
	}
	
	public void verifDiscTime(String dispName)throws Exception {
		Workbook workbook = new XSSFWorkbook();
        Sheet studentsSheet = workbook.createSheet("Step1HyOnlinePrep");
		for (int i = 1; i < 1500; i++) {	
			int subName = driver
					.findElements(
							By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a"))
					.size();
			if (subName > 0) {
				waitFor(2);
				WebElement subNameText = driver
						.findElement(By
								.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"
										+ dispName + "']"));
				modName = subNameText.getText();
				subNameText.click();
			}

			int nubEle = driver.findElements(
					By.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a"))
					.size();
			waitFor(2);
			if (nubEle > 0) {
				waitFor(2);
				WebElement lecSlidesText = driver.findElement(By
						.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a"));
				modName = lecSlidesText.getText();
				lecSlidesText.click();
				waitFor(1);
				verifyVideoTitle(workbook, studentsSheet);
				waitFor(3);
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				clickCloseSubLink();
				break;
			}
		}
	}

	public void clicVideoTime() {
		for (int i = 1; i < 1500; i++) {
			int nubEle = driver.findElements(
					By.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
							+ "]/div[1]/a")).size();
			waitFor(2);
			if (nubEle > 0) {
				int m = i;
				waitFor(3);
				String timeVal = (getContTime(m));// get the time from dashboards
				waitFor(5);
				WebElement videoTitleText = driver.findElement(By
						.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
								+ "]/div[1]/a"));
				titleName = videoTitleText.getText();// need Text Value
				// videoTitleText.click();
				waitFor(5);
				getVideoTime();
				waitFor(3);
				org.testng.Assert.assertEquals(timeVal.trim(), getVideoTime()
						.trim());
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				break;
			}
		}
	}

	public void clicVideoTitle(String xlPath) throws Exception {
		for (int i = 1; i < 1500; i++) {
			int nubEle = driver.findElements(
					By.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
							+ "]/div[1]/a")).size();
			waitFor(2);
			if (nubEle > 0) {
				int m = i;
				waitFor(3);
				timeVal = (getContTime(m));// get the time from dashboards
				waitFor(5);
				WebElement videoTitleText = driver.findElement(By
						.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
								+ "]/div[1]/a"));
				titleName = videoTitleText.getText();// need Text Value
				System.out.println("Title : " + titleName +"Dash board Time : " + timeVal + "Video runtime : " + getVideoTime());
				gettimefromexcel(3, 7, titleName, timeVal, xlPath);
			} else {
				System.out.println("No More Element found !!!!");
				break;
			}
		}
	}

	public void verifyVideoTitle( Workbook workbook, Sheet studentsSheet) throws Exception {
		for (int i = 1; i < 1500; i++) {
			int nubEle = driver.findElements(
					By.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
							+ "]/div[1]/a")).size();
			waitFor(2);
			if (nubEle > 0) {
				int m = i;
				waitFor(3);
				timeVal = (getContTime(m));// get the time from dashboards
				waitFor(3);
				WebElement videoTitleText = driver.findElement(By
						.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
								+ "]/div[1]/a"));
				titleName = videoTitleText.getText();// need Text Value
				videoTitleText.click();
				waitFor(2);
				WebElement getvideoTitleText = driver.findElement(By
						.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
				titleName = getvideoTitleText.getText();// need Text Value
				//System.out.println("Lecture title Name : "+titleName);
				waitFor(5);
				// excel method ->
				//System.out.println("Dash board Time : " + timeVal +" , "+ "Video runtime : " + getVideoTime());
				writeStudentsListToExcel(titleName,timeVal,getVideoTime(),workbook,studentsSheet);
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				driver.navigate().back();
				driver.navigate().back();
				break;
			}
		}
	}
	private void gettimefromexcel(int ColNum, int durColNum, String titleName,
			                      String timeval, String xlPath) 
			                    		  throws Exception {

		setExcelFile(xlPath, "sheetname");
		try {
			for (int i = 1; i < rowNum; i++) {
				String CellData = null;
				Row = ExcelWSheet.getRow(i);
				if (Row != null) {
					Cell = ExcelWSheet.getRow(i).getCell(ColNum);
					CellData = Cell.getStringCellValue();
					if (CellData.equalsIgnoreCase(titleName)) {
						System.out.println("Excle Value : " + CellData);
						Cell = ExcelWSheet.getRow(i).getCell(durColNum);
						CellData = Cell.getStringCellValue();
						System.out.println("Duration  in XL Sheet : "
								+ CellData);
						if (CellData.equalsIgnoreCase(timeval)) {
							setCellData("Pass", i, 8);
						} else {
							System.out.println("Excel Sheet Duration : "
									+ CellData + " : : "
									+ "Video DashBord Duration: " + timeval);
							setCellData(timeval, i, 8);
						}
						Cell = null;
					}
				}
			}
		} catch (Exception e) {
		}
	}  
	
	public static void openStudentsListToExcel(String dTime,String rTime){		
		Workbook workbook = new XSSFWorkbook();
        Sheet studentsSheet = workbook.createSheet("Step1HyOnlinePrep");
	}
	
	public static void writeStudentsListToExcel(String subTitle,String dTime,String rTime, Workbook workbook, Sheet studentsSheet) throws ParseException{

		Row row1 = studentsSheet.createRow(0);
        row1.createCell(0).setCellValue("Video Title");
        row1.createCell(1).setCellValue("DeshBoard time");
        row1.createCell(2).setCellValue("Video Runtime");
        row1.createCell(3).setCellValue("Result");
        row1.createCell(4).setCellValue("Time Deff");
   
        Row row = studentsSheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(subTitle);
            row.createCell(1).setCellValue(dTime);
            row.createCell(2).setCellValue(rTime);

            if(dTime.trim().equalsIgnoreCase(rTime.trim())){
            	row.createCell(3).setCellValue("Pass");
            }else{
            	row.createCell(3).setCellValue("Fail");
            	row.createCell(4).setCellValue(timeDifference(dTime,rTime));
            	if(rTime.trim().equalsIgnoreCase("00:00:00")){
        			row.createCell(5).setCellValue("Video is not loaded");
                }
            }
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static double timeDifference(String dTime,String rTime) throws ParseException{	
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	    Date date = null;
	    Date date1 = null;
	    try {
	        date = sdf.parse(dTime);
	        date1 = sdf.parse(rTime);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    long timedeff = ((date1.getTime() - date.getTime())/1000);
	   return timedeff;
	}

	public void clickOnProducts() throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
        Sheet studentsSheet = workbook.createSheet("Step1HyOnlinePrep");
		
		for (int i = 1; i < 1500; i++) {
			int subName = driver.findElements(
					By.xpath(".//*[@id='home-dashboard-table-txt']/li[" + i
							+ "]/ul/li[1]/a")).size();
			if (subName > 0) {
				System.out.println(" Value of Disciplines : " + i);
				waitFor(3);
				WebElement subNameText = driver.findElement(By
						.xpath(".//*[@id='home-dashboard-table-txt']/li[" + i
								+ "]/ul/li[1]/a"));
				modName = subNameText.getText();
				System.out.println("Home dashboard Disciplines name : "
						+ modName);
				veriftDisplayTime(modName,workbook,studentsSheet);
			} else {
				System.out.println("No More Disciplines found !!!!");
				break;
			}
		}
	}

// *********************************************************************
	@Test
	public void readdata() throws Exception {
		// System.out.println(fileName);
		// setExcelFile(fileName,sheetname);
		// getCellDataPara(3);
		//setCellData("pass", 2, 8);
		//timeDifference("00:28:55","00:28:52");
	}

	public void testJar(String ProdName, String DisName, String xlpath)
			throws Exception {
		waitFor(3);
		setUserName("abrahman");
		waitFor(3);
		setPwd("abrahman");
		waitFor(3);
		clickOnProduct(ProdName);
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickDisplayTime(DisName, xlpath);
	}
	@Test
	public void testTimeinDashboard()
			throws Exception {
		waitFor(1);
		setUserName("abrahman");
		waitFor(1);
		setPwd("abrahman");
		waitFor(1);
		clickOnProduct("USMLEStep1OnlinePrep2010");
		waitFor(1);
		clickLogIn();
		waitFor(2);
		//clickOnProducts();
		verifDiscTime("Physiology");
	}

	// ***********************************************************************************************

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
