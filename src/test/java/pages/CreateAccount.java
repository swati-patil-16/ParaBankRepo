package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parabank.automation.BaseClass;

public class CreateAccount extends BaseClass {

	public static int checkingsAccountNumber;
	public static int savingsAccountNumber;
	public static String amount = prop.getProperty("amountToDebit");
	
	public void clickOnOpenNewAccountLink() {
		try {
			WebElement ele = driver.findElement(By.xpath("//a[text() = 'Open New Account']"));

			if (ele.isDisplayed()) {
				ele.click();
			} else {
				throw new Exception("Click on Open New Account link could not be located");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void verifyTitle(String expectedTitle) {
		try {
			String actualTitle = driver.findElement(By.className("title")).getText();
			if (!actualTitle.equalsIgnoreCase(expectedTitle)) {
				throw new Exception("Title is " + actualTitle + "instead of " + expectedTitle);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void verifyDefaultOption() {
		try {
			String expectedOption = "CHECKING";
			Select select = new Select(driver.findElement(By.id("type")));
			WebElement selectedOption = select.getFirstSelectedOption();
			String defaultSelection = selectedOption.getText();
			if (!defaultSelection.equals(expectedOption)) {
				throw new Exception("By default CHECKING option is not selected");
			}

		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void clickOnOpenNewAccountButton() {
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='submit']"))));
			
			
			if (driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@type='submit']")).click();
			} else
				throw new Exception("Button is not present");
		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void getNewCheckingsAccount() {

		try {
			String stringAccountNumber = driver.findElement(By.id("newAccountId")).getText();
			checkingsAccountNumber = Integer.parseInt(stringAccountNumber);
			driver.findElement(By.id("newAccountId")).click();
		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		finally {
			System.out.println(checkingsAccountNumber);
		}
	}

	public void verifyCheckingsAccount(String accountType, String balance, String available) {

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("accountId"))));
			
			/*String stringAccountNumber = driver.findElement(By.id("accountId")).getText();
			Thread.sleep(3000);
			int accountNumber = Integer.parseInt(stringAccountNumber);
			
			if (accountNumber != checkingsAccountNumber) {
				throw new Exception("Account number is different");
			}*/
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("accountType"))));
			
			String actualAccountType = driver.findElement(By.id("accountType")).getText();
			
			System.out.println(actualAccountType);
			Thread.sleep(3000);
			if (!accountType.equalsIgnoreCase(actualAccountType)) {
				throw new Exception("Account type is different");
			}

			String actualBalance = driver.findElement(By.id("balance")).getText();
			Thread.sleep(3000);
			if (!balance.equalsIgnoreCase(actualBalance)) {
				throw new Exception("Actual Balance is different");
			}

			String actualAvailableBalance = driver.findElement(By.id("availableBalance")).getText();
			Thread.sleep(3000);
			if (!available.equalsIgnoreCase(actualAvailableBalance)) {
				throw new Exception("Actual available balance is different");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void selectSavingsAccount() {
		try {
			Select select = new Select(driver.findElement(By.id("type")));
			select.selectByVisibleText("SAVINGS");
			
			WebElement ele = driver.findElement(By.xpath("//input[@type='submit']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void getNewSavingsAccount() {

		try {
			String stringAccountNumber = driver.findElement(By.id("newAccountId")).getText();
			savingsAccountNumber = Integer.parseInt(stringAccountNumber);
			driver.findElement(By.id("newAccountId")).click();
		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		finally {
			System.out.println(savingsAccountNumber);
		}
	}
	
	public void verifySavingsAccount(String accountType, String balance, String available) {

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("accountId"))));
			
			/*String stringAccountNumber = driver.findElement(By.id("accountId")).getText();
			int accountNumber = Integer.parseInt(stringAccountNumber);
			if (accountNumber != savingsAccountNumber) {
				throw new Exception("Account number is different");
			}*/

			String actualAccountType = driver.findElement(By.id("accountType")).getText();
			System.out.println(actualAccountType);
			Thread.sleep(3000);
			if (!accountType.equalsIgnoreCase(actualAccountType)) {
				throw new Exception("Account type is different");
			}

			String actualBalance = driver.findElement(By.id("balance")).getText();
			Thread.sleep(3000);
			if (!balance.equalsIgnoreCase(actualBalance)) {
				throw new Exception("Actual Balance is different");
			}

			String actualAvailableBalance = driver.findElement(By.id("availableBalance")).getText();
			Thread.sleep(3000);
			if (!available.equalsIgnoreCase(actualAvailableBalance)) {
				throw new Exception("Actual available balance is different");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clickOnBillPay() {
		try {
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[4]/a")).click();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void verifyHeaderOnBillPay(String expected) {
		try {
		String actualHeading = driver.findElement(By.xpath("(//*[@id=\"rightPanel\"]//h1)[1]")).getText();
		
		if(!actualHeading.equalsIgnoreCase(expected))
		{
			throw new Exception("Bill Payment Service Heading is not correct");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void fillBillPaymentForm(String name, String address, String city, String state, String zipCode, String phone)
	{
		try {
		WebElement payeeName = driver.findElement(By.xpath("//input[@name='payee.name']"));
		WebElement payeeAddress = driver.findElement(By.xpath("//input[@name='payee.address.street']"));
		WebElement payeeCity = driver.findElement(By.xpath("//input[@name='payee.address.city']"));
		WebElement payeeState = driver.findElement(By.xpath("//input[@name='payee.address.state']"));
		WebElement payeeZipCode = driver.findElement(By.xpath("//input[@name='payee.address.zipCode']"));
		WebElement payeePhoneNumber = driver.findElement(By.xpath("//input[@name='payee.phoneNumber']"));
		WebElement payeeAccountNumber = driver.findElement(By.xpath("//input[@name='payee.accountNumber']"));
		WebElement verifyAccountNumber = driver.findElement(By.xpath("//input[@name='verifyAccount']"));
		WebElement amountToPay = driver.findElement(By.xpath("//input[@name='amount']"));
		Select s = new Select(driver.findElement(By.xpath("//select[@name='fromAccountId']")));
		
		if(!payeeName.isDisplayed()||!payeeAddress.isDisplayed()||!payeeCity.isDisplayed()||!payeeState.isDisplayed()||
				!payeeZipCode.isDisplayed()||!payeePhoneNumber.isDisplayed()||!payeeAccountNumber.isDisplayed()||
				!verifyAccountNumber.isDisplayed()||!amountToPay.isDisplayed())
		{
			throw new Exception("One Of form element is missing");
		}
		
		payeeName.sendKeys(name);
		payeeAddress.sendKeys(address);
		payeeCity.sendKeys(city);
		payeeState.sendKeys(state);
		payeeZipCode.sendKeys(zipCode);
		payeePhoneNumber.sendKeys(phone);
		payeeAccountNumber.sendKeys(String.valueOf(savingsAccountNumber));
		verifyAccountNumber.sendKeys(String.valueOf(savingsAccountNumber));
		amountToPay.sendKeys(amount);
		
		s.selectByVisibleText(String.valueOf(checkingsAccountNumber));
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();	
		}
	}
	
	
	public void clickOnSendPayment() {
		try {
			WebElement button = driver.findElement(By.xpath("//input[@value='Send Payment']"));
			if(!button.isDisplayed()) {
				{throw new Exception("Send Payment button is not present");}
			}	
			button.click();
			
			}			
			
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();	
		}
	}
	
	public void verifyBillPaymentMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//h1)[1]"))));
			
			
			String headingMessage = driver.findElement(By.xpath("(//h1)[1]")).getText();
			
			System.out.println(headingMessage);
			
			if(!headingMessage.equals("Bill Payment Complete")) {
				throw new Exception("Heading is not equal to Bill Payment Complete");
			}
			
			WebElement amount = driver.findElement(By.xpath("//span[@id='amount']"));
			String stringAmount = amount.getText();
			stringAmount.replace('$',' ').replace(".00"," ").replace(" ", "");
		    System.out.println(stringAmount);
			if(!CreateAccount.amount.equals(stringAmount)) {
				throw new Exception("Debited amount is not same");
			}
			
			WebElement fromAccountId = driver.findElement(By.xpath("//span[@id='fromAccountId']"));
			String displayedFromAccountId = fromAccountId.getText();
			if(!displayedFromAccountId.equals(String.valueOf(checkingsAccountNumber))) {
				throw new Exception("Debited account number is not same");
			}
						
			}			
			
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();	
		}
	}
	
	public void clickOnAccountOverview() {
		try {
			WebElement accountOverview = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a"));
			if(!accountOverview.isDisplayed()) {
				throw new Exception("Account Overview link is not available");
			}
			accountOverview.click();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();	
		}
	}
	
	public void selectDebitedAccount() {
		try {
			
	
		String xpath = "//a[text()='"+String.valueOf(checkingsAccountNumber)+"']";
		
		driver.findElement(By.xpath(xpath)).click();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();	
		}
	}
	
	public void verifyDebitedEntry() {
		try {
			List<WebElement> webElementList = driver.findElements(By.xpath("//table[@id='transactionTable']//tbody//tr"));
			int n = webElementList.size() - 1 ;
			
			String rowPath = "//table[@id='transactionTable']//tbody//tr["+n+"]//td[3]";
								
			String actualDebitedAmount = driver.findElement(By.xpath(rowPath)).getText();
			actualDebitedAmount.replace('$',' ').replace(".00"," ").replace(" ", "");
			if(!actualDebitedAmount.equalsIgnoreCase(amount)) {
				throw new Exception("Debited amount is not equal to actual debited amount");
			}
					
			}
			catch(Exception e) {
				e.printStackTrace();
				Assert.fail();	
			}
	}
	
	public void selectCreditedAccount() {
		try {
		String xpath = "//a[text()='"+String.valueOf(savingsAccountNumber)+"']";
		
		driver.findElement(By.xpath(xpath)).click();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();	
		}
	}
	
	public void verifyCreditedEntry() {
		try {
						
			String actualCreditedAmount = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody//tr[1]//td[4]")).getText();
			actualCreditedAmount.replace('$',' ').replace(".00"," ").replace(" ", "");
			if(!actualCreditedAmount.equalsIgnoreCase(amount)) {
				throw new Exception("Debited amount is not equal to actual debited amount");
			}
					
			}
			catch(Exception e) {
				e.printStackTrace();
				Assert.fail();	
			}
	}
	
	
	
	
	
	
	
	


	
}
