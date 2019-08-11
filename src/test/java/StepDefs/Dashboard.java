package StepDefs;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import PageObjects.CardDetailsPage;
import PageObjects.CertificateDisplayPage;
import PageObjects.CreateCertificatePage;
import PageObjects.CreateSubagentsPage;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.SearchFunctionalityPage;
import PageObjects.Simulator3DSecure;

public class Dashboard extends FunctionalTest{

	String baseURL= "https://partner-de.sb-testsb0208.sisu.sh/#!/";

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private CreateCertificatePage createCertificatePage;
	private CardDetailsPage cardDetailsPage;
	private Simulator3DSecure simulator3DSecure;
	private CertificateDisplayPage certificateDisplayPage;
	private SearchFunctionalityPage searchFunctionalityPage;
	private CreateSubagentsPage createSubagentsPage;
	
	@Test
	public void scenarioCreateAndDownloadCertificate() throws InterruptedException {
		driver.get(baseURL);
		//assertTrue((driver.getCurrentUrl()).contains(baseURL));
		assertTrue(true);
		this.loginPage = new LoginPage(driver, wait);
		assertTrue(loginPage != null);
		this.loginPage.fillUserName("testuser0608@sisu.com");
		this.loginPage.fillPassword("1q2w3e4r");
		this.dashboardPage = this.loginPage.userLogin();
		this.createCertificatePage = this.dashboardPage.clickCreateCertificate();
		this.createCertificatePage.fillProductCategory();
		this.createCertificatePage.fillProductPrice();
		this.createCertificatePage.selectInsurancePeriod(1);
		this.createCertificatePage.checkTheftProtection();
		this.createCertificatePage.fillSerialNumber("12345");
		this.createCertificatePage.fillEmail("test@xyz.com");
		this.createCertificatePage.fillFirstName("User");
		this.createCertificatePage.fillLastName("Tester");
		this.createCertificatePage.fillStreetName("Customer Street");
		this.createCertificatePage.fillStreetNumber("2");
		this.createCertificatePage.fillZip("10551");
		this.createCertificatePage.fillCity("Berlin");
		this.createCertificatePage.checkConfirmationBoxes();
		this.createCertificatePage.clickCreateCertificate();
		this.createCertificatePage.selectVisaPayment();
		this.cardDetailsPage = this.createCertificatePage.clickProceedPayment();
		this.simulator3DSecure = this.cardDetailsPage.clickProceedPayment();
		this.certificateDisplayPage = this.simulator3DSecure.clickSubmit();
		this.certificateDisplayPage.downloadCertificate();	
		this.dashboardPage.userLogout();
	}
	
	
	@Test
	public void scenarioSearchUsingZertifikatsnummer() throws InterruptedException {
		driver.get(baseURL);
		this.loginPage = new LoginPage(driver, wait);
		this.loginPage.fillUserName("testuser0608@sisu.com");
		this.loginPage.fillPassword("1q2w3e4r");
		this.dashboardPage = this.loginPage.userLogin();
		this.searchFunctionalityPage = this.dashboardPage.clickSearchFunctionality();
		this.searchFunctionalityPage.fillCertificateNumber("100000839943");
		this.searchFunctionalityPage.search();
		this.searchFunctionalityPage.seeText("100000839943");
		this.dashboardPage.userLogout();
	}
	
	@Test
	public void scenarioSearchUsingCustomerEmail() throws InterruptedException {
		driver.get(baseURL);
		this.loginPage = new LoginPage(driver, wait);
		this.loginPage.fillUserName("testuser0608@sisu.com");
		this.loginPage.fillPassword("1q2w3e4r");
		this.dashboardPage = this.loginPage.userLogin();
		this.searchFunctionalityPage = this.dashboardPage.clickSearchFunctionality();
		this.searchFunctionalityPage.fillCustomerEmail("test@abc.com");
		this.searchFunctionalityPage.search();
		this.searchFunctionalityPage.seeText("test@abc.com");
		this.dashboardPage.userLogout();
	}
	
	@Test
	public void scenarioViewCertificatesFromList() throws InterruptedException {
		driver.get(baseURL);
		this.loginPage = new LoginPage(driver, wait);
		this.loginPage.fillUserName("testuser0608@sisu.com");
		this.loginPage.fillPassword("1q2w3e4r");
		this.dashboardPage = this.loginPage.userLogin();
		this.searchFunctionalityPage = this.dashboardPage.clickSearchFunctionality();
		this.certificateDisplayPage = this.searchFunctionalityPage.viewFirstCertificate();
		this.certificateDisplayPage.downloadCertificate();
		this.dashboardPage.userLogout();
	}
	
	@Test
	public void scenarioCreateSubagents() throws InterruptedException {
		driver.get(baseURL);
		this.loginPage = new LoginPage(driver, wait);
		this.loginPage.fillUserName("testuser0608@sisu.com");
		this.loginPage.fillPassword("1q2w3e4r");
		this.dashboardPage = this.loginPage.userLogin();
		this.createSubagentsPage = this.dashboardPage.clickCreateSubagents();
		this.createSubagentsPage.fillFirstName("SubAgent");
		this.createSubagentsPage.fillLastName("Agent");
		int randomUserId = (new Random()).nextInt(9999);
		String emailAddress= "subagent" +randomUserId + "@agent.com";
		this.createSubagentsPage.fillEmail(emailAddress);
		this.createSubagentsPage.fillPassword("12345678");
		this.createSubagentsPage.fillPasswordConfirm("12345678");
		this.createSubagentsPage.createSubagent();
		this.createSubagentsPage.viewSubagent(emailAddress);
		this.dashboardPage.userLogout();
	}
	
	@Test
	public void scenarioViewSubagents() throws InterruptedException {
		driver.get(baseURL);
		this.loginPage = new LoginPage(driver, wait);
		this.loginPage.fillUserName("testuser0608@sisu.com");
		this.loginPage.fillPassword("1q2w3e4r");
		this.dashboardPage = this.loginPage.userLogin();
		this.createSubagentsPage = this.dashboardPage.clickCreateSubagents();
		this.createSubagentsPage.viewSubagent("Ihre bereits angelegten Nutzer");
		this.dashboardPage.userLogout();
	}



}

