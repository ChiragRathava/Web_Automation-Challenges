package com.ChiragRathava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_Challenge4 {
    WebDriver driver;

    public LoginPage_Challenge4(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        this.driver.findElement(By.name("username")).sendKeys(new CharSequence[]{username});
        this.driver.findElement(By.name("password")).sendKeys(new CharSequence[]{password});
        this.driver.findElement(By.id("js-login-btn")).click();
    }
}
