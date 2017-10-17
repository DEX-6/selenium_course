package ru.stqa.training.selenium.pageObject.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class CreateProductPageAdm extends AbstractPage {

    WebDriver driver;
    String productName;

    public CreateProductPageAdm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void topMenuItemClick(String topMenuItemName) {
        driver.findElement(By.xpath("//ul[@class='index']//a[contains(text(), '" + topMenuItemName + "')]")).click();
        Assert.assertTrue("Вкладка меню не была выбрана!", driver.findElement(By.xpath("//ul[@class='index']//a[contains(text(), '" + topMenuItemName + "')]/..")).getAttribute("class").equals("active"));
    }

    public void fillField(String fieldName, String text) {
        driver.findElement(By.xpath("//input[@name='" + fieldName + "']")).sendKeys(text);
//        driver.findElement(By.xpath("//div[@class='content']//input[@name='" + fieldName + "']")).sendKeys();
    }

    public void fillTextArea(String fieldName, String text){
        driver.findElement(By.xpath("//div[@class='" + fieldName + "']")).click();
        driver.findElement(By.xpath("//div[@class='" + fieldName + "']")).sendKeys(text);
    }

    public void radioButtonClick(String buttonName){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//label[input[@type='radio' and @name='status']]"));
        for (int i = 0; i < radioButtons.size(); i++) {
            WebElement rButton = radioButtons.get(i);
            if ((rButton.getAttribute("textContent").equals(buttonName))) {
                rButton.click();
                Assert.assertTrue("Кнопка не была нажата!",
                        rButton.findElement(By.xpath(".//input")).getAttribute("checked").equals("true"));
                break;
            }
        }


    }

    public void downLoadPic() {
        File file = new File("cats.jpg");
        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(file.getAbsolutePath());
    }

    public String createProductName() {
        productName = "Product №" + uniqueNumberGenerator(10);
        return productName;
    }

    public String getProductName() {
        return productName;
    }

}
