package testNGAnnotaions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting 
{
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters({"browserName" ,"url"})
	public void LunchBrowser(String browserName,String url) throws InterruptedException
	{
		if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		driver.get(url);
		
	}
	@Test
	@Parameters({"userName","password"})
	public void enterLoginDetails(String userName,String password)
	{
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver; 
		jsExecutor1.executeScript("document.querySelector(\"input[type='submit']\").click();");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.findElement(By.xpath("//input[@type='submit' and @value='Login' and contains(@class, 'btn') and contains(@class, 'btn-small')]")).click();
	}
	
	@AfterTest
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
	}
}
