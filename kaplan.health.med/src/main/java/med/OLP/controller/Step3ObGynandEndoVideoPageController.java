package med.OLP.controller;

import junit.framework.Assert;
import med.OLP.model.OLPHomePageModel;
import med.OLP.model.OLPHomepageConfirmationPage;
import med.OLP.model.Step3ObGynandEndoVideoPageModel;

import org.openqa.selenium.WebDriver;

public class Step3ObGynandEndoVideoPageController {
	protected WebDriver driver = null;
	public Step3ObGynandEndoVideoPageModel olpObGynpage = null;
	public OLPHomepageConfirmationPage confmPage = null;
	
	
	public Step3ObGynandEndoVideoPageController(WebDriver driver){
		this.driver = driver;
		olpObGynpage = new Step3ObGynandEndoVideoPageModel(driver);
		confmPage = new OLPHomepageConfirmationPage(driver);
	}
	
	public void verifyStep3ObGynandEndoVideotitle(){
		olpObGynpage.waitFor(5);
		olpObGynpage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		olpObGynpage.waitFor(2);
		olpObGynpage.clickOnChapterPage("");
		olpObGynpage.waitFor(2);
		olpObGynpage.clickOnMol("Infectious Disease");
	}

}
