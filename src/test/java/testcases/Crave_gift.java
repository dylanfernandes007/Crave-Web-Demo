package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Crave_gift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.crave.ca/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Gift Crave")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div[4]/div[1]/div/div[2]/div"))).click();;
		
        
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div[4]/div[1]/div/div[2]/div")).click();//25$
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div[5]/a"))).click();;
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div[5]/a")).click();//select button
		
		driver.findElement(By.linkText("Continue as a guest")).click();
		

	}

}
