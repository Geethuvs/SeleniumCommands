package org.obs.basics;

import org.obs.utility.RandomData;
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
        String fn= RandomData.getFirstName();
        String ln=RandomData.getLastName();
        String em=RandomData.getEmail();
        String pNum=RandomData.getPhoneNumber();
        String adr=RandomData.getAddress();
        String cty=RandomData.getCity();
        String ste=RandomData.getState();
        String pwd=RandomData.getPassword();
        String postCode=RandomData.getPostalCode();
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys(fn);
        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys(ln);
        WebElement phone= driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(pNum);
        WebElement email= driver.findElement(By.xpath("//input[@name='userName' and @id='userName']"));
        email.sendKeys(em);
        WebElement address= driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys(adr);
        WebElement city= driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys(cty);
        WebElement state= driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys(ste);
        WebElement postalCode= driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys(postCode);
        WebElement userName= driver.findElement(By.xpath("//input[@name='email' and @id='email']"));
        userName.sendKeys(em);
        WebElement passWord= driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys(pwd);
        WebElement confirmPassWord= driver.findElement(By.xpath("//input[contains(@name,'confirm')]"));
        confirmPassWord.sendKeys(pwd);
        WebElement submit= driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        driver.close();


    }
}
