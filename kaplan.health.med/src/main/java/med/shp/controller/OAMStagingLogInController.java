package med.shp.controller;

import med.shp.model.OAMStagingLogInConfirmationPage;
import med.shp.model.OAMStagingLogInModel;

import org.openqa.selenium.WebDriver;

public class OAMStagingLogInController {
	
	protected WebDriver driver = null;
	public OAMStagingLogInModel homepage = null;
	public OAMStagingLogInConfirmationPage confmPage = null;
	
	
	public OAMStagingLogInController(WebDriver driver){
		this.driver = driver;
		homepage = new OAMStagingLogInModel(driver);
		confmPage = new OAMStagingLogInConfirmationPage(driver);
	}

}
