package org.obs.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        WebElement registration= driver.findElement(By.xpath("//a[text()='REGISTER']"));
        registration.click();
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys("ABC");
        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys("vs");
        WebElement phone= driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("1234");
        WebElement email= driver.findElement(By.xpath("//input[@name='userName' and @id='userName']"));
        email.sendKeys("geethu@gmail.com");
        WebElement address= driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys(" ABC line, trivandrum");
        WebElement city= driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("Trivandrum");
        WebElement state= driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys("Kerala");
        WebElement postalCode= driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys("695125");
        WebElement userName= driver.findElement(By.xpath("//input[@name='email' and @id='email']"));
        userName.sendKeys("geethu@gmail.com");
        WebElement passWord= driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("123@456");
        WebElement confirmPassWord= driver.findElement(By.xpath("//input[contains(@name,'confirm')]"));
        confirmPassWord.sendKeys("123@456");
        WebElement submit= driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();


    }
}
