import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assignment7 {

    public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.qaclickacademy.com/practice.php");

        //1. Print number of rows and column
        WebElement table = driver.findElement(By.id("product"));
        int rowCount = table.findElements(By.xpath("//table[@id='product']/tbody/tr")).size();
        System.out.println("The row count is -> " + rowCount);

        int columnCount = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size();
        System.out.println("The column count is -> " + columnCount);


        //2. Print the 3rd row
        String value = table.findElement(By.xpath("//table[@id='product']/tbody/tr[4]")).getText();
        System.out.println(value);

        driver.quit();
    }
}
