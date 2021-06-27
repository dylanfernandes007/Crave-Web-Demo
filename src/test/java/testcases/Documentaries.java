package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Documentaries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
	       WebDriver driver =new ChromeDriver();
		driver.get("https://www.crave.ca/");
		driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     WebElement element = driver.findElement(By.linkText("TV Shows"));
	     
	     Actions action = new Actions(driver);
	     action.moveToElement(element).build().perform();
	     driver.findElement(By.linkText("Documentary")).click();
	     
	 	js.executeScript("window.scrollBy(0,2000)");
	 	
	 	 driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div[4]/button")).click();// load more button
	     System.out.println("Test Passed");
	     
	     

	}

}
