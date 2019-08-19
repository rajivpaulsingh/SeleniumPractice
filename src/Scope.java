import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scope {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("http://www.qaclickacademy.com/practice.php");

        //1. Total number of links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. Total number of links only in the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //3. Total number of links only in the first column of the footer section
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //4. Clicking on all the links in the footer column section
        for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

            String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
            Thread.sleep(2000);

        }
        //5. Get the title of all the opened tabs
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext()) {

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }

        driver.quit();

    }
}
