package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSuccesPO extends BasePagePO {
	
	//locator as fields
	private By successBox = By.id("success");
	
	public LoginSuccesPO(WebDriver driver) {
		super(driver);
	}

	public boolean successBoxIsPresent() {
		return isIn(successBox);	
	}
}