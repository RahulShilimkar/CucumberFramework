package allSharedFilesStoredHere;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CommonCode {
	
	public WebDriver driver;
	//note:- who ever use's this class,can just create an object of this call and send driver argument.
	
	public CommonCode(WebDriver driver)
	{
		this.driver = driver;
	}

	public void switchToOfferPage()
	{
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> i = window.iterator();
		   String parentWindow = i.next();
		   String childWindow = i.next();
		   driver.switchTo().window(childWindow);
	}

}
