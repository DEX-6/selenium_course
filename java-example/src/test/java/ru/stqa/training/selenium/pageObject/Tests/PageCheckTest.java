package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Tests.TestBase;
import ru.stqa.training.selenium.pageObject.Pages.MainPage;

public class PageCheckTest extends TestBase {


    @Test
    public void pageCheckTest() {
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

//        Более точно, нужно открыть главную страницу, выбрать первый товар в блоке Campaigns и проверить следующее:
        MainPage mainPage = new MainPage(driver);

        mainPage.getMainProductName();
        mainPage.getMainProductPrice();
        mainPage.getMainProductPriceWithSale();

//        Проверка цвета акционной цены
        System.out.println("green: " + mainPage.mainPriceGreenColor());
        System.out.println("blue: " + mainPage.mainPriceBlueColor());
        Assert.assertTrue("Цвет акционной цены не является красным!",
                mainPage.mainPriceGreenColor() == 0 && mainPage.mainPriceBlueColor() == 0);

//        Переход на страницу продукта
        mainPage.goToProductPage();
        wait.until(ExpectedConditions.titleContains("Yellow Duck | Subcategory | Rubber Ducks | My Store"));
//
//
//
//
////        Проверки
////        а) на главной странице и на странице товара совпадает текст названия товара
//        Assert.assertTrue("Название товара на главной странице \"" + mainProductName + "\" не совпадает с названием на странице товара \"" + subProductName + "\"!",
//                mainProductName.equals(subProductName));
//
////        б) на главной странице и на странице товара совпадают цены (обычная и акционная)
//        Assert.assertTrue("Обычная цена товара на главной странице \"" + mainProductPrice + "\" не совпадает с обычной ценой на странице товара \"" + subProductPrice + "\"!",
//                mainProductPrice.equals(subProductPrice));
//
//        Assert.assertTrue("Акционная цена товара на главной странице \"" + mainProductPriceWithSale + "\" не совпадает с акционной ценой на странице товара \"" + subProductPriceWithSale + "\"!",
//                mainProductPriceWithSale.equals(subProductPriceWithSale));
//
////        в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
////        г) акционная жирная и красная (можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
////        (цвета надо проверить на каждой странице независимо, при этом цвета на разных страницах могут не совпадать)
//        г) акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)

    }
}
