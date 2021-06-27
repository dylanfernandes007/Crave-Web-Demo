package testnglearning;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{
	//listeners are like triggers in sql

	public void onTestStart(ITestResult result) {// no msg??
		// TODO Auto-generated method stub
		
	}
// start, success, failure, skip
	public void onTestSuccess(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output","false");//add this when html is used, 

		Reporter.log("Test case successfully executed");
		
	}
//reportng, guice should be in pom.xml
	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		//to create screenshot
		Reporter.log("<a href=\"C:\\Users\\way2automation\\Desktop\\cyimg.png\" target=\"_blank\">Screenshot link</a>");// use double  slash always when in quotes
		Reporter.log("<a href=\"C:\\Users\\way2automation\\Desktop\\cyimg.png\" target=\"_blank\"><img src=\"C:\\Users\\way2automation\\Desktop\\cyimg.png\" height=200 width=200></a>");
		

		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
