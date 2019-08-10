package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Simulator3DSecure extends PageObjectCommons{

	
	@FindBy(name="submitButton")
	WebElement buttonSubmit;
	
	public Simulator3DSecure(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public CertificateDisplayPage clickSubmit() {
		this.buttonSubmit.click();
		return new CertificateDisplayPage(driver, wait);
	}

}
