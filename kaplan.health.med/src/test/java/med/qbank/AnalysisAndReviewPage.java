package med.qbank;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import med.base.BaseScript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import reporter.JyperionListener;

@Listeners(JyperionListener.class)
public class AnalysisAndReviewPage extends BaseScript{
	
	@Test
	public void VerifyTestAnalysisReviewpageforQbankOLP(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "COMLEXQbankOLP");
		openQBankPage().verifyAnalysisReviewpage();
	}
	
	@Test
	public void VerifyAnalysispageforQbankOLPproducts(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "COMLEXQbankOLP");
		openQBankPage().verifyAnalysispageforQbankOLP();
	}
	
	@Test
	public void VerifyAnalysispageforQbankOLP(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "COMLEXQbankOLP");
		openQBankPage().verifyAnalysispageforQbankOLP();
	}
	
	@Test
	public void VerifyReviewpageforQbankOLPproducts(){
		openOPLLogInPage().logInOLPPage("abrahman", "abrahman", "COMLEXQbankOLP");
		openQBankPage().verifyReviewpageforQbankOLP();
	}
	
	@Test
	public void VerifyExplanationforQbankOLPproducts(){
		openOPLLogInPage().logInOLPPage("abrahman", "vvvv", "COMLEXQbankOLP");
		openQBankPage().verifyExplanationOLP();
	}
	
	@Test 
	public void dateCheck(){
		 /*SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		    System.out.println("The short date format is  " + df.toPattern());
		    Locale loc = Locale.US;
		    System.out.println("The usa date formate  " + loc);
		    df = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, loc);
		    System.out.println("The usa date formate  " + df.toPattern());*/
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(new Date());
		 calendar.add(Calendar.HOUR,5);
		 System.out.println(calendar.getTime());
	}

}
