package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import allSharedFilesStoredHere.SharedFilesAcrossProject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPageObjects;
import pageObjects.pageObjectsManager;

public class LandingPageStepDefinition {

	
	public WebDriver driver;
	public String offerPageText;
	public String landingPageText;
	public SharedFilesAcrossProject sharedFiles;
	
	public LandingPageStepDefinition(SharedFilesAcrossProject sharedFiles)
	{
		this.sharedFiles = sharedFiles;
	}
	
	@Given("user is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
	   
	}
	@When("user searched with shortName {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
    	LandingPageObjects landingPage = sharedFiles.pageObject.getLandingPage();
    	landingPage.searchName(shortName);
    	Thread.sleep(3000);
    	sharedFiles.landingPageText = landingPage.getProductName().split("-")[0].trim();
    	System.out.println("The name derived is "+sharedFiles.landingPageText);	
				
//    	pageObjectsManager pageObjectManager = new pageObjectsManager(sharedFiles.driver);
//    	LandingPageObjects landingPage = pageObjectManager.getLandingPage();
//    	landingPage.searchName(shortName);
//    	Thread.sleep(3000);
//    	sharedFiles.landingPageText = landingPage.getProductName().split("-")[0].trim();
//    	System.out.println("The name derived is "+sharedFiles.landingPageText);	
    	
    	
//    	pageObjectsManager pageObjectManager = new pageObjectsManager(sharedFiles.driver);
//		pageObjectManager.getLandingPage().searchName(shortName);
//		Thread.sleep(3000);
//		sharedFiles.landingPageText = pageObjectManager.getLandingPage().getProductName().split("-")[0].trim();
//		System.out.println("The name derived is "+sharedFiles.landingPageText);	 
//		
//		
//		LandingPageObjects landingPage = new LandingPageObjects(sharedFiles.driver);
//		landingPage.searchName(shortName);
//		Thread.sleep(3000);
//		sharedFiles.landingPageText = landingPage.getProductName().split("-")[0].trim();
//		System.out.println("The name derived is "+sharedFiles.landingPageText);	    
	}
	
}


