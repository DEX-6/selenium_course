package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

//public class DebugTest extends TestBase {
public class DebugTest {

    @Test
    public void debugTest() {
//        driver.get("http://localhost/litecart/en/");
//        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

//        Акционная цена (красная)
//        String color = driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li//strong[@class='campaign-price']")).getCssValue("color");
        String color = "rgba(204, 0, 0, 1)";
        System.out.println(color.getBytes().length);
        String colorRGB = color.substring(5, 14);
        System.out.println(colorRGB);
        String colorR = colorRGB.split(", ")[0];
        String colorG = colorRGB.split(", ")[1];
        String colorB = colorRGB.split(", ")[2];

        System.out.println("colorR: " + colorR);
        System.out.println("colorG: " + colorG);
        System.out.println("colorB: " + colorB);
//        rgba(204, 0, 0, 1)
    }
}
