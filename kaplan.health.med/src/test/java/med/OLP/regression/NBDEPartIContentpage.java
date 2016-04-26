package med.OLP.regression;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import reporter.JyperionListener;
import med.base.BaseScript;
@Listeners(JyperionListener.class)

public class NBDEPartIContentpage extends BaseScript{
	
	@Test
	public void VerifyNBDEDental(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NBDEPI2015OnlinePrepHTML");
		olphomepage().verifyNBDETesting();
	}
	
	@Test
	public void VerifyNBDEImmunology(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NBDEPI2015OnlinePrepHTML");
		olphomepage().verifyNBDEImmunology();
	}
	@Test
	public void VerifyNBDEMicrobiology(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NBDEPI2015OnlinePrepHTML");
		olphomepage().verifyNBDEMicrobiology();
	}
	@Test
	public void VerifyNBDEBiochemistry(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NBDEPI2015OnlinePrepHTML");
		olphomepage().verifyNBDEBiochemistry();
	}
	@Test
	public void VerifyNBDEPhysiology(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NBDEPI2015OnlinePrepHTML");
		olphomepage().verifyNBDEPhysiology();
	}
	@Test
	public void VerifyNBDEAnatomy(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NBDEPI2015OnlinePrepHTML");
		olphomepage().verifyNBDEAnatomy();
	}
	@Test
	public void VerifyNBDEPathology(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NBDEPI2015OnlinePrepHTML");
		olphomepage().verifyNBDEPathology();
	}

}
