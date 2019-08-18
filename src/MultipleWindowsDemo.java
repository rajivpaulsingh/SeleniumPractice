import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsDemo {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://identity.flickr.com/sign-up");

        driver.findElement(By.xpath("//a[@href='https://www.flickr.com/help/terms']")).click();
        System.out.println("Parent window title -> " + driver.getTitle()); //parent window title

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();

        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
        System.out.println("Child window title -> " + driver.getTitle()); //child window title

        driver.switchTo().window(parentID);
        System.out.println("Parent window title -> " + driver.getTitle()); //parent window title

        driver.quit();
    }
}