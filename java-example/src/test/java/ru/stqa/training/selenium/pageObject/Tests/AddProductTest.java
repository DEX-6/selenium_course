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
        createProductPageAdm.createProductName();

        createProductPageAdm.topMenuItemClick("General");
        createProductPageAdm.radioButtonClick(" Enabled");
//        createProductPageAdm.fillField("name[en]", createProductPageAdm.getProductName());
        createProductPageAdm.fillField("code", createProductPageAdm.getProductName());
        createProductPageAdm.categoryCheckboxClick("Root");
        createProductPageAdm.categoryCheckboxClick("Rubber Ducks");
//        createProductPageAdm.downLoadPic();
        createProductPageAdm.productGroupsCheckboxClick("Female");
//        Заполнение вкладки Information
//        createProductPageAdm.topMenuItemClick("Information");
//        createProductPageAdm.fillField("short_description[en]", createProductPageAdm.getProductName());
//        createProductPageAdm.fillTextArea("trumbowyg-editor", String.valueOf(createProductPageAdm.getProductName()));
//        createProductPageAdm.fillField("head_title[en]", createProductPageAdm.getProductName());
//        createProductPageAdm.fillField("meta_description[en]", createProductPageAdm.getProductName());
    }
}
