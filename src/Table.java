import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Table {

    public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20284/nz-vs-eng-final-icc-cricket-world-cup-2019");

        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();

        //3rd element in the row
        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
        int sum = 0;

        for(int i = 0; i < count-2; i++) {
            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int valueInt = Integer.parseInt(value);
            sum = sum + valueInt;
        }

        String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extraInt = Integer.valueOf(extras);

        int expectedSum = sum + extraInt;
        String actualSum = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int actualSumInt = Integer.parseInt(actualSum);

        if (expectedSum == actualSumInt) {
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }

        driver.quit();
    }
}
