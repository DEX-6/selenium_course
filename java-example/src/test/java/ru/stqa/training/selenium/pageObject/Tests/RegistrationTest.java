package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.LoginPage;
import ru.stqa.training.selenium.pageObject.Pages.MainPage;
import ru.stqa.training.selenium.pageObject.Pages.RegistrationPage;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationTest() throws InterruptedException {
        String email;

//        Переход на страницу сайта
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

        MainPage mainPage = new MainPage(driver);

//        Начало регистрации
        mainPage.initRegistration();
        wait.until(ExpectedConditions.titleContains("Create Account | My Store"));

//        Заполнение необхлдимых полей
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm();
        email = registrationPage.getEmail();
        registrationPage.createAccount();


//        Выход
        registrationPage.logout();
        Assert.assertTrue("Не удалось выполнить выход!", registrationPage.isLogoutSuccess());
        registrationPage.loginLinkClick();
//        mainPage.loginLinkClick();

//        Вход
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email);
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));
        Assert.assertTrue("Не удалось выполнить вход!", loginPage.isLoginSuccess());

//        Повторный выход
        loginPage.logout();
        Assert.assertTrue("Не удалось выполнить выход!", loginPage.isLogoutSuccess());


    }

}
