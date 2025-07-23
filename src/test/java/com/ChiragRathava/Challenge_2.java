package com.ChiragRathava;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Challenge_2 {

    @Description("Web tables verification")
    @Test
    public void test() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"rt-table\"]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        driver.findElement(By.id("edit-record-3")).click();
        Thread.sleep(3000);

//        driver.findElement(By.id("age")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE,"29");
//        driver.findElement(By.id("department")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE,"Legal");
//        driver.findElement(By.id("submit")).click();

        // JUnit
        assertEquals("29",driver.findElement(By.id("age")).getAttribute("value"));

        // TestNG
        Assert.assertEquals(driver.findElement(By.id("department")).getAttribute("value"),"Legal");

        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);

        driver.quit();

    }
}
