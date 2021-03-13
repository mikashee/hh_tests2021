package tests;

import Helpers.Selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class BaseGuiTest {
    protected WebDriver getDriver() {
        return WebDriverFactory.getDriver();
    }

    @BeforeClass
    public void baseBeforeClass() {
        String className = this.getClass().getSimpleName();
        Thread.currentThread().setName("["+className+"]");
        WebDriverFactory.startBrowser();
    }

    @AfterClass
    public void baseAfterClass() {
        WebDriverFactory.finishBrowser();
    }
}
