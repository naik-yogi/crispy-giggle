package main.java.demo;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class AmazonSearch {
    ChromeDriver driver;
    public AmazonSearch()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void endTest()
    {
        System.out.println("Closing the browser");
        driver.quit();

    }

    
    public  void testCase01(){ try {
        System.out.println("Start Test case: Amazon Search");
        driver.get("https://www.google.com/");
        WebElement searchBox= driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("amazon");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        boolean displayed =driver.findElement(By.xpath("//a[contains(@href,'amazon.in')]")).isDisplayed();
        if(displayed){
            System.out.println("Found the link");
        }else{
            System.out.println("No link is found");
        }
        System.out.println("End Test case: Amazon Search");      
    } catch (Exception e) {
        System.out.println(e);
    
    }
}
}

