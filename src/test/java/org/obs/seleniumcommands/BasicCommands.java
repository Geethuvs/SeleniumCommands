package org.obs.seleniumcommands;

import org.obs.utility.RandomData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasicCommands extends Base {
    @Test
    public void verifyPageTitle() {
        driver.get("https://demowebshop.tricentis.com/");
        String actTitle = driver.getTitle();
        String expTitle = "Demo Web Shop";
        Assert.assertEquals(actTitle, expTitle, "Title not matching");
    }

    @Test
    public void verifyUserLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));//To find web element
        login.click();
        String emailId = "geethuaravind@gmail.com";
        String pWord = "geethuvs@1994";
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys(emailId);
        WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
        password.sendKeys(pWord);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualEmail = userAccountEmail.getText();
        Assert.assertEquals(actualEmail, emailId, "User login failed");
    }

    @Test

    public void verifyRegister() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        String fName = RandomData.getFirstName();
        String lName = RandomData.getLastName();
        String email = fName + "." + lName + "@obsqura.com";
        String passWord = fName + "." + lName;
        WebElement firstNames = driver.findElement(By.xpath("//input[@class='text-box single-line' and @name='FirstName']"));
        firstNames.sendKeys(fName);
        WebElement lastNames = driver.findElement(By.xpath("//input[@id='Last' or @name='LastName']"));
        lastNames.sendKeys(lName);
        WebElement emails = driver.findElement(By.xpath("//input[@id='Email']"));
        emails.sendKeys(email);
        WebElement passwords = driver.findElement(By.xpath("//input[@id='Password']"));
        passwords.sendKeys(passWord);
        WebElement confirmPasswords = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPasswords.sendKeys(passWord);
        WebElement registerButton = driver.findElement(By.xpath("//input[@name='register-button']"));
        registerButton.click();
        WebElement userMail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualMail = userMail.getText();
        Assert.assertEquals(actualMail, email, "User login failed");
        driver.close();
    }

    @Test
    public void verifyDifferentWebElementCommands() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        String valueAttributeValue = registerButton.getAttribute("value");
        String classAttributeValue = registerButton.getAttribute("class");
        String typeAttributeValue = registerButton.getAttribute("type");
        System.out.println(valueAttributeValue);
        System.out.println(typeAttributeValue);
        System.out.println(classAttributeValue);
        String tagName = registerButton.getTagName();
        System.out.println(tagName);
    }

    @Test
    public void verifyRegisterButtonDisplayedOrNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean status = registerButton.isDisplayed();
        System.out.println(status);
        Assert.assertTrue(status, "Register button not present");
    }

    @Test
    public void verifyRegisterButtonEnabledOrNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean buttonEnable = registerButton.isEnabled();
        System.out.println(buttonEnable);
        Assert.assertTrue(buttonEnable, "Register button is not enabled");
    }

    @Test
    public void verifyGenderSelectedOrNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement gender = driver.findElement(By.id("gender-female"));
        boolean buttonSelectedOrNot = gender.isSelected();
        System.out.println(buttonSelectedOrNot);
        Assert.assertFalse(buttonSelectedOrNot, "Gender selected");
        gender.click();
        boolean buttonStatus = gender.isSelected();
        System.out.println(buttonStatus);
        Assert.assertTrue(buttonStatus, "Gender not selected");
    }

    @Test
    public void verifyFormSubmit() {
        String fn = RandomData.getFirstName();
        String ln = RandomData.getLastName();
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstName.sendKeys(fn);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastName.sendKeys(ln);
        WebElement userName = driver.findElement(By.cssSelector("input#validationCustomUsername"));
        String un = RandomData.getFirstName();
        userName.sendKeys(un);
        WebElement city = driver.findElement(By.cssSelector("input#validationCustom03"));
        String c = RandomData.getCity();
        city.sendKeys(c);
        WebElement state = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        String s = RandomData.getState();
        state.sendKeys(s);
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        String z = RandomData.getZipCode();
        zipCode.sendKeys(z);
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
        checkBox.click();
        WebElement submitForm = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitForm.submit();
    }

    @Test
    public void navigationCommands() {
        //driver.get("https://demowebshop.tricentis.com/");
        driver.navigate().to("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement fName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        fName.sendKeys("Anu");
        WebElement lName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lName.sendKeys("krish");
        driver.navigate().refresh();
        driver.navigate().to("https://demowebshop.tricentis.com/cart");
    }

    @Test
    public void verifyGetCssValue() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        String cssValue = submit.getCssValue("background-color");
        System.out.println(cssValue);

    }

    @Test
    public void verifyGetLocation() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        Point point = submit.getLocation();
        System.out.println("x location: " + point.getX());
        System.out.println("y location: " + point.getY());
    }

    @Test
    public void verifyGetSize() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        Dimension dimension = submit.getSize();
        System.out.println("Height = " + dimension.getHeight());
        System.out.println("Width = " + dimension.getWidth());
    }

    @Test
    public void verifySelectGender() {
        driver.get("https://demowebshop.tricentis.com/register");
        List<WebElement> genders = driver.findElements(By.xpath("//input[@name='Gender']"));
        selectGender("male", genders);
    }

    public void selectGender(String gender, List<WebElement> genders) {
        for (int i = 0; i < genders.size(); i++) {
            WebElement element = genders.get(i);
            String attribute = element.getAttribute("id");
            if (attribute.contains(gender)) {
                element.click();
                break;
            }
        }
    }

    @Test
    public void verifyPanelSelection() {
        driver.get("https://demo.guru99.com/test/newtours/");
        List<WebElement> panelSelection = driver.findElements(By.xpath("//a[@style='margin-left: 5px;color: #0000ee;text-decoration: underline;']"));
        selectPanel("Flights", panelSelection);
    }

    public void selectPanel(String panelName, List<WebElement> panelSelection) {
        for (int i = 0; i < panelSelection.size(); i++) {
            WebElement panel = panelSelection.get(i);
            String text = panel.getText();
            if (text.equals(panelName)) {
                panel.click();
                break;
            }
        }
    }

    @Test
    public void verifySimpleAlert() {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickButton = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/button"));
        clickButton.click();
        Alert alert = driver.switchTo().alert(); //switching to alert
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void verifyConfirmationAlertOk() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement confirmationOk = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/p[4]/button"));
        confirmationOk.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void verifyConfirmationCancel() {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement confirmationCancel = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/p[4]/button"));
        confirmationCancel.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }

    @Test
    public void verifyPromptAlert() {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement promptAlert = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div/div[2]/button"));
        promptAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("sample Message");
        alert.accept();
    }

    @Test
    public void verifyUserEdit() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        WebElement useName = driver.findElement(By.xpath("//input[@name='username']"));
        useName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        List<WebElement> panelSelects = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        selectPanels("Admin", panelSelects);
        List<WebElement> systemUsersData = driver.findElements(By.xpath("//div[@class='oxd-table-card']//div//div/following-sibling::div//div"));
        systemUsersDataMethod("Jacqueline.White", systemUsersData);
    }

    public void selectPanels(String selectValue, List<WebElement> panelSelects) {
        for (int i = 0; i < panelSelects.size(); i++) {
            WebElement element = panelSelects.get(i);
            String elementText = element.getText();
            if (elementText.equals(selectValue)) {
                element.click();
            }
        }

    }

    public void systemUsersDataMethod(String userData, List<WebElement> systemUsersData) {
        for (int j = 0; j < systemUsersData.size(); j++) {
            WebElement userDetails = systemUsersData.get(j);
            String userDetailsText = userDetails.getText();
            //if(userDetailsText.equals(userData)){


            //  }
        }

    }

    @Test
    public void verifyMultipleWindowHandling() {
        driver.get("https://demo.guru99.com/popup.php");
        String parentWindow = driver.getWindowHandle();
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iteratorHandle = handles.iterator();
        while (iteratorHandle.hasNext()) {
            String nextElement = iteratorHandle.next();
            if (!parentWindow.equals(nextElement)) {
                driver.switchTo().window(nextElement);
                WebElement emailId = driver.findElement(By.xpath("//input[@name='emailid']"));
                emailId.sendKeys("abc@gmail.com");
                WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
                submitButton.click();
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }

    @Test
    public void validateCountryDropDownValues() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        select.selectByVisibleText("INDIA");
        //select.selectByValue("INDIA");
        //select.selectByIndex(28);
        List<WebElement> dropDownValues = select.getOptions();
        System.out.println("Size of dropDown list " + dropDownValues.size());
        for (int i = 0; i < dropDownValues.size(); i++) {
            WebElement countryName = dropDownValues.get(i);
            String name = countryName.getText();
            System.out.println(name);
        }
    }

    @Test

    public void verifyCountrySelect() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        selectCountryName("AUSTRIA", countryDropDown);
    }

    public void selectCountryName(String countryName, WebElement countryDropDown) {
        Select select = new Select(countryDropDown);
        boolean countryFound = false;
        List<WebElement> countryList = select.getOptions();
        for (int i = 0; i < countryList.size(); i++) {
            WebElement countryValue = countryList.get(i);
            String countryValueName = countryValue.getText();
            if (countryName.equals(countryValueName)) {
                select.selectByValue(countryName);
                countryFound = true;
                return;
            }
        }
        if (!countryFound) {
            throw new RuntimeException("Country not found " + countryName);
        }
        WebElement selectedCountry = select.getFirstSelectedOption();
        String countryText = selectedCountry.getText();
        Assert.assertEquals(countryText, countryName, "Country not selected");
    }

    @Test
    public void validateDeselect() {
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='second']"));
        Select select = new Select(countryDropDown);
        boolean isMultiple = select.isMultiple();
        Assert.assertTrue(isMultiple, "Given dropdown is not a multiselect");
        select.selectByVisibleText("Pizza");
        select.selectByVisibleText("Donut");
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (int i = 0; i < selectedOptions.size(); i++) {
            WebElement selectedValue = selectedOptions.get(i);
            String valueSelected = selectedValue.getText();
            System.out.println(valueSelected);
        }
        //select.deselectAll();
        //select.deselectByVisibleText("Pizza");
    }

    @Test
    public void selectFromDropDown() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
        WebElement tutorialButton = driver.findElement(By.id("menu1"));
        tutorialButton.click();
        Thread.sleep(10000);
        List<WebElement> dropDownList = driver.findElements(By.xpath("//ul//li//a[@role='menuitem']"));
        dropDownValues("HTML", dropDownList);
    }

    public void dropDownValues(String valueToSelect, List<WebElement> dropDownList) {
        for (int i = 0; i < dropDownList.size(); i++) {
            WebElement dropDownValue = dropDownList.get(i);
            String valueText = dropDownValue.getText();
            if (valueText.equals(valueToSelect)) {
                dropDownValue.click();
                break;
            }
        }
    }
}
















