package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login_BDU {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
       
        driver.get("https://crave.ca");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        
        
      
       // driver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div/div/login-register/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div[3]/div/a/div")).click();
       
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        
        driver.findElement(By.xpath("(//*[contains(text(),'Through my')])[1]")).click();
        
        
        System.out.println("Test passed");
       // driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/div/div/div[2]/ol")).click();
        driver.findElement(By.xpath("//*[@id=\"searchString\"]")).sendKeys("guest");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/div/div/div[2]/ol/li/a/img")).click();
        

        driver.findElement(By.id("username")).sendKeys("manisha9");
        driver.findElement(By.id("password")).sendKeys("manisha");
        
        driver.findElement(By.id("login")).click();
        
        
        
        
       
         

        
	}

}
