package med.shp.controller;

import med.shp.model.OAMQALogInPageModel;

import org.openqa.selenium.WebDriver;

public class OAMQALogInPageController {

	protected WebDriver driver = null;
	public OAMQALogInPageModel homePage = null;
	
	public OAMQALogInPageController(WebDriver driver){
		this.driver = driver;
		homePage = new OAMQALogInPageModel(driver);
	}
	
	public void test(){
		homePage.clickOnOAMQA();
		homePage.clickOnUser();
		homePage.clickOnCreateStudent();
		homePage.clickCreateStudent();
		homePage.setFName("Abdur");
		homePage.setLName("Rahman");
		homePage.SelectProgram("COMLEX");
		homePage.setLogInEmail("some@kaplan.com");
		homePage.setLogInPwd("pwd");
		homePage.setLogInConPwd("pwd");
		
	}


}
