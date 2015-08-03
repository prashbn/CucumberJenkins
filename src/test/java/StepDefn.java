import java.util.List;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import ReusableComponents.IntializeDriver;
import ReusableComponents.VansahInterface;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class StepDefn {
	
	private List<String> inputs;
    private String testCaseId;
    private WebDriver driver;
    VansahInterface vansahinterface;
    
 

	
	public void IntializeVansha()

	{
		 String VANSAH_URI="";
		 String VANSAH_PACKAGE=System.getProperty("jenkins.package");
		 String VANSAH_TYPE="2";
		 String VANSAH_RELEASE=System.getProperty("jenkins.release");
		 String VANSAH_BUILD=System.getProperty("jenkins.build");
		 String VANSAH_ENVIRONMENT=System.getProperty("jenkins.environment");	
		 String JENKINS_BUILD_URL = System.getProperty("jenkins.buildUrl");
		 String VANSAH_AGENT="AGENT2";
		 String VANSAH_TOKEN="FLEXATSI15";	
		 String PROXY_SERVER="";
		 int PROXY_PORT=0;
		 
		vansahinterface = VansahInterface.getInstance(VANSAH_URI,VANSAH_PACKAGE,VANSAH_TYPE,VANSAH_RELEASE,VANSAH_BUILD,VANSAH_ENVIRONMENT,VANSAH_AGENT,VANSAH_TOKEN,PROXY_SERVER,PROXY_PORT); 

	}
	
	    @Before(value="@Regression")
	    public void beforeScenario() {

			// TODO Auto-generated method stub
	    	System.out.println("Before Regression");
	    	IntializeDriver intializedriver= new IntializeDriver();
	   
	    	
	    	try 
	    	{
				driver = intializedriver.setUp();
				
			} 
	    	catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}


    
    @Given("^(\\d+) I open the page$")
    public void tc_I_open_the_page(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	 testCaseId= Integer.toString(arg1);
    	 
    	 System.out.println("Test case id :"+testCaseId );
     //	setup();
    }
    

    


	@When("^I click on Login after keyin sample and sample(\\d+)$")
    public void i_click_on_Login_after_keyin_sample_and_sample(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
		 LoginPage.txtbx_UserName(driver).sendKeys("testuser_1");
		 
		 LoginPage.txtbx_Password(driver).sendKeys("Test@123");
	 
		 LoginPage.btn_LogIn(driver).click();
		
       
    }

    @Then("^I should be redirected to the landing page$")
    public void i_should_be_redirected_to_the_landing_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
		//suppose if the user is not redirectecd to login page update the results with this method
 
    	
    }

    @Then("^Update results in vansha$")
    public void update_results_in_vansha() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	vansahinterface.UpdateResultsInVansah(testCaseId, "pass", "Sucessfully Opened page ");
    }
  
    
    


}
