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
import utils.TextContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String productPageProductName;
	public String offerPageProductName;
	TextContextSetup textContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
		this.landingPage=textContextSetup.pageObjectManager.getLandingPageObject();
	}
	
	@Given("User is on greenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		//LandingPage landingPage= new LandingPage(textContextSetup.driver);
		landingPage=textContextSetup.pageObjectManager.getLandingPageObject();
		landingPage.SearchItem(shortName);
		
		//textContextSetup.driver.findElement(By.className("search-keyword")).sendKeys(shortName);
	    Thread.sleep(2000);
	    textContextSetup.productPageProductName= landingPage.getProductName();
	    
	}
	
	/*@When("Added {string} items of the selected product to cart")
	public void added_items_selected_products_to_cart(String productQuantity) throws NumberFormatException, InterruptedException {
		landingPage.addProductToCart(Integer.parseInt(productQuantity));
	}*/
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_product(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		System.out.println("testing some stuff");
		System.out.println("testing some stuff");
		System.out.println("testing some stuff");
		System.out.println("testing some stuff");
		System.out.println("testing some stuff");
		System.out.println("testing some stuff");
	}
	
	
}
