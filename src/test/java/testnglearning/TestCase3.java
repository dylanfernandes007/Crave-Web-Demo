package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	
	
	@Test(priority = 1)
	public void doUserReg() {
		
		System.out.println("Executing User Reg Test");
		Assert.fail("Submit button missing hence failing the test");// hard assert?yes but it inside the method// we are failing it purposefully
		
	}
	
	
	@Test(priority = 2,dependsOnMethods = "doUserReg")
	public void doLogin() {
		
		System.out.println("Executing Login Test");
		
	}
	
	
	@Test(priority = 3)
	public void isSkip() {//remember throw is used here
		
		throw new SkipException("Skipping the test as the condition is not met");
	}
	
	

}
