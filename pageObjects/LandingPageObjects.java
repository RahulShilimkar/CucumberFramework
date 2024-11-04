package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {
	
	public WebDriver driver;
	
	public LandingPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By searchItems = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	
	public void searchName(String name)
	{
		driver.findElement(searchItems).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void clickOnTopDeals()
	{
		driver.findElement(topDeals).click();
	}
	

}
