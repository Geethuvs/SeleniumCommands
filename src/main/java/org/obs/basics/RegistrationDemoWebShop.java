package org.obs.basics;

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
        WebElement registers= driver.findElement(By.xpath("//a[@class='ico-register']"));
        registers.click();
        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        WebElement firstNames= driver.findElement(By.xpath("//input[@class='text-box single-line' and @name='FirstName']"));
        firstNames.sendKeys("Anu");
        WebElement lastNames= driver.findElement(By.xpath("//input[@id='Last' or @name='LastName']"));
        lastNames.sendKeys("krishna");
        WebElement emails= driver.findElement(By.xpath("//input[@id='Email']"));
        emails.sendKeys("anukrishna@gmail.com");
        WebElement passwords= driver.findElement(By.xpath("//input[@id='Password']"));
        passwords.sendKeys("anuPassword");
        WebElement confirmPasswords= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPasswords.sendKeys("anuPassword");
        WebElement registerButton= driver.findElement(By.xpath("//input[@name='register-button']"));
        registerButton.click();






    }
}
