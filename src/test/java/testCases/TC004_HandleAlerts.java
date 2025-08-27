package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC004_HandleAlerts extends BaseClass {
	
	@Test
	
	public void verifyAlerts() throws InterruptedException
	{
	HomePage hp=new HomePage(driver);
	
	hp.clickSimpleAlert();
	logger.info("clicked on OK button on simple alert");
	
	
	hp.clickConfirmationAlert();
	logger.info("clicked on OK button on confirmation alert");
	
	
	hp.clickPromptAlert("Welcome to pop up field");
	logger.info("clicked on OK button on prompt alert");
	Thread.sleep(5000);
	}

}
