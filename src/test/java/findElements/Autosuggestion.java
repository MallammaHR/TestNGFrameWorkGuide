package findElements;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestion {
    private WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    
    public void setup() 
    {
        WebDriverManager.firefoxdriver().setup();
        
        driver = new FirefoxDriver();
        
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testAutoSuggestions() throws InterruptedException
    {
        driver.get("https://www.google.com/");

        String searchQuery = "selenium";
        By searchInput = By.name("q");
        By autoSuggestion = By.xpath("//ul[@role='listbox']//span[contains(text(), '" + searchQuery + "')]");

        driver.findElement(searchInput).sendKeys(searchQuery);
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(autoSuggestion));

        Thread.sleep(2000);

        List<WebElement> suggestions = driver.findElements(autoSuggestion);
        int count = suggestions.size();
        System.out.println("Number of auto-suggestions: " + count);

        for (WebElement suggestion : suggestions) {
            String text = suggestion.getText();
            System.out.println(text);
        }
    }

    @AfterMethod
    public void cleanup() 
    {
        driver.quit();
    }
}