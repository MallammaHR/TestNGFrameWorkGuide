package findElements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTest
{
	 public static  WebDriver driver;
	static  WebDriverWait wait;
    public static void main(String[] args) 
    {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        try 
        {
            driver.get("https://www.google.com/");
            
            driver.findElement(By.name("q")).click();
            
            

            String title = driver.getTitle();
            
            if (title.contains("Google"))
            {
                System.out.println("Page title contains 'Google'.");
            }
            
            else 
            {
                System.out.println("Page title does not contain 'Google'.");
            }

            try
            {
                WebElement crmProElement = driver.findElement(By.xpath("//a[text()='Gmail']"));

                if (crmProElement.isDisplayed()) 
                {
                    System.out.println("Gmail element is displayed.");
                } 
                else 
                {
                    System.out.println("CRMPRO element is not displayed.");
                }
            } 
            catch (Exception e) {
                System.out.println("An error occurred while checking the element: " + e.getMessage());
            }
            

            // Take screenshot
            try 
            {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Path destination = Path.of("C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\SeleniumOverallTestNGFrameWork\\screenshots\\screenshot.png");
                Files.copy(screenshotFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot captured successfully.");
            }
            catch (IOException e)
            {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("An error occurred: " + e.getMessage());
        } 
        finally
        {
            if (driver != null) 
            {
                driver.quit();
            }
        }
    }
}