package ru.stqa.training.selenium.pageObject.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    public void init(String browserName) {
        if (browserName.equals("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new ChromeDriver(desiredCapabilities);
        } else if (browserName.equals("InternetExplorer")) {
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        } else if (browserName.equals("Firefox Old Scheme Caps")) {
            desiredCapabilities.setCapability(FirefoxDriver.MARIONETTE, false);
            driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")), new FirefoxProfile(), desiredCapabilities);
            driver.manage().window().maximize();
        } else if (browserName.equals("Firefox Old Scheme Options")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setLegacy(false);
            options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        } else if (browserName.equals("Firefox New Scheme")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

}
