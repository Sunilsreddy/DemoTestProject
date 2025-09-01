package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    public int retryCount = 0;
    public static final int MAX_RETRY_COUNT = 3; // Define maximum retry attempts

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry
    }
}






/*
Steps to implement Retry Analyser:=
Step1: Create RetryAnalyzer class and give the retry count as 3 times to rerun failed test scripts
Step2: Create RetryListener class and implement ITestAnnotation listner to refer RetryAnalyzer class
Step3: Add below Listner parameters for testng.xml file
        <listeners>
		<listener class-name="utilities.ExtentReportManager"></listener>
		<listener class-name="retryAnalyzer.RetryListener" />
		</listeners>

*/