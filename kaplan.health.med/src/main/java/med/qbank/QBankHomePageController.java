package med.qbank;

import junit.framework.Assert;
import med.OLP.model.OLPHomePageModel;
import med.OLP.model.OLPHomepageConfirmationPage;

import org.openqa.selenium.WebDriver;

public class QBankHomePageController {
	
	protected WebDriver driver = null;
	public OLPHomePageModel olphomepage = null;
	public OLPHomepageConfirmationPage confmPage = null;
	
	
	public QBankHomePageController(WebDriver driver){
		this.driver = driver;
		olphomepage = new OLPHomePageModel(driver);
		confmPage = new OLPHomepageConfirmationPage(driver);
	}
	
	public void verifyAnalysisReviewpage() {
		
		Assert.assertEquals("Welcome to the COMLEX Qbank.", "Welcome to the " + confmPage.getWelcomePageText());
		olphomepage.waitFor(3);
		olphomepage.clickOnPreviousTest();
		olphomepage.waitFor(3);
		System.out.println(confmPage.getAnalysisPageText());
		Assert.assertEquals("TEST ANALYSIS : HISTORY", confmPage.getAnalysisPageText());
		olphomepage.waitFor(3);
		confmPage.verifyColHeaderText();
		olphomepage.waitFor(2);
		Assert.assertEquals("Analysis",confmPage.getAnalysisString());
		olphomepage.waitFor(2);
		Assert.assertEquals("Review",confmPage.getReviewString());
	}
	
	public void verifyAnalysispageforQbankOLP() {
		Assert.assertEquals("Welcome to the COMLEX Qbank.", "Welcome to the " + confmPage.getWelcomePageText());
		olphomepage.waitFor(3);
		olphomepage.clickOnPreviousTest();
		olphomepage.waitFor(3);
		olphomepage.clickOnAnalysislink();
		olphomepage.waitFor(2);
		olphomepage.clickOnReviewThistest();
		olphomepage.waitFor(2);
		olphomepage.clickOnGoToAnalysis();
		olphomepage.waitFor(2);
		Assert.assertEquals("OVERALL PERFORMANCE ANALYSIS",confmPage.getOVERALLPERFORMANCEText());
		olphomepage.waitFor(2);
		Assert.assertEquals("DISCIPLINE",confmPage.getDisciplineText());
		olphomepage.waitFor(2);
		Assert.assertEquals("ORGAN SYSTEM",confmPage.getOrganSystemText());
	}

	public void verifyReviewpageforQbankOLP() {
		Assert.assertEquals("Welcome to the COMLEX Qbank.", "Welcome to the " + confmPage.getWelcomePageText());
		olphomepage.waitFor(3);
		olphomepage.clickOnPreviousTest();
		olphomepage.waitFor(3);
		olphomepage.clickOnReviewlink();
		olphomepage.waitFor(2);
		olphomepage.clickOnViewReview();
		olphomepage.waitFor(3);
		/*confmPage.verifyReviewColHeaderText();
		olphomepage.waitFor(2);*/
		olphomepage.clickOnExplanationLink();
		olphomepage.waitFor(2);
		Assert.assertTrue(confmPage.getExplanationLinkVal());
		olphomepage.waitFor(2);
	}

	public void verifyExplanationOLP() {
		Assert.assertEquals("Welcome to the COMLEX Qbank.", "Welcome to the " + confmPage.getWelcomePageText());
		olphomepage.waitFor(3);
		olphomepage.clickOnPreviousTest();
		olphomepage.waitFor(3);
		olphomepage.clickOnReviewlink();
		olphomepage.waitFor(2);
		olphomepage.clickOnViewReview();
		olphomepage.waitFor(3);
		olphomepage.clickOnExplanationLink();
		olphomepage.waitFor(2);
		Assert.assertTrue(confmPage.getExplanationLinkVal());
		olphomepage.waitFor(2);
		olphomepage.clickOnCloseLink();
		olphomepage.waitFor(2);
		Assert.assertFalse(confmPage.getCloseLinkVal());
	}
	
}
