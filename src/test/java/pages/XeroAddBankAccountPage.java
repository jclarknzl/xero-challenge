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
	private By bankSearchBox = By.xpath("//div[@data-automationid='bankSearch']//input");
	private By searchBanksList = By.xpath("//div[@data-automationid='searchBanksList']/ul");

	private By accountNameField = By.xpath("//div[@data-automationid='accountName']//input");
	private By accountTypeBox = By.xpath("//div[@data-automationid='accountType']//input");
	private By accountNumberField = By.xpath("//div[@data-automationid='accountNumber'and not(ancestor::div[contains(@style,'display: none')])]//input");

	private By continueButton = By.id("common-button-submit-1015");

	// Page constructor:
	public XeroAddBankAccountPage(WebDriver driver){
		this.driver = driver;
	}

	// Page methods:

	// When choosing which bank to select, first check the list of popular banks already present on the page, then if it's not present, search for it.
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

	public void enterAccountName(String accountName){
		XeroUtils.waitFor(driver, accountNameField).sendKeys(accountName);
	}

	public void chooseAccountType(){
		driver.findElement(accountTypeBox).click();
		XeroUtils.waitFor(driver, By.xpath("//ul[@id='boundlist-1076-listEl']/li[1]")).click();
	}

	public void enterAccountNumber(String ban){
		XeroUtils.waitFor(driver, accountNumberField).click();
		driver.findElement(accountNumberField).sendKeys(ban);
	}

	public void submitBankAccount(){
		driver.findElement(continueButton).isDisplayed();
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