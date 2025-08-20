package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HandleRadioButtonsCheckBox;
import pageObjects.HomePage;
import utilities.DataProviders;

public class TC003_DDT extends BaseClass{
	
	@Test(dataProvider="excelData", dataProviderClass=DataProviders.class, groups={"Regression", "Master"})
	public void verify_dataDriveTest(String username, String email, String phonenumber, String gender, String day) throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		HandleRadioButtonsCheckBox hrc= new HandleRadioButtonsCheckBox(driver);
		
		logger.info("Started TC003_DDT Test Execution Started");
		
		try
		{			
		
		hp.clickHome();
		logger.info("Clicked on Homepage");
		
		hp.enterName(username); //entering user name from excel sheet
		logger.info("Entered username" + username); 
		
		
		hp.enterEmail(email); //entering email from excel sheet
		logger.info("Entered email" + email);
		
				
		hp.enterPhone(phonenumber); //entering phone number from excel sheet
		logger.info("Entered phone number" + phonenumber);
		
				
		hrc.genderSelect(gender); //selecting gender from excel sheet
		logger.info("Gender radion button selected"+ gender);
		
		hrc.daySelect(day); //selecting day from excel sheet
		logger.info("Day checkbox selected"+ day);			
		
		
		boolean targetPage=hp.isMyHomePageExists();
		Assert.assertEquals(targetPage, true, "HomePage Failed to Load");
		logger.info("Homepage label verified");
		
		Thread.sleep(10000);
		
	
	}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			
		}
	
	
	
}


}
