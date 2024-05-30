package testNGAnnotaions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ParametrizationTestNG
{
	public WebDriver driver;
	
	@BeforeTest
	public void IntialBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
	}
		
	@Test
	public void launchBrowser() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
	}
	
	@Test(dataProvider = "logindata",dataProviderClass = ParametrizationTestNGWithDataProviderSuuplier.class)
 	public void testMethod(String un,String pw) throws InterruptedException
	{
		//driver.findElement(By.name("q")).sendKeys("seleniumhq");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(un);
		driver.findElement(By.id("pass")).sendKeys(pw);
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
//		String actualTitle = driver.getTitle();
//		String expectedTitle="Facebook";
//		
//		Assert.assertEquals(actualTitle,expectedTitle,"Title didnot Match");
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}		

}


//String xpath="//span[text()='selenium']/b[text()='hq']";
//List<WebElement> allSuggestions = driver.findElements(By.xpath(xpath));
//
//for(WebElement sugestion:allSuggestions)
//{
//	String text=sugestion.getText();
//	if(text.equals("seleniumhq"))
//	{
//		sugestion.click();
//		break;
//	}
//}
