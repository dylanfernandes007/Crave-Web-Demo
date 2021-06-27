package testcases;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnAssertions {

	WebDriver driver;

//Store current project workspace location in a string variable ‘path’

	@BeforeTest
	public void SetDriver() {

//Mention the location of ChromeDriver in localsystem
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void verifyTitle() {
		driver.get("https://www.crave.ca/");
		String ActualTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		String ExpectedTitle = "Crave | Watch HBO, Showtime and Starz Movies and TV Shows Online";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed");
	}

	@AfterTest
	public void closedriver() {

//closes the browser instance
		driver.close();

	}

}