package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.MainPage;
import ru.stqa.training.selenium.pageObject.Pages.ProductPage;

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

        String mainProductName = mainPage.getMainProductName();
        String mainProductPrice = mainPage.getMainProductPrice();
        String mainProductPriceWithSale = mainPage.getMainProductPriceWithSale();

//        Проверка акционной цены
//        Проверка цвета акционной цены
        Assert.assertTrue("Цвет акционной цены не является красным!",
                mainPage.mainPriceColorSector(salePrice, green) == 0
                        && mainPage.mainPriceColorSector(salePrice, blue) == 0
                        && mainPage.mainPriceColorSector(salePrice, red) > 0);

//        Проверка, что акционная цена имеет жирный шрифт
        Assert.assertTrue("Шрифт акционной цены не является жирным!",
                mainPage.getMainPriceWeight(salePrice).equals("bold"));

//        Проверка обычной цены
//        Проверка цвета обычной цены
        Assert.assertTrue("Цвет обычной цены не является серым!",
                (mainPage.mainPriceColorSector(generalPrice, red) == mainPage.mainPriceColorSector(generalPrice, green))
                        && (mainPage.mainPriceColorSector(generalPrice, green) == mainPage.mainPriceColorSector(generalPrice, blue)));
//       Проверка, что обычная цена зачеркнута
        Assert.assertTrue("Текст не свяляется зачеркнутым!",
                mainPage.textDecorationLine(browserType, mainPage.mainProductPriceElement).equals("line-through"));

//        Проверка, что Акционная цена больше обычной
        Assert.assertTrue("Ошибка проверки размера текста цены", mainPage.getMainPriceSize(salePrice) > mainPage.getMainPriceSize(generalPrice));

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

//        Проверка цвета обычной цены
        Assert.assertTrue("Цвет обычной цены не является серым!",
                (productPage.subPriceColorSector(generalPrice, red) == productPage.subPriceColorSector(generalPrice, green))
                        && (productPage.subPriceColorSector(generalPrice, green) == productPage.subPriceColorSector(generalPrice, blue)));
//       Проверка, что обычная цена зачеркнута
        Assert.assertTrue("Текст не свяляется зачеркнутым!",
                productPage.textDecorationLine(browserType, productPage.subProductPriceElement).equals("line-through"));


//        Проверка цвета акционной цены
        Assert.assertTrue("Цвет акционной цены не является красным!",
                productPage.subPriceColorSector(salePrice, green) == 0
                        && productPage.subPriceColorSector(salePrice, blue) == 0
                        && productPage.subPriceColorSector(salePrice, red) > 0);

//        Проверка, что акционная цена имеет жирный шрифт
        Assert.assertTrue("Шрифт акционной цены не является жирным!",
                productPage.getSubPriceWeight(salePrice).equals("bold"));

//        Проверка, что Акционная цена больше обычной
        Assert.assertTrue("Ошибка проверки размера текста цены", productPage.getSubPriceSize(salePrice) > productPage.getSubPriceSize(generalPrice));
    }
}
