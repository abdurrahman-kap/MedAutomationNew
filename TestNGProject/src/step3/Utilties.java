package step3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Utilties {
	public static final String URL ="https://qa-jasperwp.kaptest.com/loginv8.aspx";
	public static String pageTile ="JasperWP Login";
	public static String product="USMLESTEP3ONLINEPREP2010";
	public static String file="C:\\workspace\\TestNGProject\\src\\step3\\TestdataStep3.xlsx";
	public static String sheetname ="test";
	//Should be greater than or equal to 1
	public static int globalrowcount=1;
	//set this to "Chrome" or "Firefox". Is not case sensitive
	public static String browser="chrome";
	public static int m=0;
		
	//MouseOver
	public static void mouseOver(WebDriver driver,By by) {
		
		WebElement item = driver.findElement(by);
		Actions  mouseOver =new Actions(driver);
		mouseOver.moveToElement(item).build().perform();
		
	}
	public static void screenshot(WebDriver driver) throws IOException
	{
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destionationFile= new File("C:\\workspace\\myproject\\bin\\mypackage\\ScreenshotsKaplan\\screenshot"+m+".jpg");
		FileUtils.copyFile(sourceFile, destionationFile);
		m=m+1;
					
	}


}
