package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {

    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement subProductNameElement;

    String subProductName;

    @FindBy(xpath = "//div[@class='information']//s[@class='regular-price']")
    WebElement subProductPriceElement;

    String subProductPrice;

    @FindBy(xpath = "//div[@class='information']//strong[@class='campaign-price']")
    WebElement subProductPriceWithSaleElement;

    String subProductPriceWithSale;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //        Поиск значений на странице товара

    public String getSubProductName() {
        return subProductName = subProductNameElement.getText();
    }

    public String getSubProductPrice() {
        return subProductPrice = subProductPriceElement.getText();
    }

    public String getSubProductPriceWithSale() {
        return subProductPriceWithSale = subProductPriceWithSaleElement.getText();
    }

    public int mainPriceColorSector(String price, String sector) {
        switch (price) {
            case "general":
                return Integer.parseInt(getPriceColorSector(subProductPriceElement, sector));

            case "sale":
                return Integer.parseInt(getPriceColorSector(subProductPriceWithSaleElement, sector));

            default: return -1;
        }
    }
}
