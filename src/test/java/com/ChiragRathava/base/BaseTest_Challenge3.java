package com.ChiragRathava.base;

import com.ChiragRathava.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest_Challenge3 {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.get("browser3");
        String url_3 = ConfigReader.get("url_3");

        if (browser.equalsIgnoreCase("chrome")) {
            this.driver = new ChromeDriver();
        } else {
            if (!browser.equalsIgnoreCase("edge")) {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            this.driver = new EdgeDriver();
        }

        this.driver.manage().window().maximize();
        this.driver.get(url_3);
    }

    @AfterMethod
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }

    }
}