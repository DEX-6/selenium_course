package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.WebElement;

public class AbstractPage {


    public String getPriceColorSector(WebElement element, String RGBSector) {
        //        в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
//        Проверка цвета акционной цены
        String color = element.getCssValue("color");
        String colorRGB = color.substring(5, 14);
        switch (RGBSector) {
            case "R":
                return colorRGB.split(", ")[0];

            case "G":
                return colorRGB.split(", ")[1];

            case "B":
                return colorRGB.split(", ")[2];
            default:
                return "Введите допустимое значение сектора цвета \"R\", \"G\" или \"B\"";
        }
    }
}
