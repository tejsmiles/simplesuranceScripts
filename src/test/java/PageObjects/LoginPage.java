package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObjectCommons {

	@FindBy(id="input-email")
	WebElement inputUserName;
	
	@FindBy(id="input-password")
	WebElement inputPassword;
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public void fillUserName(String userName) {
		this.inputUserName.clear();
		this.inputUserName.sendKeys(userName);
	}
	
	public void fillPassword(String password) {
		this.inputPassword.clear();
		this.inputPassword.sendKeys(password);
	}
	
	public DashboardPage userLogin() {
		this.inputPassword.submit();
		return new DashboardPage(driver, wait);
	}

}
