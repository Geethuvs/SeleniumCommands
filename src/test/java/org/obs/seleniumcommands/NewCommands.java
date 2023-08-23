package org.obs.seleniumcommands;

import org.obs.utility.RandomData;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class NewCommands extends Base{
    @Test
    public void verifyPageTitles() {
        driver.get("https://demowebshop.tricentis.com/");
        String actTitle = driver.getTitle();
        String expTitle = "Demo Web Shop";
        Assert.assertEquals(actTitle, expTitle, "Title not matching");
    }
}
