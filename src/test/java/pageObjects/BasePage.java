package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
	
	
	
	
	//----COMMON METHODS-----------------------------------------------------------------------------------------
	//Java script click on element
	public static void jsClick(WebDriver driver, WebElement elementToClick) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
			}
	
    //Actions click on element
	public static void actClick(WebElement elementToClick, WebDriver driver) {
		Actions ob = new Actions(driver);
		ob.moveToElement(elementToClick).click().build().perform();
	}
	
	//Implicit wait
	public static void implicitWait(WebDriver driver, int wait_sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_sec));
	}
	
	//Implicit wait and click on element
	public static void implicitWaitAndClick(WebDriver driver, WebElement elementToClick, int wait_sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_sec));
		elementToClick.click();
	}
	
	//Explicit wait for the element to be displayed
	public static void explicitWait_IsDiplayed(WebDriver driver, WebElement element, int wait_sec)
	{
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(d -> element.isDisplayed());
	}
	
	//Explicit wait for the element to be displayed and click
	public static void explicitWaitAndClick(WebDriver driver, WebElement elementToClick, int wait_sec)
	{
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(d -> elementToClick.isDisplayed());
	    elementToClick.click();
	}
	
	//Fluent wait for the element to be displayed
	public static void fluentWait_IsDiplayed(WebDriver driver, WebElement element, int wait_sec)
	{
		Wait<WebDriver> wait = new FluentWait<>(driver)
							       .withTimeout(Duration.ofSeconds(wait_sec))
				                   .pollingEvery(Duration.ofMillis(300))
				                   .ignoring(NoSuchElementException.class);
		wait.until(d -> element.isDisplayed());
	}
	
	//Fluent wait for the element to be displayed and click
	public static void fluentWaitAndClick(WebDriver driver, WebElement elementToClick, int wait_sec)
	{
		Wait<WebDriver> wait = new FluentWait<>(driver)
							       .withTimeout(Duration.ofSeconds(wait_sec))
				                   .pollingEvery(Duration.ofMillis(300))
				                   .ignoring(NoSuchElementException.class);
		wait.until(d -> elementToClick.isDisplayed());
	    elementToClick.click();
	}
	
	
	//Java script to scroll to the element
	public static void jsScrollToElement(WebDriver driver, WebElement element)
	{
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//Java script to scroll to the element and click
	public static void jsScrollToElementAndClick(WebDriver driver, WebElement element)
	{
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 element.click();
	}
	
	//Actions class to move to the element
	public static void actMoveToElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);	
	    actions.moveToElement(element).perform();
	}
	
	//Actions class to move to the element and click
	public static void actMoveToElementAndClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);	
	    actions.moveToElement(element).click().build().perform();
	}
	
	//Actions class for double click
	public static void actDoubleClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);	
	    actions.moveToElement(element).doubleClick().build().perform();
	}
	
	// Normal alert with only OK button
	public static void handleSimpleAlert(WebDriver driver, int wait_sec) throws InterruptedException
		{		   
	    Alert alert = driver.switchTo().alert();
	    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(ExpectedConditions.alertIsPresent());
	    System.out.print(alert.getText());
	    alert.accept();
	    }
	
	
	//Confirmation alert with Ok and Cancel options
	public static void handleConfirmationAlert(WebDriver driver, int wait_sec) throws InterruptedException
	{		   
    Alert alert = driver.switchTo().alert();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
    wait.until(ExpectedConditions.alertIsPresent());
    System.out.print(alert.getText());
    alert.accept();
    //alert.dismiss();
    }
	
	//Prompt alert with input dialouge box options
		public static void handlePromptAlert(WebDriver driver, int wait_sec, String value) throws InterruptedException
		{		   
	    Alert alert = driver.switchTo().alert();
	    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(ExpectedConditions.alertIsPresent());
	    System.out.print(alert.getText());
	    alert.sendKeys(value);
	    alert.accept();
	   //alert.dismiss();
	    }
		
		// Verify page label or header values
		public static boolean verifyLabelIsDisplayed(WebDriver driver, WebElement element ) 
		{
			try
			{
				return(element.isDisplayed());
			}
			catch(Exception e)
			{
				return false;
			}
		}
	
}
	
	
