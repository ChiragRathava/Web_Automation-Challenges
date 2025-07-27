package com.ChiragRathava.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalPage_Challenge3 {
    private WebDriver driver;
    private WebDriverWait wait;

    public ModalPage_Challenge3(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
    }

    public void waitForPageLoad() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until((d) -> ((JavascriptExecutor)d).executeScript("return document.readyState", new Object[0]).equals("complete"));
    }

    public void clickShowLargeModal() {
        WebElement button = this.driver.findElement(By.id("showLargeModal"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", new Object[]{button});
        button.click();
    }

    public String getModalTitle() {
        return this.driver.findElement(By.cssSelector("div.modal-title.h4")).getText();
    }

    public String getParagraphText() {
        return this.driver.findElement(By.tagName("p")).getText();
    }

    public void closeModalWithButton() {
        this.driver.findElement(By.id("closeLargeModal")).click();
    }

    public void closeModalWithX() {
        ((WebElement)this.wait.until(ExpectedConditions.elementToBeClickable(By.className("close")))).click();
    }
}