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

public class GreenCartStepDefinition {
	
	public WebDriver driver;
	public String offerPageText;
	public String landingPageText;
	
	@Given("user is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars and Dependencies\\Browser Drivers\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user searched with shortName {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(3000);
		landingPageText = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println("The name derived is "+landingPageText);	    
	}
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


