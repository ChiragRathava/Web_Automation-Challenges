
package com.ChiragRathava;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class Challenge_4 {
    @Description(" Login and Dashboard Page Automation in App.vwo.com and Run in two browsers parallel. ")
    @Test
    public void Parallel() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/");
        this.sleep(3000L);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys(new CharSequence[]{"hoxiji5811@nike4s.com"});
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(new CharSequence[]{"6d!DJnd2uZLW8QG"});
        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();
        this.sleep(7000L);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("accountId=1122987"));
        String Header = driver.findElement(By.xpath("//h4[text()=\"Dashboard\"]")).getText();
        AssertJUnit.assertEquals("Dashboard", Header);
        System.out.println("Header: " + Header);
        String User = driver.findElement(By.xpath("//span[text()=\"hoxi ji\"]")).getText();
        AssertJUnit.assertEquals("hoxi ji", User);
        System.out.println(User);
        WebElement menu = driver.findElement(By.xpath("//button[@aria-label='Open user menu']//img[@alt='hoxi ji']"));
        menu.click();
        this.sleep(3000L);
        WebElement logout = driver.findElement(By.xpath("//li[@data-qa=\"logout-btn\"]"));
        logout.click();
        this.sleep(3000L);
        driver.quit();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}