package test_chrome;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

class DriverLifeCycleSetting {
	
	protected WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver(); see the pages
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterEach
	void tearDown() throws Exception {
		if(driver != null) {
			driver.quit();
		}
	}
}

