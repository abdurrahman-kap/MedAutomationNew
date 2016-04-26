package med.OLP.regression;

import org.testng.annotations.Test;

import med.base.BaseScript;

public class Step3ObGynandEndoVideoTitlle extends BaseScript {
	
	@Test
	public void VerifyInternalMedicine(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "USMLEStep3OnlinePrep2010");	
	}
}
