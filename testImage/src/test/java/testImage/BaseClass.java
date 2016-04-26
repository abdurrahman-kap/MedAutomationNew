package testImage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
 
import org.openqa.selenium.OutputType;
 
import org.openqa.selenium.TakesScreenshot;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class BaseClass {
 
    static WebDriver driver;
 
    public static WebDriver getDriver(){
 
        if(driver==null){
        	System.setProperty("webdriver.chrome.driver","C:\\DevTools\\Browser\\chromedriver.exe");// chromedriver
    		driver = new ChromeDriver();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }
 }
 