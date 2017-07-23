package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by i-ru on 23.07.2017.
 */
public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
//        driver.get("http://www.google.com/");
//        driver.findElement(By.name("q")).sendKeys("webdriver");
//        driver.findElement(By.name("btnG")).click();
//        wait.until(ExpectedConditions.titleIs("webdriver - Поиск в Google"));

//        Пришлось писать для Яндекса, ибо на гугле заметили подозрительную активность)
        driver.get("https://yandex.ru/");
        driver.findElement(By.name("text")).sendKeys("webdriver");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        wait.until(ExpectedConditions.titleContains("webdriver — Яндекс:"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
