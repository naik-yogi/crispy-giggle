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

public class NestedFrames {
    ChromeDriver driver;

    public NestedFrames() {
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
            System.out.println("Start Test case: Nested Frames");
            driver.get("https://the-internet.herokuapp.com/nested_frames");
            // switching to top frame
            driver.switchTo().frame("frame-top");
            //switching to left frame
            driver.switchTo().frame("frame-left");
            System.out.println(driver.findElement(By.xpath("//body")).getText());
            //switching back to top frame
            driver.switchTo().parentFrame();
            //switching to middle frame
            driver.switchTo().frame("frame-middle");
            System.out.println(driver.findElement(By.xpath("//body")).getText());
            //switching back to top frame
            driver.switchTo().parentFrame();
            //switching to right frame
            driver.switchTo().frame("frame-right");
            System.out.println(driver.findElement(By.xpath("//body")).getText());
            //switching to default frame
            driver.switchTo().defaultContent();
            //switching to bottom frame
            driver.switchTo().frame("frame-bottom");
            System.out.println(driver.findElement(By.xpath("//body")).getText());
            //switching to default frame
            driver.switchTo().defaultContent();
            System.out.println("End Test case: Nested Frames");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}

