package testCases;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC008_FileUpload extends BaseClass{
	HomePage hp=new HomePage(driver);
	BasePage bp=new BasePage(driver);

@Test
	
	public void verifFileUpload() throws InterruptedException
	{
	driver.navigate().to("https://davidwalsh.name/demo/multiple-file-upload.php");
	Thread.sleep(3000);
	
//	//Single file upload
//	driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\uploadTest_1.txt");
//	Thread.sleep(3000);
	
//	//Multiple file upload 
//	String file1="C:\\Users\\uploadTest_1.txt";
//	String file2="C:\\Users\\uploadTest_2.txt";
//	driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
//	Thread.sleep(3000);
		
	
	String fileLocation="C:\\Users\\uploadTest_1.txt";
	hp.fileUpload(driver, fileLocation);
	Thread.sleep(3000);
	
//	String fileLocation1="C:\\Users\\uploadTest_1.txt";
//	String fileLocation2="C:\\Users\\uploadTest_2.txt";
//	hp.fileUploadMultiple(driver, fileLocation1,fileLocation2);
//	Thread.sleep(3000);
	
	
	}

}
