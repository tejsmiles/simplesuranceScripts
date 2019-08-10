package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CertificateDisplayPage extends PageObjectCommons {

	@FindBy(linkText="Zertifikat herunterladen")
	WebElement linkToDownloadCertificate;
	
	public CertificateDisplayPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
	
	public void downloadCertificate() {
		this.linkToDownloadCertificate.click();
	}

}
