package kaplanHealth;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestclassTest {
	protected static WebDriver driver = null;

  @BeforeMethod
  public void setup() {
	  driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test() {
	  driver = new FirefoxDriver();
	  driver.navigate().to("google.com");
  }
}
