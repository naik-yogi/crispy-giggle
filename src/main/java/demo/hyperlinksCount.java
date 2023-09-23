package demo;
import java.time.Duration;
import java.util.List;
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


public class hyperlinksCount {
    ChromeDriver driver;
    public hyperlinksCount()
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Start Test case: Hyperlinks Count");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> hyperlinks= driver.findElements(By.tagName("a"));
        int count = hyperlinks.size();
        System.out.println("count of hyperlinks is :"+count);
        System.out.println("End Test case: Hyperlinks Count");      
    } catch (Exception e) {
        System.out.println(e);
    
    }
}
}

