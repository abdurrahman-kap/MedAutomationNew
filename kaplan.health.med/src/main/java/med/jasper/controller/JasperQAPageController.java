package med.jasper.controller;

import med.jasper.model.JasperHomepageConfirmationPage;
import med.jasper.model.JasperQAPageModel;

import org.openqa.selenium.WebDriver;

public class JasperQAPageController {
	
	protected WebDriver driver = null;
	public JasperQAPageModel homepage = null;
	public JasperHomepageConfirmationPage confmPage = null;
	
	
	public JasperQAPageController(WebDriver driver){
		this.driver = driver;
		homepage = new JasperQAPageModel(driver);
		confmPage = new JasperHomepageConfirmationPage(driver);
	}
	
	public void testContents(){
		homepage.setKECUserName("abrahman");
		homepage.waitFor(2);
		homepage.setKECPWD("Nusrat1234!");
		homepage.waitFor(2);
		homepage.setUserName("abrahman");
		homepage.waitFor(2);
		homepage.setPwd("abrahman");
		homepage.clickOnProduct("USMLEStep1Qbank2010");
		homepage.waitFor(2);
		homepage.clickLogIn();
		homepage.waitFor(5);
		driver.navigate().to("http://qwjasweb02.kaplaninc.com/apps/delivery/contentitemv2.aspx?format=xml&name=OL1595");
		homepage.waitFor(15);
		confmPage.getUpdateDate();
	}

}
