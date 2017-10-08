package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class DebugTest extends TestBase {
public class DebugTest {

    @Test
    public void debugTest() {
//        driver.get("http://localhost/litecart/en/");
//        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

//        Акционная цена (красная)
//        String color = driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li//strong[@class='campaign-price']")).getCssValue("color");
//        String color = "rgba(204, 0, 0, 1)";
//        System.out.println(color.getBytes().length);
//        String colorRGB = color.substring(5, 14);
//        System.out.println(colorRGB);
//        String colorR = colorRGB.split(", ")[0];
//        String colorG = colorRGB.split(", ")[1];
//        String colorB = colorRGB.split(", ")[2];
//
//        System.out.println("colorR: " + colorR);
//        System.out.println("colorG: " + colorG);
//        System.out.println("colorB: " + colorB);
//        rgba(204, 0, 0, 1)

        String color = "rgba(119, 119, 119, 1)";
        System.out.println("color: " + color);
        String colorRGB;


//        String [] colorRGB = color.split("([0-9]{1,}, [0-9]{1,}, [0-9]{1,})");
//        String colorRGB = String.format("([0-9]{1,}, [0-9]{1,}, [0-9]{1,})", color);
        Pattern pattern = Pattern.compile("[0-9]{1,}, [0-9]{1,}, [0-9]{1,}");
        Matcher matcher = pattern.matcher(color);
        if (matcher.find()){
            colorRGB = matcher.group();
        } else colorRGB = "цвет не найден";
        System.out.println("colorRGB: " + colorRGB);
    }
}
