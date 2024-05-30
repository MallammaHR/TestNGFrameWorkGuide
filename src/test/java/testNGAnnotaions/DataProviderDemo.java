
package testNGAnnotaions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo 
{
	WebDriver driver;
	//@Test(dataProvider = "TestData", dataProviderClass = DataProviderDemoSupplier.class)
	@Test(dataProvider = "testdata")
	public void lunchrowser(String username,String password) throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
//		boolean loginsucesfful = driver.findElement(By.xpath("//a[text()='Home']")).isDisplayed();
//		 Assert.assertTrue(loginsucesfful, "Login failed for username: " + username);
//		driver.quit();
	}
	
	@DataProvider(name="testdata",parallel = true)
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="Taanya";
		data[0][1]="MALLU@123";
		
		data[1][0]="Taanya";
		data[1][1]="Mallu123";
		
		return data;
	}

}
