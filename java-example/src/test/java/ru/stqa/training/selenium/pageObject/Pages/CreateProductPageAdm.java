package ru.stqa.training.selenium.pageObject.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateProductPageAdm extends AbstractPage {

    WebDriver driver;
    String productName;
    Thread thread = new Thread();

    public CreateProductPageAdm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void topMenuItemClick(String topMenuItemName) throws InterruptedException {
        driver.findElement(By.xpath("//ul[@class='index']//a[contains(text(), '" + topMenuItemName + "')]")).click();
        thread.sleep(500);
        Assert.assertTrue("Вкладка меню не была выбрана!", driver.findElement(By.xpath("//ul[@class='index']//a[contains(text(), '" + topMenuItemName + "')]/..")).getAttribute("class").equals("active"));
    }

    public void fillField(String fieldName, String text) {
        WebElement input = driver.findElement(By.xpath("//input[@name='" + fieldName + "']"));
        if (input.getAttribute("placeholder").equals("")) {
            input.clear();
        }
        input.sendKeys(text);
//        Assert.assertTrue("", (input.getText().equals(text)|| input.getAttribute("value").equals(text)));
    }

    public void fillTextArea(String fieldName, String text) {
        driver.findElement(By.xpath("//div[@class='" + fieldName + "']")).click();
        driver.findElement(By.xpath("//div[@class='" + fieldName + "']")).sendKeys(text);
    }

    public void radioButtonClick(String buttonName) {
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

    public void categoryCheckboxClick(String nameCheckbox, String checkboxState) {
        boolean cState = false;
        switch (checkboxState) {
            case "+":
                cState = true;
                break;
            case "-":
                cState = false;
                break;
        }
        if (checkboxState(driver.findElement(By.xpath("//input[@name='categories[]' and @data-name='" + nameCheckbox + "']"))) != cState) {
            driver.findElement(By.xpath("//input[@name='categories[]' and @data-name='" + nameCheckbox + "']")).click();
        }
        Assert.assertTrue("Не удалось установить значение чекбокса",
                checkboxState(driver.findElement(By.xpath("//input[@name='categories[]' and @data-name='" + nameCheckbox + "']"))) == cState);

    }

    public void productGroupsCheckboxClick(String nameCheckbox, String checkboxState) {
        boolean cState = false;
        switch (checkboxState) {
            case "+":
                cState = true;
                break;
            case "-":
                cState = false;
                break;
        }

        List<WebElement> tdList = driver.findElements(By.xpath("//td[input[@name='product_groups[]']]/following-sibling::td"));
        int checkboxNumber = 0;
        for (; checkboxNumber < tdList.size(); checkboxNumber++) {
            if (tdList.get(checkboxNumber).getText().equals(nameCheckbox)) {
                break;
            }
        }
        List<WebElement> inputList = driver.findElements(By.xpath("//input[@name='product_groups[]']"));
        if (checkboxState(inputList.get(checkboxNumber)) != cState) {
            inputList.get(checkboxNumber).click();
        }
        Assert.assertTrue("Не удалось установить значение чекбокса",
                checkboxState(inputList.get(checkboxNumber)) == cState);
    }

    public void fillCombobox(String fieldName, String text) {
        Select select = new Select(driver.findElement(By.xpath("//select[@name='" + fieldName + "']")));
        select.selectByVisibleText(text);
//        select.selectByValue(text);
    }

    public void buttonClick(String buttonName) {
        driver.findElement(By.xpath("//button[@name='" + buttonName + "']")).click();
    }

    private boolean checkboxState(WebElement checkbox) throws NullPointerException {
        if (checkbox.getAttribute("checked") == null) {
            return false;
        } else if (checkbox.getAttribute("checked").equals("true")) {
            return true;
        } else return false;
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

    public String notice_success(){
        return driver.findElement(By.xpath("//div[@class='notice success']")).getText();
    }
}
