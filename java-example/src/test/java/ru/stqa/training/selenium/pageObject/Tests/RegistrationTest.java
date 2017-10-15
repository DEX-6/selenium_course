package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.MainPage;
import ru.stqa.training.selenium.pageObject.Pages.RegistrationPage;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationTest() {

        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

        MainPage mainPage = new MainPage(driver);

        mainPage.initRegistration();
        wait.until(ExpectedConditions.titleContains("Create Account | My Store"));

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm();
        registrationPage.createAccount();
    }

}
