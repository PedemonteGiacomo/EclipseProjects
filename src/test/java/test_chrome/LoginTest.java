package test_chrome;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import POs.LoginFormPO;
import POs.LoginSuccesPO;

public class LoginTest extends DriverLifeCycleSetting{
	
	private LoginFormPO login;
	private	LoginSuccesPO loginSuccess;

	@Test
	public void testLoginOK() throws InterruptedException {
		login = new LoginFormPO(driver);
		//
		// goto login-success page
		loginSuccess = (LoginSuccesPO) login.with("user","user");
		assertTrue(loginSuccess.successBoxIsPresent());
		Thread.sleep(1500);
	}
	
	
	@Test
	public void testLoginNO_OK() throws InterruptedException {
		login = new LoginFormPO(driver);
		login.with("user","error");
		// remain in the login-success page
		assertTrue(login.invalidBoxIsPresent());
		Thread.sleep(1500);
	}
}
