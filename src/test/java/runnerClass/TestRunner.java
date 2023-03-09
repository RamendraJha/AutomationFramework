package runnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "featureFile",
		glue="stepDefination",
		plugin = {"pretty" ,"json:target/cucumber.json"}) 
public class TestRunner {

	
	
	
	
}
