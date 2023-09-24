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

import com.github.dockerjava.api.model.Frame;

public class IMDBRatings {
    ChromeDriver driver;

    public IMDBRatings() {
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
            System.out.println("Start Test case: IMDB Ratings");
            driver.get("https://www.imdb.com/chart/top/");
            //Highest rated movie on IMDB
            driver.findElement(By.xpath("//select[@id='sort-by-selector']")).click();
            driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[3]")).click();
            Thread.sleep(5000);
            System.out.println("Highested rated movie on IMDB is :"+driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata')]/li/div[2]/div/div/div[1]/a/h3")).getText());

            //Movies in the table
            List<WebElement> allMovies= driver.findElements(By.xpath("//ul[contains(@class,'ipc-metadata')]/li/div[2]/div/div"));
            System.out.println("Number of movies included in the table is :"+allMovies.size());

            //Oldest movie on the list
            driver.findElement(By.xpath("//select[@id='sort-by-selector']")).click();
            driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[4]")).click();
            driver.findElement(By.id("swap-sort-order-button")).click();
            System.out.println("Oldest movie on the list is :"+driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata')]/li/div[2]/div/div/div[1]/a/h3")).getText());

            //Most recent movie on the list
            driver.findElement(By.xpath("//select[@id='sort-by-selector']")).click();
            driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[4]")).click();
            driver.findElement(By.id("swap-sort-order-button")).click();
            System.out.println("Most recent movie on the list is :"+driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata')]/li/div[2]/div/div/div[1]/a/h3")).getText());

            //Movie with most user ratings
            driver.findElement(By.xpath("//select[@id='sort-by-selector']")).click();
            driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[5]")).click();
            System.out.println("Movie with most user ratings :"+driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata')]/li/div[2]/div/div/div[1]/a/h3")).getText());          
          
            System.out.println("End Test case: IMDB Ratings");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}


