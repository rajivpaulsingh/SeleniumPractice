import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL {

    public static void main(String args[]) {

        //SSL Certificates

        //Desired capabilities
        DesiredCapabilities ch = DesiredCapabilities.chrome();
        ch.acceptInsecureCerts();
//        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        ChromeOptions c = new ChromeOptions();
        c.merge(ch);

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver(c);
    }
}
