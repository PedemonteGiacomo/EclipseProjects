package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO extends BasePagePO{

	//locator as fields
	private By usernameInput = By.xpath("//input[@id='username']");
	private By pswInput = By.xpath("//input[@id='password']");
	private By submitButton = By.xpath("//button[@type='submit']");
	private By invalidBox = By.id("invalid");
	
	public LoginFormPO(WebDriver driver) {
		super(driver);
		visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
	}
	
	public BasePagePO with(String username, String pwd) {
		type(usernameInput, username);
		type(pswInput, pwd);
		click(submitButton);
		if(getUrl().equals("https://bonigarcia.dev/selenium-webdriver-java/login-form.html"))
			return this;
		else return new LoginSuccesPO(driver);
	}

	public boolean invalidBoxIsPresent() {
		return isIn(invalidBox);
	}

}
