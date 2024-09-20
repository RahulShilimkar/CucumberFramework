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

public class OfferPageStepDefinition {
//	Here we are keeping only the cases which are related to LandingPage on WebSite.
// We get null pointer exception if we done have WebDriver object created
	
	
	public String offerPageText;

	
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
	   driver.findElement(By.linkText("Top Deals")).click();
	   Set<String> window = driver.getWindowHandles();
	   Iterator<String> i = window.iterator();
	   String parentWindow = i.next();
	   String childWindow = i.next();
	   driver.switchTo().window(childWindow);
	   driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	   Thread.sleep(2000);
	   offerPageText = driver.findElement(By.cssSelector("tr > td:nth-child(1)")).getText();
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerPageText, landingPageText);
	}
}


