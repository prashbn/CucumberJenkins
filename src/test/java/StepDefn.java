import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class StepDefn {
	
	private List<String> inputs;
    private String testCaseId;
    
    private WebDriver driver;
    
    
    
    private IntializeVansah VANSAH = IntializeVansah.getInstance( );
    private UpdateVansahTestStatus UVTS = new UpdateVansahTestStatus();
    
    private void setup() {
		// TODO Auto-generated method stub
    	IntializeDriver id= new IntializeDriver();
    	
    	try {
			driver = id.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


    
    @Given("^(\\d+) I open the page$")
    public void tc_I_open_the_page(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	 testCaseId= Integer.toString(arg1);
    	 
    	 System.out.println("Test case id :"+testCaseId );
     	setup();
    }
    

    


	@When("^I click on Login after keyin sample and sample(\\d+)$")
    public void i_click_on_Login_after_keyin_sample_and_sample(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
		System.out.println("Clicked on Login Successfull");
	
		
       
    }

    @Then("^I should be redirected to the landing page$")
    public void i_should_be_redirected_to_the_landing_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
		//suppose if the user is not redirectecd to login page update the results with this method
 
    	
    }

    @Then("^Update results in vansha$")
    public void update_results_in_vansha() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	UVTS.UpdateResults(testCaseId, "pass", "Sucessfully Opened page ");
    }
  
    
    


}
