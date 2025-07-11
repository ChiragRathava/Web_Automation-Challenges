package com.ChiragRathava;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class level_1 {

    @Description("Web_Table")
    @Test
    public void test() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.applitools.com");

        Thread.sleep(3000);

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.id("log-in")).click();

        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        Assert.assertEquals(url,"https://demo.applitools.com/app.html","not match");

        String first_part = "//table[@class=\"table table-padded\"]//tbody/tr[" ;
        String second_part = "]/td[" ;
        String third_part = "]" ;

        int row = driver.findElements(By.xpath("//table[@class=\"table table-padded\"]//tbody/tr")).size();

        double total = 0.0;

        // Loop through only column 5 in each row
        for (int i = 1; i <= row; i++) {
            String xpath = first_part + i + "]/td[5]";
            WebElement cell = driver.findElement(By.xpath(xpath));
            String data = cell.getText().trim();
            System.out.println("Row " + i + ", Column 5 data: " + data);

            if (!data.isEmpty()) {
                char sign = data.charAt(0); // '+' or '-'
                String numericPart = data.substring(1).replace(",", "").replace("USD", "").trim(); // "1250" or "320"
                double value = Double.parseDouble(numericPart);

                if (sign == '+') {
                    total += value;
                } else if (sign == '-') {
                    total -= value;
                }
            }
        }

        System.out.println("Calculated Total: " + total);

        // Final Assertion
        Assert.assertEquals(Math.round(total * 100.0) / 100.0, 1996.22, "Total mismatch with expected value.");

        driver.quit();

    }
}
