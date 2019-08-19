import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Assignment6 {

    public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.qaclickacademy.com/practice.php");

        //1. Select checkbox
        driver.findElement(By.cssSelector("input#checkBoxOption2")).click();

        //2. Get the name of the selected checkbox
        String selectedCheckbox = driver.findElement(By.cssSelector("input#checkBoxOption2")).getText();

        //3. Select the above option name in the dropdown
        Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText(selectedCheckbox);
        String selectedDropdown = driver.findElement(By.id("dropdown-class-example")).getText();

        //4. Entering the selecting value from the dropdown in the text field
        driver.findElement(By.id("name")).sendKeys(selectedDropdown);

        //5. Checking the alert message
        driver.findElement(By.id("alertbtn")).click();
        driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertTrue(alertMessage.contains(selectedDropdown));

        driver.quit();
    }
}
