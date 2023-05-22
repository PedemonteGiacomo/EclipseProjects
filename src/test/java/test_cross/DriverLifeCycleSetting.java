package test_cross;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

class DriverLifeCycleSetting {
	
	protected WebDriver driver;
	
	/*

	Removed this following because the parameterized and the DriverFactory make the setup
	of each driver every time we perform different tests on different browser.
	
	@BeforeEach
	@ParameterizedTest
	@EnumSource(Browser.class)
	protected void setUpBeforeClass(Browser browser) throws Exception {
		//WebDriverManager.chromedriver().setup(); only for test_cross driver
		driver = cross_browser.DriverFactory.getNewDriverInstance(browser);
	}
	/*
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	*/

	@AfterEach
	void tearDown() throws Exception {
		if(driver != null) {
			driver.quit();
		}
	}
}

