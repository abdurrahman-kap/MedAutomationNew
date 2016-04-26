package med.jasper.controller;

import junit.framework.Assert;
import med.OLP.model.OLPLogInPageModel;
import med.jasper.model.JasperHomePageModel;
import med.jasper.model.JasperHomepageConfirmationPage;
import med.jasper.model.JasperLoginPageModel;

import org.openqa.selenium.WebDriver;

public class JasperLogInPageController {
	
	WebDriver driver;
	private OLPLogInPageModel logInpage;
	private JasperHomepageConfirmationPage confmPage;
	public JasperHomePageModel homepage = null;
	public JasperLoginPageModel jLogInPage = null;
	
	public JasperLogInPageController(WebDriver driver){
		this.driver = driver;
		logInpage = new OLPLogInPageModel(driver);
		confmPage = new JasperHomepageConfirmationPage(driver);
		homepage = new JasperHomePageModel(driver);
		jLogInPage = new JasperLoginPageModel(driver);
	}
	
	public void logInOLPPage(String uName,String pwd,String prod) 
	{
		logInpage.waitFor(5);
		logInpage.setUserName(uName);
		logInpage.waitFor(3);
		logInpage.setPwd(pwd);
		logInpage.waitFor(3);
		logInpage.clickOnProduct(prod);
		logInpage.waitFor(2);
		logInpage.clickLogIn();
		logInpage.waitFor(2);
	}
	
	public void logInOLPPage(String uName,String pwd,String prod,String syllabusPath ) 
	{
		logInpage.waitFor(5);
		logInpage.setUserName(uName);
		logInpage.waitFor(3);
		logInpage.setPwd(pwd);
		logInpage.waitFor(3);
		logInpage.clickOnProduct(prod);
		logInpage.waitFor(2);
		logInpage.clickOnSyllabusPath(syllabusPath);
		logInpage.clickLogIn();
		logInpage.waitFor(2);
	}
	
	public void logInJasperPage(String ukName,String kPwd,String uName,String pwd,String prod ) 
	{
		logInpage.waitFor(5);
		jLogInPage.setKecUserName(ukName);
		logInpage.waitFor(3);
		jLogInPage.setKecPwd(kPwd);
		logInpage.waitFor(3);
		logInpage.waitFor(5);
		logInpage.setUserName(uName);
		logInpage.waitFor(3);
		logInpage.setPwd(pwd);
		logInpage.waitFor(3);
		logInpage.clickOnProduct(prod);
		logInpage.waitFor(2);
		jLogInPage.clickLogIn();
		logInpage.waitFor(7);
	}
}
