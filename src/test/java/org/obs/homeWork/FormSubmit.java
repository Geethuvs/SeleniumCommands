package org.obs.homeWork;

import org.obs.seleniumcommands.Base;
import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormSubmit extends Base {
    @Test
    public void verifyFormSubmitNew() {
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        String firstName = RandomData.getFirstName();
        String lastName = RandomData.getLastName();
        String userName = firstName + lastName;
        String city = RandomData.getCity();
        String state = RandomData.getState();
        String zip = RandomData.getZipCode();
        WebElement firstNames = driver.findElement(By.id("validationCustom01"));
        firstNames.sendKeys(firstName);
        WebElement lastNames = driver.findElement(By.id("validationCustom02"));
        lastNames.sendKeys(lastName);
        WebElement userNames = driver.findElement(By.id("validationCustomUsername"));
        userNames.sendKeys(userName);
        WebElement cities = driver.findElement(By.id("validationCustom03"));
        cities.sendKeys(city);
        WebElement states = driver.findElement(By.id("validationCustom04"));
        states.sendKeys(state);
        WebElement zipes = driver.findElement(By.id("validationCustom05"));
        zipes.sendKeys(zip);
        WebElement termsAndConditions= driver.findElement(By.xpath("//input[@class='form-check-input']"));
        termsAndConditions.click();
        WebElement submitForm=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitForm.click();
        String expectedMessage="Form has been submitted successfully!";
        WebElement submitMessage= driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualMessage= submitMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Form submission failed");
    }
}
