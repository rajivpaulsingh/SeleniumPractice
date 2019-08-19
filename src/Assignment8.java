import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Assignment8 {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.qaclickacademy.com/practice.php");

        //Auto suggest  "UNITED' go and select United States
        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("UNITED");

        //Using the Javascript HTMP DOM
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementByClass(\"ui-menu-item\").value";
        String text = (String) js.executeScript(script);

        int i = 0;

        while (!text.equalsIgnoreCase("UNITED STATES")) {
            i++;
            driver.findElement(By.cssSelector("input#autocomplete")).sendKeys(Keys.DOWN);
            Thread.sleep(1000);
            text = (String) js.executeScript(script);

            if (i > 5) {
                break;
            }
        }

        String actualText = driver.findElement(By.cssSelector("input#autocomplete")).getText();
        System.out.println(actualText);
        Assert.assertEquals(actualText, "United States");

        driver.quit();
    }
}
