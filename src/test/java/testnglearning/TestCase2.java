package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	
	
	@Test
	public void validateTitle() {
		
		String expected_title = "Gmail.com";
		String actual_title = "Yahoo.com";
		/*
		if(expected_title.equals(actual_title)) {// to compare both in java
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case failed");// this is just a mesg, not failing the TC
		}
		*/
	
		System.out.println("Beginning");
		
		// use SoftAssert when u don't want to stop execution in case of failure, no need of try catch
		//for hard assert, we have static methods so dont create object of class
		// for soft assert, non static methods, so create obj of class
		//one test but multiple assertions
		SoftAssert softAssert = new SoftAssert();// soft assert
		
		softAssert.assertEquals(actual_title, expected_title);//1st
		softAssert.assertTrue(false,"Element not present hence failing the test");// check y, didnt understand, its like iselementpresent
		softAssert.fail("Forcefully failing the test");// check 
		
		//check what is the use of the above 3 statements
		System.out.println("Ending");
		
		// if u dont write assertAll, it will not show failures
		//softAssert.assertAll();// this is what shows the failure	
		// Failures: 1 even if actual=expected=gmail
	// sometimes u need hard along with soft
	}
}
