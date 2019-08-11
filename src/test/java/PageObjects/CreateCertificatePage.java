package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateCertificatePage extends PageObjectCommons{

	@FindBy(xpath="//div[@id=\"s2id_certificate-categories\"]/a")
	WebElement selectProductCategory;

	@FindBy(xpath="//option[contains(text(),'Smartphone')]")
	WebElement selectProduct;

	@FindBy(xpath="//div[@id=\"s2id_certificate-original-price\"]/a")
	WebElement selectProductPriceList;

	@FindBy(xpath="//option[contains(text(),'250-500€')]")
	WebElement selectProductPrice;

	@FindAll({@FindBy(name="insurancePeriod")})
	List<WebElement> radioInsurancePeriod;

	@FindBy(id="optionalTheft")
	WebElement checkboxTheftProtection;

	@FindBy(id="certificate-product-serial")
	WebElement inputSerialNumber;

	@FindBy(id="certificate-customer-email")
	WebElement inputCustomerEmail;

	@FindBy(id="certificate-customer-firstname")
	WebElement inputCustomerFirstName;

	@FindBy(id="certificate-customer-lastname")
	WebElement inputCustomerLastName;

	@FindBy(id="certificate-customer-streetname")
	WebElement inputCustomerStreetName;

	@FindBy(id="certificate-customer-streetnumber")
	WebElement inputCustomerStreetNumber;

	@FindBy(id="certificate-customer-zip")
	WebElement inputCustomerZip;

	@FindBy(id="certificate-customer-city")
	WebElement inputCustomerCity;

	@FindAll({@FindBy(xpath="//div[@class=\"checkbox\"]/label/input")})
	List<WebElement> confirmationCheckboxes;
	////div[@class="checkbox"]/label/input[@class="ng-valid-parse"]

	//@FindBy(xpath="//button/span[text()=\"Schutzbrief abschließen\"]")
	@FindBy(xpath="//button[@class=\"certificate-submit-button\"]")
	WebElement buttonCreateCertificate;

	@FindBy(id="payment-visa")
	WebElement radioPaymentVisa;

	@FindBy(xpath="//button[text()=\"Kauf abschließen\"]")
	WebElement buttonProceedPayment;

	public CreateCertificatePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void fillProductCategory() {
		this.selectProductCategory.click();
		this.selectProduct.click();
	}

	public void fillProductPrice() {
		this.selectProductPriceList.click();
		this.selectProductPrice.click();
	}

	public void selectInsurancePeriod(int option) {
		this.radioInsurancePeriod.get(option-1).click();
	}

	public void checkTheftProtection() {
		this.checkboxTheftProtection.click();
	}

	public void fillSerialNumber(String number) {
		this.inputSerialNumber.clear();
		this.inputSerialNumber.sendKeys(number);
	}

	public void fillEmail(String email) {
		this.inputCustomerEmail.clear();
		this.inputCustomerEmail.sendKeys(email);
	}

	public void fillFirstName(String firstName) {
		this.inputCustomerFirstName.clear();
		this.inputCustomerFirstName.sendKeys(firstName);
	}

	public void fillLastName(String lastName) {
		this.inputCustomerLastName.clear();
		this.inputCustomerLastName.sendKeys(lastName);
	}

	public void fillStreetName(String streetName) {
		this.inputCustomerStreetName.clear();
		this.inputCustomerStreetName.sendKeys(streetName);
	}

	public void fillStreetNumber(String streetNumber) {
		this.inputCustomerStreetNumber.clear();
		this.inputCustomerStreetNumber.sendKeys(streetNumber);
	}

	public void fillZip(String zipCode) {
		this.inputCustomerZip.clear();
		this.inputCustomerZip.sendKeys(zipCode);
	}

	public void fillCity(String city) {
		this.inputCustomerCity.clear();
		this.inputCustomerCity.sendKeys(city);
	}

	//Can separate all the checkboxes for more combinations of test cases
	public void checkConfirmationBoxes() {
		if(!this.confirmationCheckboxes.isEmpty())
			for(int i=0; i<this.confirmationCheckboxes.size(); i++) {
				this.confirmationCheckboxes.get(i).click();
			}
	}

	public void clickCreateCertificate() {
		this.buttonCreateCertificate.click();
	}

	public void selectVisaPayment() {
		this.radioPaymentVisa.click();
	}

	public CardDetailsPage clickProceedPayment() {
		this.buttonProceedPayment.click();
		return new CardDetailsPage(driver, wait);
	}
}
