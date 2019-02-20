package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchPage {

	WebDriver driver;
	By searchBox = By.name("q");
	By searchButton = By.name("btnK");

	public GoogleSearchPage(WebDriver driver){
		this.driver = driver;
	}

	public void search(String query){
		driver.findElement(searchBox).sendKeys(query);
		//driver.findElement(searchButton).click();
		driver.findElement(searchBox).sendKeys(Keys.RETURN);
	}

	public void clickSearch(){
		driver.findElement(searchButton).click();
	}

}