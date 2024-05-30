package testNGAnnotaions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelWithDataProvider {

    WebDriver driver;

    @Test(dataProvider = "testdata")
    public void launchBrowser(String username, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.get("https://classic.freecrm.com/");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn")));
        loginButton.click();
        
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        System.out.println("The actual title of the webpage is: " + actualTitle);
        String expectedTitle = "CRMPRO";
       // Assert.assertEquals(actualTitle, expectedTitle, "Title is not matching");
        Thread.sleep(2000);
        //driver.quit();
    }

    @DataProvider(name = "testdata",parallel=true)
    public Object[][] getData() {
        Object[][] data = new Object[3][2];

        data[0][0] = "Taanya";
        data[0][1] = "MALLU@123";

        data[1][0] = "Taya";
        data[1][1] = "Taany@123";
        
        data[2][0] = "Taanygssda";
        data[2][1] = "MdsgsdgALLU@123";


        return data;
    }
}