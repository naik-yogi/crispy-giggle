package demo;

import java.time.Duration;
import java.util.List;
import java.util.Set;
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

public class WindowsHandle {
    ChromeDriver driver;

    public WindowsHandle() {
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
            System.out.println("Start Test case: Windows Handling");
            driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
            String parentWindowHandle = driver.getWindowHandle();
            driver.switchTo().frame("iframeResult");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Try it']")).click();
            Set<String> handlesId= driver.getWindowHandles();
            for (String string : handlesId) {
                if(string!=parentWindowHandle){
                    driver.switchTo().window(string);
                }
            }
            System.out.println("URL of the window is :"+driver.getCurrentUrl());
            System.out.println("URL of the window is :"+driver.getTitle());
            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(parentWindowHandle);
            Thread.sleep(3000);
                
            System.out.println("End Test case: Windows Handling");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}



