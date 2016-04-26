package admin.reports.controller;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import admin.reports.Model.AdminLoginConfirmationPageModel;
import admin.reports.Model.AdminlogInPageModel;

public class AdminLogInPageController {
	
	WebDriver driver;
	private AdminlogInPageModel logInpage;
	private AdminLoginConfirmationPageModel confmPage;
	
	public AdminLogInPageController(WebDriver driver){
		this.driver = driver;
		logInpage = new AdminlogInPageModel(driver);
		confmPage = new AdminLoginConfirmationPageModel(driver);
	}
	
	public void verifyDisplayedLoginpage(){
		logInpage.waitFor(2);
		confmPage.getBlueBanner();
		logInpage.waitFor(2);
		confmPage.getFooterString();
		logInpage.waitFor(2);
		confmPage.getPageConfString();
		logInpage.waitFor(2);
	}

	public void verifylogInAdminReport(){
		logInpage.waitFor(3);
		logInpage.setUserName("kaplan@kaplan.com");
		logInpage.waitFor(2);
		logInpage.setPwd("kaplan");
		logInpage.waitFor(2);
		logInpage.clickLogIn();
		logInpage.waitFor(2);
		Assert.assertEquals(confmPage.getPageNavConf(), "Welcome to the Reporting Portal");
	}
	
	public void verifyErrormessages (){
		
		String uID[] = {" ","kaplan","kaptest","kaplan@kaplan.com","abdur@yahoo.com","abdur@yahoo.com"};
		String pWD[] = {"kaplan","kaptestttt","kaplan","kaplkaplan","qazxsw","kaplan"};
		
		String errMess[] = {"Please enter a valid Email","Please enter a valid Email",
							"Please enter a valid Email","Please enter a valid Email Address",
							"We're sorry, we don't recognize that ",
							"We're sorry, we don't recognize that "};
		for(int i = 0;i<5;i++){
			logInpage.waitFor(3);
			logInpage.setUserName(uID[i]);
			logInpage.waitFor(2);
			logInpage.setPwd(pWD[i]);
			logInpage.waitFor(2);
			logInpage.clickLogIn();
			Assert.assertTrue(confmPage.geterrorMessageOne().contains(errMess[i]));
		}
	}

	public void verifyErrorLogIn() {
		
		logInpage.waitFor(3);
		logInpage.setUserName(" ");
		logInpage.waitFor(2);
		logInpage.setPwd(" ");
		logInpage.waitFor(2);
		logInpage.clickLogIn();
		Assert.assertEquals(confmPage.geterrorMessageUid(), "Please enter a valid Email Address");
		Assert.assertEquals(confmPage.geterrorMessagePwd(), "Please enter a valid Password");
	}

	public void verifySignOutFunctionality() {
		logInpage.waitFor(3);
		logInpage.setUserName("kaplan@kaplan.com");
		logInpage.waitFor(2);
		logInpage.setPwd("kaplan");
		logInpage.waitFor(2);
		logInpage.clickLogIn();
		logInpage.waitFor(2);
		Assert.assertEquals(confmPage.getPageNavConf(), "Welcome to the Reporting Portal");
		logInpage.waitFor(2);
		logInpage.clickSignOut();
		logInpage.waitFor(2);
		Assert.assertEquals(confmPage.getSignOutConf(), "Please Log in to the Reporting portal");
	}
	
}
