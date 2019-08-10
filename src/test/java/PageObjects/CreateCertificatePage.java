package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateCertificatePage extends PageObjectCommons{

	
	@FindBy(id="certificate-categories")
	WebElement selectProductCategory;
		
	@FindBy(id="certificate-original-price")
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

	
	public CreateCertificatePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void fillProductCategory(String productCategory) {
		this.selectProductCategory.clear();
		this.selectProductCategory.sendKeys(productCategory);
	}
	
	public void fillProductPrice(String productPrice) {
		this.selectProductPrice.clear();
		this.selectProductPrice.sendKeys(productPrice);
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
	
	//Can separate all the 4 checkboxes for more combinations of test cases
	public void checkConfirmationBoxes() {
		for(int i=0; i<this.confirmationCheckboxes.size(); i++) {
			this.confirmationCheckboxes.get(i).click();
		}
	}
	
}
