package com.ChiragRathava.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WebTablesPage_level2 {
    private WebDriver driver;

    private By table = By.xpath("//div[@class='rt-table']");
    private By editButton = By.id("edit-record-3");
    private By ageInput = By.id("age");
    private By departmentInput = By.id("department");
    private By submitButton = By.id("submit");

    public WebTablesPage_level2(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForTableToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(table));
    }

    public void scrollPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
    }

    public void clickEditRecord() {
        driver.findElement(editButton).click();
    }

    public String getAge() {
        return driver.findElement(ageInput).getAttribute("value");
    }

    public String getDepartment() {
        return driver.findElement(departmentInput).getAttribute("value");
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}

