package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageCheckTest extends TestBase {

    @FindBy(xpath = "//div[@id = 'box-campaigns']//li//div[@class='name']")
    WebElement mainProductNameElement;

    String mainProductName;

    @FindBy(xpath = "//h1")
    WebElement subProductNameElement;

    String subProductName;

    @FindBy(xpath = "//div[@id = 'box-campaigns']//li//s[@class='regular-price']")
    WebElement mainProductPriceElement;

    String mainProductPrice;

    @FindBy(xpath = "//div[@class='information']//s[@class='regular-price']")
    WebElement subProductPriceElement;

    String subProductPrice;

    @FindBy(xpath = "//div[@id = 'box-campaigns']//li//strong[@class='campaign-price']")
    WebElement mainProductPriceWithSaleElement;

    String mainProductPriceWithSale;

    @FindBy(xpath = "//div[@class='information']//strong[@class='campaign-price']")
    WebElement subProductPriceWithSaleElement;

    String subProductPriceWithSale;

    @Test
    public void pageCheckTest() {
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

//        Более точно, нужно открыть главную страницу, выбрать первый товар в блоке Campaigns и проверить следующее:

//        Поиск значений на главной странице
        mainProductName = mainProductNameElement.getText();
        mainProductPrice = mainProductPriceElement.getText();
        mainProductPriceWithSale = mainProductPriceWithSaleElement.getText();

//        Переход на страницу товара
        driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li//a")).click();
        wait.until(ExpectedConditions.titleContains("Yellow Duck | Subcategory | Rubber Ducks | My Store"));

//        Поиск значений на странице товара
        subProductName = subProductNameElement.getText();
        subProductPrice = subProductPriceElement.getText();
        subProductPriceWithSale = subProductPriceWithSaleElement.getText();

//        Проверки
//        а) на главной странице и на странице товара совпадает текст названия товара
        Assert.assertTrue("Название товара на главной странице \"" + mainProductName + "\" не совпадает с названием на странице товара \"" + subProductName + "\"!",
                mainProductName.equals(subProductName));

//        б) на главной странице и на странице товара совпадают цены (обычная и акционная)
        Assert.assertTrue("Обычная цена товара на главной странице \"" + mainProductPrice + "\" не совпадает с обычной ценой на странице товара \"" + subProductPrice + "\"!",
                mainProductPrice.equals(subProductPrice));

        Assert.assertTrue("Акционная цена товара на главной странице \"" + mainProductPriceWithSale + "\" не совпадает с акционной ценой на странице товара \"" + subProductPriceWithSale + "\"!",
                mainProductPriceWithSale.equals(subProductPriceWithSale));

//        в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
//        г) акционная жирная и красная (можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
//        (цвета надо проверить на каждой странице независимо, при этом цвета на разных страницах могут не совпадать)
//        г) акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)
    }
}
