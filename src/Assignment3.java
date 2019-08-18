import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Assignment3 {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();

        //Explicit wait to wait for 20 seconds
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("div#results"))));

        System.out.println(driver.findElement(By.cssSelector("div#results")).getText());
        driver.quit();


    }
}
