package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class BaseGuiTest {
    WebDriver driver;
    @BeforeClass
    public void baseBeforeClass() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        System.setProperty("webdriver.chrome.driver", "C:\\WORK\\AllDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }
    @AfterClass
    public void baseAfterClass() {
        driver.close();
    }
}
