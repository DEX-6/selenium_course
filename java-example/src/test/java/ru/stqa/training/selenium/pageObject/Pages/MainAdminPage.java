package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainAdminPage extends AbstractPage {

    WebDriver driver;

    public MainAdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login() {

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public void mainMenuItemClick(String mainMenuName) {
        driver.findElement(By.xpath("//div[@id = 'box-apps-menu-wrapper']//li[@id = 'app-']//span[contains(text(), '" + mainMenuName + "')]")).click();
    }

    public void subMenuItemClick(String subMenuName) {
        driver.findElement(By.xpath("//div[@id = 'box-apps-menu-wrapper']//li[@id = 'app-']//ul[@class = 'docs']//li[contains(@id, 'doc-')]//span[contains(text(), '" + subMenuName + "')]"));
    }

    public void initCreateProduct() {
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']")).click();
    }

    public int getRowsCount(){
        List <WebElement> rows = driver.findElements(By.xpath("//form[@name='catalog_form']//tr[@class='row']"));
        return rows.size();
    }

    public String getTextNameField(){
        return driver.findElement(By.xpath("//form[@name='catalog_form']//td[3]")).getText();
    }

}
