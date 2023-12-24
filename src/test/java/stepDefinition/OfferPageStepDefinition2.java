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
		this.offerPage=textContextSetup.pageObjectManager.getOfferPageObject();
	}
	
	@Then("^user searched for (.+) same shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		
		switchToChildWindow();
		offerPage=textContextSetup.pageObjectManager.getOfferPageObject();
		offerPage.searchInSearchField(shortName);
	    Thread.sleep(2000);
	    offerPageProductName= offerPage.getOfferPageProductName();
	}
	public void switchToChildWindow() {
	
		landingPage=textContextSetup.pageObjectManager.getLandingPageObject();
		landingPage.selectTopDealsPage();
	    textContextSetup.genericUtils.switchToChildWindow();
		
	}
	
	@Then("validate product name in offer page matched with landing page")
	public void compare_name_on_offerPage_LandingPage() {
		Assert.assertEquals(textContextSetup.productPageProductName, offerPageProductName);
	}
	
	@Then("user should able to see 5,10,20 options in page size dropdown")
	public void verify_options_page_size_dropdown() {
		offerPage.verifyPageSizeOptions();
	}
	
	@Then("^user click on (.+) in dropdown and able to see options in result$")
	public void click_dropdown_and_see_results(String pageSizeCount) throws InterruptedException {
		offerPage.clickPageSizeOptionsValidateRowsCounts(pageSizeCount);
	}
} 
