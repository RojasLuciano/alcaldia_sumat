package test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		// Create a Chrome driver. All test classes use this.
		System.setProperty("webdriver.gecko.driver", "res\\geckodriver.exe");
		driver = new EventFiringWebDriver(new FirefoxDriver(getChromeOptions()));
		
	}

	@AfterClass
	public void tearDown() {
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.quit();		
	}


	
	private FirefoxOptions getChromeOptions() {
		FirefoxOptions options = new FirefoxOptions();
		// options.addArguments("disable-infobars");
		options.setHeadless(false);
		return options;
	}

	
 
}// final
