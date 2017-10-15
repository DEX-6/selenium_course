package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage extends AbstractPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillRegistrationForm() {
        fillRegistrationField("firstname", "Name");
        fillRegistrationField("lastname", "Lastname");
        fillRegistrationField("address1", "Address");
        fillRegistrationField("postcode", uniqueNumberGenerator(5));
        fillRegistrationField("city", "NewYork");
        fillRegistrationCombobox("Country", "US");
        fillRegistrationCombobox("Zone/State/Province", "AL");
        fillRegistrationField("email", uniqueNumberGenerator(10) + "@mail.ru");
        fillRegistrationField("phone", "+1" + uniqueNumberGenerator(10));
        fillRegistrationField("password", "11111");
        fillRegistrationField("confirmed_password", "11111");
    }

    private void fillRegistrationField(String fieldName, String text) {
        driver.findElement(By.xpath("//form[@name='customer_form']//input[@name='" + fieldName + "']")).sendKeys(text);
    }

    private void fillRegistrationCombobox(String fieldName, String text) {
        Select select = new Select(driver.findElement(By.xpath("//form[@name='customer_form']//td[contains(text(), '" + fieldName + "')]//select")));
//        select.selectByVisibleText(text);
        select.selectByValue(text);
    }

    public void createAccount(){
        driver.findElement(By.xpath("//button[@name='create_account']")).click();
    }

    private String uniqueNumberGenerator(int numberOfDigits) {
        StringBuilder postcode = new StringBuilder();

        for (int i = 0; i < numberOfDigits; i++) {
            postcode.append(numberGenerator());
        }
        return String.valueOf(postcode);
    }

    private String numberGenerator() {
        int a = 1 + (int) (Math.random() * 9);
        return String.valueOf(a);
    }

}
