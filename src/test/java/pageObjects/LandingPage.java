package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingPage {

	public WebDriver driver;
	
	By search= By.className("search-keyword");
	By productName=By.cssSelector("h4.product-name");
	By topDeals=By.linkText("Top Deals");
	By incrementButton=By.cssSelector("a.increment");
	By quantityBox=By.cssSelector("input.quantity");
	By addToCartButton=By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SearchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(By.linkText("Top Deals")).click();
	}
	
	public String getTitleLandingPage() {
		return driver.getTitle();
	}
	
	/*public void addProductToCart(int productQuantity) throws InterruptedException {
		
		for(int i=1;i<productQuantity;i++) {
			driver.findElement(incrementButton).click();
		}
		Thread.sleep(2000);
		Assert.assertEquals(Integer.parseInt(driver.findElement(quantityBox).getText()), productQuantity);
		driver.findElement(addToCartButton).click();
	}*/
	
	public void incrementQuantity(int quantity) {
		int i = quantity-1;
		while(i>0) {
			driver.findElement(incrementButton).click();
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
}
