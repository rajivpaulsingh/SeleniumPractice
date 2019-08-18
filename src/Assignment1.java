import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        driver.findElement((By.cssSelector("*[id='checkBoxOption1']"))).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("*[id='checkBoxOption1']")).isSelected());
        Thread.sleep(2000);

        driver.findElement((By.cssSelector("*[id='checkBoxOption1']"))).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("*[id='checkBoxOption1']")).isSelected());
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//*[@type='checkbox']")).getSize());
        driver.quit();


    }
}
