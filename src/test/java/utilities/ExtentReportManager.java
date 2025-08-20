package utilities;

// Listener class used to generate Extent Reports

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		String repName="Sunil-Reddy-Extent-Report-"+timeStamp+".html";
	
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); //specify location of the report
		
		htmlReporter.config().setDocumentTitle("Automation Report");//title of report
		htmlReporter.config().setReportName("Functional Report");//name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);		
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Sunil");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);
	}
	
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
		
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		ExtentTest test = extent.createTest(tr.getTestClass().getName());
		test.assignCategory(tr.getMethod().getGroups());
		
		test.log(Status.FAIL, tr.getName()+ "got failed");
		test.log(Status.INFO, tr.getThrowable().getMessage());
	
		try {
			String imgPath=new BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
		
			
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}