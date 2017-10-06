package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@id = 'box-campaigns']//li//div[@class='name']")
    WebElement mainProductNameElement;

    String mainProductName;

    @FindBy(xpath = "//div[@id = 'box-campaigns']//li//s[@class='regular-price']")
    WebElement mainProductPriceElement;

    String mainProductPrice;

    @FindBy(xpath = "//div[@id = 'box-campaigns']//li//strong[@class='campaign-price']")
    WebElement mainProductPriceWithSaleElement;

    String mainProductPriceWithSale;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getMainProductName() {
        return mainProductName = mainProductNameElement.getText();
    }

    public String getMainProductPrice() {
        return mainProductPrice = mainProductPriceElement.getText();
    }

    public String getMainProductPriceWithSale() {
        return mainProductPriceWithSale = mainProductPriceWithSaleElement.getText();
    }

    public int mainPriceColorSector(String price, String sector) {
        switch (price) {
            case "general":
                return Integer.parseInt(getPriceColorSector(mainProductPriceElement, sector));

            case "sale":
                return Integer.parseInt(getPriceColorSector(mainProductPriceWithSaleElement, sector));

                default: return -1;
        }
    }

    public void goToProductPage() {
        driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li//a")).click();
    }
}