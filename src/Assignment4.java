import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Assignment4 {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[@href='/windows']")).click();

        //Clicking on the link to open the new window
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();

        String parentID = it.next();
        String childID = it.next();

        //Switch to child window and print text
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.xpath("/html/body/div/h3")).getText());

        //Switch back to parent window and print text
        driver.switchTo().window(parentID);
        System.out.println(driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText());
        driver.quit();

    }
}
