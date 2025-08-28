package testCases;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;
import pageObjects.HomePage;

public class TC005_HandleTables extends BaseClass{
	HomePage hp=new HomePage(driver);
	
	
@Test
	
	public void verifTables() throws InterruptedException
	{
	
	WebElement ele = driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody"));
	//WebElement ele = driver.findElement(By.xpath("//*[@id=\"taskTable\"]"));
	BasePage.jsScrollToElement(driver,ele);
	
	WebElement table = driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody")); 
	//WebElement staticTable = driver.findElement(By.xpath("//*[@id=\"taskTable\"]")); 
	
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	int rowsCount = rows.size();
	//System.out.println("Total Rows count in table" + rowsCount);
	
	// print complete table data 
	for (WebElement row : rows) { 
        List<WebElement> cols = row.findElements(By.tagName("td"));     
        //System.out.println("Total Column count in each row" + cols.size());        
    for (WebElement col : cols) {            
             System.out.print(col.getText() + "\t"); 
           } 
        System.out.println();
	}
	 
	
	 // print specific column data by altering xpath like below. 
     for (int i=2; i<=rowsCount; i++)
     {
    	 String authorNames= driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+i+"]/td[2]")).getText();
    	 System.out.print(authorNames + "\t");
     }
     System.out.println();
     
     
     
  // print specific column data, based on condition if author name = Mukesh then print book names column values
     for (int i=2; i<=rowsCount; i++)
     {
    	 String authorNames= driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+i+"]/td[2]")).getText();
    	 if(authorNames.equals("Mukesh"))
    	 {
    		 String bookNames= driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+i+"]/td[1]")).getText();
    		 System.out.print(bookNames + "\t"+authorNames);
    	 }
    	 System.out.println();    		 
     }
         
     
     // Calculate total price of Price column in table and print
     int totalPrice=0;
     for (int i=2; i<=rowsCount; i++)
     {
    	 String price= driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+i+"]/td[4]")).getText();
    	 totalPrice=totalPrice+Integer.parseInt(price);
     }
     System.out.println(totalPrice); 
     
	 
     
     
     
     //Function calling from homepage class to print table data
     hp.readFullTable(driver);
     hp.readColumnInTable(driver);
}


}