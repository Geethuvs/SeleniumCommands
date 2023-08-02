package org.obs.basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsCommands {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement emailField = driver.findElement(By.id("Email"));//To find web element
        emailField.sendKeys("geethuaravind1994@gmail.com");
        WebElement passWordField = driver.findElement(By.name("Password"));
        passWordField.sendKeys("PassWord");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();
    }
}

