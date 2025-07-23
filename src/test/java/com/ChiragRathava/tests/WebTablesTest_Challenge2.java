package com.ChiragRathava.tests;

import com.ChiragRathava.base.BaseTest_Challenge2;
import com.ChiragRathava.pages.WebTablesPage_level2;
import com.ChiragRathava.utils.ConfigReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest_Challenge2 extends BaseTest_Challenge2 {

    @Description("Web tables verification")
    @Test
    public void verifyWebTableEditData() throws InterruptedException {
        WebTablesPage_level2 webTables = new WebTablesPage_level2(driver);

        webTables.waitForTableToLoad();
        webTables.scrollPage();

        webTables.clickEditRecord();
        Thread.sleep(2000);

        Assert.assertEquals(webTables.getAge(), ConfigReader.get("age"));
        Assert.assertEquals(webTables.getDepartment(), ConfigReader.get("department"));

        webTables.clickSubmit();
        Thread.sleep(1000);
    }
}
