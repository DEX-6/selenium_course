package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractPage {

    WebDriver driver;

    AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    String getPriceColorSector(WebElement element, String RGBSector) {
        //        в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
//        Проверка цвета акционной цены
        String color = element.getCssValue("color");
        String colorRGB;
        Pattern pattern = Pattern.compile("[0-9]{1,}, [0-9]{1,}, [0-9]{1,}");
        Matcher matcher = pattern.matcher(color);
        if (matcher.find()) {
            colorRGB = matcher.group();
        } else colorRGB = "Цвет не найден";
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

    String getPriceSize(WebElement price) {
        String fontSize = price.getCssValue("font-size");
        String priceSize;
        Pattern pattern = Pattern.compile("[0-9]{1,}[.0-9]{0,}");
        Matcher matcher = pattern.matcher(fontSize);
        if (matcher.find()) {
            priceSize = matcher.group();
        } else priceSize = "Не удалось узнать размер шрифта";
        return priceSize;
    }

    public String getPriceWeight(WebElement price) {
        String fontWeight = price.getCssValue("font-weight");
        switch (fontWeight) {
            case "bold":
            case "900":
            case "700":
                return "bold";
            case "normal":
            case "400":
                return "normal";
            default:
                return "Шрифт не определен";
        }
    }

    public void loginLinkClick() {
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/login']")).click();
    }

    public void logout() {
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/logout']")).click();
    }

    public boolean isLogoutSuccess() {
        return driver.findElement(By.xpath("//div[@class='notice success' and contains(text(),' You are now logged out.' )]")).isEnabled();
    }
}
