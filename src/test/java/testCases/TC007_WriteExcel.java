package testCases;

import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TC007_WriteExcel extends BaseClass{
	HomePage hp=new HomePage(driver);
	BasePage bp=new BasePage(driver);
	
@Test
public void verifWriteExcel() throws InterruptedException, IOException
{	     
	
//		// workbook object
//	        XSSFWorkbook workbook = new XSSFWorkbook();
//	     // spreadsheet object
//	        XSSFSheet spreadsheet = workbook.createSheet("Test Execution Results");
//	        
//	        // creating a row object
//	        XSSFRow row;
//	        
//	        String name="SunilReddy";
//	        int number=123456789;
//	       
//	        
//	     // This data needs to be written (Object[])
//	        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
//	        studentData.put("1", new Object[] { "Test Name", "Opportunity Number", "Quote Number", "Execution Status" });
//	        studentData.put("2", new Object[] { "Testone", Integer.toString(number), name,"Pass" });
//	        studentData.put("3", new Object[] { "Testtwo",Integer.toString(number), name, "Pass" });
//	        Set<String> keyid = studentData.keySet();
//
//	        int rowid = 0;
//	     // writing the data into the sheets...
//	        for (String key : keyid) 
//	        {
//	        	row = spreadsheet.createRow(rowid++);
//	            Object[] objectArr = studentData.get(key);
//	            int cellid = 0;
//
//	            for (Object obj : objectArr) 
//	            {
//	                Cell cell = row.createCell(cellid++);
//	                cell.setCellValue((String)obj);
//	            }
//	        }
//	        // .xlsx is the format for Excel Sheets...
//	        // writing the workbook into the file...
//	    	// Now you can do whatever you need to do with it, for example copy somewhere
//			String timeNote=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//			
//	        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\Test_Results"+"_"+timeNote+".xlsx"));
//	        workbook.write(out);
//	        out.close();
	   
            
	
	
	
		
	
			String str="My Test";
            int opptynum=98453;
            int quotenum=63609833;
            String exeRes="Pass";	
	        bp.writeExcelTestResults(driver, str, opptynum, quotenum, exeRes);
}

}