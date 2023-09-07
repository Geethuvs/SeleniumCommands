package org.obs.seleniumcommands;

import org.obs.utility.NewTableUtility;
import org.obs.utility.RandomData;
import org.obs.utility.TableUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import javax.swing.*;
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

    @Test
    public void verifyFileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys("D:\\Selenium\\image.jpg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement uploadMessage = driver.findElement(By.xpath("//div[@id='content']//div//h3"));
        String actualMessage = uploadMessage.getText();
        String expectedMessage = "File Uploaded!";
        Assert.assertEquals(actualMessage, expectedMessage, "File upload failed");
    }

    @Test

    public void verifyRightClick() {
        List<String> rightClickList = new ArrayList<>();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).build().perform();
        List<WebElement> listOfWebElements = driver.findElements(By.xpath("//ul//li[contains(@class,'context-menu-item context-menu-icon context-menu-icon')]"));
        for (int i = 0; i < listOfWebElements.size(); i++) {
            WebElement singleElement = listOfWebElements.get(i);
            String singleElementText = singleElement.getText();
            rightClickList.add(singleElementText);
        }

    }

    @Test

    public void verifyDoubleClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).build().perform();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "You double clicked me.. Thank You..";
        Assert.assertEquals(actualMessage, expectedMessage, "double click failed");
        alert.accept();
    }

    @Test
    public void verifyMoveToElementAndClickAndHold() {
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        WebElement alphabetA = driver.findElement(By.xpath("//ul[@id='sortable']//li[@name='A']"));
        WebElement alphabetC = driver.findElement(By.xpath("//ul[@id='sortable']//li[@name='C']"));
        Actions action = new Actions(driver);
        action.moveToElement(alphabetA);
        action.clickAndHold();
        action.moveToElement(alphabetC);
        action.release().build().perform();
    }

    @Test
    public void verifyDragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropHere = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragMe, dropHere).build().perform();
    }

    @Test
    public void verifyDragAndDropByOffset() {
        driver.get("https://demoqa.com/dragabble");
        WebElement dragMe = driver.findElement(By.id("dragBox"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(dragMe, 150, 100).build().perform();

    }

    @Test
    public void verifyMoveToElement() {
        driver.get("https://demoqa.com/menu/");
        Actions action = new Actions(driver);
        WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        action.moveToElement(mainItem2).build().perform();
        WebElement subSubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.moveToElement(subSubList).build().perform();
        WebElement subSubItem1 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        action.moveToElement(subSubItem1).build().perform();
    }

    @Test
    public void verifyProgressBar() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar1 = driver.findElement(By.xpath("//div[@class='range']//input[@name='range']"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar1).clickAndHold().moveToElement(progressBar1, 83, 0).release().build().perform();
    }

    @Test
    public void verifyFrames() {
        driver.get("https://demoqa.com/frames");
        // driver.switchTo().frame("frame1");
        // WebElement firstFrame= driver.findElement(By.id("frame1"));
        // driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(1);
        WebElement frame1 = driver.findElement(By.id("sampleHeading"));
        String fram01 = frame1.getText();
        System.out.println(fram01);
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

    @Test
    public void verifyProgressBar2() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar2 = driver.findElement(By.xpath("//div[@class='range range-success']//input[@name='range']"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar2).clickAndHold().moveToElement(progressBar2, 50, 0).release().build().perform();
    }

    @Test
    public void verifyProgressBar3() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar3 = driver.findElement(By.xpath("//div[@class='range range-warning']//input[@name='range']"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar3).clickAndHold().moveToElement(progressBar3, 80, 0).build().perform();
    }

    @Test
    public void verifyProgressBar4() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar4 = driver.findElement(By.xpath("//div[@class='range range-primary']//input[@name='range']"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar4).clickAndHold().moveToElement(progressBar4, 40, 0).build().perform();
    }

    @Test
    public void verifyProgressBar5() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar5 = driver.findElement(By.xpath("//div[@class='range range-info']//input[@name='range']"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar5).clickAndHold().moveToElement(progressBar5, 70, 0).build().perform();
    }

    @Test
    public void verifyProgressBar6() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar6 = driver.findElement(By.xpath("//div[@class='range range-danger']//input[@name='range']"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar6).clickAndHold().moveToElement(progressBar6, 15, 0).build().perform();
    }

    @Test
    public void verifyDragAndDropList() {
        driver.get("https://selenium.obsqurazone.com/drag-drop.php");
        WebElement draggable1 = driver.findElement(By.xpath("//span[text()='Draggable n°2']"));
        WebElement droppableArea = driver.findElement(By.xpath("//div[@id='mydropzone']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(draggable1, droppableArea).build().perform();
    }

    @Test
    public void verifyJavaScriptExecutor() {
        driver.get("https://demowebshop.tricentis.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('Email').value='geethuaravind@gmail.com'");
        js.executeScript("document.getElementById('Password').value='geethuvs@1994'");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        js.executeScript("arguments[0].click();", loginButton);
    }

    @Test
    public void verifySubscription() {
        driver.get("https://demowebshop.tricentis.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('newsletter-email').value='geethuaravind@gmail.com'");
        js.executeScript("document.getElementById('newsletter-subscribe-button').click();");
        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);
    }

    @Test
    public void verifyVerticalScrol() {
        driver.get("https://demowebshop.tricentis.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
    }

    @Test
    public void verifyHorizontalScrol() {
        driver.get("https://demo.guru99.com/test/guru99home/scrolling.html");
        WebElement vbScript = driver.findElement(By.xpath("//a[text()='VBScript']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", vbScript);
    }

    @Test
    public void verifyScrollIntoTotalHeight() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    @Test
    public void verifyVerticalScroll() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement linux = driver.findElement(By.xpath("//i[@class='icon-linux']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linux);
    }

    @Test
    public void verifyCompanyDetails() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
        for (int i = 2; i < rowElements.size(); i++) {
            WebElement company = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[" + i + "]//td[1]"));
            String companyValue = company.getText();
            if (companyValue.equals("Island Trading")) {
                WebElement contact = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[" + i + "]//td[2]"));
                System.out.println(contact.getText());
                WebElement country = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[" + i + "]//td[3]"));
                System.out.println(country.getText());
                break;
            }
        }
    }

    @Test
    public void verifyTableValues() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
        List<WebElement> columnElements = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//td"));
        List<ArrayList<String>> actualTableValues = TableUtility.get_Dynamic_TwoDimension_TablElemnts(rowElements, columnElements);
        int rowSize = actualTableValues.size();
        int columnSize = actualTableValues.get(0).size();
        for (int i = 0; i < rowSize; i++) {
            String country = actualTableValues.get(i).get(0);
            if (country.equals("Island Trading")) {
                System.out.println(actualTableValues.get(i).get(1));
                System.out.println(actualTableValues.get(i).get(2));
                break;
            }
        }
    }


    @Test
    public void verifyUserManagementEdit() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        WebElement useName = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @name='username']"));
        useName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
        //Alert alert = driver.switchTo().alert();
        //alert.accept();
        List<WebElement> panelSelects = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        selectPanels("Admin", panelSelects);
        List<WebElement> rowElements=driver.findElements(By.xpath("//div[@class='oxd-table']//div[@class='oxd-table-body']//div[@class='oxd-table-card']"));
        List<WebElement>columnElements=driver.findElements(By.xpath("//div[@class='oxd-table']//div[@class='oxd-table-body']//div[@class='oxd-table-card']//div[@class='oxd-table-cell oxd-padding-cell']/div"));
        List<ArrayList<String>> tableActualValues= NewTableUtility.getDynamicTableDetails(rowElements,columnElements);
        int rSize= tableActualValues.size();
        int cSize=tableActualValues.get(0).size();
        for(int i=0;i<rSize;i++)
        {
            String userName=tableActualValues.get(i).get(0);
            if(userName.equals("Jacqueline.White")){
                System.out.println(tableActualValues.get(i).get(1));
                System.out.println(tableActualValues.get(i).get(2));
                System.out.println(tableActualValues.get(i).get(3));
                break;
            }
        }


    }
    public void selectPanels(String selectValue, List<WebElement> panelSelects) {
        for (int i = 0; i < panelSelects.size(); i++) {
            WebElement element = panelSelects.get(i);
            String elementText = element.getText();
            if (elementText.equals(selectValue)) {
                element.click();
                break;
            }
        }

    }
}


















