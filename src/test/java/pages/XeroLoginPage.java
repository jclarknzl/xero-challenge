package pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XeroLoginPage {

	WebDriver driver;
	By usernameField = By.name("userName");
	By passwordField = By.name("password");
	By loginButton = By.id("submitButton");


	public XeroLoginPage(WebDriver driver){
		this.driver = driver;
	}

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