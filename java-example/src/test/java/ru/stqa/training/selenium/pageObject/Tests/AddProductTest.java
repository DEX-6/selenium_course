package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.CreateProductPageAdm;
import ru.stqa.training.selenium.pageObject.Pages.MainAdminPage;

public class AddProductTest extends TestBase {

    Thread thread = new Thread();

    @Test
    public void addProductTest() throws InterruptedException {
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

        CreateProductPageAdm createProductPageAdm = new CreateProductPageAdm(driver);
        createProductPageAdm.createProductName();
//        Заполнение вкладки General

//        Status
        createProductPageAdm.radioButtonClick(" Enabled");
//        Name
        createProductPageAdm.fillField("name[en]", createProductPageAdm.getProductName());
//        Code
        createProductPageAdm.fillField("code", createProductPageAdm.getProductName());
//        Categories
        createProductPageAdm.categoryCheckboxClick("Root", "-");
        createProductPageAdm.categoryCheckboxClick("Rubber Ducks", "+");

//        Default Category
        createProductPageAdm.fillCombobox("default_category_id", "Rubber Ducks");
//        Product Groups
        createProductPageAdm.productGroupsCheckboxClick("Female", "+");
        createProductPageAdm.productGroupsCheckboxClick("Male", "-");

//        Quantity
        createProductPageAdm.fillField("quantity", "15,00");

//        Quantity Unit
        createProductPageAdm.fillCombobox("quantity_unit_id", "pcs");

//        Delivery Status
        createProductPageAdm.fillCombobox("delivery_status_id", "3-5 days");

//        Sold Out Status
        createProductPageAdm.fillCombobox("sold_out_status_id", "Temporary sold out");

//        Upload Images
        createProductPageAdm.downLoadPic();

//        Date Valid From
        createProductPageAdm.fillField("date_valid_from", "01.01.2018");

//        Date Valid To
        createProductPageAdm.fillField("date_valid_to", "01.01.2020");


//        Заполнение вкладки Information
        createProductPageAdm.topMenuItemClick("Information");

//        Manufacturer
        createProductPageAdm.fillCombobox("manufacturer_id", "ACME Corp.");

//        Keywords
        createProductPageAdm.fillField("keywords", createProductPageAdm.getProductName());

//        Short Description
        createProductPageAdm.fillField("short_description[en]", createProductPageAdm.getProductName());

//        Description
        createProductPageAdm.fillTextArea("trumbowyg-editor", String.valueOf(createProductPageAdm.getProductName()));

//        Head Title
        createProductPageAdm.fillField("head_title[en]", createProductPageAdm.getProductName());

//        Meta Description
        createProductPageAdm.fillField("meta_description[en]", createProductPageAdm.getProductName());

//        Заполнение вкладки Information
        createProductPageAdm.topMenuItemClick("Prices");

//        Purchase Price
        createProductPageAdm.fillField("purchase_price", "15,00");
        createProductPageAdm.fillCombobox("purchase_price_currency_code", "US Dollars");

//        Price
        createProductPageAdm.fillField("prices[USD]", "5");
        createProductPageAdm.fillField("gross_prices[EUR]", "5");

//        Сохранение продукта
        createProductPageAdm.buttonClick("save");
        thread.sleep(2000);
        Assert.assertTrue("Не было показано сообщение об успешном создании продукта", createProductPageAdm.notice_success().contains("Changes were successfully saved"));

//        Поиск созданного товара
        //        Переход на вкладку "Catalog"
        mainAdminPage.mainMenuItemClick("Catalog");
        mainAdminPage.subMenuItemClick("Catalog");

        wait.until(ExpectedConditions.titleContains("Catalog | My Store"));
    }
}
