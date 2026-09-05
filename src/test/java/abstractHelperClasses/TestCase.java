package abstractHelperClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static abstractHelperClasses.PropertiesLoader.getProperty;


public abstract class TestCase {
    public WebDriver driver;
    public Properties properties ;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(getChromeOptions());
        properties = getProperty();
        }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
          //  driver.quit();
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true);
        return options;
    }
}
