package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountrySortCheckTest extends TestBase {

    @FindBy(xpath = "//form[@name='countries_form']//tr[@class='row']")
    List<WebElement> countryRow;

    @FindBy(xpath = "//table[@id = 'table-zones']//tr")
    List<WebElement> zonesRow;

    List<String> countryListNaturale = new ArrayList<String>();
    List<String> countryListSorted;

    List<String> zones = new ArrayList<String>();
    List<Integer> notNullZones = new ArrayList<Integer>();

    List<String> zoneNature;
    List<String> zoneSorted;

    @Test
    public void countrySortCheckTest() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.titleContains("Countries | My Store"));

        int countryCount = countryRow.size();
        System.out.println("Количество стран: " + countryCount);
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
                System.out.println("Номер строки с непустой зоной: " + notNullZones.get(notNullZones.size() - 1));
            }
        }

//        Проверка стран, у которых количество зон больше нуля
        for (int j = 0; j < notNullZones.size(); j++) {
            WebElement countryWithZone = driver.findElement(By.xpath("//form[@name='countries_form']//tr[@class='row'][" + notNullZones.get(j) + "]//td[5]//a"));
            countryWithZone.click();

            wait.until(ExpectedConditions.titleContains("Edit Country | My Store"));
            zoneNature = new ArrayList<>();

//            Проверка сортировки зон по алфавиту
            {
                for (int i = 0; i < zonesRow.size() - 2; i++) {
                    zoneNature.add(driver.findElement(By.xpath("//table[@id = 'table-zones']//tr[" + (i + 2) + "]//td[3]")).getText());
                    System.out.println("Зона " + notNullZones.get(j) + ":" + zoneNature.get(i));
                }
                zoneSorted = new ArrayList<String>(zoneNature);
                Collections.sort(zoneSorted);

                Assert.assertTrue("Списки не равны!", zoneNature.equals(zoneSorted));

                driver.navigate().back();
                wait.until(ExpectedConditions.titleContains("Countries | My Store"));
            }

        }
    }
}
