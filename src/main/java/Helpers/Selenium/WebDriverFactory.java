package Helpers.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static final long IMPLICIT_WAIT_TIMEOUT = 10;
    private static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<WebDriver>();
    static String browser = "CHROME";

    public static WebDriver getDriver() {
        if (driverContainer.get() != null) {
            //driverContainer.get().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            return driverContainer.get();
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }
    public static void startBrowser() {
        if (driverContainer.get() == null) {
            if (browser.equalsIgnoreCase("CHROME")) {
                System.setProperty("webdriver.chrome.driver", "C:\\WORK\\AllDrivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                driverContainer.set(new ChromeDriver(options));

            } else {
                throw new IllegalStateException("Unsupported browser type");
            }
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    public static void finishBrowser() {
        driverContainer.get().quit();
        driverContainer.set(null);
    }
}
