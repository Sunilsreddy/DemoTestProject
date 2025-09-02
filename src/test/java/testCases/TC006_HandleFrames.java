package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC006_HandleFrames extends BaseClass{
	HomePage hp=new HomePage(driver);
	BasePage bp=new BasePage(driver);
	
	
@Test
	
	public void verifFrames() throws InterruptedException
	{
	driver.navigate().to("https://ui.vision/demo/webtest/frames/");
	Thread.sleep(3000);
//	
//	
//	 WebElement frameElement = driver.findElement(By.xpath("/html[1]/frameset[1]/frame[1]"));
//	 driver.switchTo().frame(frameElement);
//	 driver .findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome sunil");
//	 Thread.sleep(5000);
//	
//	 driver.switchTo().defaultContent();
//	//input[@name='mytext1']

	 //Switch to frame
	 hp.switchToFrame(driver);
	 //perform the operation
	 driver .findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome sunil");
	 Thread.sleep(5000);
	 //switch to main window from frame
	 hp.switchToMainWindowFromFrame(driver);
	 
	
	 
	 
	 
////-------Below code is example for multiple frame or nested frames options----------------------------
//	 WebElement frameElement = driver.findElement(By.xpath("//frameset//frameset//frame[2]"));
//	 driver.switchTo().frame(frameElement);
//	 //Again switch to 0 index subframe in mainframe
//	 driver.switchTo().frame(0);	 
//	 WebElement elem = driver .findElement(By.xpath("//*[@id=\\\"i9\\\"]/div[3]/div"));
//	 bp.jsClick(driver, elem);
//	 Thread.sleep(5000);	
//	 driver.switchTo().defaultContent();
////-----------------------------------------------------------------------------------------------------
//	 
//	 
	  
	}

}
