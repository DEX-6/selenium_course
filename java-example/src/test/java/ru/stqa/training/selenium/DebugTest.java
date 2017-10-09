package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DebugTest extends TestBase {
//public class DebugTest {

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
//
//        String color = "rgba(119, 119, 119, 1)";
//        System.out.println("color: " + color);
//        String colorRGB;
//
//
////        String [] colorRGB = color.split("([0-9]{1,}, [0-9]{1,}, [0-9]{1,})");
////        String colorRGB = String.format("([0-9]{1,}, [0-9]{1,}, [0-9]{1,})", color);
//        Pattern pattern = Pattern.compile("[0-9]{1,}, [0-9]{1,}, [0-9]{1,}");
//        Matcher matcher = pattern.matcher(color);
//        if (matcher.find()){
//            colorRGB = matcher.group();
//        } else colorRGB = "цвет не найден";
//        System.out.println("colorRGB: " + colorRGB);
//
//        driver.get("http://localhost/litecart/en/");
//        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));
//
//        String generalLine = driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li//s[@class='regular-price']"))
//                .getCssValue("font-size");
//        System.out.println( "general: " + generalLine);
//
//        String salelLine = driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li//strong[@class='campaign-price']"))
//                .getCssValue("font-size");
//
//        System.out.println("sale: " + salelLine);
//
//        String fontSize = driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li//strong[@class='campaign-price']")).getCssValue("font-size");
//        String priceSize;
//        Pattern pattern = Pattern.compile("[0-9]{1,}[.0-9]{0,}");
//        Matcher matcher = pattern.matcher(fontSize);
//        if (matcher.find()){
//            priceSize = matcher.group();
//        } else priceSize = "Не удалось узнать размер шрифта";
//
//        System.out.println(" priceSize: " + Double.parseDouble(priceSize));

        //        Проверка, что акционная цена имеет жирный шрифт

//        driver.get("http://localhost/litecart/en/");
//        wait.until(ExpectedConditions.titleContains("Online Store | My Store"));

        driver.get("http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");
        wait.until(ExpectedConditions.titleContains("Yellow Duck | Subcategory | Rubber Ducks | My Store"));

        System.out.println("sale: " + driver
                .findElement(By.xpath("//div[@class='information']//strong[@class='campaign-price']")).getCssValue("font-weight"));

//        text-decoration-line


        if (browserType.equals(BrowserType.IE)){

        }
    }
}
