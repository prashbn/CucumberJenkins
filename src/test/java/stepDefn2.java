import static org.junit.Assert.assertEquals;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefn2 {
	
	private List<Integer> numbers;
    private int sum;

    @Given("^a list of numbers$")
    public void a_list_of_numbers(List<Integer> numbers) throws Throwable {
    	System.out.println("Hiiiii");
        this.numbers = numbers;
    }

    @When("^I summarize them$")
    public void i_summarize_them() throws Throwable {
        for (Integer number : numbers) {
            sum += number;
        }
    }

    @Then("^should I get (\\d+)$")
    public void should_I_get(int expectedSum) throws Throwable {
       assertEquals(sum, expectedSum);

    }

}
