package pages;
import org.openqa.selenium.By;

import com.parabank.automation.BaseClass;

public class LoginPage extends BaseClass{
	

	public void navigateToURL(String url)
	{
		driver.navigate().to(url);
	}
	
	
	public void enterLoginDetails(String username, String password) {
		try {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
		
	public boolean VerifyTitle(String expectedTitle) {
		boolean result = false;
		try {		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if(actualTitle.equals(expectedTitle))
		{
			result = true;
		}
		}		
		catch(Exception e) {
			e.printStackTrace();
				
		}		
		return result;	
		
	}
	
}
