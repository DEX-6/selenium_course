package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by i-ru on 30.09.2017.
 */
public class StickersCheckTest extends TestBase {

    private final String visibleDucksPath = "//li[@class='product column shadow hover-light']";
    private final String duckStickersPath = ".//div[contains(@class, 'sticker')]";

    @FindBy(xpath = visibleDucksPath)
    List<WebElement> visibleDucks;

    @Test
    public void stickersCheckTest() {
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

        for (int i = 0; i < visibleDucks.size(); i++) {
            Assert.assertTrue("Количество стикеров " + "\"" + visibleDucks.get(i).findElements(By
                            .xpath(duckStickersPath)).size() + "\"" + " не равно единице!",
                    visibleDucks.get(i).findElements(By.xpath(duckStickersPath)).size() == 1);
            System.out.println("Проверена утка №" + (i + 1));
        }
    }
}
