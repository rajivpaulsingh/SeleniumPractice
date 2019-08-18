import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SalesForceLoginTest {

    public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait

        driver.get("https://login.salesforce.com/");

        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Login | Salesforce");

        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("xyz");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("xyz");
//        driver.findElement(By.xpath("//*[@id='Login']")).click();
//        driver.findElement(By.cssSelector("*[id='Login']")).click();
        driver.findElement(By.cssSelector("input#Login")).click();

        WebDriverWait d = new WebDriverWait(driver, 20); //explicit wait
        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#Login")));

        driver.quit();

    }
}
