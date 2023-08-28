package org.obs.homeWork;

import org.obs.seleniumcommands.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemo extends Base {
    @Test
    public void verifySimpleFormDemo() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterMessage = driver.findElement(By.id("single-input-field"));
        enterMessage.sendKeys("New Message");
        WebElement showMessage = driver.findElement(By.xpath("//button[@id='button-one']"));
        showMessage.click();
        boolean showMessageDisplayed= showMessage.isDisplayed();
        Assert.assertTrue(showMessageDisplayed,"Show message button is not displayed");
        WebElement enterValueA = driver.findElement(By.id("value-a"));
        enterValueA.sendKeys("35");
        WebElement enterValueB = driver.findElement(By.id("value-b"));
        enterValueB.sendKeys("30");
        WebElement getTotal = driver.findElement(By.xpath("//button[@id='button-two']"));
        getTotal.click();
    }
}