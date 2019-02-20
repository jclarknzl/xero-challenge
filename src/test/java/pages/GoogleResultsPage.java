package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class GoogleResultsPage {

	WebDriver driver;

	By resultsLoaded = By.id("resultStats");
	By firstSearchResult = By.xpath("//a/h3[1]");

	public GoogleResultsPage(WebDriver driver){
		this.driver = driver;
	} 

	public void pageLoaded(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(resultsLoaded));
	}

	public void resultsPresent(){
		String result = driver.findElement(firstSearchResult).getText();
		//System.out.println("//a/h3[1] = " + result);
	}
}