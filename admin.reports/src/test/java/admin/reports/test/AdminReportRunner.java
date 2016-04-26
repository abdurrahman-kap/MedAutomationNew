package admin.reports.test;

public class AdminReportRunner {

	public static void main(String[] args) {
		
		AdminLogInPage adminR = new AdminLogInPage();
		adminR.beforeMethod();
		adminR.openLogInPage();
		adminR.afterMethod();
		
		adminR.beforeMethod();
		adminR.VerifyDisplayedLoginpage();
		adminR.afterMethod();
		
		adminR.beforeMethod();
		adminR.VerifyErrorLogInMessages();
		adminR.afterMethod();
		
		adminR.beforeMethod();
		adminR.VerifyLoginAdminReport();
		adminR.afterMethod();
		
		adminR.beforeMethod();
		adminR.VerifySignOutFunctionality();
		adminR.afterMethod();

	}

}
