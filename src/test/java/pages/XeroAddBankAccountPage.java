package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.XeroUtils;

public class XeroAddBankAccountPage {

	private WebDriver driver;
	private String pageReadyclass = "//div[@class='route route-entered']";

	private By popularBanksList = By.xpath("//div[@data-automationid='popularBanksList']/ul");
	private By bankSearchBox = By.name("xui-searchfield-1018-inputEl");
	private By searchBanksList = By.xpath("//div[@data-automationid='searchBanksList']/ul");

	private By accountNameField = By.id("accountname-1037-inputEl");
	private By accountTypeBox = By.id("accounttype-1039-inputEl");
	private By accountNumberField = By.id("accountnumber-1068-inputEl");

	private By continueButton = By.id("common-button-submit-1015");

	public XeroAddBankAccountPage(WebDriver driver){
		this.driver = driver;
	}

	public void chooseBank(String bank){
		XeroUtils.waitFor(driver, popularBanksList);
		if (lookForBankInPopularList(bank) != null){
			lookForBankInPopularList(bank).click();
		} else {
			searchForBank(bank).click();
		}
	}

	// Check to see if the bank name is already available in the list of popular banks.
	private WebElement lookForBankInPopularList(String bankName){
		try {
			return driver.findElement(popularBanksList).findElement(By.xpath("./li[text()='" + bankName + "']"));
		} catch (NoSuchElementException e){
			return null;
		}
	}

	// Search for and select the bank manually using the search bar.
	private WebElement searchForBank(String bankName){
		driver.findElement(bankSearchBox).sendKeys(bankName);
		return XeroUtils.waitFor(driver, searchBanksList).findElement(By.xpath("./li[text()='" + bankName + "']"));
	}

	// Enter an account name.
	public void enterAccountName(String accountName){
		XeroUtils.waitFor(driver, accountNameField).sendKeys(accountName);
	}

	// Enter an account type.
	public void chooseAccountType(){
		driver.findElement(accountTypeBox).click();
		XeroUtils.waitFor(driver, By.xpath("//ul[@id='boundlist-1076-listEl']/li[1]")).click();
	}

	// Enter an account number.
	public void enterAccountNumber(String ban){
		System.out.println("Entering BAN:     " + ban);
		driver.findElement(accountNumberField).sendKeys(ban);
	}

	// Submit entered bank account details.
	public void submitBankAccount(){
		driver.findElement(continueButton).click();
	}

	// Skip Authority to Disclose form download.
	public void skipFormDownload(){
		XeroUtils.waitFor(driver, By.xpath("//a[@data-automationid='connectbank-buttonIHaveAForm']")).click();
	}

	// Skip Authority to Disclose form upload.
	public void skipFormUpload(){
		XeroUtils.waitFor(driver, By.xpath(pageReadyclass + "//a[@data-automationid='uploadForm-uploadLaterButton']")).click();
		XeroUtils.waitFor(driver, By.xpath(pageReadyclass + "//a[@data-automationid='uploadFormLater-goToDashboardButton']")).click();
	}

	// Shortcut method to skip through all Authority to Disclose form pages and go to dashboard after entering a new bank account.
	public void skipToDashboard(){
		skipFormDownload();
		skipFormUpload();
	}

}