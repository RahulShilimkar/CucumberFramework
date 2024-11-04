package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPageObjects {
	
	public WebDriver driver;
	
	public OffersPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By searchItems = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr > td:nth-child(1)");
	
	public void searchItems(String name)
	{
		driver.findElement(searchItems).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}
