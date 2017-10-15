package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("11111");
        driver.findElement(By.name("login")).click();
    }

    public boolean isLoginSuccess() {
        return driver.findElement(By.xpath("//div[@class='notice success' and contains(text(),'You are now logged in' )]")).isEnabled();
    }

}
