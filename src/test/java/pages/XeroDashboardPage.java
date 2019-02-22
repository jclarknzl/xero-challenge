package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.XeroUtils;

public class XeroDashboardPage {

	private WebDriver driver;
	private By connectBankAccount = By.xpath("//dt[@data-automationid='welcome-ListItem-BANK']/a");
	private By connectedBankAccounts = By.xpath("//div[@data-automationid='bankWidget']");

	// Page constructor:
	public XeroDashboardPage(WebDriver driver){
		this.driver = driver;
	}

	// Page methods:
	public void clickConnectBankAccount(){
		XeroUtils.waitFor(driver, connectBankAccount).click();
	}

	public void verifyConnectedBankAccount(String ban){
		XeroUtils.scrollTo(driver, driver.findElement(connectedBankAccounts).findElement(By.xpath("//div[text()='" + ban + "']")));

	}

}