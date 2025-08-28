package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HandleRadioButtonsCheckBox;
import pageObjects.HomePage;
import pageObjects.BasePage;
import utilities.DataProviders;

public class TC003_DDT extends BaseClass{
	 
	
	@Test(dataProvider="excelData", dataProviderClass=DataProviders.class, groups={"Regression", "Master"}, priority=1)
	public void verify_dataDriveTest(String username, String email, String phonenumber, String gender, String day, String country) throws InterruptedException
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
		
		
		System.out.print(hp.verifyHomePageLabelIsDisplayed());
		logger.info("Homepage label verified");
		
		Thread.sleep(5000);
		
				
		
// 				hp.jsClickHomePagePromptAlert();
//				logger.info("Js method clicked on prompt alert ");
//				Thread.sleep(10000);
				
//				hp.actClickHomePageConfirmationtAlert();
//				logger.info("Act method clicked on confirmation alert ");
//				Thread.sleep(10000);
				
//				hp.implicitWaitAndClickHomePagePromptAlert();
//				logger.info("implicit method clicked on prompt alert ");
//				Thread.sleep(10000);
				
//				hp.explicitWaitAndClickHomePageConfirmationtAlert();
//				logger.info("explicit method clicked on prompt alert ");
//				Thread.sleep(5000);
				
//				hp.explicitWait_IsDiplayed_HomePageLabel();		
//				logger.info("home page label verified using explicit wait");
//				BaseClass.implicitWait(driver, 5);
//				
//				System.out.print(hp.getText_HomePageSubHeader());
//				logger.info("homepage sub header has been printed");
//				
//				hp.fluentWaitAndClickHomePageConfirmationtAlert();
//				logger.info("fluent method clicked on prompt alert ");
//				BaseClass.implicitWait(driver, 5);
//				Thread.sleep(5000);
			
		
		
				hp.selectContryDropDown(country);
				logger.info("country drop down has been selected to India");
				Thread.sleep(5000);
				
//				hp.getDropDownOptions();
//				logger.info("Printed all dropdown values");
//				Thread.sleep(5000);
////	
		     
//		        hp.jsScrollToElementAndClick_homePagePromptAlert();
//		        logger.info("clicked on prompt alert using js click");
//		        Thread.sleep(5000);
		
//				hp.clickUploadSingleFile();
//				logger.info("click on upload single file button");
//				Thread.sleep(5000);
		
//				hp.actClick_ClickUploadSingleFile();
//				logger.info("click on upload single file button using actions class");
//				Thread.sleep(5000);
//		
//				hp.actDoubleClick_wednesdayCheckbox();
//				logger.info("double clicked");
//				Thread.sleep(5000);
		
//				hp.selectColorsDropDown("Green");
//				logger.info("colors drop down has been selected to Green");
//						       
//				hp.selectSortedListDropDown("Dog");
//				logger.info("sorted list drop down has been selected to Dog");
//				Thread.sleep(5000);
		
//				hp.mouseHoverClickMobile();
//				logger.info("mouse houver click has done for mobiles");
//				Thread.sleep(5000);
		
		
//		 		//Click on some button or link to open new tab
//	    		driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button")).click();
//				hp.switchToNewTab(driver);
//				hp.switchToOldTab(driver);
//				logger.info("switch tabs are working");
//				Thread.sleep(5000);
		
//				//Click on some button or link to open new window
//				driver.findElement(By.xpath("//*[@id=\"PopUp\"]")).click();
//				Thread.sleep(5000);
//				hp.switchNewWindow(driver);
//				Thread.sleep(5000);
//				hp.switchOldWindow(driver);
//				Thread.sleep(5000);
				
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@Test(dataProvider="excelData", dataProviderClass=DataProviders.class, groups={"Regression", "Master"}, priority=2)
//	public void myMethod(String username, String email, String phonenumber, String gender, String day, String country)
//	{
//		System.out.println(username);
//		System.out.println(email);
//		System.out.println(phonenumber);
//		System.out.println(gender);
//		System.out.println(day);
//		System.out.println(country);
//	}
//	
			
}