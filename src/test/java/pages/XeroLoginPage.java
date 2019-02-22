package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XeroLoginPage {

	private WebDriver driver;
	private By usernameField = By.name("userName");
	private By passwordField = By.name("password");
	private By loginButton = By.id("submitButton");

	// Page constructor:
	public XeroLoginPage(WebDriver driver){
		this.driver = driver;
	}

	// Page Methods:
	public void enterUsername(String userName){
		driver.findElement(usernameField).sendKeys(userName);
	}

	public void enterPassword(String password){
		driver.findElement(passwordField).sendKeys(password);
	}

	public void login(){
		driver.findElement(loginButton).click();
	}

}