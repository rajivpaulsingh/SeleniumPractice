import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableSort1 {

    public static void main(String args[]) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
        Thread.sleep(1000);
        List<WebElement> firstColList = driver.findElements(By.cssSelector("tr td:nth-child(2)"));

        //Create array list and store column elements
        ArrayList<String> originalList = new ArrayList<String>();
        for(int i = 0; i < firstColList.size(); i++) {
            System.out.println(firstColList.get(i).getText());
            originalList.add(firstColList.get(i).getText());
        }

        //Copy the array to another array list
        ArrayList<String> copiedList = new ArrayList<String>();
        for(int i = 0; i < originalList.size(); i++) {
            copiedList.add(originalList.get(i));
        }

        //Sort the copied array list
        System.out.println("*******************");
        Collections.sort(copiedList);
        for(String st : copiedList) {
            System.out.println(st);
        }

        //Compare the two arrays to make sure the original was already sorted
        Assert.assertTrue(originalList.equals(copiedList));
    }
}
