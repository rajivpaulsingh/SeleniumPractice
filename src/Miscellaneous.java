import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Miscellaneous {

    public static void main(String args[])  throws IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Maximize the browser
        driver.manage().window().maximize();

        //Delete the cookies before the test
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("sessionKey");

        driver.get("https://www.google.com");

        //Take screenshot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/Users/singh2_rajiv/Automation/Selenium/screenshot.png"));
    }
}
