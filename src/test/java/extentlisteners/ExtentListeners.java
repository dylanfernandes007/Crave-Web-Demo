package extentlisteners;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

//import utilities.TestUtil;


// just added the methods so that I dont get errors

public class ExtentListeners implements ITestListener {

	static Date d = new Date();//current timestamp
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";// this will create new report every time

	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	
	public static ExtentTest test;
/*
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
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

	public void onTestStart(ITestResult result) {

	
		 test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
      
        

	}

	public void onTestSuccess(ITestResult result) {// method name, markup

		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);
		

	}

	public void onTestFailure(ITestResult result) {// screenshot

		try {
		TestUtil.captureScreenshot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(excepionMessage);
		
	
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " FAILED"+"</b>";		
	
		try {
			
			String screenshot = TestUtil.fileName;
			test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
				// build will generate ss// code for capturing ss, b is bold, <br> is new line
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);
		
		

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
/*		}
 */
		

	}


