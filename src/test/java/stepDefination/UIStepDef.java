package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.MailUtils.FileReadWrite;
import com.MailUtils.ReportingPojo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class UIStepDef {
	
	Scenario scenario;
	ReportingPojo reporting=new ReportingPojo();
	WebDriver driver;
	
	@Before
	public void before(Scenario scenario) {
		
	    this.scenario = scenario;
	    reporting.setFeatureName(scenario.getName());  
	    System.setProperty("webdriver.chrome.driver", "/Users/ramendrakumar/Downloads/chromedriver_mac_arm64/chromedriver");
		
		driver=new ChromeDriver();
	}
	
	@After
	public void after(Scenario scenario) {
		this.scenario = scenario;
		reporting.setTag(scenario.getSourceTagNames().toString());
		reporting.setStatus(scenario.getStatus().toString());
		FileReadWrite.saveScenarioNameToFile(reporting.toString(), FileReadWrite.scenarioDetails);
		driver.close(); 
	}
	
	
	
	
	
	@Given("I navigate to the url")
	public void i_navigate_to_the_url() {
		
		driver.navigate().to("https://thedemosite.co.uk/");
		try {
			driver.manage().timeouts().wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@When("I will land up in Home page")
	public void i_will_land_up_in_home_page() {
	    driver.findElement(By.xpath("//span[contains(text(),'About')]"));
	}

	@Then("Validate the Title of Web Page")
	public void validate_the_title_of_web_page() {
	    String title= driver.getTitle();
	    System.out.println(title);
	}

	@When("I will click on contact hyperlink")
	public void i_will_click_on_contact_hyperlink() {
		driver.findElement(By.xpath("//li[@id='menu-item-25']//a"));
		driver.findElement(By.xpath("//li[@id='menu-item-25']//a")).click();
		
	}

	@Then("I verify contact header is on the page")
	public void i_verify_contact_header_is_on_the_page() {
		
		driver.findElement(By.xpath("//h1[contains(text(),'Contact')]")).isDisplayed();
	}


}
