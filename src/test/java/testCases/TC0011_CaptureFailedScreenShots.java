package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.io.File;
import org.apache.commons.io.FileUtils;

import pageObjects.BasePage;

public class TC0011_CaptureFailedScreenShots extends BaseClass {
	BasePage bp=new BasePage(driver);
	

	//public static void main(String[] args) throws InterruptedException
	@Test
	public void methodA() throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		//bp.captureScreenshot(driver);
		driver.findElement(By.xpath("//input[@id='email']asdf")).sendKeys("welcome");
		
		
		Thread.sleep(3000);
		driver.close();	
		}
	
	@AfterMethod()
	public void captureFailedScreenshot(ITestResult result) throws IOException
	{
		{   System.out.print((result.getStatus()-1));
			System.out.print(ITestResult.FAILURE);
			if (ITestResult.FAILURE==(result.getStatus()-1)){
				try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String screenshotName = "FailedScreenShot_"+result.getName()+"_" + System.currentTimeMillis() + ".png";
            File destination = new File(".\\screenshots\\" + screenshotName); // Create a 'screenshots' folder in your project
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot captured for failed test: " + result.getName());
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }	
	   }
	}
  }


}
