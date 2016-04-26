package testImage;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SendMailWithAttachment{
	
    public static void main(String[] args) throws IOException, InterruptedException {
    	
        Scanner kb = new Scanner(System.in);
        System.out.println("enter ur id: ");
        String id = kb.nextLine();
        System.out.println("enter ur pass: ");
        String password = kb.nextLine();
        System.out.println("enter email-id to whom u want to send the mail: ");
        String toId = kb.nextLine();
        System.out.println("enter subject for mail: ");
        String subject = kb.nextLine();
        System.out.println("enter the content of the mail: ");
        String content = kb.nextLine();
       
        //open gamil
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://gmail.kaplan.com");
       
        //login to gmail
        driver.findElement(By.id("Email")).sendKeys(id);
        driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.name("signIn")).click();
       
        //click on compose and add the to mail id, and subject
        driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
        driver.findElement(By.xpath("//form[1]//textarea[1]")).sendKeys(toId);
        driver.findElement(By.xpath("//div[@class='aoD az6']//input[@class='aoT']")).sendKeys(subject);
       
        //wirte the mail body, that mail body is under frame so 1st switch the control to frame then write
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='1']")));
        driver.findElement(By.xpath("//body[@class='editable LW-avf']")).sendKeys(content);
        driver.switchTo().defaultContent(); // again switch back to main page
       
        //click on attachment
        driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
        //use autoit tool to attach a file
        Runtime.getRuntime().exec("C:\\selenium\\AutoIT\\fileUpload.exe");
        Thread.sleep(10000); //wait for 10sec to upload file
       
        //click on send
        driver.findElement(By.xpath("//div[text()='Send']")).click();
        String msg = driver.findElement(By.xpath("//div[contains(text(),'Your message has been sent.')]")).getText();
        String exp = "Your message has been sent. View message";
        Assert.assertEquals(msg, exp);
        System.out.println("pass");
        driver.close();
    }
}
