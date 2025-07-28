package com.ChiragRathava.tests;

import com.ChiragRathava.base.BaseTest_Challenge4;
import com.ChiragRathava.pages.DashboardPage_Challenge4;
import com.ChiragRathava.pages.LoginPage_Challenge4;
import com.ChiragRathava.utils.ConfigReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Parallel_Execute_Challenge4 extends BaseTest_Challenge4 {

    @Description("Login and validate Dashboard Page")
    @Test
    public void Parallel() throws InterruptedException {
        this.driver.get("https://app.vwo.com/");
        Thread.sleep(3000L);

        LoginPage_Challenge4 login = new LoginPage_Challenge4(this.driver);
        login.login(ConfigReader.get("username_4"), ConfigReader.get("password_4"));

        Thread.sleep(10000L);
        assertTrue(this.driver.getCurrentUrl().contains("accountId=1122987"));

        DashboardPage_Challenge4 dashboard = new DashboardPage_Challenge4(this.driver);
        assertEquals(ConfigReader.get("Header"), dashboard.getDashboardHeader());
        assertEquals(ConfigReader.get("user"), dashboard.getLoggedInUser());

        Thread.sleep(3000L);
        dashboard.getMenu();

        Thread.sleep(2000L);
        dashboard.getLogOut();
    }
}
