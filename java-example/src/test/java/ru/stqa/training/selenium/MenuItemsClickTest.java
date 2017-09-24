package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MenuItemsClickTest extends TestBase {

    @FindBy(xpath = "//div[@id = 'box-apps-menu-wrapper']//li[@id = 'app-']")
    List<WebElement> mainMenuItem;

    @FindBy(xpath = "//div[@id = 'box-apps-menu-wrapper']//li[@id = 'app-']//ul[@class = 'docs']//li[contains(@id, 'doc-')]")
    List<WebElement> subMenuItem;


    @Test
    public void menuItemsClickTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.titleContains("My Store"));

        int mainMenuItemCount = mainMenuItem.size();
        System.out.println("mainMenuItemCount = " + mainMenuItemCount);

        for (int i = 0; i < mainMenuItemCount; i++) {
            mainMenuItem.get(i).click();
            Assert.assertTrue("Вкладка меню не была выбрана!", mainMenuItem.get(i).getAttribute("class")
                    .equals("selected"));
            int subMenuItemCount = subMenuItem.size();
            if (subMenuItemCount > 0) {
                for (int j = 0; j < subMenuItemCount; j++) {
                    subMenuItem.get(j).click();
                    Assert.assertTrue("Подвкладка меню не была выбрана!", subMenuItem
                            .get(j).getAttribute("class").equals("selected"));
                }
            }
            System.out.println("Click: " + (i + 1) + "\n");
        }
    }
}
