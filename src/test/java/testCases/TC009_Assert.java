package testCases;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TC009_Assert {
	
	public static void main(String[] args)
	{
		
		//Different Hard asserts statements
				Assert.assertEquals("xyz", "xyz");
				Assert.assertEquals(123, 123);		
				Assert.assertNotEquals("xyz", 123);
				Assert.assertTrue(true);
				Assert.assertTrue(1==1);
				System.out.println("Checking hard assertions");

//Hard Assert- will stop the execution of test script flow, if the condition fails, so try to use Soft asserts.
//Soft Assert- will complete test script execution, but in the console you can see which soft assert condition got failed.
//sa.assertAll - this method is mandatory to close soft asserts in the class
				
				
		//Different Soft assert statements
				SoftAssert sa=new SoftAssert();
				sa.assertEquals("xyz", "xyz");
				sa.assertEquals(123, 123);
				sa.assertNotEquals("xyz", 123);
				sa.assertTrue(true);
				sa.assertTrue(1==1);
				System.out.println("checking soft assertions");				
		//Mandatory step to close soft assertions
				sa.assertAll(); //Mandatory for soft assert ending
	}

}
