package med.OLP.regression;

import med.base.BaseScript;

import org.testng.annotations.Test;

public class OLPHomePage extends BaseScript{

	
	@Test 
	public void followingSyllabusPaths(){
		openOPLLogInPage().logInOLPPage("arahman1", "arahman1", "NBDE1DiagOLP","/nbde/nbde1Diag2010_v2");
		olphomepage().openNBDEDiagnosticInstitutionalPage();
	}

	
	@Test
	public void testContents(){
		openJasQALogInPage().testContents();	
	}
}
