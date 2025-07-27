
package com.ChiragRathava.tests;

import com.ChiragRathava.base.BaseTest_Challenge3;
import com.ChiragRathava.pages.ModalPage_Challenge3;
import com.ChiragRathava.utils.ConfigReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class content_of_theModel_Challenge3 extends BaseTest_Challenge3 {

    @Description("Verify the Large Modal Text")
    @Test
    public void testLargeModalText() {
        ModalPage_Challenge3 modalPage = new ModalPage_Challenge3(this.driver);
        modalPage.waitForPageLoad();

        System.out.println("✅ Page is fully loaded");
        modalPage.clickShowLargeModal();
        this.sleep(3000L);

        String title = modalPage.getModalTitle();
        assertEquals(ConfigReader.get("Title"), title);

        String paraText = modalPage.getParagraphText();
        System.out.println("Paragraph: " + paraText);

        assertTrue(paraText.startsWith("Lorem Ipsum is simply dummy text"));
        assertTrue(paraText.contains("It has survived not only five centuries"));
        assertTrue(paraText.endsWith("including versions of Lorem Ipsum."));

        modalPage.closeModalWithButton();
        modalPage.clickShowLargeModal();
        modalPage.closeModalWithX();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
