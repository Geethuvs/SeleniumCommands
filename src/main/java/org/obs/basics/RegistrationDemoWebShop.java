package org.obs.basics;

import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationDemoWebShop {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement register= driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        String fName= RandomData.getFirstName();
        String lName=RandomData.getLastName();
        String email=fName+"."+lName+"@obsqura.com";
        String passWord=fName+"."+lName;
        WebElement registers= driver.findElement(By.xpath("//a[@class='ico-register']"));
        registers.click();
        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        WebElement firstNames= driver.findElement(By.xpath("//input[@class='text-box single-line' and @name='FirstName']"));
        firstNames.sendKeys(fName);
        WebElement lastNames= driver.findElement(By.xpath("//input[@id='Last' or @name='LastName']"));
        lastNames.sendKeys(lName);
        WebElement emails= driver.findElement(By.xpath("//input[@id='Email']"));
        emails.sendKeys(email);
        WebElement passwords= driver.findElement(By.xpath("//input[@id='Password']"));
        passwords.sendKeys(passWord);
        WebElement confirmPasswords= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPasswords.sendKeys(passWord);
        WebElement registerButton= driver.findElement(By.xpath("//input[@name='register-button']"));
        registerButton.click();
        driver.close();
    }
}
