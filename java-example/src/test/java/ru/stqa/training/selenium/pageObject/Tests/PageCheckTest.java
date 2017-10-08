package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.ProductPage;
import ru.stqa.training.selenium.pageObject.Tests.TestBase;
import ru.stqa.training.selenium.pageObject.Pages.MainPage;

public class PageCheckTest extends TestBase {
    private static final String red = "R";
    private static final String green = "G";
    private static final String blue = "B";
    private static final String generalPrice = "general";
    private static final String salePrice = "sale";



    @Test
    public void pageCheckTest() {
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

//        Более точно, нужно открыть главную страницу, выбрать первый товар в блоке Campaigns и проверить следующее:
        MainPage mainPage = new MainPage(driver);

        String mainProductName =  mainPage.getMainProductName();
        String mainProductPrice =  mainPage.getMainProductPrice();
        String mainProductPriceWithSale =  mainPage.getMainProductPriceWithSale();

//        Проверка цвета акционной цены
        System.out.println("Акционная цена, красный: " + mainPage.mainPriceColorSector(salePrice, red));
        System.out.println("Акционная цена, зеленый: " + mainPage.mainPriceColorSector(salePrice, green));
        System.out.println("Акционная цена, синий: " + mainPage.mainPriceColorSector(salePrice, blue));
        Assert.assertTrue("Цвет акционной цены не является красным!",
                mainPage.mainPriceColorSector(salePrice, green) == 0 && mainPage.mainPriceColorSector("sale", "B") == 0);


//        Проверка цвета обычной цены
        System.out.println("Обычная цена, красный: " + mainPage.mainPriceColorSector(generalPrice, red));
        System.out.println("Обычная цена, зеленый: " + mainPage.mainPriceColorSector(generalPrice, green));
        System.out.println("Обычная цена, синий: " + mainPage.mainPriceColorSector(generalPrice, blue));
        Assert.assertTrue("Цвет обычной цены не является серым!",
                (mainPage.mainPriceColorSector(generalPrice, red) == mainPage.mainPriceColorSector(generalPrice, green))
                        && (mainPage.mainPriceColorSector(generalPrice, green) == mainPage.mainPriceColorSector(generalPrice, blue)));
//        Переход на страницу продукта
        mainPage.goToProductPage();
        wait.until(ExpectedConditions.titleContains("Yellow Duck | Subcategory | Rubber Ducks | My Store"));

        ProductPage productPage = new ProductPage(driver);

//        Проверки
//        а) на главной странице и на странице товара совпадает текст названия товара
        Assert.assertTrue("Название товара на главной странице \"" + mainProductName + "\" не совпадает с названием на странице товара \"" + productPage.getSubProductName() + "\"!",
                mainProductName.equals(productPage.getSubProductName()));

//        б) на главной странице и на странице товара совпадают цены (обычная и акционная)
        Assert.assertTrue("Обычная цена товара на главной странице \"" + mainProductPrice + "\" не совпадает с обычной ценой на странице товара \"" + productPage.getSubProductPrice() + "\"!",
                mainProductPrice.equals(productPage.getSubProductPrice()));

        Assert.assertTrue("Акционная цена товара на главной странице \"" + mainProductPriceWithSale + "\" не совпадает с акционной ценой на странице товара \"" + productPage.getSubProductPriceWithSale() + "\"!",
                mainProductPriceWithSale.equals(productPage.getSubProductPriceWithSale()));

//        в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
//        г) акционная жирная и красная (можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
//        (цвета надо проверить на каждой странице независимо, при этом цвета на разных страницах могут не совпадать)
//        г) акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)

    }

//    rgba(119, 119, 119, 1)
}
