package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;


public class XeroSteps {

    private WebDriver driver;
    private String baseURL = "http://www.xero.com/";

    // Randomised bank account number for testing purposes. This ensures the test can be run multiple times without running into issues.
    //private String r = "" + ((int)(Math.random()*1000001));
    private String ban = "01000100000" + ((int)(Math.random()*101)+1000);
    private String accountName = "Test Account " + (int)(Math.random()*1001);


    @Given("^I am on the Xero login page$")
    public void i_am_on_the_Xero_login_page(){
        if (driver == null) {
            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
        }
        driver.get("https://login.xero.com");
    }

    @Given("^I log in to my account$")
    public void i_log_in_to_my_account(){
        XeroLoginPage xeroLoginPage = new XeroLoginPage(driver);
        xeroLoginPage.enterUsername("bjokwfgd@grr.la");
        xeroLoginPage.enterPassword("password1");
        xeroLoginPage.login();
    }

    @When("^I select to add a bank account to my organisation$")
    public void i_select_to_add_a_bank_account_to_my_organisation(){
        XeroDashboardPage xeroDashboardPage = new XeroDashboardPage(driver);
        xeroDashboardPage.clickConnectBankAccount();
    }

    @When("^I choose an \"([^\"]*)\" bank account$")
    public void i_choose_an_bank_account(String bank){
        XeroAddBankAccountPage xeroAddBankAccountPage = new XeroAddBankAccountPage(driver);
        xeroAddBankAccountPage.chooseBank(bank);
        xeroAddBankAccountPage.enterAccountName(accountName);
        xeroAddBankAccountPage.chooseAccountType();
        xeroAddBankAccountPage.enterAccountNumber(ban);
        xeroAddBankAccountPage.submitBankAccount();
        xeroAddBankAccountPage.skipToDashboard();
    }

    @Then("^the bank account should be added$")
    public void the_bank_account_should_be_added(){
        XeroDashboardPage xeroDashboardPage = new XeroDashboardPage(driver);
        xeroDashboardPage.verifyConnectedBankAccount(ban);
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }


}
