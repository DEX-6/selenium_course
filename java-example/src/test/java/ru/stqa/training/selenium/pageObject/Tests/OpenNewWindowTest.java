package ru.stqa.training.selenium.pageObject.Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.pageObject.Pages.CountriesPage;
import ru.stqa.training.selenium.pageObject.Pages.MainAdminPage;

public class OpenNewWindowTest extends TestBase {

    @Test
    public void openNewWindowTest() {
//        1) зайти в админку
        driver.get("http://localhost/litecart/admin/");
        MainAdminPage mainAdminPage = new MainAdminPage(driver);
        mainAdminPage.login();
        wait.until(ExpectedConditions.titleContains("My Store"));

//        2) открыть пункт меню CountriesPage
//        Переход на вкладку "CountriesPage"
        mainAdminPage.mainMenuItemClick("Countries");

        wait.until(ExpectedConditions.titleContains("Countries | My Store"));

        CountriesPage countriesPage = new CountriesPage(driver, wait);

//        Code (ISO 3166-1 alpha-2)
//        3) открыть на редактирование какую-нибудь страну или начать создание новой
        countriesPage.clickFirstCountry();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//        4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        countriesPage.newWindowClick("iso_code_2", "http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2");
        wait.until(ExpectedConditions.titleContains("ISO 3166-1 alpha-2 - Wikipedia"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='p-logo']")));

//        5) Закрытие старого окно (текущего)
        countriesPage.closeCurrentWindow();

//        6) Возврат в старое окно
        countriesPage.switchToFirstWindow();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//        Code (ISO 3166-1 alpha-3)
//        4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        countriesPage.newWindowClick("iso_code_3", "http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3");
        wait.until(ExpectedConditions.titleContains("ISO 3166-1 alpha-3 - Wikipedia"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='p-logo']")));

//        5) Закрытие старого окно (текущего)
        countriesPage.closeCurrentWindow();

//        6) Возврат в старое окно
        countriesPage.switchToFirstWindow();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//        Tax ID Format
//        4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        countriesPage.newWindowClick("tax_id_format", "https://en.wikipedia.org/wiki/Regular_expression");
        wait.until(ExpectedConditions.titleContains("Regular expression - Wikipedia"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='p-logo']")));

//        5) Закрытие старого окно (текущего)
        countriesPage.closeCurrentWindow();

//        6) Возврат в старое окно
        countriesPage.switchToFirstWindow();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//        Address Format
//        4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        countriesPage.newWindowClick("address_format", "http://www.addressdoctor.com/en/countries-data/address-formats.html");
        wait.until(ExpectedConditions.titleContains("International Proper Mailing Address Format | Informatica US"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//footer[@class='site-footer']")));

//        5) Закрытие старого окно (текущего)
        countriesPage.closeCurrentWindow();

//        6) Возврат в старое окно
        countriesPage.switchToFirstWindow();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//        Postcode Format
//        4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        countriesPage.newWindowClick("postcode_format", "https://en.wikipedia.org/wiki/Regular_expression");
        wait.until(ExpectedConditions.titleContains("Regular expression - Wikipedia"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='p-logo']")));

//        5) Закрытие старого окно (текущего)
        countriesPage.closeCurrentWindow();

//        6) Возврат в старое окно
        countriesPage.switchToFirstWindow();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//        Currency Code
//        4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        countriesPage.newWindowClick("currency_code", "https://en.wikipedia.org/wiki/List_of_countries_and_capitals_with_currency_and_language");
        wait.until(ExpectedConditions.titleContains("List of countries and capitals with currency and language - Wikipedia"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='p-logo']")));

//        5) Закрытие старого окно (текущего)
        countriesPage.closeCurrentWindow();

//        6) Возврат в старое окно
        countriesPage.switchToFirstWindow();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//        Phone Country Code
//        4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        countriesPage.newWindowClick("phone_code", "https://en.wikipedia.org/wiki/List_of_country_calling_codes");
        wait.until(ExpectedConditions.titleContains("List of country calling codes - Wikipedia"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='p-logo']")));

//        5) Закрытие старого окно (текущего)
        countriesPage.closeCurrentWindow();

//        6) Возврат в старое окно
        countriesPage.switchToFirstWindow();
        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));
    }
}
