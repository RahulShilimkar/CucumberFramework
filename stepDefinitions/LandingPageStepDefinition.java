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

public class LandingPageStepDefinition {
	//Here we are keeping only the cases which are related to LandingPage on website.
	//We haave to transfer state of driver and landingPageText to OfferPageStepDefinition,which can be done using Dependency Injection.
	//Dependency Injection being used is Pico container, take it from maveb repo and paste in pom.xml
		public WebDriver driver;
		public String offerPageText;
		public String landingPageText;
		TestContextSetup testContextSetup;  //Creating a global variable.
		
		//Creating below constructor to access methods/variable in TestContextSetup class
		//Constructor is Runned automatically as soon as we run test,hence we sued it to create and access variables in utils class
		public LandingPageStepDefinition(TestContextSetup testContextSetup)
		{
			this.testContextSetup = testContextSetup;   //testContextSetup - get's a life here.
		}
	
	@Given("user is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars and Dependencies\\Browser Drivers\\chromedriver.exe");  
	   testContextSetup.driver = new ChromeDriver();
	   testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user searched with shortName {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(3000);
		//testContextSetup.landingPageText -> Changing because we need to share this as well across multiple files.
		testContextSetup.landingPageText = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println("The name derived is "+testContextSetup.landingPageText);	    
	}

}


