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

public class LandingPageStepDefinition {
	//Here we are keeping only the cases which are related to LandingPage on website.
	//We haave to transfer state of driver and landingPageText to OfferPageStepDefinition,which can be done using Dependency Injection.
	
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

}


