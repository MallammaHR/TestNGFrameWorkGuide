package testNGAnnotaions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertDemo 
{
	WebDriver driver;
	//@Test(dataProvider = "TestData", dataProviderClass = DataProviderDemoSupplier.class)
	@Test()
	public void lunchrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("Taanya");
		driver.findElement(By.name("password")).sendKeys("MALLU@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		String actualTitle=driver.getTitle();
		System.out.println("The actual title of the webpage is : "+actualTitle);
		String expectedTitle="CRMRO";
		Assert.assertEquals(actualTitle,expectedTitle, "Title is not matching");
		Thread.sleep(2000);
		driver.quit();
	}
}
