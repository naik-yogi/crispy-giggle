package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
///
import org.openqa.selenium.support.ui.WebDriverWait;

public class linkedInPost {
    ChromeDriver driver;

    public linkedInPost() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        // driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        

    }

    public void endTest() {
        System.out.println("Closing the browser");
        driver.quit();

    }

    public void testCase01() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("Start Test case: LinkedIn Post");
            driver.get("https://in.linkedin.com/");
            WebElement email = driver.findElement(By.id("session_key"));
            WebElement password = driver.findElement(By.id("session_password"));
            email.sendKeys("naikyogesh620@gmail.com");
            password.sendKeys("12345@YOGESH");
            //clicking on login button
            driver.findElement(By.xpath("//button[normalize-space(text())='Sign in']")).click();
            Thread.sleep(3000);
            //waiting till buttons are clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'profile')]/div/div/span")));
            //finding profile views
            String profileViews = driver.findElement(By.xpath("//a[contains(@href,'profile')]/div/div/span")).getText();
            System.out.println("Count of profile views is :"+profileViews);
            //finding post impressions
            String postImpressions= driver.findElement(By.xpath("//a[contains(@href,'shares')]/div/div/span")).getText();
            System.out.println("Impressions of your post: "+postImpressions);
            //clicking on start a post
            driver.findElement(By.xpath("//button[@id='ember26']")).click();
            //waiting until buttons are clickable
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='share-unified-settings-entry-button']")));
            //clicking on button to change post visibility
            driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']")).click();
            //finding connections only button
            driver.findElement(By.id("CONNECTIONS_ONLY")).click();
            //clicking on done button
            driver.findElement(By.xpath("//div[@class='share-box-footer__main-actions']/button[2]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div/div/div/div[1]")).sendKeys("My first post here");
            //wait until post button is enabled
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='share-box_actions']//button")));
            driver.findElement(By.xpath("//div[@class='share-box_actions']//button")).click();
            


            System.out.println("End Test case: LinkedIn Post");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
