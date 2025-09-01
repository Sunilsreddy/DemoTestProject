package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;
import pageObjects.HomePage;

public class TC0010_FileUploadAutoIT extends BaseClass{
	HomePage hp=new HomePage(driver);
	BasePage bp=new BasePage(driver);

@Test
	
	public void verifFileUploadAutoIT() throws InterruptedException, AWTException
	{
	driver.navigate().to("https://www.foundit.in/uipload");
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();
	Thread.sleep(3000);	
	WebElement ele=driver.findElement(By.xpath("//input[@id='file-upload']"));
	bp.jsClick(driver, ele);
	Thread.sleep(3000);
	
	
//	//Step 1: Copy the file path to the clipboard
//	StringSelection filePath=new StringSelection("C:\\Users\\uploadTest_1.txt");
//	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
//	Thread.sleep(3000);
//	
//	//Step2: Ctrl +V action perform on clipboard
//	Robot rb=new Robot();
//	rb.keyPress(KeyEvent.VK_CONTROL);  //For Mac: rb.keyPress(KeyEvent.VK_META);
//	rb.keyPress(KeyEvent.VK_V);
//	rb.keyRelease(KeyEvent.VK_V);
//	rb.keyRelease(KeyEvent.VK_CONTROL);
//	Thread.sleep(3000);
//	
//	//Step3: click on return/enter key
//	rb.keyPress(KeyEvent.VK_ENTER);
//	rb.keyRelease(KeyEvent.VK_ENTER);
//	Thread.sleep(3000);
	
	
	
	String filePathLocation="C:\\Users\\uploadTest_2.txt";
	hp.fileUploadAutoIT(driver, filePathLocation);
	
	
	
	
	
	}
	
	
}


