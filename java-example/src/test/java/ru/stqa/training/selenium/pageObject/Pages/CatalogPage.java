package ru.stqa.training.selenium.pageObject.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by i-ru on 25.10.2017.
 */
public class CatalogPage extends AbstractPage {
    WebDriver driver;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void expandProductList() {

        driver.findElement(By.xpath("//i[@class='fa fa-folder']//following-sibling::a")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-folder']//following-sibling::a")).click();
    }

    public void logCheck() {
        int productsSize = 1;
        for (int i = 0; i < productsSize; i++) {
            List<WebElement> products = driver.findElements(By.xpath("//td[input[contains(@name,'products')]]/following-sibling::td//a[not(@title)]"));
            productsSize = products.size();
            String productName = products.get(i).getText();
            products.get(i).click();
            List<LogEntry> browserLogs = driver.manage().logs().get("browser").getAll();
            System.out.println(productName + ". Количество логов: " + browserLogs.size());
        driver.navigate().back();
        }
    }
}
