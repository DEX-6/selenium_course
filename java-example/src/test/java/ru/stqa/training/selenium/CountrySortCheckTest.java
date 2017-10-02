package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CountrySortCheckTest extends TestBase {

    @FindBy(xpath = "//form[@name='countries_form']//tr[@class='row']")
    List<WebElement> countryRow;

    List<String> countryListNaturale = new ArrayList<String>();
    //    List<WebElement> countryListNaturale;
    List<String> countryListSorted;

    List<String> zones = new ArrayList<String>();
    List<Integer> notNullZones = new ArrayList<Integer>();

    @FindBy(xpath = "//table[@id = 'table-zones']//tr")
    List<WebElement> zonesRow;

    @Test
    public void countrySortCheckTest() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.titleContains("Countries | My Store"));

        int countryCount = countryRow.size();
        System.out.println(countryCount);

//        Получение списка стран
        for (int i = 0; i < countryCount; i++) {
            countryListNaturale.add(driver
                    .findElement(By.xpath("//form[@name='countries_form']//tr[@class='row'][" + (i + 1) + "]//td[5]"))
                    .getText());
            System.out.println("Страна: " + countryListNaturale.get(i));
        }

//        Сортировка списка стран для проверки, что страны отсортированы по алфавиту
        countryListSorted = new ArrayList<String>(countryListNaturale);
        Collections.sort(countryListSorted);

//        Проверка сортировки стран
        Assert.assertTrue("Списки не равны!", countryListNaturale.equals(countryListSorted));

//        Получение списка зон
        driver.findElements(By.xpath("//form[@name='countries_form']//tr[@class='row']//td[6]"));

//        Получаем номера строк, в которых количество зон больше нуля
        for (int i = 0; i < countryCount; i++) {
            zones.add(driver.findElement(By.xpath("//form[@name='countries_form']//tr[@class='row'][" + (i + 1) + "]//td[6]")).getText());
            if (!zones.get(i).equals("0")) {
                notNullZones.add(i + 1);
            }
        }

//        Проверка стран, у которых количество зон больше нуля
/*        for (int i = 0; i < notNullZones.size(); i++) {
            List<WebElement> countryWithZone = driver.findElements(By.xpath("//form[@name='countries_form']//tr[@class='row'][" + notNullZones.get(i) + "]//td[5]"));
            for (int j = 0; j < countryWithZone.size(); j ++){
                countryWithZone.get(j).click();

            }

//            driver.navigate().back();
        }*/

        List<WebElement> countryWithZone = driver.findElements(By.xpath("//form[@name='countries_form']//tr[@class='row'][" + notNullZones.get(1) + "]//td[5]"));
        countryWithZone.get(1).click();

        wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));

//            Получение списка зон
        for (int i = 0; i < zonesRow.size(); i++) {
//            driver.findElements("")

        }


    }
}
