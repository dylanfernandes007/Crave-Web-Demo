package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rotator_arrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.crave.ca/");
		driver.manage().window().maximize();
		
		 JavascriptExecutor js= (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div[3]/div/div/div[2]/div[2]")).click();
	}

}
