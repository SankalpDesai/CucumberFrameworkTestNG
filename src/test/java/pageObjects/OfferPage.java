package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {

	public WebDriver driver;
	
	private By searchField= By.id("search-field");
	private By offerPageProductNameColumn=By.cssSelector("tr td:nth-child(1)");
	public String offerPageURL= "https://rahulshettyacademy.com/seleniumPractise/#/";
	
	public OfferPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void searchInSearchField(String shortName) {
		driver.findElement(searchField).sendKeys(shortName);
	}
	
	public String getOfferPageProductName() {
		return driver.findElement(offerPageProductNameColumn).getText();
	}
	
	public String getOfferPageURL() {
		return driver.getCurrentUrl().toString();
	}
}
