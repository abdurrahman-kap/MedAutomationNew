package med.jasper.controller;

import junit.framework.Assert;
import med.jasper.model.JasperHomePageModel;
import med.jasper.model.JasperHomepageConfirmationPage;

import org.openqa.selenium.WebDriver;

public class JasperHomePageController {
	protected WebDriver driver = null;
	public JasperHomePageModel homepage = null;
	public JasperHomepageConfirmationPage confmPage = null;
	
	
	public JasperHomePageController(WebDriver driver){
		this.driver = driver;
		homepage = new JasperHomePageModel(driver);
		confmPage = new JasperHomepageConfirmationPage(driver);
	}
	
	public void verifyDisplayBiochemistryVideotitle() 
	{
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnBiochemistry();
		homepage.waitFor(2);
		homepage.clickOnMol("Biochemistry");
	}

	public void verifyDisplayBiochemistryQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnBiochemistry();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Biochemistry");
	}

	public void verifyDisplayImmunologyQuiztitle() {
		
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnImmunology();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Immunology, Hematology, and Oncology");
	}

	public void verifyDisplayInfectiousDiseaseQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnInfectiousDisease();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Infectious Disease");
	}
	public void verifyDisplayEpidemiologyQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnEpidemiology();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Epidemiology and Biostatistics");
	}

	public void verifyDisplayBehavioralQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnBehavioral();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Behavioral Medicine and Ethics");
	}

	public void verifyDisplayNeuroscienceQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnNeuroscience();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Neuroscience");
	}

	public void verifyDisplayMusculoskeletalQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnMusculoskeletal();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Musculoskeletal and Connective Tissue");
	}
	public void verifyDisplayRespiratoryQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnRespiratory();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Respiratory Medicine");
	}

	public void verifyDisplayCardiologyQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnCardiology();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Cardiology");
	}

	public void verifyDisplayGastroenterologyQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnGastroenterology();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Gastroenterology");
	}

	public void verifyDisplayEndocrinologyQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnEndocrinology();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Endocrinology");
	}

	public void verifyDisplayNephrologyQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnNephrology();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Nephrology");
	}

	public void verifyDisplayReproductiveQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnReproductive();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Reproductive Medicine");
	}
	
	public void openNBDEDiagnosticInstitutionalPage() {
		homepage.waitFor(5);
		Assert.assertEquals("NBDE Diagnostic Institutional", confmPage.getWelcomePageText());
	}

	public void verifyDisplayPharmacologyQuiztitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickOnChapterPage("Pharmacology");
	}

	public void verifyDisplayPharmacologyVideotitle() {
		homepage.waitFor(5);
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickOnMol("Pharmacology");
	}

	public void verifyDisplayImmunologyVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnImmunology();
		homepage.waitFor(2);
		homepage.clickOnMol("Immunology, Hematology, and Oncology");
	}

	public void verifyDisplayInfectiousDiseaseVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnInfectiousDisease();
		homepage.waitFor(2);
		homepage.clickOnMol("Infectious Disease");
	}

	public void verifyDisplayEpidemiologyVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnEpidemiology();
		homepage.waitFor(2);
		homepage.clickOnMol("Epidemiology and Biostatistics");
	}

	public void verifyDisplayBehavioralMedicineVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnBehavioral();
		homepage.waitFor(2);
		homepage.clickOnMol("Behavioral Medicine and Ethics");
	}

	public void verifyDisplayNeuroscienceVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnNeuroscience();
		homepage.waitFor(2);
		homepage.clickOnMol("Neuroscience");
	}

	public void verifyDisplayMusculoskeletalVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnMusculoskeletal();
		homepage.waitFor(2);
		homepage.clickOnMol("Musculoskeletal and Connective Tissue");
	}

	public void verifyDisplayRespiratoryMedicineVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnRespiratory();
		homepage.waitFor(2);
		homepage.clickOnMol("Respiratory Medicine");
	}

	public void verifyDisplayCardiologyVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnCardiology();
		homepage.waitFor(2);
		homepage.clickOnMol("Cardiology");
	}

	public void verifyDisplayGastroenterologyVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnGastroenterology();
		homepage.waitFor(2);
		homepage.clickOnMol("Gastroenterology");
	}

	public void verifyDisplayEndocrinologyVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnEndocrinology();
		homepage.waitFor(2);
		homepage.clickOnMol("Endocrinology");
	}

	public void verifyDisplayNephrologyVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnNephrology();
		homepage.waitFor(2);
		homepage.clickOnMol("Nephrology");
	}

	public void verifyDisplayReproductiveMedicineVideotitle() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnReproductive();
		homepage.waitFor(2);
		homepage.clickOnMol("Reproductive Medicine");
	}

	public void verifyPharmacologyVideoDuration() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickDisplayTime("Pharmacology");
	}
	
	public void verifyCardiologyVideoDuration() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickDisplayTime("Cardiology");
	}
	public void verifyGastroenterologyVideoDuration() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickDisplayTime("Gastroenterology");
	}
	public void verifyEndocrinologyVideoDuration() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickDisplayTime("Endocrinology");
	}
	public void verifyNephrologyVideoDuration() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickDisplayTime("Nephrology");
	}
	public void verifyPReproductiveMedicineVideoDuration() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickDisplayTime("Reproductive Medicine");
	}

	public void verifyAnalysisReviewpage() {
		// TODO Auto-generated method stub
		
	}

	public void ver() {
		homepage.waitFor(5);
		homepage.clickOnContinue();
		//Assert.assertEquals("My High Yield Dashboard",confmPage.getHomePagetitle());
		homepage.waitFor(2);
		homepage.clickOnPharmacology();
		homepage.waitFor(2);
		homepage.clickDisplayTime("Internal Medicine");
	}
	
}
