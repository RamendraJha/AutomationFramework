package stepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.MailUtils.FileReadWrite;
import com.MailUtils.ReportingPojo;



public class NewFeatureStepDef {

	Scenario scenario;
	ReportingPojo reporting=new ReportingPojo();
		
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	    reporting.setFeatureName(scenario.getName());  
	}
	@After
	public void after(Scenario scenario) {
		this.scenario = scenario;
		reporting.setTag(scenario.getSourceTagNames().toString());
		reporting.setStatus(scenario.getStatus().toString());
		FileReadWrite.saveScenarioNameToFile(reporting.toString(), FileReadWrite.scenarioDetails);
		System.out.println(reporting.toString()); 
	}
	
	RequestSpecification requestSpecification;
	Response response;
	ValidatableResponse validatableResponse;
	
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		
		
	   requestSpecification=given().baseUri("https://postman-library-api.glitch.me");
		
	}

	@When("I complete action")
	public void i_complete_action() {
		response=requestSpecification.get("/books");
		 

	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		validatableResponse=response.then();
	    validatableResponse.statusCode(200);
		
	}
	
	
	@Given("I have a endPoint to hit")
	public void i_have_a_end_point_to_hit() {
		
		requestSpecification=given().baseUri("https://postman-library-api.glitch.me");
	}

	@When("I want to hit get request")
	public void i_want_to_hit_get_request() {
		response=requestSpecification.get("/books");
	}

	@Then("validate statusCode and StatusLine")
	public void validate_status_code_and_status_line() {
		validatableResponse=response.then();
	    validatableResponse.assertThat().statusCode(200);
	    validatableResponse.assertThat().header("Content-Type", "application/json; charset=utf-8");
	    
	}


}
