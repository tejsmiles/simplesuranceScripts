package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSubagentsPage extends PageObjectCommons {

	@FindBy(id="subagent-create-firstname")
	WebElement inputFirstname;
	
	@FindBy(id="subagent-create-lastname")
	WebElement inputLastname;
	
	@FindBy(id="subagent-create-email")
	WebElement inputEmail;
	
	@FindBy(id="subagent-create-password")
	WebElement inputPassword;
	
	@FindBy(id="subagent-create-password-confirm")
	WebElement inputPasswordConfirm;
	
	
	public CreateSubagentsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public void fillFirstName(String firstName) {
		this.inputFirstname.clear();
		this.inputFirstname.sendKeys(firstName);
	}
	
	public void fillLastName(String lastName) {
		this.inputLastname.clear();
		this.inputLastname.sendKeys(lastName);
	}
	

	public void fillEmail(String email) {
		this.inputEmail.clear();
		this.inputEmail.sendKeys(email);
	}
	
	public void fillPassword(String password) {
		this.inputPassword.clear();
		this.inputPassword.sendKeys(password);
	}
	
	public void fillPasswordConfirm(String password) {
		this.inputPasswordConfirm.clear();
		this.inputPasswordConfirm.sendKeys(password);
	}
	
	public void createSubagent() {
		this.inputPassword.submit();
	}
	
	public void viewSubagent(String text) {
		driver.getPageSource().contains(text);
	}
	
}
