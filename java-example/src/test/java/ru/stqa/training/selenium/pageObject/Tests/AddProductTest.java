package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.CreateProductPageAdm;
import ru.stqa.training.selenium.pageObject.Pages.MainAdminPage;

public class AddProductTest extends TestBase {

    @Test
    public void addProductTest() {
//        Вход
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        MainAdminPage mainAdminPage = new MainAdminPage(driver);
        mainAdminPage.login();
        wait.until(ExpectedConditions.titleContains("My Store"));

//        Переход на вкладку "Catalog"
        mainAdminPage.mainMenuItemClick("Catalog");
        mainAdminPage.subMenuItemClick("Catalog");

        wait.until(ExpectedConditions.titleContains("Catalog | My Store"));

//        Создание нового продукта
        mainAdminPage.initCreateProduct();
        wait.until(ExpectedConditions.titleContains("Add New Product | My Store"));

//        Заполнение вкладки General
        CreateProductPageAdm createProductPageAdm = new CreateProductPageAdm(driver);
        createProductPageAdm.topMenuItemClick("General");
        createProductPageAdm.fillField("name[en]", createProductPageAdm.createProductName());
        createProductPageAdm.downLoadPic();

//        Заполнение вкладки

    }
}
