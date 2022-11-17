package stepdefinitions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.parabank.automation.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccount;

public class createAccountSteps extends BaseClass{
	CreateAccount createAccount;
	@BeforeClass
	public void setup() {
		try {
			launchApp();
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
		
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
  
	
	@When("user clicks on Open new Account link")
	public void user_clicks_on_open_new_account_link() {
		createAccount = new CreateAccount();
		try {
		createAccount.clickOnOpenNewAccountLink();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	 
	}

	@Then("user should be able to see {string} title")
	public void user_should_be_able_to_see_title(String string) {
		try {
			createAccount.verifyTitle(string);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	 
	}
	   
	
	@Then("Checkings should be by default selected")
	public void checkings_should_be_by_default_selected() {
	    try {
	    	createAccount.verifyDefaultOption();
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	  
	}

	@Then("user clicks on OpenNewAccount button")
	public void user_clicks_on_open_new_account_button() {
		
		 try {
		    	createAccount.clickOnOpenNewAccountButton();
		    }
		    catch (Exception e)
		    {
		    	e.printStackTrace();
				Assert.fail();
		    }
	    
	}

	@Then("new checkings Account Number should be created")
	public void new_checkings_account_number_should_be_created() {
		try {
			createAccount.getNewCheckingsAccount();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
			    
	}

	@Then("in Account details section {string} , {string}, {string} should be present for checkings account")
	public void in_account_details_section_should_be_present_for_checkings_account(String string, String string2, String string3) {
		try {
			createAccount.verifyCheckingsAccount(string, string2, string3);
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}

	@Then("selects savings from the dropdown list")
	public void selects_savings_from_the_dropdown_list() {
		try {
			createAccount.selectSavingsAccount();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}
	
	@Then("new savings Account Number should be created")
	public void new_savings_account_number_should_be_created() {
		
		try {
			createAccount.getNewSavingsAccount();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	    
	}

   @Then("in Account details section {string} , {string}, {string} should be present for savings account")
	public void in_account_details_section_should_be_present_for_savings_account(String string, String string2, String string3) {
		try {
			createAccount.verifySavingsAccount(string, string2, string3);
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}
	
	@When("user clicks on BillPay link")
	public void user_clicks_on_bill_pay_link() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.clickOnBillPay();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}

	@Then("{string} header should be displayed")
	public void header_should_be_displayed(String string) {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.verifyHeaderOnBillPay(string);
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}

	@Then("user fills {string} , {string}, {string}, {string}, {string}, {string}")
	public void user_fills(String string, String string2, String string3, String string4, String string5, String string6) {
	    try {
	    	CreateAccount createAccount = new CreateAccount();
	    	createAccount.fillBillPaymentForm(string, string2, string3, string4, string5, string6);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}

	@Then("user clicks on Send Payment Button")
	public void user_clicks_on_send_payment_button() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.clickOnSendPayment();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}

	@Then("user should get BillPaymentComplete message")
	public void user_should_get_bill_payment_complete_message() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.verifyBillPaymentMessage();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}

	@Then("user clicks on Account Overview")
	public void user_clicks_on_account_overview() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.clickOnAccountOverview();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    } 
	}

	@Then("user selects debited account number")
	public void user_selects_debited_account_number() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.selectDebitedAccount();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    } 
	}

	@Then("entry should be created for debited amount")
	public void entry_should_be_created_for_debited_amount() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.verifyDebitedEntry();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }   
	}

	@Then("user selects credited account number")
	public void user_selects_credited_account_number() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.selectCreditedAccount();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }
	}

	@Then("entry should be created for credited amount")
	public void entry_should_be_created_for_credited_amount() {
		try {
			CreateAccount createAccount = new CreateAccount();
			createAccount.verifyCreditedEntry();
		}
		catch (Exception e)
	    {
	    	e.printStackTrace();
			Assert.fail();
	    }  
	}



}
