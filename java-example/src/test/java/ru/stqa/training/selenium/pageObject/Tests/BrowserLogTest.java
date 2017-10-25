package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.CatalogPage;
import ru.stqa.training.selenium.pageObject.Pages.MainAdminPage;

/**
 * Created by i-ru on 25.10.2017.
 */
public class BrowserLogTest extends TestBase {

    @Test
    public void srowserLogTest() {
        //        1) зайти в админку
        driver.get("http://localhost/litecart/admin/");
        MainAdminPage mainAdminPage = new MainAdminPage(driver);
        mainAdminPage.login();
        wait.until(ExpectedConditions.titleContains("My Store"));

//        2) открыть пункт меню Catalog
//        Переход на вкладку "Catalog"
        mainAdminPage.mainMenuItemClick("Catalog");
        mainAdminPage.subMenuItemClick("Catalog");

        wait.until(ExpectedConditions.titleContains("Catalog | My Store"));
        CatalogPage catalogPage = new CatalogPage(driver);

//        Раскрываем все продукты
        catalogPage.expandProductList();
        catalogPage.logCheck();

    }
}
