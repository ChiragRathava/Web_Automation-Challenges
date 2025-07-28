
package com.ChiragRathava.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest_Challenge4 {
    public WebDriver driver;

    @Parameters("browser")

    @BeforeMethod
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            this.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            this.driver = new EdgeDriver();
        }

        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }

    }
}