package admin.reports.test;

import org.testng.annotations.Test;

public class AdminLogInPage extends BaseScript  {
	
	@Test
	public void VerifyDisplayedLoginpage(){
		openLogInPage().verifyDisplayedLoginpage();
	}
	
	@Test
	public void VerifyLoginAdminReport(){
		openLogInPage().verifylogInAdminReport();
	}
	
	@Test
	public void VerifyErrorMessages(){
		openLogInPage().verifyErrormessages();
	}
	
	@Test
	public void VerifyErrorLogInMessages(){
		openLogInPage().verifyErrorLogIn();
	}
	
	@Test
	public void VerifySignOutFunctionality(){
		openLogInPage().verifySignOutFunctionality();
	}
}
