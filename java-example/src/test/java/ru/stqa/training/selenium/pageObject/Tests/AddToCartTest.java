package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.CartPage;
import ru.stqa.training.selenium.pageObject.Pages.MainPage;
import ru.stqa.training.selenium.pageObject.Pages.ProductPage;

public class AddToCartTest extends TestBase {

    @Test
    public void addToCartTest() {
//        1) открыть главную страницу
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);

//        4) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
        for (int i = 1; i <= 3; i++) {
//        2) открыть первый товар из списка
            mainPage.firstProductClick();
//        wait.until(ExpectedConditions.titleContains(""));

//            Рыбор размера утки при необходимости
            if(productPage.size.size() > 0){
                productPage.selectSize();
            }
//        2) добавить его в корзину
            productPage.buttonClick("add_cart_product");
//        3) подождать, пока счётчик товаров в корзине обновится

            String count = String.valueOf(i);
            wait.until(d -> (productPage.productsCounter.getText().equals(count)));
            wait.until(ExpectedConditions.attributeToBe(productPage.productsCounter, "textContent", count));
            driver.navigate().back();
        }
//        5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", mainPage.cart);
        mainPage.cartClick();
//        6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
        CartPage cartPage = new CartPage(driver);

        while (cartPage.cartItems.size() > 0){
            wait.until(ExpectedConditions.visibilityOf(cartPage.buttonRemove));
            cartPage.removeCartItem();

        wait.until(ExpectedConditions.stalenessOf(cartPage.getRemovedItem()));
        }

    }
}
