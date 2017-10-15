package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    public static String browserType;


    public void init(String browserName) {
        if (browserName.equals("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new ChromeDriver(desiredCapabilities);
            browserType = BrowserType.CHROME;
        } else if (browserName.equals("InternetExplorer")) {
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            browserType = BrowserType.IE;
        } else if (browserName.equals("Firefox Old Scheme Caps")) {
            desiredCapabilities.setCapability(FirefoxDriver.MARIONETTE, false);
            driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")), new FirefoxProfile(), desiredCapabilities);
            driver.manage().window().maximize();
            browserType = BrowserType.FIREFOX;
        } else if (browserName.equals("Firefox Old Scheme Options")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setLegacy(false);
            options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            browserType = BrowserType.FIREFOX;
        } else if (browserName.equals("Firefox New Scheme")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            browserType = BrowserType.FIREFOX;
        }
    }

    @Before
    public void start() {
        {
            init("Chrome");
//            init("InternetExplorer");
//            init("Firefox Old Scheme Caps");
//            init("Firefox Old Scheme Options");
//            init("Firefox New Scheme");
            wait = new WebDriverWait(driver, 10);
        }
    }

    @After
    public void quit() {
//        driver.quit();
    }

}
