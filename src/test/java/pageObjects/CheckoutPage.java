package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;
	
	By cart = By.cssSelector("img[alt='Cart']");
	By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoApplyButton = By.cssSelector(".promoBtn");
	By placeOrderButton=By.xpath("//button[contains(text(),'Place Order')]");
	By veggieNameColumnName=By.xpath("//tbody//tr//td[2]//p");
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void proceedToCheckout() {
		driver.findElement(cart).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean verifyPromoButton() {
		return driver.findElement(promoApplyButton).isDisplayed();
	}
	
	public boolean verifyPlaceOrderButton() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
	public void clickPlaceOrderButton() {
		driver.findElement(placeOrderButton).click();
	}
	
	public String getVeggieName() {
		return driver.findElement(veggieNameColumnName).getText().split("-")[0].trim();
	}
}
