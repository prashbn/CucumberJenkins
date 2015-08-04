package ReusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.WebClient;


//Singelton class for Driver
public class IntializeDriver {
	
	public WebDriver driver;
	WebClient wclient=new WebClient();
	Properties property = new Properties();
	static String baseURL=null;
	static IntializeDriver initializedriver = null;
	
	
	public IntializeDriver()
	{
		
	}
	


	public WebDriver setUp() throws Exception {
		
		System.setProperty("webdriver.ie.driver","src\\test\\resources\\IEDriverServer.exe");
		
	try{
		try {
			  property.load(new FileInputStream("src/test/resources/Config.properties"));
			} catch (IOException e) {
			 
			}
		String browserType = property.getProperty("BrowserType");
		switch(browserType)
		{
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "IExplorer":
			driver = new InternetExplorerDriver();
			break;
		case "Chrome":
			driver = new ChromeDriver();
			break;
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Capabilities capObj = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(" Browser Name is :" +capObj.getBrowserName());
		System.out.println("Browswe Version is :"+capObj.getVersion());
		baseURL=property.getProperty("BaseURL");
		System.out.println("Base url "+baseURL);
		driver.get(property.getProperty("BaseURL"));
		System.out.println("-------------");
	}
	catch(WebDriverException e)
	{
		System.out.println("Web Driver Intialization Failed");
	}
	return driver;
	}

	
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}
}
