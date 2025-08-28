package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {
	int small_Wait=5; int medium_Wait=10; int long_Wait=20;
	
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
	
	@FindBy(how=How.XPATH, using="//*[@id=\"header-inner\"]/div[2]/p/span")
	@CacheLookup
	WebElement homePageSubHeader;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"alertBtn\"]")
	@CacheLookup
	WebElement homeSimpleAlert;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"promptBtn\"]")
	@CacheLookup
	WebElement homePagePromptAlert;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"confirmBtn\"]")
	@CacheLookup
	WebElement homePageConfirmationptAlert;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"country\"]")
	@CacheLookup
	WebElement country;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"singleFileForm\"]/button")
	@CacheLookup
	WebElement uploadSingleFile;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"wednesday\"]")
	@CacheLookup
	WebElement wednesdayCheckbox;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/div/ul/li[1]/button")
	@CacheLookup
	WebElement simpleAlert;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/div/ul/li[2]/button")
	@CacheLookup
	WebElement confirmationAlert;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/div/ul/li[3]/button")
	@CacheLookup
	WebElement promptAlert;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"colors\"]")
	@CacheLookup
	WebElement colors;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"animals\"]")
	@CacheLookup
	WebElement sortedList;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"HTML3\"]/div[1]/div/button")
	@CacheLookup
	WebElement pointMe;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"HTML3\"]/div[1]/div/div/a[1]")
	@CacheLookup
	WebElement mobiles;
	
	@FindBy(how=How.XPATH, using="//*[@id=\\\"HTML1\\\"]/div[1]/table/tbody")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"HTML4\"]/div[1]/button")
	@CacheLookup
	WebElement newTabButton;
	
	
//--------------------COMMMON METHODS------------------------------------------------------------------------------
	
	//Handle dropdown for country
	public void selectContryDropDown(String value)
	{
	    BasePage.jsScrollToElement(driver, country);
		Select db  = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
		db.selectByVisibleText(value);
	}
	
	//Print all dropdown values for country
	public void getDropDownOptions()
	{
		BasePage.jsScrollToElement(driver, country);
		Select db  = new Select(driver.findElement(By.xpath("//*[@id=\"colors\"]")));
		List<WebElement> allOptions = db.getOptions();
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
	    }
	}
	
	
	//Handle dropdown for colors
	public void selectColorsDropDown(String value)
	{
	    BasePage.jsScrollToElement(driver, colors);
		Select db  = new Select(driver.findElement(By.xpath("//*[@id=\"colors\"]")));
		db.selectByVisibleText(value);
	}
	
	//Handle drop down for sorted list animals
	public void selectSortedListDropDown(String value)
	{
	    BasePage.jsScrollToElement(driver, sortedList);
		Select db  = new Select(driver.findElement(By.xpath("//*[@id=\"animals\"]")));
		db.selectByVisibleText(value);
	}
    
	// Print full table data
	public static void readFullTable(WebDriver driver)
	{
		WebElement table = driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody")); 
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// print complete table data 
		for (WebElement row : rows) { 
	        List<WebElement> cols = row.findElements(By.tagName("td"));     
	    for (WebElement col : cols) {            
	             System.out.print(col.getText() + "\t"); 
	           } 
	        System.out.println();
		}
	}
	
	//Print specific column details in a table 
	public static void readColumnInTable(WebDriver driver)
	{
		WebElement table = driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody")); 
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowsCount = rows.size();
		// print specific column data by altering xpath like below. 
	     for (int i=2; i<=rowsCount; i++)
	     {
	    	 String names= driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+i+"]/td[2]")).getText();
	    	 System.out.print(names + "\t");
	     }
	     System.out.println();
	}
	
	
	
	
	
//---------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
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
		
	
	public String verifyHomePageLabelIsDisplayed()
	{
		BasePage.jsScrollToElement(driver, homePageLabel);
		BasePage.verifyLabelIsDisplayed(driver, homePageLabel);
		return homePageLabel.getText();
	}
	
	public String getText_HomePageSubHeader()
	{
		return homePageSubHeader.getText();
		
	}
	
	
	
	
	public void mouseHoverClickMobile()
	{
		BasePage.jsScrollToElement(driver, pointMe);
		BasePage.mouseHoverClick(driver, pointMe, mobiles);
	}
	
	public void jsClickHomePagePromptAlert()
	{
		BasePage.jsClick(driver, homePagePromptAlert);
	}
	
	
	public void actClickHomePageConfirmationtAlert()
	{
		BasePage.actClick(homePageConfirmationptAlert, driver);
	}
	
	
	public void implicitWaitAndClickHomePagePromptAlert()
	{
		BasePage.implicitWaitAndClick(driver, homePagePromptAlert, small_Wait);
	}
	
	public void explicitWait_IsDiplayed_HomePageLabel()
	{
		BasePage.explicitWait_IsDiplayed(driver, homePageLabel, small_Wait);
	}
	
	public void explicitWaitAndClickHomePageConfirmationtAlert()
	{
		BasePage.explicitWaitAndClick(driver, homePageConfirmationptAlert, small_Wait);
	}
	
	public void fluentWaitAndClickHomePageConfirmationtAlert()
	{
		BasePage.fluentWaitAndClick(driver, homePageConfirmationptAlert, medium_Wait);
	}
	
	public void jsScrollToElementAndClick_homePagePromptAlert()
	{
		BasePage.jsScrollToElementAndClick(driver, homePagePromptAlert);
	}
	
	
	public void clickUploadSingleFile()
	{
		BasePage.actMoveToElement(driver, uploadSingleFile);
		uploadSingleFile.click();
	}
	
	public void actClick_ClickUploadSingleFile()
	{
		BasePage.actMoveToElementAndClick(driver, uploadSingleFile);
	}
	
	public void actDoubleClick_wednesdayCheckbox()
	{
		BasePage.actDoubleClick(driver, wednesdayCheckbox);
	}
	
	public void clickSimpleAlert() throws InterruptedException
	{
		simpleAlert.click();
		BasePage.handleSimpleAlert(driver, small_Wait);
	}
	
	public void clickConfirmationAlert() throws InterruptedException
	{
		confirmationAlert.click();
		BasePage.handleConfirmationAlert(driver, small_Wait);
	}
	
	public void clickPromptAlert(String value) throws InterruptedException
	{
		promptAlert.click();
		BasePage.handlePromptAlert(driver, small_Wait, value );
	}
}
