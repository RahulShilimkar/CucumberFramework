package allSharedFilesStoredHere;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.pageObjectsManager;

public class SharedFilesAcrossProject {
	
	public WebDriver driver;
	public String landingPageText;
	public pageObjectsManager pageObject;
	public TestBase testBase;
	public CommonCode commoncode;
	
	public SharedFilesAcrossProject() throws IOException
	{
		testBase = new TestBase();
		pageObject = new pageObjectsManager(testBase.WebDriverManager()); //this will pass driver to POM inturn will send to all PO files
		commoncode = new CommonCode(testBase.WebDriverManager());
	}

}
