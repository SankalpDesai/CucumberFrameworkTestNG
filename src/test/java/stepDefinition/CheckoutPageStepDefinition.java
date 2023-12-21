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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String productPageProductName;
	public String offerPageProductName;
	TextContextSetup textContextSetup;
	public LandingPage landingPage;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
		this.checkoutPage=textContextSetup.pageObjectManager.getCheckoutPageObject();
	}
	
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String veggieName) throws InterruptedException {
		//checkoutPage=textContextSetup.pageObjectManager.getCheckoutPageObject();
		checkoutPage.proceedToCheckout();
		//Thread.sleep(2000);
		Assert.assertEquals(checkoutPage.getVeggieName(), veggieName);
	}
	
	@Then("Verify user has the ability to enter promo code and place the order")
	public void Verify_user_has_the_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
		checkoutPage.clickPlaceOrderButton();
	}
	
	
}
