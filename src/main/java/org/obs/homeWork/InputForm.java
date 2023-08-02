package org.obs.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputForm {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://selenium.obsqurazone.com/index.php");
        WebElement inputForm=driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
        inputForm.click();
        WebElement message=driver.findElement(By.cssSelector("#single-input-field"));
        message.sendKeys("Sample Message");
        WebElement ShowMessage= driver.findElement(By.id("button-one"));
        ShowMessage.click();
        WebElement ValueA=driver.findElement(By.id("value-a"));
        ValueA.sendKeys("10");
        WebElement ValueB= driver.findElement(By.id("value-b"));
        ValueB.sendKeys("15");
        WebElement GetTotal= driver.findElement(By.id("button-two"));
        GetTotal.click();
        driver.close();


        }


    }

