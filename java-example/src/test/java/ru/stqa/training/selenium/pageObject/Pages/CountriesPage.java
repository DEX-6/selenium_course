package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CountriesPage extends AbstractPage {
    WebDriver driver;
    protected WebDriverWait wait;


    Set<String> oldWindows;
    Set<String> allWindows;
    String firstWindow;

    public CountriesPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public void clickFirstCountry() {
        driver.findElement(By.xpath("//form[@name='countries_form']//a")).click();
    }

    public void newWindowClick(String fieldName, String href) {
        firstWindow = driver.getWindowHandle();
        oldWindows = driver.getWindowHandles();
        driver.findElement(By.xpath("//td[input[@name='" + fieldName + "'] or textarea[@name='" + fieldName + "']]//a[@href='" + href + "']")).click();
        allWindows = driver.getWindowHandles();
        allWindows.removeAll(oldWindows);
        driver.switchTo().window(allWindows.iterator().next());
    }

    public void closeCurrentWindow() {
        driver.close();
    }

    public void switchToFirstWindow() {
        driver.switchTo().window(firstWindow);
    }
}
