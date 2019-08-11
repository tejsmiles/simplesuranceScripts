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
	
	@FindBy(xpath="//span[@ng-click=\"getCertificates()\"]")
	WebElement buttonSearch;
	

	@FindAll({@FindBy(xpath="//td[@at-attribute=\"certificateNumber\"]/a")})
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

	public void search() {
		this.buttonSearch.click();
	}
	
	public void seeText(String text) {
		driver.getPageSource().contains(text);
	}
	
	public CertificateDisplayPage viewFirstCertificate() {
		if(!this.certificateList.isEmpty()) {
			this.certificateList.get(0).click();
		}
		return new CertificateDisplayPage(driver, wait);
	}
	
	

}
