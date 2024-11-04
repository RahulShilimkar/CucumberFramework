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
import pageObjects.OffersPageObjects;
import pageObjects.pageObjectsManager;

public class OffersPageStepDefinitions {
	public WebDriver driver;
	public String offerPageText;
	public String landingPageText;
	public SharedFilesAcrossProject sharedFiles;
	
	public OffersPageStepDefinitions(SharedFilesAcrossProject sharedFiles)
	{
		this.sharedFiles = sharedFiles;
	}
	
	
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
	   clickOnTopDeals();
	   sharedFiles.commoncode.switchToOfferPage();

	   OffersPageObjects offersPage = sharedFiles.pageObject.getOffersPage();
	   offersPage.searchItems(shortName);
	   Thread.sleep(2000);
	   offerPageText = offersPage.getProductName();
	   
	   
//	   pageObjectsManager pageObjectManager = new pageObjectsManager(sharedFiles.driver);
//	   OffersPageObjects offersPage = pageObjectManager.getOffersPage();
//	   offersPage.searchItems(shortName);
//	   Thread.sleep(2000);
//	   offerPageText = offersPage.getProductName();
	}
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerPageText, sharedFiles.landingPageText);
	}
	
	public void clickOnTopDeals()
	{
		
		LandingPageObjects landingPage = sharedFiles.pageObject.getLandingPage();
		landingPage.clickOnTopDeals();
		
		
//		pageObjectsManager pageObjectManager = new pageObjectsManager(sharedFiles.driver);
//		LandingPageObjects landingPage = pageObjectManager.getLandingPage();
//		landingPage.clickOnTopDeals();
		
		
//		pageObjectsManager pageObjectManager = new pageObjectsManager(sharedFiles.driver);
//		pageObjectManager.getLandingPage().clickOnTopDeals();
//		LandingPageObjects landingPage = new LandingPageObjects(sharedFiles.driver);
//		landingPage.clickOnTopDeals();
	}
	
}
