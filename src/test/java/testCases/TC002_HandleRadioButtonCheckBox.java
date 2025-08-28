package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HandleRadioButtonsCheckBox;
import pageObjects.HomePage;

public class TC002_HandleRadioButtonCheckBox extends BaseClass {
	
	@Test(groups= {"Sanity", "Master"})
	public void handleRadioButtonCheckBox()
	{
		logger.info("Started TC002 Handle Radio Button and Check Box Test Execution Started");
		
		try
		{		
		HomePage hp=new HomePage(driver);
		HandleRadioButtonsCheckBox hrc= new HandleRadioButtonsCheckBox(driver);
				
		hp.clickHome();
		logger.info("Clicked on Homepage");
		
		hp.enterName(p.getProperty("username"));//reading user name from config.properties file
		logger.info("Entered username" + p.getProperty("username")); 
				
		
		hp.enterEmail(randomString()+"@gmail.com"); //entering random email
		logger.info("Entered email" + randomString() + "@gmail.com");
		
		hp.enterPhone(randomNumber()); //entering random phone number
		logger.info("Entered phone number" + randomNumber());
		
		System.out.print(hp.verifyHomePageLabelIsDisplayed());
		logger.info("Homepage label verified");
		
		hrc.genderSelect("male");
		logger.info("Gender radion button selected");
		
		hrc.genderSelect("female");
		logger.info("Gender radion button selected");
		
		hrc.daySelect("sunday");
		logger.info("Day checkbox selected");
		
		hrc.daySelect("monday");
		logger.info("Day checkbox selected");
		
	}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			
		}
	
	
	
}
}


