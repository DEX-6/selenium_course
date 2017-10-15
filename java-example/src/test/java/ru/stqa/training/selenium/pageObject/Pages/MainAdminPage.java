package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainAdminPage extends AbstractPage {

    WebDriver driver;

    public MainAdminPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(){

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public void mainMenuItemClick(){
        driver.findElement(By.xpath("//div[@id = 'box-apps-menu-wrapper']//li[@id = 'app-']//span[contains(text(), 'Catalog')]")).click();
    }

    public void subMenuItemClick(){
        driver.findElement(By.xpath(""));
    }

}
