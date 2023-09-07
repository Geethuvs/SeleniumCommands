package org.obs.homeWork;

import org.obs.seleniumcommands.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemo extends Base {
    @Test
    public void verifySingleInputField() {

        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterMessage = driver.findElement(By.id("single-input-field"));
        String singleInputMessage="Hello World";
        enterMessage.sendKeys(singleInputMessage);
        WebElement showMessage = driver.findElement(By.xpath("//button[@id='button-one']"));
        showMessage.click();
        WebElement messageElement= driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualMessage=messageElement.getText();
        String expectedMessage="Your Message : "+singleInputMessage;
        Assert.assertEquals(actualMessage,expectedMessage,"Message not matching");


    }

    @Test
    public void verifyTwoInputFields() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterValueA = driver.findElement(By.id("value-a"));
        enterValueA.sendKeys("10");
        WebElement enterValueB = driver.findElement(By.id("value-b"));
        enterValueB.sendKeys("45");
        WebElement getTotal = driver.findElement(By.xpath("//button[@id='button-two']"));
        getTotal.click();
        boolean getTotalButton= getTotal.isDisplayed();
        Assert.assertTrue(getTotalButton,"Button not displaying");
    }
}