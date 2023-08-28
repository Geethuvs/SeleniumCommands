package org.obs.seleniumcommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Base {
    public WebDriver driver;


    public void initialiseTest(String browser) {
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid browser received");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void setUp(){
        initialiseTest("Chrome");
    }
    @AfterMethod
    public void tearDown(){

        //driver.close();
    }
}








