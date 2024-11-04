package allSharedFilesStoredHere;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		//Above step will change the file type of global.properties to InputStream
		Properties prop = new Properties();  //this will give access and read the global.properties file
		prop.load(fis);  //This need file type in InputStream format
		String URL = prop.getProperty("QAUrl");
		
		if(driver == null)
		{
			if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
			{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium Jars and Dependencies\\Browser Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("Edge"))
			{
				System.setProperty("webdriver.msedge.driver", "C:\\Selenium Jars and Dependencies\\Browser Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			else
			{
				System.out.println("Invalid driver specified");
			}
			
			
			driver.get(URL);		
		}

		return driver;
	}

}
