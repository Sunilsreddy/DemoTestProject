package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HandleRadioButtonsCheckBox extends BasePage {
	
	public HandleRadioButtonsCheckBox(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div[3]/div[1]/input")
	WebElement maleGender;
	
	@FindBy(xpath="//*[@id=\"post-body-1307673142697428135\"]//*[contains(text(),'Female')]")
	WebElement femaleGender;

	@FindBy(xpath="//*[@id=\"post-body-1307673142697428135\"]//*[contains(text(),'Sunday')]")
	WebElement daySunday;
	
	@FindBy(xpath="//*[@id=\"post-body-1307673142697428135\"]//*[contains(text(),'Monday')]")
	WebElement dayMonday;
	
	
		
	
	public void genderSelect(String gender)
	{
		if(!(gender.isEmpty()))
		{
		if(gender.toLowerCase()=="male")
		{
	           if(!maleGender.isSelected())
	         {
	    	   maleGender.click();
	         }
	      else if(gender.toLowerCase()=="female")
	      {
	    	  if(!femaleGender.isSelected())
		      {
	    		  femaleGender.click();
		      }
	      }
		}
		}
	}
	
	
	public void daySelect(String day)
	{
		if(!(day.isEmpty()))
		{
		switch (day.toLowerCase()) {
		case "sunday":
			if ( !daySunday.isSelected() )
			{
				daySunday.click();
			} break;
		case "monday":
			if ( !dayMonday.isSelected() )
			{
				dayMonday.click();
			} break;
		default:
		    System.out.println("Select correct day");
		}
	}
	}
	
	
	
}
