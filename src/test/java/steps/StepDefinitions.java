package autotest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;

public class StepDefinitions{

	private int piecesOfToast;
	private WebDriver driver;

	@Given("^I have (\\d+) pieces of toast$")
	public void i_have_pieces_of_toast(int arg1) throws Throwable {
	    piecesOfToast = arg1;
	}

	@When("I eat (\\d+) pieces of toast$")
	public void i_eat(int arg1) throws Throwable {
	    piecesOfToast -= arg1;
	}

	@Then("^I should have (\\d+) pieces of toast$")
	public void i_should_have_pieces_of_toast(int arg1) throws Throwable {
	    if(piecesOfToast == arg1);
	}

	@Given("^I open a browser$")
	public void i_open_a_browser() throws Throwable {
		driver = new FirefoxDriver();
	}

	@When("^I navigate to (\\w+)$")
	public void i_navigate_to(String site) throws Throwable {
		if (driver == null){
			driver = new FirefoxDriver();
		}
		switch(site.trim()){
			case "stuff":
				driver.get("http://www.stuff.co.nz");
				break;
			case "google":
				driver.get("http://www.google.co.nz");
				break;
			case "Vodafone":
				driver.get("http://www.vodafone.co.nz");
				break;
		}

	    
	}

	@Then("^I should see the news$")
	public void i_should_see_the_news() throws Throwable {
		driver.findElement(By.xpath("//div[contains(@class,'main-article')]"));
	}

	@Then("^The browser should close$")
	public void the_browser_should_close() throws Throwable {
		driver.quit();
	}

	@When("^I search for (.*)$")
	public void i_search_for(String query) throws Throwable {
		GoogleSearchPage gPage = new GoogleSearchPage(driver);
		gPage.search(query);
	}

	@Then("^I should see search results$")
	public void i_should_see_search_results() {
		GoogleResultsPage gPage = new GoogleResultsPage(driver);
		gPage.pageLoaded();
		gPage.resultsPresent();
	}

	@After
	public void tearDown(){
		if (driver != null){
			driver.quit();
		}
	}

	@Given("^I log in to My Vodafone$")
	public void i_log_in_to_My_Vodafone() throws Throwable {
	    VodafoneHomePage vPage = new VodafoneHomePage(driver);
	    vPage.clickLoginMan();
	    vPage.enterUsername("colinspocket@gmail.com");
	    vPage.enterPassword("password1");
	    vPage.signIn();
	}

	@Then("^I should be on the Account Summary page$")
	public void i_should_be_on_the_Account_Summary_page() throws Throwable {
	    AccountSummaryPage sPage = new AccountSummaryPage(driver);
	    String expectedTitle = "Account summary";
	    sPage.getPageTitle().equals(expectedTitle);
	}

}