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

public class ZoneSortCheckTest extends TestBase {
    @FindBy(xpath = "//form[@name='geo_zones_form']//tr[@class='row']")
    List<WebElement> countriesRow;

    @FindBy(xpath = "//table[@id='table-zones']//tr")
    List<WebElement> zonesRow;

    private List<String> countriesListNature;
    private List<String> countriesListSorted;
    private List <String> zonesListNatural;
    private List<String> zoneListSorted;

    @Test
    public void zoneSortCheckTest() {

        driver.get(" http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.titleContains("Geo Zones | My Store"));

        countriesListNature = new ArrayList<String>();
//        Получение списка зон
        for (int i = 0; i < countriesRow.size(); i++) {
            countriesListNature.add(driver.findElement(By.xpath("//form[@name='geo_zones_form']//tr[@class='row'][" + (i + 1) + "]//td[3]"))
                    .getText());
            System.out.println("Страна:" + countriesListNature.get(i));
        }

//        Сортировка зон по алфавиту
        countriesListSorted = new ArrayList<>(countriesListNature);
        Collections.sort(countriesListSorted);

//        Проверка сортировки зон по алфавиту
        Assert.assertTrue("Списки не равны", countriesListNature.equals(countriesListSorted));

//        Переход по ссылке в страну и проверка сортировки зон внутри нее
        for (int j = 0; j < countriesRow.size(); j ++){
            WebElement countryWithZone = driver.findElement(By.xpath("//form[@name='geo_zones_form']//tr[@class='row'][" + (j + 1) + "]//td[3]//a"));
            System.out.println("Переход в страну: " + driver.findElement(By.xpath("//form[@name='geo_zones_form']//tr[@class='row'][" + (j + 1) + "]//td[3]")).getText());
            countryWithZone.click();
            wait.until(ExpectedConditions.titleContains("Edit Geo Zone | My Store"));

            zonesListNatural = new ArrayList<String>();
//            Проврка сортировки зон по алфавиту
            {
                for (int i = 0; i < zonesRow.size() - 2; i++) {
                    zonesListNatural.add(driver.findElement(By.xpath("//table[@id='table-zones']//tr[" + (i + 2) + "]//td[3]//option[@selected='selected']")).getText());
                }
                zoneListSorted = new ArrayList<String>(zonesListNatural);
                Collections.sort(zoneListSorted);

                Assert.assertTrue("Списки не равны!", zonesListNatural.equals(zoneListSorted));

                driver.navigate().back();
                wait.until(ExpectedConditions.titleContains("Geo Zones | My Store"));
            }

        }
    }
}
