package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class imageURLs {
    ChromeDriver driver;

    public imageURLs() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        // driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));

    }

    public void endTest() {
        System.out.println("Closing the browser");
        driver.quit();

    }

    public void testCase01() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
            System.out.println("Start Test case: BMS Image URLs");
            // Enter URL https://in.bookmyshow.com/explore/home/chennai
            driver.get("https://in.bookmyshow.com/explore/home/chennai");
            Thread.sleep(3000);

            // Locate the elements in recommended movies and store it in a list Using Locator "XPath"
            // *[@id="super-container"]/div[2]/div[3]/div[1]/div[7]/div/div/div/div[2]/div/div[1]/descendant::img
            // Using loop store webelemnt of all elements
             
            // Inside the loop print the url .getAttribute("src");
            // Run loop for length of list
            driver.findElement(By.xpath("//div[contains(@class,'fQuapp')]")).click();
            Thread.sleep(3000);
            List<WebElement> urlList= driver.findElements(By.xpath("//div[contains(@class,'kNWDcM')]/div//img"));
            for (WebElement element : urlList) {
                String name = element.getAttribute("alt");
                String url=element.getAttribute("src");
                System.out.println("URL of the movie "+name.toUpperCase()+" is :"+url);
                System.out.println();
            }
            // locate the elmeent (2nd div of premier ) Using Locator "XPath"
            // //*[@id="super-container"]/div[2]/div[3]/div[1]/div[6]/div/div/div/div[2]/div/div[1]/child::a[2]/descendant::h3
            // print text using get text
            // Locate the element conataining language of 2nd premier movie Using Locator
            // "XPath"
            // //*[@id="super-container"]/div[2]/div[3]/div[1]/div[6]/div/div/div/div[2]/div/div[1]/child::a[2]/descendant::div[@class='sc-7o7nez-0
            // veMGd']
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            List<WebElement> targetElement= driver.findElements(By.xpath("//h2"));

            for (WebElement element : targetElement) {
                if(element.getText().equalsIgnoreCase("Premieres")){
                    jsExecutor.executeScript("arguments[0].scrollIntoView();", targetElement);
                }
            }
            // Actions action = new Actions(driver);
            // action.moveToElement(targetElement);
            Thread.sleep(3000);
            WebElement premierSecondMovie= driver.findElement(By.xpath("//div[contains(@class,'ggjljY')]/a[2]//img"));
            String nameOfMovie=premierSecondMovie.getAttribute("alt");
            System.out.println("Name of the 2nd premier movie is :"+nameOfMovie);

            WebElement languageOfMovie= driver.findElement(By.xpath("//div[contains(@class,'ggjljY')]/a[2]/div/div[3]/div[2]/div"));
            String language= languageOfMovie.getText();
            System.out.println("Language of 2nd premier movie is :"+language);
            // print text using get text
            
            System.out.println("End Test case: BMS Image URLs");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
