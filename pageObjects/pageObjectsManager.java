package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageObjectsManager {
	
	public WebDriver driver;
	public LandingPageObjects landingPage;
	public OffersPageObjects offersPage;
	
	public pageObjectsManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPageObjects getLandingPage()
	{
		landingPage = new LandingPageObjects(driver);
		return landingPage;
	}
	
	public OffersPageObjects getOffersPage()
	{
		offersPage = new OffersPageObjects(driver);
		return offersPage;
	}

}
