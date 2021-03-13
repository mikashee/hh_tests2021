package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.testng.annotations.Test;


public class ResTest extends BaseGuiTest{
    @Test
    public void test_te(){
        Cookie ck = new Cookie("hhtoken","Goe8ETKKBVJVHHz_WyEglIHecLoP","/");
        WebDriver driver = getDriver();
        //открытие сайта

        driver.get("http://hh.ru");

        //проверка авторизации
        String locator = "//*[@data-navi-item-name=\"applicantProfile\"]";
        if (!isElementOnPage(driver, locator)){
            //установка кукков (авторизация)
            System.out.println("hhtokenBefore: "+driver.manage().getCookieNamed("hhtoken").toString());
            driver.manage().addCookie(ck);
            System.out.println("hhtokenAfter: "+driver.manage().getCookieNamed("hhtoken").toString());

            driver.get("http://hh.ru");
        }

        Assert.assertTrue("not authorizated", isElementOnPage(driver, locator));

        //смотрим аккаунт:
        driver.findElement(By.xpath(locator)).click();

        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"HH-Supernova-Menu-Content\"]//*[@data-qa=\"mainmenu_applicantInfo\"]")));

        String accName = driver.findElement(By.xpath("//*[@class=\"HH-Supernova-Menu-Content\"]//*[@data-qa=\"mainmenu_applicantInfo\"]")).getText();
        System.out.println("-авторизован как <" + accName +">");

    }

    boolean isElementOnPage(WebDriver driver, String locator){
        return driver.findElements(By.xpath(locator)).size()>0;
    }

}

