import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features ={"src/test/resources/login.feature"},
tags={"@Login","~@TC001"},
plugin = {"html:target/cucumber-html-report", "pretty:target/cucumber-json-report.json"},
strict = true
)

public class TestMaster {
	

}
