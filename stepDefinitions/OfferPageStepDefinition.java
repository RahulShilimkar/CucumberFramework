package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
//	Here we are keeping only the cases which are related to LandingPage on WebSite.
// We get null pointer exception if we dont have WebDriver object created after breaking files into different pages.
	
	
	public String offerPageText;
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}

	
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
//		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
//		//testContextSetup.driver - this driver variable is already initialized.		
		clickToTopDeals();
		switchWindow();
	   testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	   Thread.sleep(2000);
	   offerPageText = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	   System.out.println("Text got is :- "+offerPageText);
	   System.out.println("Value of landing page is :- "+testContextSetup.landingPageText);
	}
	
	//Making classes loosely coupled and following Single responsibility principle.
	public void clickToTopDeals()
	{
		//testContextSetup.driver - this driver variable is already initialized.
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	}
	public void switchWindow()
	{
		 Set<String> window = testContextSetup.driver.getWindowHandles();
		  Iterator<String> i = window.iterator();
		  String parentWindow = i.next();
		  String childWindow = i.next();
		  testContextSetup.driver.switchTo().window(childWindow);
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerPageText, testContextSetup.landingPageText);
	    testContextSetup.driver.quit();
	}
}


