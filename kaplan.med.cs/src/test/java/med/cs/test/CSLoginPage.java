package med.cs.test;

import org.testng.annotations.Test;
public class CSLoginPage extends BaseScript{
	
@Test
public void Verifylogin(){
	openLogon().verifylogin();
}
}
