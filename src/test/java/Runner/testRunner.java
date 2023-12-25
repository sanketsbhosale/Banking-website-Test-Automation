package Runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features", glue="StepDefinitions", tags="@testLogout" )
public class testRunner extends AbstractTestNGCucumberTests {
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
