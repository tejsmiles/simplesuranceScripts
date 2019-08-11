package StepDefs;
import org.junit.Test;

import PageObjects.CardDetailsPage;
import PageObjects.CertificateDisplayPage;
import PageObjects.CreateCertificatePage;
import PageObjects.CreateSubagentsPage;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.SearchFunctionalityPage;
import PageObjects.Simulator3DSecure;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;



public class DashboardSteps extends FunctionalTest{

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
	@Given("User Login to Dashboard")
	public void user_Login_to_Dashboard() {
		driver.get(baseURL);
		this.loginPage = new LoginPage(driver, wait);
		this.loginPage.fillUserName("testuser0608@sisu.com");
		this.loginPage.fillPassword("1q2w3e4r");
		this.dashboardPage = this.loginPage.userLogin();
	}

	@Test
	@When("User clicks on ‘create certificate'")
	public void user_clicks_on_create_certificate() {
		this.createCertificatePage = this.dashboardPage.clickCreateCertificate();
	}

	@Test
	@When("User enters the Product and Customer information")
	public void user_enters_the_Product_and_Customer_information() {
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
		
	}

	@Test
	@When("User completes the payment")
	public void user_completes_the_payment() {
		this.createCertificatePage.selectVisaPayment();
		this.cardDetailsPage = this.createCertificatePage.clickProceedPayment();
		this.simulator3DSecure = this.cardDetailsPage.clickProceedPayment();
		this.certificateDisplayPage = this.simulator3DSecure.clickSubmit();
		
	}

	@Test
	@Then("Certificate is available for download")
	public void certificate_is_available_for_download() {
		this.certificateDisplayPage.downloadCertificate();
		
	}

	@Test
	@When("User clicks on ‘search functionality'")
	public void user_clicks_on_search_functionality() {
		this.searchFunctionalityPage = this.dashboardPage.clickSearchFunctionality();
		
	}

	@Test
	@When("User enters the Zertifikatsnummer")
	public void user_enters_the_Zertifikatsnummer() {
		this.searchFunctionalityPage.fillCertificateNumber("100000839943");
		
	}

	@Test
	@When("User clicks search")
	public void user_clicks_search() {
		this.searchFunctionalityPage.search();
		
	}

	@Test
	@Then("Certificate with Zertifikatsnummer is displayed")
	public void certificate_with_Zertifikatsnummer_is_displayed() {
		this.searchFunctionalityPage.seeText("100000839943");
		
	}

	@Test
	@When("User enters the customer email")
	public void user_enters_the_customer_email() {
		this.searchFunctionalityPage.fillCustomerEmail("test@abc.com");
		
	}

	@Test
	@When("User clicks on first certificate from the list")
	public void user_clicks_on_first_certificate_from_the_list() {
		this.certificateDisplayPage = this.searchFunctionalityPage.viewFirstCertificate();
		
	}

	@Test
	@Then("Certificate is displayed")
	public void certificate_is_displayed() {
		this.certificateDisplayPage.downloadCertificate();
		
	}

	@Test
	@When("User clicks on ‘create subagents'")
	public void user_clicks_on_create_subagents() {
		this.createSubagentsPage = this.dashboardPage.clickCreateSubagents();
		
	}

	@Test
	@When("User enters subagent details")
	public void user_enters_subagent_details() {
		this.createSubagentsPage.fillFirstName("SubAgent");
		this.createSubagentsPage.fillLastName("Agent");
		this.createSubagentsPage.fillEmail("subagent@agent.com");
		this.createSubagentsPage.fillPassword("12345678");
		this.createSubagentsPage.fillPasswordConfirm("12345678");
		this.createSubagentsPage.createSubagent();
		
	}

	@Test
	@Then("Subagent is created and displayed")
	public void subagent_is_created_and_displayed() {
		this.createSubagentsPage.viewSubagent("subagent@agent.com");
		
	}

	@Test
	@Then("Subagent list is displayed")
	public void subagent_list_is_displayed() {
		this.createSubagentsPage.viewSubagent("Ihre bereits angelegten Nutzer");
		
	}

}

