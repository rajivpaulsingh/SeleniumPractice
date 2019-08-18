import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/rajivpaulsingh/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");

        //Selecting the current date
        driver.findElement((By.xpath("//i[@class='icon ir datePicker']"))).click();
        driver.findElement(By.xpath("//*[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();

        //Selecting the drop downs
        Select select1 = new Select(driver.findElement(By.id("Adults")));
        select1.selectByValue("2");

        Select select2 = new Select(driver.findElement(By.id("Childrens")));
        select2.selectByValue("1");

        //Clicking the link and filling text fields
        driver.findElement(By.id("MoreOptionsLink")).click();
        Select select3 = new Select(driver.findElement(By.id("Class")));
        select3.selectByValue("Business");

        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");

        //Search flights
        driver.findElement(By.id("SearchBtn")).click();
        Thread.sleep(2000);

        //Displaying the error received
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

        driver.quit();

    }
}
