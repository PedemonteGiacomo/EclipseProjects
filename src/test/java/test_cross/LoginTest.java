package test_cross;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import POs.LoginFormPO;
import POs.LoginSuccesPO;
import cross_browser.Browser;
import cross_browser.DriverFactory;

public class LoginTest extends DriverLifeCycleSetting{
	
	private LoginFormPO login;
	private	LoginSuccesPO loginSuccess;

	@ParameterizedTest
	@EnumSource(Browser.class)
	public void testLoginOK(Browser browser) throws InterruptedException {
		driver = DriverFactory.getNewDriverInstance(browser);
		login = new LoginFormPO(driver);
		// goto login-success page
		loginSuccess = (LoginSuccesPO) login.with("user","user");
		assertTrue(loginSuccess.successBoxIsPresent());
		Thread.sleep(1500);
	}
	
	@ParameterizedTest
	@EnumSource(Browser.class)
	public void testLoginNO_OK(Browser browser) throws InterruptedException {
		driver = DriverFactory.getNewDriverInstance(browser);
		login = new LoginFormPO(driver);
		login.with("user","error");
		// remain in the login-success page
		assertTrue(login.invalidBoxIsPresent());
		Thread.sleep(1500);
	}
}
