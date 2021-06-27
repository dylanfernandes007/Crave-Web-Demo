package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ant902879\\Desktop\\study\\Batch10thOct2020Selenium2\\SeleniumTesting\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        
        
        driver.get("https://crave.ca");
        driver.manage().window().maximize();
        
       // driver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div/div/login-register/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/div[4]/div/a/div")).click();
       
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        
        driver.findElement(By.xpath("(//*[contains(text(),'Through my')])[1]")).click();
 
       // driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/div/div/div[2]/ol")).click();
        driver.findElement(By.xpath("//*[@id=\"searchString\"]")).sendKeys("guest");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/div/div/div[2]/ol/li/a/img")).click();
        

        driver.findElement(By.id("username")).sendKeys("manisha9");
        driver.findElement(By.id("password")).sendKeys("manisha");
        
        driver.findElement(By.id("login")).click();
        
        driver.switchTo().activeElement();
        
    	
	/*	WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/button[1]/div/div/span/img"))).click();;
		
        System.out.println("test pls");
        if(driver.getPageSource().contains("Choose your profile")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}
		*/
		     Actions a= new Actions(driver);
			//driver.findElement(By.xpath("//*[@id="__next"]/div/header/div/div[2]/section/div[2]/div/div[1]/a/span")).click();
			WebElement mainmenu=driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/button[1]/div/div/span/img"));
			a.moveToElement(mainmenu).build().perform();
			 mainmenu.click();
        
		
	}

}
