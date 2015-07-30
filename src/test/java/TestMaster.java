import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features ={"src/test/resources/login.feature"},
plugin = {"html:target/cucumber-html-report", "pretty:target/cucumber-json-report.json"},
strict = true
)

public class TestMaster
{

			
			private IntializeVansah initalizeVANSAH = IntializeVansah.getInstance( );
			private String VANSAH_PACKAGE=System.getProperty("jenkins.package");
			private String VANSAH_TYPE="2";
			private String VANSAH_RELEASE=System.getProperty("jenkins.release");
			private String VANSAH_BUILD=System.getProperty("jenkins.build");
			private String VANSAH_ENVIRONMENT=System.getProperty("jenkins.environment");	
			private String VANSAH_AGENT="AGENT2";
			private String VANSAH_TOKEN="FLEXATSI15";
			

			
			public void Intialize()

			{
				System.out.println(" VANSAH_PACKAGE :" + VANSAH_PACKAGE);
				System.out.println(" VANSAH_RELEASE :" + VANSAH_RELEASE);
				System.out.println(" VANSAH_BUILD :" + VANSAH_BUILD);
				System.out.println(" VANSAH_ENVIRONMENT:" + VANSAH_ENVIRONMENT);
				initalizeVANSAH.setPackage(VANSAH_PACKAGE);
				initalizeVANSAH.setType(VANSAH_TYPE);
				initalizeVANSAH.setRelease(VANSAH_RELEASE);
				initalizeVANSAH.setBuild(VANSAH_BUILD);
				initalizeVANSAH.setEnvironment(VANSAH_ENVIRONMENT);
				initalizeVANSAH.setAgent(VANSAH_AGENT);
				initalizeVANSAH.setToken(VANSAH_TOKEN);

			}
			
}
