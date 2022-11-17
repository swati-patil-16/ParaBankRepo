package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import com.parabank.automation.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends BaseClass {

	LoginPage loginPage  = new LoginPage(); ;
	
	@Before
	public void setup() {
		try {
			launchApp();
	}
		catch(Exception e)
		{
			
			Assert.fail();
		}
	}
		
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(screenshot, "image/png", "name");
		}	             
		driver.quit();
	}
  
	@When("user enters the URL in browser")
	public void user_enters_the_url_in_browser() {
		try {	
			
			loginPage.navigateToURL(prop.getProperty("url"));
		} 
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@And("user logins to application using credentials")
	public void user_logins_to_application_using_credentials() {

		try {
			
			loginPage.enterLoginDetails(prop.getProperty("username"), prop.getProperty("password"));
			
		}

		catch (Exception e) {
			Assert.fail();
		}

	}

	
	@Then("user should be able to see the title")
	public void user_should_be_able_to_see_the_title() {
		
		try {
			String title = prop.getProperty("title");
			loginPage.VerifyTitle(title);

		} catch (Exception e) {
			Assert.fail();
		}

	}

}
