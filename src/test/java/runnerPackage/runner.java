package runnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
   features = {"features/createAccount.feature"},
   glue = {"stepdefinitions"},
   plugin= {"pretty","html:target/site/cucumber-pretty",
		   "json:target/cucumber.json"},
   monochrome =true
   )
   
public class runner extends AbstractTestNGCucumberTests{
	

}
