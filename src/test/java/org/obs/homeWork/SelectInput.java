package org.obs.homeWork;

import org.obs.seleniumcommands.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectInput extends Base {
    @Test

    public void verifySelectInputDemo() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colorDropDown = driver.findElement(By.xpath("//select[@id='single-input-field']"));
        selectColor("Yellow", colorDropDown);
    }

    public void selectColor(String color, WebElement colorDropDown) {
        Select select = new Select(colorDropDown);
        List<WebElement> colorOptionsList = select.getOptions();
        for (int i = 0; i < colorOptionsList.size(); i++) {
            WebElement colorElement = colorOptionsList.get(i);
            String colorText = colorElement.getText();
            if (colorText.equals(color)) {
                select.selectByValue(color);
            }
        }

    }

    @Test
    public void verifyTwoInputFieldsOne() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement multiColorDropDown = driver.findElement(By.id("multi-select-field"));
        selectMultiColor("Green", multiColorDropDown);
        verifyGetFirstSelected();
        verifyGetAllSelected();
    }

    public void selectMultiColor(String color1, WebElement mutiColorDropDown) {
        Select select = new Select(mutiColorDropDown);
        select.selectByVisibleText(color1);
    }

    @Test
    public void verifyTwoInputFieldsTwo() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement multiColorDropDown = driver.findElement(By.id("multi-select-field"));
        selectMultiColor("Green", "Red", multiColorDropDown);
        verifyGetFirstSelected();
        verifyGetAllSelected();
    }

    public void selectMultiColor(String color1, String color2, WebElement multiColorDropDown) {
        Select select = new Select(multiColorDropDown);
        boolean isMultiple = select.isMultiple();
        select.selectByVisibleText(color1);
        select.selectByVisibleText(color2);
    }

    @Test
    public void verifyTwoInputFieldsThree() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement multiColorDropDown = driver.findElement(By.id("multi-select-field"));
        selectMultiColor("Green", "Red", "Yellow", multiColorDropDown);
        verifyGetFirstSelected();
        verifyGetAllSelected();
    }

    public void selectMultiColor(String color1, String color2, String color3, WebElement multiColorDropDown) {
        Select select = new Select(multiColorDropDown);
        boolean isMultiple = select.isMultiple();
        Assert.assertTrue(isMultiple, "Given drop down is not multiselect");
        select.selectByVisibleText(color1);
        select.selectByVisibleText(color2);
        select.selectByVisibleText(color3);
    }

    public void verifyGetFirstSelected(){
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement getFirstSelected=driver.findElement(By.id("button-first"));
        getFirstSelected.click();
    }

    public void verifyGetAllSelected(){
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement getAllSelected = driver.findElement(By.id("button-all"));
        getAllSelected.click();
    }
}

