package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.BasePage;

public class TC001_HomePageTest extends BaseClass {
	
		
	@Test(groups= {"Sanity", "Master"})
	public void verifyHomePage()
	{
		logger.info("Started TC001_HomePageTest Execution");
		
		try
		{		
		HomePage hp=new HomePage(driver);
				
		hp.clickHome();
		logger.info("Clicked on Homepage");
		
		//hp.enterName(randomString().toUpperCase());
		//logger.info("Entered username" + randomString()); 
		//OR
		hp.enterName(p.getProperty("username"));//reading username from properties file
		logger.info("Entered username" + p.getProperty("username")); 
				
		
		hp.enterEmail(randomString()+"@gmail.com"); //entering random string for email
		logger.info("Entered email" + randomString() + "@gmail.com");
		
		hp.enterPhone(randomNumber()); //entering random phone number
		logger.info("Entered phone number" + randomNumber());
		
		boolean targetPage=hp.isMyHomePageExists();
		Assert.assertEquals(targetPage, true, "HomePage Failed to Load");
		logger.info("Homepage label verified");
		
		
		
		
	}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			
		}
	
	
	
}
}
