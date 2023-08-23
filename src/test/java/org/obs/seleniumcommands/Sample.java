package org.obs.seleniumcommands;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
    @Test
    public void verifyStringResult() {
        String expectedResult = "Hello";
        String actualResult = "Hello01";
        Assert.assertEquals(actualResult, expectedResult, "Result not matched");
    }

    @Test
    public void verifyIntegerResult() {
        int expValue = 10;
        int actValue = 20;
        Assert.assertEquals(actValue, expValue, "Result not matched");
    }

    @Test
    public void verifyBooleanTrue() {
        boolean actBoolean = true;
        Assert.assertTrue(actBoolean, "Result not matched");
    }

    @Test
    public void verifyBooleanFalse() {

        }
    }
