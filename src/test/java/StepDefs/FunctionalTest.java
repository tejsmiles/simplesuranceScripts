package StepDefs;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FunctionalTest {
	static WebDriver driver;
	static WebDriverWait wait;

	@BeforeClass
	public static void setUp() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 20);
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}

	@After
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}
	
}
