package med.OLP.controller;

import junit.framework.Assert;
import med.OLP.model.OLPHomePageModel;
import med.OLP.model.OLPHomepageConfirmationPage;
import org.openqa.selenium.WebDriver;

public class OLPHomePageController {
	
	protected WebDriver driver = null;
	public OLPHomePageModel olphomepage = null;
	public OLPHomepageConfirmationPage confmPage = null;
	
	
	public OLPHomePageController(WebDriver driver){
		this.driver = driver;
		olphomepage = new OLPHomePageModel(driver);
		confmPage = new OLPHomepageConfirmationPage(driver);
	}
	
	public void openNBDEDiagnosticInstitutionalPage() {
		olphomepage.waitFor(5);
		Assert.assertEquals("NBDE Diagnostic Institutional", confmPage.getWelcomePageText());
	}
	
	
	public void verifyNBDETesting() {
		olphomepage.waitFor(5);
		olphomepage.waitFor(5);
		olphomepage.clickOnContinue();
		Assert.assertEquals("My NBDE Part I Online Prep Dashboard",confmPage.getHomePagetitle());
		olphomepage.waitFor(2);
		olphomepage.clickDental();
		olphomepage.waitFor(2);
		olphomepage.clickOnMol("Dental");	
	}

	public void verifyNBDEImmunology() {
		olphomepage.waitFor(5);
		olphomepage.clickOnContinue();
		Assert.assertEquals("My NBDE Part I Online Prep Dashboard",confmPage.getHomePagetitle());
		olphomepage.waitFor(2);
		olphomepage.clickOnImmunology();
		olphomepage.waitFor(2);
		olphomepage.clickOnMol("Immunology");
		}

	public void verifyNBDEMicrobiology() {
		olphomepage.waitFor(5);
		olphomepage.clickOnContinue();
		Assert.assertEquals("My NBDE Part I Online Prep Dashboard",confmPage.getHomePagetitle());
		olphomepage.waitFor(2);
		olphomepage.clickOnMicrobiology();
		olphomepage.waitFor(2);
		olphomepage.clickOnMol("Microbiology");
	}

	public void verifyNBDEBiochemistry() {
		olphomepage.waitFor(5);
		olphomepage.clickOnContinue();
		Assert.assertEquals("My NBDE Part I Online Prep Dashboard",confmPage.getHomePagetitle());
		olphomepage.waitFor(2);
		olphomepage.clickOnBiochemistry();
		olphomepage.waitFor(2);
		olphomepage.clickOnMol("Biochemistry");
	}

	public void verifyNBDEPhysiology() {
		olphomepage.waitFor(5);
		olphomepage.clickOnContinue();
		Assert.assertEquals("My NBDE Part I Online Prep Dashboard",confmPage.getHomePagetitle());
		olphomepage.waitFor(2);
		olphomepage.clickOnPhysiology();
		olphomepage.waitFor(2);
		olphomepage.clickOnMol("Physiology");
	}

	public void verifyNBDEAnatomy() {
		olphomepage.waitFor(5);
		olphomepage.clickOnContinue();
		Assert.assertEquals("My NBDE Part I Online Prep Dashboard",confmPage.getHomePagetitle());
		olphomepage.waitFor(2);
		olphomepage.clickOnAnatomy();
		olphomepage.waitFor(2);
		olphomepage.clickOnMol("Anatomy");
	}

	public void verifyNBDEPathology() {
		olphomepage.waitFor(5);
		olphomepage.clickOnContinue();
		Assert.assertEquals("My NBDE Part I Online Prep Dashboard",confmPage.getHomePagetitle());
		olphomepage.waitFor(2);
		olphomepage.clickOnPathology();
		olphomepage.waitFor(2);
		olphomepage.clickOnMol("Pathology");
	}
	
}
