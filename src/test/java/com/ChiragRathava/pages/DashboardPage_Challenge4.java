package com.ChiragRathava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage_Challenge4 {
    WebDriver driver;

    public DashboardPage_Challenge4(WebDriver driver) {
        this.driver = driver;
    }

    public String getDashboardHeader() {
        return this.driver.findElement(By.xpath("//h4[text()=\"Dashboard\"]")).getText();
    }

    public String getLoggedInUser() {
        return this.driver.findElement(By.xpath("//span[text()=\"hoxi ji\"]")).getText();
    }

    public void getMenu() {
        WebElement menu = this.driver.findElement(By.xpath("//button[@aria-label='Open user menu']//img[@alt='hoxi ji']"));
        menu.click();
    }

    public void getLogOut() {
        WebElement Logout = this.driver.findElement(By.xpath("//li[@data-qa=\"logout-btn\"]"));
        Logout.click();
    }
}