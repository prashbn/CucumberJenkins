import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.FileUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefn2 {
	
	private List<Integer> numbers;
    private int sum;
  WebDriver driver = new FirefoxDriver();
  
  
	//	  System.setProperty("webdriver.ie.driver", "C:\\Users\\Prasha\\Downloads\\IEDriverServer_x64_2.46.0\\IEDriverServer.exe" );  
	//  driver = new InternetExplorerDriver();
	
//driver = new  InternetExplorerDriver ();

//driver = new  SafariDriver();
  
  public void openBrowser()
  {
  driver.get("https://google.com");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
  Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
  String browser = caps.getBrowserName() ;
  String  platform = caps.getPlatform().toString();
  driver.findElement(By.id("ABC"));
 
  
  
  
  }
  
  
  @Given("^a list of numbers$")
  public void a_list_of_numbers(List<Integer> numbers) throws Throwable {
	  openBrowser();
    
  }
  
  
  

	public void hoverOverMenu(String menu,String SubMenu)
	{
		
		selectDropDown("11");
		Actions actions = new Actions(driver);
		 //driver.findElement(By.linkText(menu)).isDisplayed();
		 try
		 {
			 driver.findElement(By.linkText(menu));
		 }
		 catch(Exception e)
		 {
			 processException(e);
			 System.out.println("*********************"+e.getClass().toString());
			 System.out.println("*********************"+e.getMessage().toString());
				throw(e);
		 }
		
		WebElement menuHoverLink = driver.findElement(By.linkText(menu));
		actions.moveToElement(menuHoverLink).perform();
	
		
		WebElement subLink = driver.findElement(By.linkText(SubMenu));
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
		actions.sendKeys("a");
		
	}
	
	public void processException(Exception e)
	{

	//			takeScreenshot();
				System.out.println("***No Such Element Exception******");
			
				
		
	}
	
	public void takeScreenshot()
	{
	/*	System.out.println("------------------------Inside Screenshot");
		File srcFile = (File) (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(srcFile, new File("c:\\Myfolder\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("**************Eroor taking print");
			e.printStackTrace();
		}*/
	}
	
	
	 public void checkPageTitle(String Title){
		 System.out.println("driver.getTitle()" + driver.getTitle());

		 assertEquals(Title+" | Healthdirect", driver.getTitle());

		   }

	public void selectandContinue(String arg) {
		// TODO Auto-generated method stub
		if (arg.equalsIgnoreCase("cough"))
		{
			driver.findElement(By.xpath("(//button[@type='button' and @class='radio'])")).isDisplayed();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("(//button[@type='button' and @class='radio'])")).click();
			driver.findElement(By.xpath("//div[@class='flu-meter-check-now active']")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void ignorepopup() throws InterruptedException {
		// TODO Auto-generated method stub
		//getcurrentWindowHandle();
		driver.switchTo().frame(1);
		
		  for (int second = 0;; second++) {
		    	if (second >= 60) ;
		    	try {
		    		if (isElementPresent(By.id("submitButton")))
		    		{
		    			   driver.findElement(By.id("submitButton")).click();
		    			   Thread.sleep(1000);
		    			   break;
		    		}
		    			  
		    			 
		    	} catch (Exception e) {}
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

	}
	
	
	public void getcurrentWindowHandle()
	{
		  Set<String> handles = driver.getWindowHandles();
		    Iterator<String> itr = handles.iterator();
		  //  firstHandle = itr.next();
		   // lastHandle = firstHandle;
		    while (itr.hasNext()) {
		    	System.out.println("--------------xyz-----------");
		     //   lastHandle = itr.next();
		    }
		    //driver.switchTo().window(lastHandle.toString());
	}
	
	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

	public void validateifEnabled(String arg) {
		// TODO Auto-generated method stub
		if(arg.equalsIgnoreCase("ENT"))
		{
			System.out.println("Checking if button is enabled");
			String xpath = "//*[@class='script ng-scope ng-pristine ng-valid ng-binding active']";
			System.out.println("Xpath "+xpath);
			if(isElementPresentbyXpath(xpath))
			{
				System.out.println("Element found and in selected state");
				System.out.println("Element text is : " + getElementText(xpath));
			}
		}
	}
	
	private boolean isElementPresentbyXpath(String xpath)
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			System.out.println("------------True-----------");
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("------------false-----------");
			return false;
		}
	
	}
	
	private String getElementText(String xpath)
	{
			return (driver.findElement(By.xpath(xpath)).getText());
	}

	public void selectspecificSymptom(String arg) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/* WebDriverWait wait = new WebDriverWait(driver, 30);
       WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'easyXDM_default')]")));
       driver.switchTo().frame(frame);
       Thread.sleep(11000);*/

		

       //Get all your health topics and select one which matches

       List<WebElement> l = driver.findElements(By.xpath("//*[@id='leftCol']/div/button"));

       for (int i = 0; i < l.size(); i++) {
           System.out.println(l.get(i).getText());
               if (l.get(i).getText().equalsIgnoreCase("Ear, nose and throat")){
                   l.get(i).click();
                   Thread.sleep(2000);

                   //Get all your symptoms and select the needed

                   List<WebElement> l1 = driver.findElements(By.xpath("//*[@id='contentHeight']/div[2]/button"));
                   //Place your second for loop for the second list here
                   l1.get(1).click(); //just to test your 'Colds and flu' link

               }
       }
		
	
		
		switch(arg.toLowerCase())
		{
		case "cold and flu":
			
		/*	Actions actions = new Actions(driver);
			WebElement menuHoverLink = driver.findElement(By.xpath("//*[@ng-true-value='49|Feeling sick or unwell|1']"));
			actions.moveToElement(menuHoverLink);
			actions.click();
			actions.perform();*/
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("(//button[@id='49'])[2]")).click();
			
			driver.findElement(By.xpath("(//*[@id='submitAnswer'])[2]")).click();
		//	driver.findElement(By.id("submitAnswer")).click();
			break;
		default:
			System.out.println("Not a valid option");
			break;
		}	
			
		
	}

	public void selectandmove(String gender, String age, String postcode) {
		// TODO Auto-generated method stub
		switch(gender.toLowerCase())
		{
		case "male":
			driver.findElement(By.id("male")).click();
			break;
		case "female":
			driver.findElement(By.id("female")).click();
			break;
		}
		driver.findElement(By.id("ageInput")).sendKeys("30");
		driver.findElement(By.id("currentLocation")).sendKeys("2077");
		List<WebElement> county = driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
	
	
		county.get(1).click();
		driver.switchTo().defaultContent();
	//	listframes();
		Actions a1 = new Actions(driver);
	//	driver.findElement(By.linkText("Conditions")).click();
		WebElement i1= driver.findElement(By.linkText("Conditions"));
		
		//WebElement i1= driver.findElement(By.xpath("//*[@title='Conditions']"));
		a1.moveToElement(i1);
		a1.contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);

		//a1.keyDown(Keys.ARROW_DOWN);
		//a1.keyUp(Keys.ARROW_DOWN);
		a1.click();
		a1.perform();
		
	}
	
	private void listframes()
	{
		System.out.println("I am displaying frames");
		List<WebElement> frameset = driver.findElements(By.tagName("iframe"));
		for (WebElement framename : frameset){
		System.out.println("frameid: " + framename.getAttribute("id"));
		System.out.println(frameset);
		}
	}
	
	
	public void windowHandles()
	{
		
		String parentWindow= driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Count of windows:"+allWindows.size());  
		for(String curWindow : allWindows){
			System.out.println("Current window : " +curWindow );
		    driver.switchTo().window(curWindow);
		}
	
		driver.findElement(By.linkText("Symptoms")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(parentWindow);
		
	}

	
	
	public void handleAlerts()
	{
		   try {
		        WebDriverWait wait = new WebDriverWait(driver, 2);
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        alert.accept();
		    } catch (Exception e) {
		        //exception handling
		    }
		
	}
	
	public void selectDropDown(String value)
	{
		WebElement dropDownListBox = driver.findElement(By.id("ccExpMth"));

		Select clickThis = new Select(dropDownListBox);
		System.out.println("================"+	clickThis.getFirstSelectedOption());
		//clickThis.deselectAll();

		clickThis.selectByVisibleText(value);
	}


}
