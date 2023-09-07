package org.obs.homeWork;

import org.obs.seleniumcommands.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WorkOutClass extends Base {
    @Test
    public void verifyTable() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
        for (int i = 2; i < row.size(); i++) {
            WebElement company = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[" + i + "]//td[1]"));
            String companyName = company.getText();
            if (companyName.equals("Island Trading")) {
                WebElement contact = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[" + i + "]//td[2]"));
                String contactText = contact.getText();
                System.out.println(contactText);
                WebElement country = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[" + i + "]//td[3]"));
                String countryText = country.getText();
                System.out.println(countryText);
            }
        }
    }
}

