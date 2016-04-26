package med.OLP.controller;

import java.io.File;
import java.io.IOException;

import med.OLP.model.OLPHomePageModel;
import med.OLP.model.OLPHomepageConfirmationPage;
import med.OLP.model.Step3ObGynandEndoVideoPageModel;

import org.openqa.selenium.WebDriver;

public class NaplexMigrationPageController {
	
	protected WebDriver driver = null;
	public Step3ObGynandEndoVideoPageModel olpObGynpage = null;
	public OLPHomepageConfirmationPage confmPage = null;
	public OLPHomePageModel olpHomepage = null;
	
	
	public NaplexMigrationPageController(WebDriver driver){
		this.driver = driver;
		olpObGynpage = new Step3ObGynandEndoVideoPageModel(driver);
		confmPage = new OLPHomepageConfirmationPage(driver);
		olpHomepage = new OLPHomePageModel(driver);
	}

	public void verifyCardiologyVideoDuration() throws IOException {
		olpHomepage.readTestData();
		}
	
}
