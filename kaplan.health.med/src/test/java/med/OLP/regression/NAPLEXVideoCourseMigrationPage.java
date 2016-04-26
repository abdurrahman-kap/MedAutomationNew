package med.OLP.regression;

import java.io.IOException;

import med.base.BaseScript;

import org.testng.annotations.Test;

public class NAPLEXVideoCourseMigrationPage extends BaseScript {

	@Test
	public void VerifyTestAnalysisReviewpageforQbankOLP() throws IOException{
		//openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "NAPLEX2015OnlinePrepHTML");
		naplexpage().verifyCardiologyVideoDuration();
	}
}
