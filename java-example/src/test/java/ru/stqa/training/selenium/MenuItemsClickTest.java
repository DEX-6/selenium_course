package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MenuItemsClickTest {

    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(driver, 10);
        }
        /*{
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }*/

        /*{
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }*/
    }

    @Test
    public void menuItemsClickTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.titleContains("My Store"));
    }

    @After
    public void quit() {
//        driver.quit();
    }
}
