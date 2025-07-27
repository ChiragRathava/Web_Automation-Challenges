
package com.ChiragRathava;

import io.qameta.allure.Description;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Challenge_3 {
    @Description("Verify the Large Modal Text")
    @Test
    public void Text() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        this.waitForPageLoad(driver);
        System.out.println("✅ Page is fully loaded");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.id("showLargeModal"));
        js.executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
        element.click();

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String title = driver.findElement(By.cssSelector("div[class=\"modal-title h4\"]")).getText();
        AssertT.assertEquals("Large Modal", title);
        System.out.println("Title: " + title);

        String paraText = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(paraText.startsWith("Lorem Ipsum is simply dummy text"));
        AssertJUnit.assertTrue(paraText.endsWith("including versions of Lorem Ipsum."));
        System.out.println("Paragraph: " + paraText);

        driver.findElement(By.id("closeLargeModal")).click();
        element.click();
        AssertJUnit.assertTrue(paraText.contains("It has survived not only five centuries"));
        driver.findElement(By.className("close")).click();
        driver.quit();
    }

    public void waitForPageLoad(WebDriver driver) {
        (new WebDriverWait(driver, Duration.ofSeconds(10L))).until((webDriver) -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState", new Object[0]).equals("complete"));
    }
}