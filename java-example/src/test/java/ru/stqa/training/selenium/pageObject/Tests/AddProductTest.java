package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.MainAdminPage;

public class AddProductTest extends TestBase {

    @Test
    public void addProductTest() {
//        Вход
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        MainAdminPage mainAdminPage = new MainAdminPage(driver);
        mainAdminPage.login();
        wait.until(ExpectedConditions.titleContains("My Store"));

        mainAdminPage.mainMenuItemClick();

    }
}
