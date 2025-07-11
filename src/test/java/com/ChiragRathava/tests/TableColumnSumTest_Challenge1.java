package com.ChiragRathava.tests;

import com.ChiragRathava.base.BaseTest_Challenge1;
import com.ChiragRathava.utils.ConfigReader;
import com.ChiragRathava.utils.TableUtils_Challenge1;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableColumnSumTest_Challenge1 extends BaseTest_Challenge1 {

    @Description("Verify the sum of column 5 values in the table")
    @Test
    public void testColumn5Total() throws Exception {
        Thread.sleep(3000);

        driver.findElement(By.id("username")).sendKeys(ConfigReader.get("username"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.get("password"));
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.id("log-in")).click();

        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertEquals(currentUrl, ConfigReader.get("url") + "/app.html", "URL not matched");

        double calculatedTotal = TableUtils_Challenge1.calculateColumn5Total(driver);
        System.out.println("Calculated Total: " + calculatedTotal);

        Assert.assertEquals(calculatedTotal, 1996.22, "Total does not match expected value.");
    }
}
