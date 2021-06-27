package extentreports;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestReports {
	
	
	
    public ExtentSparkReporter htmlReporter;// Create HTML file and add basic configuration
    public ExtentReports extent; // attaching reporter and other system info like tester name
    public ExtentTest test;// create test case and add pass fail skip logs
    
    @BeforeTest
    public void setReport() {
    	
    	htmlReporter= new ExtentSparkReporter("./reports/extent.html");// see htmlReporter up
    	// this will be created here
    	
    	htmlReporter.config().setEncoding("utf-8");// standard encoding for html  files
    	htmlReporter.config().setDocumentTitle("w2a automation reports");
    	htmlReporter.config().setReportName("automation test results");
    	htmlReporter.config().setTheme(Theme.STANDARD);// dark color report, 
    	
    	extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);// this is to attach all to the extent report
    	
    	extent.setSystemInfo("Automation tester", "rahul arora");// see extent up
    	extent.setSystemInfo("Organization", "way2automation");
    	extent.setSystemInfo("Build no.", "W2A-1234");
    }
    
    @Test
    public void doLogin() {// to login
    	test = extent.createTest("Login Test");// out it in all methods
    	test.log(Status.INFO, "entering username");
    	test.log(Status.INFO, "entering password");
    	
    	System.out.println("executing Login test");
    	
    }
    @Test
    public void doUserReg() {// to register user
    	test =extent.createTest("User Reg Test");//createTest is to show in report
    	Assert.fail("Failing user reg test");
    	
    }
  
    
    
    @Test
    public void doComposeEmail() {
    	test =extent.createTest("User Reg Test");
    	throw new SkipException("Skipping the test");// when skip, throw
       	
       }
    
    @AfterMethod  // this is called after every test
    public void afterTestCase(ITestResult result) { //afterTestCase was called tearDown before
    	if(result.getStatus() == ITestResult.FAILURE ) {
    		test.log(Status.FAIL, "failed test");
    		Markup m= MarkupHelper.createLabel("failed", ExtentColor.RED);// RED for fail
    		test.fail(m);// test.fail used to show the labels in the report
    		
    	} else if(result.getStatus() == ITestResult.SUCCESS ) {
    		test.log(Status.PASS, "pass test");
    		Markup m= MarkupHelper.createLabel("passed", ExtentColor.GREEN);// GREEN for pass
    		test.pass(m);
    	}
    	 else if(result.getStatus() == ITestResult.SKIP ) {
     		test.log(Status.SKIP, "test skipped");
     		Markup m= MarkupHelper.createLabel("skipped", ExtentColor.YELLOW);// YELLOW skip
    		test.skip(m);
     	}
       	
       
    }
    
    
 
    @AfterTest
    public void endReport() {
    	
    	extent.flush();
    }
  
    
    


}
