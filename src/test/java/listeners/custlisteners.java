package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.w2a.base.baseclass;

public class custlisteners extends baseclass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	//	System.out.println("Successfully Executed Test Cases");
		//screenS(result.getMethod().getMethodName());
	
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Faild Test");
		screenS(result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	

}
