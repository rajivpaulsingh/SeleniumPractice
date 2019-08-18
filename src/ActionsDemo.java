import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionsDemo {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList'"))).build().perform();
        driver.findElement(By.linkText("Your Account")).click();

        //Capital words and double click
        a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //Right Click
        a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList'"))).contextClick().build().perform();
//        driver.quit();

    }
}
