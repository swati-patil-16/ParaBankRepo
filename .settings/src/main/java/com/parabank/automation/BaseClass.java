package com.parabank.automation;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;	

	
	public static void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("Configs\\config.properties");
			prop.load(ip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void launchApp()throws InterruptedException {
		
		loadConfig();
		String browserName =  prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{				
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		//Maximize the screen
		driver.manage().window().maximize();

		//Implicit TimeOuts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						

	}

}
