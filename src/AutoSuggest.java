import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoSuggest {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.ksrtc.in");
        driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys("BENG");
//        driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys(Keys.DOWN);

        //JavaScript HTML DOM can extract hidden elements
        //Because Selenium cannot identify any hidden or ajax elements
        //Investigate the properties of object if it has any hidden elements
        //Selenium created an API to execute javascript elements - Javascript Executor

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"fromPlaceName\").value";
        String text = (String) js.executeScript(script);
        System.out.println(text);
        int i = 0;

        while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {

            i++;
            driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys(Keys.DOWN);
            Thread.sleep(1000);
            text = (String) js.executeScript(script);
            if (i > 10) {
                break;
            }
        }
        if(i > 10) {
            System.out.println("Element not found");
        }
        else {
            System.out.println("Test passed");
        }

        driver.quit();
    }
}
