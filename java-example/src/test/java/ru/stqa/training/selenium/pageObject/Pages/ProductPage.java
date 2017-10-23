package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends AbstractPage {

    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement subProductNameElement;

    String subProductName;

    @FindBy(xpath = "//div[@class='information']//s[@class='regular-price']")
    public
    WebElement subProductPriceElement;

    String subProductPrice;

    @FindBy(xpath = "//div[@class='information']//strong[@class='campaign-price']")
    public
    WebElement subProductPriceWithSaleElement;

    String subProductPriceWithSale;

    @FindBy(xpath = "//span[@class='quantity']")
    public
    WebElement productsCounter;

    @FindBy(xpath = "//select[@name='options[Size]']")
    public
    List<WebElement> size;

    public ProductPage(WebDriver driver) {
        super(driver);
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

    public int subPriceColorSector(String price, String sector) {
        switch (price) {
            case "general":
                return Integer.parseInt(getPriceColorSector(subProductPriceElement, sector));

            case "sale":
                return Integer.parseInt(getPriceColorSector(subProductPriceWithSaleElement, sector));

            default:
                return -1;
        }
    }

    public Double getSubPriceSize(String price) {
        switch (price) {
            case "general":
                return Double.parseDouble(getPriceSize(subProductPriceElement));

            case "sale":
                return Double.parseDouble(getPriceSize(subProductPriceWithSaleElement));

            default:
                return -1.0;
        }
    }

    public String getSubPriceWeight(String price) {
        switch (price) {
            case "general":
                return getPriceWeight(subProductPriceElement);

            case "sale":
                return getPriceWeight(subProductPriceWithSaleElement);

            default:
                return "Шрифт цены не определен";
        }
    }

    public String textDecorationLine(String browserType, WebElement price) {
        switch (browserType) {
            case BrowserType.IE:
                return price.getCssValue("text-decoration");
            case BrowserType.CHROME:
                return price.getCssValue("text-decoration-line");
            case BrowserType.FIREFOX:
                return price.getCssValue("text-decoration");
            default:
                return "Невозможно получить офромление элемента";
        }
    }

    public void selectSize(){
        Select select = new Select(size.get(0));
        select.selectByIndex(1);
    }

}
