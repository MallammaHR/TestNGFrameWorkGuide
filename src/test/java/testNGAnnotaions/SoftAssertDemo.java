package testNGAnnotaions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDemo 
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
		//boolean userNamedispalyed=driver.findElement(By.xpath("//a[text()='Home']")).isDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle,expectedTitle, "User Name is not displayed");
		driver.quit();
		softAssert.assertAll();//i should use this softAssert at the end of test method ,
								//SO that it will give final assertion check and it report if any failure
								//if we don't use softassert.all, then it mark our test method as passed and 
								//it will not give not give any assertion failure report
								//should be the last statement of the test method
								//even if the execution fails it will execute the remaining statements of the current test method
	}							
	
}
