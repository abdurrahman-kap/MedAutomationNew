package med.cs.model;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSAdminPageModel {
	
	protected WebDriver driver = null;
	
	public CSAdminPageModel(WebDriver driver){
		this.driver= driver;
	}
	
	public String getlecHeaderText() {
		WebElement getlecSlides = driver.findElement(By
				.xpath(".//*[@id='fullScreenContainer']/div[1]/h3"));
		System.out.println("Chk Value : " + getlecSlides.getText());
		return getlecSlides.getText();
	}

	public String getWelcomePageText() {
		waitFor(5);
		WebElement fndElement = driver.findElement(By.xpath("//tr[4]/td/b"));
		return fndElement.getText();
	}

	public String getAnalysisPageText() {
		waitFor(2);
		WebElement fndElement = driver.findElement(By
				.xpath("//thead/tr[1]/td/div"));
		return fndElement.getText();
	}

	public String getAnalysisString() {
		WebElement pagetitleText = driver.findElement(By
				.xpath("//tbody/tr/td[7]/a[1]"));
		return pagetitleText.getText();
	}

	public String getReviewString() {
		waitFor(2);
		WebElement fndElement = driver.findElement(By.xpath("//tr/td[7]/a[2]"));
		return fndElement.getText();
	}

	public void verifyColHeaderText() {
		String getVal = null;
		String colHeader[] = { "#", "DATE & TIME", "TYPE", "STATUS", "# of ?s",
				"SCORE", "" };
		for (int i = 1; i < 15; i++) {
			int nubEle = driver.findElements(
					By.xpath("//table[2]/thead/tr[3]/td[" + i + "]")).size();
			waitFor(2);
			if (nubEle > 0) {
				waitFor(3);
				WebElement getlecSlidesText = driver.findElement(By
						.xpath("//table[2]/thead/tr[3]/td[" + i + "]"));
				System.out.println("Lecture Slide : "
						+ getlecSlidesText.getText());
				getVal = getlecSlidesText.getText();
				if (getVal != null) {
					Assert.assertEquals(colHeader[i - 1], getVal);
				}
			} else {
				break;
			}
		}

	}

	public void verifyReviewColHeaderText() {
		String getVal = null;
		String colHeader[] = { "Correct?", "Correct Answer", "Previous Answer",
				"Seconds Used", "Disciplines", "Organ Systems", "Q.Id", "" };
		for (int i = 5; i < 25; i++) {
			int nubEle = driver
					.findElements(
							By.xpath(".//*[contains(@id,'section')]/table/thead/tr[2]/td["
									+ i + "]")).size();
			waitFor(2);
			if (nubEle > 0) {
				waitFor(3);
				WebElement getlecSlidesText = driver
						.findElement(By
								.xpath(".//*[contains(@id,'section')]/table/thead/tr[2]/td["
										+ i + "]"));
				getVal = getlecSlidesText.getText();
				Assert.assertEquals(colHeader[i - 5], getVal);
			} else {
				break;
			}
		}
		// "M","Q#",
	}

	public String getHomePagetitle() {
		WebElement pagetitleText = driver.findElement(By
				.xpath(".//*[@id='welcome-message-container']/div/h3"));
		System.out.println("Home Page Title : " + pagetitleText.getText());
		return pagetitleText.getText();
	}
	public void waitFor(int sec){
		  try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
}
