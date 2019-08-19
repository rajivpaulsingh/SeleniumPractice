import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://www.path2usa.com/travel-companions");

        driver.findElement(By.id("travel_date")).click();

        //April 25
        //Grab the common attribute, put it in list and then do comparison

        //Select month
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")) {

            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        //select date
        List<WebElement> dates = driver.findElements(By.className("day"));
        int count = driver.findElements(By.className("day")).size();

        for(int i = 0; i < count; i++) {

            String text = driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("25")) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }

        Thread.sleep(3000);

        driver.quit();

    }
}
