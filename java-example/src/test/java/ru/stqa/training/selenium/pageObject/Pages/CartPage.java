package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@name='remove_cart_item']")
    public
    WebElement buttonRemove;

    //    @FindBy(xpath = "//table[@class='dataTable rounded-corners']//tr/td[@class='item']")
    public
    WebElement removedCartItem;

    @FindBy(xpath = "//table[@class='dataTable rounded-corners']//tr/td[@class='item']")
    public
    List<WebElement> cartItems;

    String removedItemName;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void removeCartItem() {
        removedItemName = buttonRemove.findElement(By.xpath("./parent::p/preceding-sibling::p//a//strong")).getText();
        buttonRemove.click();
    }

    public WebElement getRemovedItem() {
        return removedCartItem = driver.findElement(By.xpath("//table[@class='dataTable rounded-corners']//tr/td[@class='item' and text()='" + removedItemName + "']"));
    }


}
