package stepDefinition;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TextContextSetup;

public class OfferPageStepDefinition2 {
	public WebDriver driver;
	public String productPageProductName;
	public String offerPageProductName;
	TextContextSetup textContextSetup;
	LandingPage landingPage;
	OfferPage offerPage;
	
	public OfferPageStepDefinition2(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}
	
	@Then("^user searched for (.+) same shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		
		switchToChildWindow();
		//OfferPage offerPage=new OfferPage(textContextSetup.driver);
		offerPage=textContextSetup.pageObjectManager.getOfferPageObject();
		offerPage.searchInSearchField(shortName);
	    //textContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
	    Thread.sleep(2000);
	    offerPageProductName= offerPage.getOfferPageProductName();
	}
	public void switchToChildWindow() {
		//if(offerPage.getOfferPageURL().equalsIgnoreCase(offerPage.offerPageURL)) {
		//textContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		landingPage=textContextSetup.pageObjectManager.getLandingPageObject();
		landingPage.selectTopDealsPage();
	    textContextSetup.genericUtils.switchToChildWindow();
		
	}
	
	@Then("validate product name in offer page matched with landing page")
	public void compare_name_on_offerPage_LandingPage() {
		Assert.assertEquals(textContextSetup.productPageProductName, offerPageProductName);
	}
}
