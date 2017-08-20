package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by i-ru on 25.07.2017.
 */
public class LitecartLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
//        driver = new InternetExplorerDriver();

//        {
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability(FirefoxDriver.MARIONETTE, false);
//            driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")), new FirefoxProfile(),caps);
//        }
//        {
//            FirefoxOptions options = new FirefoxOptions();
//            options.setLegacy(false);
//            options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//            driver = new FirefoxDriver(options);
//        }

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void litecartLoginTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.titleContains("My Store"));
    }

    @After
    public void quit() {
        driver.quit();
        driver = null;
    }
}
