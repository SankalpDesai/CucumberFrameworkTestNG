package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OfferPage {

	public WebDriver driver;
	
	private By searchField= By.id("search-field");
	private By offerPageProductNameColumn=By.cssSelector("tr td:nth-child(1)");
	public String offerPageURL= "https://rahulshettyacademy.com/seleniumPractise/#/";
	private By pageSizeOptionsCount= By.xpath("//*[@id='page-menu']//option");
	private By pageSizeDropdownButton= By.xpath("//select[@id='page-menu']");
	private By pageSizeRowCount= By.xpath("//tr//td[1]");
	
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
	
	public void verifyPageSizeOptions() {
		driver.findElement(pageSizeDropdownButton).click();
 
	      String[] exp = {"5","10","20"};
	      WebElement dropdown = driver.findElement(pageSizeDropdownButton);  
	      Select select = new Select(dropdown);  

	      List<WebElement> options = select.getOptions();  
	      for(WebElement we:options)  
	      {  
	       boolean match = false;
	       for (int i=0; i<exp.length; i++){
	           if (we.getText().equals(exp[i])){
	             match = true;
	           }
	         }
	       Assert.assertTrue(match);

	      }
	}
	
	public void clickPageSizeOptionsValidateRowsCounts(String pageSizeCount) throws InterruptedException {
		
		WebElement dropdown = driver.findElement(pageSizeDropdownButton);  
	      Select select = new Select(dropdown);  

	      List<WebElement> options = select.getOptions();
	      
	      for(WebElement we:options)  
	      {  
	    	  int actualRowCount;
	    	  if(we.getText().equals(pageSizeCount)) {
		    	  we.click();
		    	  actualRowCount=driver.findElements(pageSizeRowCount).size();
		    	  Assert.assertEquals(actualRowCount, Integer.parseInt(pageSizeCount));
		    	  Thread.sleep(5000);
	    	  }
	}
	}}
