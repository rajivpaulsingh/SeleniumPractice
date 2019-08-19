import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TableSort2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("tr th:nth-child(3)")).click();
        driver.findElement(By.cssSelector("tr th:nth-child(3)")).click();

        List<WebElement> firstColList = driver.findElements(By.cssSelector("tr td:nth-child(3)"));
        sortColumn(firstColList, "asc", "integers");

    }

    public static void sortColumn(List<WebElement> firstColList, String order, String format) {

        ArrayList<String> originalList = new ArrayList<String>();
        for (int i = 0; i < firstColList.size(); i++) {
            originalList.add(firstColList.get(i).getText());
        }

        ArrayList<String> copiedList = new ArrayList<String>();
        for (int i = 0; i < originalList.size(); i++) {
            copiedList.add(originalList.get(i));
        }

        System.out.println("*****************************");
        if (format.equalsIgnoreCase("integers")) {
            Arrays.sort(copiedList.toArray());
            if (order.equalsIgnoreCase("desc")) {
                Arrays.sort(copiedList.toArray(), Collections.reverseOrder());
            }

        } else {

//string
            Collections.sort(copiedList);
            if (order.equalsIgnoreCase("desc")) {
                Collections.reverse(copiedList);
            }
        }

        for (String s : originalList) {
            System.out.println(s);
        }

        for (String s : copiedList) {
            System.out.println(s);
        }

        Assert.assertTrue(originalList.equals(copiedList));

    }
}