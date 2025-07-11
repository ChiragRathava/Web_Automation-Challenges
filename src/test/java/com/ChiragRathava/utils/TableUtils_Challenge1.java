package com.ChiragRathava.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableUtils_Challenge1 {

    public static double calculateColumn5Total(WebDriver driver) {
        int rowCount = driver.findElements(By.xpath("//table[@class='table table-padded']//tbody/tr")).size();
        double total = 0.0;

        for (int i = 1; i <= rowCount; i++) {
            String xpath = "//table[@class='table table-padded']//tbody/tr[" + i + "]/td[5]";
            WebElement cell = driver.findElement(By.xpath(xpath));
            String data = cell.getText().trim(); // e.g., "+ 1,250 USD"

            System.out.println("Row " + i + ", Column 5 data: " + data);

            if (!data.isEmpty()) {
                char sign = data.charAt(0);
                String numericPart = data.substring(1).replace(",", "").replace("USD", "").trim();
                double value = Double.parseDouble(numericPart);

                if (sign == '+') {
                    total += value;
                } else if (sign == '-') {
                    total -= value;
                }
            }
        }

        return Math.round(total * 100.0) / 100.0; // rounded to 2 decimals
    }
}
