package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigation {
	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.crave.ca/");
		driver.manage().window().maximize();
		System.out.println("Test Passed");
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/ul/li[3]/a")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in to view"))).click();;
		//driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div/div/div/a")).click();
}
}