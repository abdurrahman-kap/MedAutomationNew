package med.cs.controller;

import med.cs.model.CSLoginConfirmationPageModel;
import med.cs.model.CSLoginPageModel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CSLoginPageController {

	protected WebDriver driver = null;
	public CSLoginPageModel loginPage = null;
	public CSLoginConfirmationPageModel loginConfpage = null;
	
	public CSLoginPageController(WebDriver driver) {
		this.driver = driver;
		loginPage = new CSLoginPageModel(driver);
		loginConfpage = new CSLoginConfirmationPageModel(driver);
	}

	public void verifylogin(){
		loginPage.setUserName("murali");
		loginPage.setPwd("kaplanadmin123$");
		loginPage.clickLogIn();
		loginPage.waitFor(1);
		Assert.assertEquals(loginConfpage.getLogOff(), "Log Off");
	}
}
