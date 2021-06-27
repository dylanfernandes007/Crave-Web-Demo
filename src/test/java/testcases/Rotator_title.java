package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Rotator_title {  //Trending now
	
	public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	driver.get("https://www.crave.ca/");
	driver.manage().window().maximize();
	
	js.executeScript("window.scrollBy(0,500)");
	driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div[3]/div/div/div[1]/div/a/div")).click();
	//driver.findElement(By.xpath("//a[contains(text(),'Trending Now')]")).click();/ this did not work
	System.out.println("Test Passed");
	//driver.findElement(By.xpath("//span[@class='icon icon-chevron-left']")).click();
	System.out.println("Test Passed1");
	
}
}