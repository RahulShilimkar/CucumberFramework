package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;  //Global driver object
	public LandingPage(WebDriver driver)  //this driver is from LandingPageOffer testContextSetup.driver.
	{
		this.driver = driver;
	}
	
	//Above driver is now having life in this file as well and is derived from main landingPage class file.
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDealsPage = By.linkText("Top Deals");
	
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void topDealsLandingPage()
	{
		driver.findElement(topDealsPage).click();
	}

}
