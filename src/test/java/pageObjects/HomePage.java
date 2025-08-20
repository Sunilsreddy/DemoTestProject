package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(how=How.XPATH, using="//*[@id=\"PageList2\"]//*[contains(text(),'Home')]")
	@CacheLookup
	WebElement lnkHome;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"name\"]")
	@CacheLookup
	WebElement name;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"email\"]")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.XPATH, using="/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div[1]/input[3]")
	@CacheLookup
	WebElement phone;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"header-inner\"]/div[1]/h1")
	@CacheLookup
	WebElement homePageLabel;
	
	
	
	public void clickHome()
	{
		lnkHome.click();
		
		//solution 2
		//Actions act=new Actions(driver);
		//act.moveToElement(lnkHome).click().perform();
		
		//solution 3
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("auguments[0].click();", lnkHome);
		
		//solution 4
		//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(lnkHome)).click();
		
	}
	
	public void enterName(String username)
	{
		name.sendKeys(username);
		
	}
	
	public void enterEmail(String userEmail)
	{
		email.sendKeys(userEmail);
		
	}
	
	public void enterPhone(String userPhone)
	{
		phone.sendKeys(userPhone);
		
	}
		
	public boolean isMyHomePageExists() 
	{
		try
		{
			return(homePageLabel.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	
}
;
