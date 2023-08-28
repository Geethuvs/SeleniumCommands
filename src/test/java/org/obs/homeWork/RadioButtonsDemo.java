package org.obs.homeWork;

import org.obs.seleniumcommands.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtonsDemo extends Base {
    @Test
    public void verifyRadioButtonDemo() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        List<WebElement> genderList = driver.findElements(By.xpath("//input[@class='form-check-input' and @name='inlineRadioOptions']//following-sibling::label"));
        genderSelect("Female", genderList);
        WebElement showSelectedValue = driver.findElement(By.id("button-one"));
        showSelectedValue.click();
        boolean isDisplayed= showSelectedValue.isDisplayed();
        Assert.assertTrue(isDisplayed,"Button not displayed");
        List<WebElement> patenintsGenderList = driver.findElements(By.xpath("//input[@name='student-gender']//following-sibling::label"));
        patenintsGenderSelect("Female", patenintsGenderList);
        List<WebElement> patenintsAgeGroupList = driver.findElements(By.xpath("//input[@name='student-age']/following-sibling::label"));
        patenintsAgeGroup("19 t0 44", patenintsAgeGroupList);
        WebElement getResults = driver.findElement(By.id("button-two"));
        getResults.click();
    }

    public void genderSelect(String gender, List<WebElement> genderList) {
        for (int i = 0; i < genderList.size(); i++) {
            WebElement genderElement = genderList.get(i);
            String genderText = genderElement.getText();
            if (genderText.equals(gender)) {
                genderElement.click();
            }
        }
    }

    public void patenintsGenderSelect(String patenintGender, List<WebElement> patenintsGenderList) {
        for (int j = 0; j < patenintsGenderList.size(); j++) {
            WebElement genderElement = patenintsGenderList.get(j);
            String genderText = genderElement.getText();
            if (genderText.equals(patenintGender)) {
                genderElement.click();
            }
        }
    }

    public void patenintsAgeGroup(String age, List<WebElement> patenintsAgeGroupList) {
        for (int k = 0; k < patenintsAgeGroupList.size(); k++) {
            WebElement ageElement = patenintsAgeGroupList.get(k);
            String ageElementText = ageElement.getText();
            if (ageElementText.equals(age)) {
                ageElement.click();
            }
        }
    }
}
