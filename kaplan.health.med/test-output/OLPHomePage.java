package kaplan.health.jasper.test;

import org.testng.annotations.Test;

public class OLPHomePage extends BaseScript{

	
	@Test 
	public void followingSyllabusPaths(){
		openOPLLogInPage().logInOLPPageWithPath("arahman1", "arahman1", "NBDE1DiagOLP","/nbde/nbde1Diag2010_v2");
		homepage().openNBDEDiagnosticInstitutionalPage();
	}
	
	@Test
	public void testing1212(){
		
		openOMALogInPage().test();
		
	}
	
	@Test
	public void testContents(){
		openJasQALogInPage().testContents();
		
	}
}
