package testImage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Step1HYOnlinePrepTitleVerification {
	private WebDriver driver = null;
	String discName;
	String discpNameVal;
	String subName;
	String chapterListName;
	String dashBoardVideoName;
	String titleString;
	String subChapterlisttext;
	String chapName;
	String dashDoardtimeVal;
	static int rowIndex = 1;
	String som;
	private static final String FILE_PATH = "C:\\Users\\AbRahman\\Desktop\\Step1HYTitleVerification.xlsx";
	
	
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

	public void clickOnContinue() {
		int fElement = driver.findElements(
				By.xpath("//div[1]/div/div/div/p[3]/a")).size();
		if (fElement != 0) {
			WebElement clickOnSubName = driver.findElement(By
					.xpath("//div[1]/div/div/div/p[3]/a"));
			clickOnSubName.click();
		}
	}

	public void clickOnChapterClose() {
		int clickLogInnum = driver.findElements(By
				.xpath(".//*[@id='chapter-list']/button")).size();
		if (clickLogInnum > 0) {
			WebElement clickLogIn = driver.findElement(By
					.xpath(".//*[@id='chapter-list']/button"));
			clickLogIn.click();
		}
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
				waitFor(3);
				WebElement clickOnProd = driver.findElement(By
						.xpath(".//*[@id='productName_chosen']/a/div/b"));
				clickOnProd.click();
				waitFor(3);
				WebElement setProd = driver.findElement(By
						.xpath(".//*[@id='productName_chosen']/div/div/input"));
				setProd.sendKeys(item);
				waitFor(3);
				WebElement clickProd = driver.findElement(By
						.xpath(".//*[@id='productName_chosen']/div/ul/li/em"));
				clickProd.click();
				waitFor(3);
			}
		}
	}

	public String getContTime(int j) {
		WebElement pagetitleText = driver.findElement(By
				.xpath("html/body/div[1]/div[1]/section[1]/div[4]/div[2]/div["
						+ j + "]/div[4]"));
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
	public void clickOnProducts() throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
        Sheet studentsSheet = workbook.createSheet("Step1HyOnlinePrepTitle");

		for (int i = 1; i < 150; i++) {

			int subName = driver.findElements(
					By.xpath(".//*[@id='home-dashboard-table-txt']/li[" + i
							+ "]/ul/li[1]/a")).size();
			if (subName > 0) {
				System.out.println("Value of Disciplines : " + i);
				waitFor(3);
				WebElement subNameText = driver.findElement(By
						.xpath(".//*[@id='home-dashboard-table-txt']/li[" + i
								+ "]/ul/li[1]/a"));
				discName = subNameText.getText();
				System.out.println("Home dashboard Disciplines name : "+ discName);
				clickDisplayTime(discName,workbook,studentsSheet);
			} else {
				System.out.println("No More Disciplines found !!!!");
				break;
			}
		}
	}

	public void clickDisplayTime(String dispName,Workbook workbook, Sheet studentsSheet) throws Exception {
		
		for (int i = 1; i < 1500; i++) {

			int subName = driver.findElements(By.xpath(".//*[@id='home-dashboard-table-txt']/li[2]/ul/li[1]/a")).size();
			if (subName > 0) {
				waitFor(3);
				WebElement subNameText = driver.findElement(By
								.xpath("//*[@id='home-dashboard-table-results']/ul[@id='home-dashboard-table-txt']//li/a[normalize-space(text())='"
										+ dispName + "']"));
				discpNameVal = subNameText.getText();
				subNameText.click();
			}

			int nubEle = driver.findElements(
					By.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a")).size();
			waitFor(1);
			if (nubEle > 0) {
				WebElement chapterListNameText = driver.findElement(By
						.xpath(".//*[@id='chapter-list']/ul/li[" + i + "]/a"));
				chapterListName = chapterListNameText.getText();
				chapterListNameText.click();
				waitFor(2);
				clicVideoTitle(workbook, studentsSheet);
				waitFor(2);
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				clickOnChapterClose();
				break;
			}
		}
	}

	public void clickOnContentDiscipline() throws Exception {
		
		Workbook workbook1 = new XSSFWorkbook();
        Sheet studentsSheet1 = workbook1.createSheet("Step1HyOnlinePrepTitle");
        
		for (int i = 1; i < 1500; i++) {

			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/a"));
			waitFor(2);
			WebElement subLink = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/ul/li[10]/a"));
			waitFor(2);
			int  subChapterlistLinknum = driver.findElements(By.xpath(".//*[@id='nav']/li[2]/ul/li[10]/ul/li["+i+"]/a")).size();
			if (subChapterlistLinknum !=0){
				WebElement subChapterlistLink = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/ul/li[10]/ul/li["+i+"]/a"));
				String subChapterlisttext = subChapterlistLink.getText();
				/*String subChapterlisttext1 = subChapterlistLink.getAttribute("value");
				System.out.println("Text from get text : " + subChapterlisttext);
				System.out.println("Text from attribute  text : " + subChapterlisttext1);*/
				waitFor(2);
				//action.moveToElement(we).moveToElement(subLink).moveToElement(subChapterlistLink).
				action.moveToElement(we).moveToElement(subLink).moveToElement(subChapterlistLink).click().build().perform();
				waitFor(2);
				clickoncententVideoTitle(subChapterlisttext,workbook1, studentsSheet1);
				waitFor(2);
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				clickOnChapterClose();
				break;
			}
		}
	}
	
public void clickOnContentDisciplineClinicalCorrelates() throws Exception {
		
		Workbook workbook1 = new XSSFWorkbook();
        Sheet studentsSheet1 = workbook1.createSheet("Step1HyOnlinePrepTitle");
        
		for (int i = 1; i < 1500; i++) {

			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/a"));
			waitFor(2);
			WebElement subLink = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/ul/li[11]/a"));
			waitFor(2);
			int  subChapterlistLinknum = driver.findElements(By.xpath(".//*[@id='nav']/li[2]/ul/li[11]/ul/li["+i+"]/a")).size();
			if (subChapterlistLinknum !=0){
				WebElement subChapterlistLink = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/ul/li[11]/ul/li["+i+"]/a"));
				String subChapterlisttext = subChapterlistLink.getText();
				String subChapterlisttext1 = subChapterlistLink.getAttribute("value");
				/*System.out.println("Text from get text : " + subChapterlisttext);
				System.out.println("Text from attribute  text : " + subChapterlisttext1);*/
				waitFor(2);
				//action.moveToElement(we).moveToElement(subLink).moveToElement(subChapterlistLink).
				action.moveToElement(we).moveToElement(subLink).moveToElement(subChapterlistLink).click().build().perform();
				waitFor(2);
				clickoncententVideoTitle(subChapterlisttext,workbook1, studentsSheet1);
				waitFor(2);
				driver.navigate().back();
			} else {
				System.out.println("No More Element found !!!!");
				clickOnChapterClose();
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
				String timeVal = (getContTime(m));// get the time from
													// dashboards

				waitFor(5);
				WebElement videoTitleText = driver.findElement(By
						.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
								+ "]/div[1]/a"));
				dashBoardVideoName = videoTitleText.getText();// need Text Value
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

	public void clicVideoTitle( Workbook workbook, Sheet studentsSheet) throws Exception {

		for (int i = 1; i < 1500; i++) {
			int chapterDashboardNum = driver.findElements(
					By.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
							+ "]/div[1]/a")).size();
			waitFor(1);
			System.out.println("	Desh Board Lecture title quentity : " + chapterDashboardNum);
			if (chapterDashboardNum > 0) {
				int m = i;
				waitFor(1);
				dashDoardtimeVal = (getContTime(m));
				System.out.println("	Dashbord time is  : " + dashDoardtimeVal);
				waitFor(1);
				WebElement dashBoardVideolinkText = driver.findElement(By
						.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
								+ "]/div[1]/a"));
				dashBoardVideoName = dashBoardVideolinkText.getText();
				System.out.println("	Lecture title Name : " + dashBoardVideoName);
				dashBoardVideolinkText.click();
				waitFor(5);
				verifyVideoTitle(discpNameVal,chapterListName ,dashBoardVideoName,dashDoardtimeVal,workbook,studentsSheet);
				waitFor(2);
				driver.navigate().back();
			} else {
				System.out.println("	No More Element found !!!!");
				break;
			}
		}
		// return titleName;
	}

	private void verifyVideoTitle(String dTitle,String cLTitle, String dBVTitle,String dbTime, Workbook workbook, Sheet studentsSheet) throws ParseException {
		
		String expected = dTitle +" - " + cLTitle +" - " + dBVTitle ;
		System.out.println("		Expected Title String : "+ expected);
		String videoTitle = getVideoTitle();
		System.out.println("		Actual Title String : "+ videoTitle);
		String videoRTime = getVideoTime();
		System.out.println("			Actual Time String : "+ videoRTime);
		writeStudentsListToExcel(expected , videoTitle,dbTime,videoRTime,workbook,studentsSheet);
	}

	private String getVideoTitle() {
		WebElement videoTitleText = driver.findElement(By
				.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
		return videoTitleText.getText();	
	}
	
	private String getContentVideoTitle() {
		WebElement videoTitleText = driver.findElement(By
				.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
		som = videoTitleText.getText();
		String[] getTime = som.split("-");
		return getTime[2];	
	}
	
	private void updateContentVideoTitletext(String dBtime,String dBVTitle, Workbook workbook, Sheet studentsSheet) throws ParseException {
		
		String expected = dBVTitle ;
		System.out.println("		Expected Title String : "+ expected);
		String videoTitle = getContentVideoTitle();
		System.out.println("		Actual Title String : "+ videoTitle);
		String videoTime = getVideoTime();
		System.out.println("		Actual Video run Time : "+ videoTime);
		writeStudentsListToExcelContent(som,expected ,videoTitle,dBtime,videoTime, workbook,studentsSheet);
	}

	public void getlecSlidesText() {
		String getVal = null;

		for (int i = 1; i < 1500; i++) {
			int nubEle = driver
					.findElements(
							By.xpath(".//*[@id='lecture-slides-focuser']/a["
									+ i + "]")).size();
			waitFor(2);
			// System.out.println("		Lecture Slide number in Vedio page: "+nubEle );
			if (nubEle > 0) {
				waitFor(2);
				WebElement getlecSlidesText = driver.findElement(By
						.xpath(".//*[@id='lecture-slides-focuser']/a[" + i
								+ "]"));
				System.out.println("		Lecture Slide : "
						+ getlecSlidesText.getText());
				getVal = getlecSlidesText.getText();
			} else {
				System.out.println("		No More Element found !!!!");
				break;
			}

		}
		// return getVal;
	}
	public static void writeStudentsListToExcelContent(String titleString ,String expectedValue ,String actualValue,String videoTime,  String deshboardvideoTime, Workbook workbook, Sheet studentsSheet) throws ParseException{

		Row row1 = studentsSheet.createRow(0);
		row1.createCell(0).setCellValue("Video Title");
        row1.createCell(1).setCellValue("Expected Video Title");
        row1.createCell(2).setCellValue("Actual Video Title");
        row1.createCell(3).setCellValue("Title verification Result");
        row1.createCell(4).setCellValue("Time verification Result");
        
        Row row = studentsSheet.createRow(rowIndex++);
        	row.createCell(0).setCellValue(titleString);
            row.createCell(1).setCellValue(expectedValue);
            row.createCell(2).setCellValue(actualValue);
            if(expectedValue.trim().equalsIgnoreCase(actualValue.trim())){
            	row.createCell(3).setCellValue("Pass");
            }else{
            	row.createCell(3).setCellValue("Fail");
            }
            
            if(deshboardvideoTime.trim().equalsIgnoreCase(videoTime.trim())){
            	row.createCell(4).setCellValue("Pass");
            }else{
            	row.createCell(4).setCellValue("Fail");
            	
            	row.createCell(5).setCellValue(timeDifference(deshboardvideoTime,videoTime));
            }
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
            System.out.println("		"+FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void writeStudentsListToExcel(String expectedValue ,String actualValue,String dbTime,String vRTime, Workbook workbook, Sheet studentsSheet) throws ParseException{

		Row row1 = studentsSheet.createRow(0);
		//row1.createCell(0).setCellValue("Video Title");
        row1.createCell(0).setCellValue("Expected Video Title");
        row1.createCell(1).setCellValue("Actual Video Title");
        row1.createCell(2).setCellValue("Title verification Result");      
        row1.createCell(3).setCellValue("Desh Board Time ");
        row1.createCell(4).setCellValue("Video Run Time");
        row1.createCell(5).setCellValue("Time verification Result");
        row1.createCell(6).setCellValue("Time Difference ");
        row1.createCell(7).setCellValue(" Comments");
        
        Row row = studentsSheet.createRow(rowIndex++);
        	//row.createCell(0).setCellValue(titleString);
            row.createCell(0).setCellValue(expectedValue);
            row.createCell(1).setCellValue(actualValue);
            if(expectedValue.trim().equalsIgnoreCase(actualValue.trim())){
            	row.createCell(2).setCellValue("Pass");
            }else{
            	row.createCell(2).setCellValue("Fail");
            }
            row.createCell(3).setCellValue(dbTime);
            row.createCell(4).setCellValue(vRTime);
            
            if(dbTime.trim().equalsIgnoreCase(vRTime.trim())){
            	row.createCell(5).setCellValue("Pass");
            }else{
            	row.createCell(5).setCellValue("Fail");
            	row.createCell(6).setCellValue(timeDifference(vRTime,dbTime));
            	if(vRTime.trim().equalsIgnoreCase("00:00:00")){
        			row.createCell(7).setCellValue("Video is not loaded");
                }
            }
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void clickOnContentLibraryBarone(int chapNum){
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/a"));
		waitFor(2);
		WebElement subLink = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/ul/li[10]/a"));
		waitFor(2);
		int  subChapterlistLinknum = driver.findElements(By.xpath(".//*[@id='nav']/li[2]/ul/li[10]/ul/li["+chapNum+"]/a")).size();
		if (subChapterlistLinknum !=0){
			WebElement subChapterlistLink = driver.findElement(By.xpath(".//*[@id='nav']/li[2]/ul/li[10]/ul/li["+chapNum+"]/a"));
			action.moveToElement(we).moveToElement(subLink).moveToElement(subChapterlistLink).click().build().perform();
		}else {
			System.out.println("No More Element found !!!!");
		}
	}
	
	public void clickoncententVideoTitle(String subChapterlisttext, Workbook workbook, Sheet studentsSheet) throws Exception {

		for (int i = 1; i < 1500; i++) {
			int chapterDashboardNum = driver.findElements(
					By.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
							+ "]/div[1]/a")).size();
			waitFor(1);
			System.out.println("	Desh Board Lecture title quentity : " + chapterDashboardNum);
			if (chapterDashboardNum > 0) {
				int m = i;
				waitFor(1);
				dashDoardtimeVal = (getContTime(m));
				System.out.println("	Dashbord time is  : " + dashDoardtimeVal);
				waitFor(1);
				WebElement dashBoardVideolinkText = driver.findElement(By
						.xpath(".//*[@id='chapter-dashboard-results']/div[" + i
								+ "]/div[1]/a"));
				dashBoardVideoName = dashBoardVideolinkText.getText();
				System.out.println("	Lecture title Name : " + dashBoardVideoName);
				dashBoardVideolinkText.click();
				waitFor(5);
				updateContentVideoTitletext(dashDoardtimeVal,dashBoardVideoName,workbook,studentsSheet);
				waitFor(2);
				driver.navigate().back();
			} else {
				System.out.println("	No More Element found !!!!");
				break;
			}
		}
		// return titleName;
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
	
	public void sendEmail(){
		final String username = "wprepemailer";
		final String password = "Kaplan1!";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp-cypress.kaplaninc.com");
		props.put("mail.smtp.port", "25");

	   /* Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");*/

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("abdur.rahman@kaplan.com"));
	        message.setSubject("Testing Subject");
	        message.setText("FYI");

	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        String file = "C:\\Users\\AbRahman\\Desktop\\Step1HYTitleVerification.xlsx";
	        String fileName = "Step1HYTitleVerification.xlsx";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	       // System.out.println("Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
// *********************************************************************
	@Test
	public void VerifyTitleInAllDiscipline() throws Exception {
		waitFor(2);
		setUserName("abrahman");
		waitFor(2);
		setPwd("abrahman");
		waitFor(2);
		clickOnProduct("USMLEStep1OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickOnContinue();
		waitFor(2);
		clickOnProducts();
	}
	
	@Test
	public void VerifyTitleInDiscipline() throws Exception {
		waitFor(2);
		setUserName("abrahman");
		waitFor(2);
		setPwd("abrahman");
		waitFor(2);
		clickOnProduct("USMLEStep1OnlinePrep2010");
		waitFor(2);
		clickLogIn();
		waitFor(2);
		clickOnContinue();
		waitFor(2);
		clickOnContentDiscipline();
		//clickOnContentDisciplineClinicalCorrelates();
	}

	// ***********************************************************************************************
	@BeforeMethod
	public void beforeMethod() {

		FirefoxProfile profile = new FirefoxProfile(); // FirefoxDriver
		// profile.setPreference("browser.cache.disk.enable", false);
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		//driver.navigate().to("http://jasperwp.qa.kaplan.com/loginv8.aspx");
		driver.navigate().to("http://jasperwp-stg.kaptest.com/loginv8.aspx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		waitFor(8);
		sendEmail();
		driver.quit();
	}

}
