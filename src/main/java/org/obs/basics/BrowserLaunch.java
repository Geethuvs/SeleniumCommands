package org.obs.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver;
        // ChromeDriver driver=new ChromeDriver();//launch chrome
        driver = new ChromeDriver(); //upcasting
        // driver=new EdgeDriver(); //launch edge
        //driver=new FirefoxDriver(); // launch firefox
        driver.manage().window().maximize(); //maximise the browser
        driver.manage().deleteAllCookies(); // To delete cookies
        driver.get("https://selenium.obsqurazone.com/index.php"); //load URL
        String actualTitle = driver.getTitle(); // get the title of the website
        System.out.println(actualTitle); // to get the title of the website
        String actualCurrentUrl = driver.getCurrentUrl(); //to get the URL of the website
        System.out.println(actualCurrentUrl);
        String actualPageSource = driver.getPageSource();// to get the source code of the website
        System.out.println(actualPageSource);
        driver.close(); // close browser


    }
}
