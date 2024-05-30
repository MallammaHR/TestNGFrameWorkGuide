package findElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitDemo 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        
        String browserName=options.getBrowserName();
       
        System.out.println("Browser name is : "+browserName);
        
        options.addArguments("--start-maximized");
        
        driver = new ChromeDriver(options);
        
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	@Test
	public void loginApplicatin()
	{
		try 
		{
			driver.get("https://classic.freecrm.com/");
			
			driver.findElement(By.name("username")).sendKeys("Taanya");
			driver.findElement(By.name("password")).sendKeys("MALLU@123");
			
			WebElement loginBTN=driver.findElement(By.xpath("//input[@type='submit']"));
			loginBTN.click();
		
			wait.until(ExpectedConditions.elementToBeClickable(loginBTN));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		String actualTitle=driver.getTitle();
		String expectedTitle="CRMPR";//CRMPRO
		Assert.assertEquals(actualTitle, expectedTitle,"Title did not Match");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
