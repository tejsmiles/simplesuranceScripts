package StepDefs;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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

		InputStream input = null;
		Properties properties = null;
		try {
			input = new FileInputStream("simplesurance.properties");
			properties = new Properties();
			properties.load(input);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.setProperty("webdriver.chrome.driver",properties.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 10);
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
