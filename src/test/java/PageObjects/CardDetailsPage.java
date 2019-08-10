package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardDetailsPage extends PageObjectCommons {

	
	@FindBy(name="SubmitToNext")
	WebElement buttonPay;
	
	public CardDetailsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public Simulator3DSecure clickProceedPayment() {
		this.buttonPay.click();
		return new Simulator3DSecure(driver, wait);
	}

}
