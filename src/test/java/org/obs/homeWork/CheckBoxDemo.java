package org.obs.homeWork;

import org.obs.seleniumcommands.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxDemo extends Base {
    @Test
    public void verifySingleCheckBoxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement singleCheckBoxDemo = driver.findElement(By.xpath("//input[@id='gridCheck']"));
        singleCheckBoxDemo.click();
        String expectedMessage = "Success - Check box is checked";
        WebElement messageElement = driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualMessage = messageElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Check box not checked");

    }

    @Test
    public void multipleCheckBoxDemoOne() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//label[@class='form-check-label' and contains(@for,'check-box')]"));
        multipleCheckBoxDemo("Check Box Four", checkBoxList);
    }

    public void multipleCheckBoxDemo(String checkBoxValue, List<WebElement> checkBoxList) {
        for (int i = 0; i < checkBoxList.size(); i++) {
            WebElement elementInList = checkBoxList.get(i);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValue)) {
                elementInList.click();
                boolean selectedCheckBox = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBox, "Expected check box not selected");
            }


        }

    }

    @Test
    public void multipleCheckBoxDemoTwo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//label[@class='form-check-label' and contains(@for,'check-box')]"));
        multipleCheckBoxDemo("Check Box Three", "Check Box Two", checkBoxList);

    }

    public void multipleCheckBoxDemo(String checkBoxValueOne, String checkBoxValueTwo, List<WebElement> checkBoxList) {
        for (int i = 0; i < checkBoxList.size(); i++) {
            WebElement elementInList = checkBoxList.get(i);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueOne)) {
                elementInList.click();
                boolean selectedCheckBoxFirst = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxFirst, "Expected check box not selected");
            }
        }
        for (int j = 0; j < checkBoxList.size(); j++) {
            WebElement elementInList = checkBoxList.get(j);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueTwo)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
    }

    @Test
    public void multipleCheckBoxDemoThree() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//label[@class='form-check-label' and contains(@for,'check-box')]"));
        multipleCheckBoxDemo("Check Box Four", "Check Box Two", "Check Box Three", checkBoxList);
    }

    public void multipleCheckBoxDemo(String checkBoxValueOne, String checkBoxValueTwo, String checkBoxValueThree, List<WebElement> checkBoxList) {
        for (int i = 0; i < checkBoxList.size(); i++) {
            WebElement elementInList = checkBoxList.get(i);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueOne)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
        for (int j = 0; j < checkBoxList.size(); j++) {
            WebElement elementInList = checkBoxList.get(j);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueTwo)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
        for (int k = 0; k < checkBoxList.size(); k++) {
            WebElement elementInList = checkBoxList.get(k);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueThree)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
    }

    @Test
    public void multipleCheckBoxDemoFour() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//label[@class='form-check-label' and contains(@for,'check-box')]"));
        multipleCheckBoxDemo("Check Box One", "Check Box Two", "Check Box Three", "Check Box Four", checkBoxList);
    }

    public void multipleCheckBoxDemo(String checkBoxValueOne, String checkBoxValueTwo, String
            checkBoxValueThree, String checkBoxValueFour, List<WebElement> checkBoxList) {
        for (int i = 0; i < checkBoxList.size(); i++) {
            WebElement elementInList = checkBoxList.get(i);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueOne)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
        for (int j = 0; j < checkBoxList.size(); j++) {
            WebElement elementInList = checkBoxList.get(j);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueTwo)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
        for (int k = 0; k < checkBoxList.size(); k++) {
            WebElement elementInList = checkBoxList.get(k);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueThree)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
        for (int m = 0; m < checkBoxList.size(); m++) {
            WebElement elementInList = checkBoxList.get(m);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueFour)) {
                elementInList.click();
                boolean selectedCheckBoxSecond = elementInList.isEnabled();
                Assert.assertTrue(selectedCheckBoxSecond, "Expected check box not selected");
            }
        }
    }

}

