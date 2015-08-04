import java.util.List;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import ReusableComponents.IntializeDriver;
import ReusableComponents.SharedComponents;
import ReusableComponents.SharedLibrary;
import ReusableComponents.VansahInterface;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class StepDefn  {
	
	VansahInterface vansahinterface = VansahInterface.getInstance();

	private String testCaseId;


    @Given("^(\\d+) I open the page$")
    public void tc_I_open_the_page(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	 testCaseId= Integer.toString(arg1);
    	 
    	 System.out.println("Test case id :"+testCaseId );
  
    }
    
	@When("^I click on Login after keyin sample and sample(\\d+)$")
    public void i_click_on_Login_after_keyin_sample_and_sample(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
		 LoginPage.txtbx_UserName().sendKeys("testuser_1");
		 
		// LoginPage.txtbx_Password().sendKeys("Test@123");
	 
		 //ssLoginPage.btn_LogIn().click();
		
       
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
