package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchFunctionalityPage extends PageObjectCommons {


	@FindBy(id="filterByCertNo")
	WebElement inputCertificateNumber;

	@FindBy(id="filterByEmail")
	WebElement inputCustomerEmail;

	@FindAll({@FindBy(xpath="//td[@at-attribute=\"certificateNumber\"]/a]")})
	List<WebElement> certificateList;


	public SearchFunctionalityPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void fillCertificateNumber(String certificateNumber) {
		this.inputCertificateNumber.clear();
		this.inputCertificateNumber.sendKeys(certificateNumber);
	}

	public void fillCustomerEmail(String email) {
		this.inputCustomerEmail.clear();
		this.inputCustomerEmail.sendKeys(email);
	}

	public void searchWithCertificateNumber() {
		this.inputCertificateNumber.submit();
	}

	public void searchWithCustomerEmail() {
		this.inputCustomerEmail.submit();
	}
	
	public CertificateDisplayPage viewFirstCertificate() {
		if(this.certificateList.size()>0) {
			this.certificateList.get(0).click();
		}
		return new CertificateDisplayPage(driver, wait);
	}

}
