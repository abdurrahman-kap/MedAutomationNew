       package qidsTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

//Broswer "Chrome" or "Firefox"	
static String browser="Firefox";	

//Login Credentials
static String username="mcroatto";
static String password="mcroatto";

//Only select product USMLESTEP1QBANKOLP or USMLESTEP1QBANK2010
static String productName="USMLESTEP1QBANK2010";

//CMS
public static String url="https://cms-jasper.kaptest.com/loginv8.aspx";

//Excel
static String excelLoc="C:\\workspace\\TestNGProject\\src\\qidsTest\\BlueAtom.xlsx";
static String sheetName="Blue Rain";

//Only change the environment to "QA=qa,Staging=stg,Web0=preview"
static String environment= "stg";

static String jasperURL= "https://"+environment+"-jasper.kaptest.com/loginv8.aspx";
static String olpURL="https://"+environment+"-jasperwp.kaptest.com/loginv8.aspx";
static String historyMgr="https://"+environment+"-jasper.kaptest.com/apps/delivery/historymgr.aspx";

//Production Urls
/*static String environment= "pwjasweb14";

static String jasperURL="http://"+environment+".iopsnt.kaplan.com/loginv8.aspx";
static String olpURL="http://"+environment+".iopsnt.kaplan.com/loginv8.aspx";
static String historyMgr="http://"+environment+".iopsnt.kaplan.com/apps/delivery/historymgr.aspx";*/

/*Start from this Qid in excel. Always less than 1 than the row number in which Qid is present.
Suppose you want to start from row 5, then select startFromRowinExcel as 4. */
static int startFromRowinExcel=1;

static String screenShotsFolder="C:\\workspace\\TestNGProject\\src\\qidsTest\\Screenshots\\";

static void screenshots(WebDriver driver, String qIDcelldata){
	
	File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destionationFile= new File(screenShotsFolder+qIDcelldata+".jpg");
	try {
		FileUtils.copyFile(sourceFile, destionationFile);
	} catch (IOException e) {
		
		e.printStackTrace();
	}

			
}
	
}
