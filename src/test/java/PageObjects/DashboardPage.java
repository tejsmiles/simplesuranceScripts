package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends PageObjectCommons{


	@FindBy(partialLinkText="Schutzbrief abschließen")
	WebElement createCertificate;
	
	@FindBy(partialLinkText="Verkaufsübersicht")
	WebElement searchFunctionality;
	
	@FindBy(partialLinkText="Nutzerverwaltung")
	WebElement  creationOfSubagents;
	
	public DashboardPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public CreateCertificatePage clickCreateCertificate() {
		this.createCertificate.click();
		return new CreateCertificatePage(driver, wait);
	}
	
	public SearchFunctionalityPage clickSearchFunctionality() {
		this.searchFunctionality.click();
		return new SearchFunctionalityPage(driver, wait);
	}
	
	public CreateSubagentsPage clickCreateSubagents() {
		this.creationOfSubagents.click();
		return new CreateSubagentsPage(driver, wait);
	}
	
}
