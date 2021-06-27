package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Search {
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.crave.ca/");
		driver.manage().window().maximize();
		System.out.println("Test Passed");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div[2]/section/div[1]/form/div/div[1]/i")).click();
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div[2]/section/div[1]/form/div/div[2]/input")).sendKeys("Game of Thrones");

		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/header/div/div[2]/section/div[2]/div/div[1]/a/span"))).click();;
		
	    
	
	    Actions a= new Actions(driver);
		//driver.findElement(By.xpath("//*[@id="__next"]/div/header/div/div[2]/section/div[2]/div/div[1]/a/span")).click();
		WebElement mainmenu=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div[2]/section/div[2]/div/div[1]/a/span"));
		a.moveToElement(mainmenu).build().perform();
		 mainmenu.click();
		
		
	}}

