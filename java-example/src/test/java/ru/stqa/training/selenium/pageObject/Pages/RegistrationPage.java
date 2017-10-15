package ru.stqa.training.selenium.pageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends AbstractPage {
    WebDriver driver;
    Thread thread = new Thread();
    String emai;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillRegistrationForm() throws InterruptedException {
        fillRegistrationField("firstname", "Name");
        fillRegistrationField("lastname", "Lastname");
        fillRegistrationField("address1", "Address");
        fillRegistrationField("postcode", uniqueNumberGenerator(5));
        fillRegistrationField("city", "NewYork");
        fillRegistrationCombobox("Country", "United States");
        thread.sleep(3000);
        fillRegistrationCombobox("Zone/State/Province", "Alabama");
        fillRegistrationField("email", createEmail());
        fillRegistrationField("phone", "+1" + uniqueNumberGenerator(10));
        fillRegistrationField("password", "11111");
        fillRegistrationField("confirmed_password", "11111");
    }

    private void fillRegistrationField(String fieldName, String text) {
        driver.findElement(By.xpath("//form[@name='customer_form']//input[@name='" + fieldName + "']")).sendKeys(text);
    }

    private void fillRegistrationCombobox(String fieldName, String text) {
        Select select = new Select(driver.findElement(By.xpath("//form[@name='customer_form']//td[contains(text(), '" + fieldName + "')]//select")));
        select.selectByVisibleText(text);
//        select.selectByValue(text);
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

//    public String getRegistrationFieldText(String fieldName){
//        return driver.findElement(By.xpath("//form[@name='customer_form']//input[@name='" + fieldName + "']")).getAttribute("text");
//    }

    private String createEmail(){
        emai = uniqueNumberGenerator(10) + "@mail.ru";
        return emai;
    }
    public String getEmail(){
        return emai;
    }
}
