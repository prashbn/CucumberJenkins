import org.junit.runner.RunWith;

import ReusableComponents.VansahInterface;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features ={"src/test/features"},
plugin = {"html:target/cucumber-html-report", "pretty:target/cucumber-json-report.json"},
strict = true
)

public class TestMaster
{

			
}
