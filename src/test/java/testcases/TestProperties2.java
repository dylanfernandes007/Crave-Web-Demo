package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestProperties2 {
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log= Logger.getLogger(TestProperties2.class.getSimpleName());
	
	
	public static void quit() {
		driver.quit();
	}

	
	public static void click(String locator){
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_CSS"))	{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		    log.info("clicking on an element" +locator);
		
	}
 
	public static void type(String locator, String value) {
		
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_CSS"))	{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		log.info("Typing in an Element : " + locator+"  entered the value as : "+value);
      }
	
	
	
	public static void main(String[] args) throws IOException
	{
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");//imported log4j from here
		
         fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
        OR.load(fis);
        log.info("OR properties loaded");
        
       
        fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
        config.load(fis);
        log.info("Config properties loaded");
        
        
       // System.out.println(OR.getProperty("email_XPATH"));
      //  System.out.println(config.getProperty("testsiteurl"));
        
        if(config.getProperty("browser").equals("chrome"))
        {
        	WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
        	 log.info("Chrome browser launched");
        }
        else if(config.getProperty("browser").equals("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
        	driver = new FirefoxDriver();
        	 log.info("Firefox browser launched");
        }
        
       driver.get(config.getProperty("testsiteurl"));
       log.info("Navigated to :" +config.getProperty("testsiteurl"));
        
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
       
      // driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys("trainer@way2automation.com");
       //driver.findElement(By.id(OR.getProperty("password_ID"))).sendKeys("hdgJH");
       
      type("email_XPATH","trainer@way2automation.com");
      type("password_ID","hdgsjha");
      click("loginBtn_CSS");	
      quit();
	}
}
