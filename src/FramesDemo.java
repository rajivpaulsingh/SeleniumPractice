import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class FramesDemo {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/draggable/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        a.dragAndDrop(source, target).build().perform();
        driver.quit();

    }
}