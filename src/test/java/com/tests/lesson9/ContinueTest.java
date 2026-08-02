package com.tests.lesson9;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class ContinueTest {

    @Test
    public void testContinueMts() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.mts.by/");
        page.waitForTimeout(3000);

        try {
            page.locator("button:has-text('Принять')").click();
        } catch (Exception e) {
        }

        page.locator("#connection-phone").scrollIntoViewIfNeeded();
        page.waitForTimeout(500);

        page.fill("#connection-phone", "297777777");
        page.fill("#connection-sum", "123");
        page.fill("#connection-email", "rewffa@yandex.ru");

        page.click("//*[@id = 'pay-connection']//button[text() = 'Продолжить']");
        System.out.println("Нажали 'Продолжить'");

        System.out.println("Ждем появления окна оплаты...");

        Locator paymentFrame = page.locator(".payment-widget-iframe");

        paymentFrame.waitFor(new Locator.WaitForOptions().setTimeout(15000));

        if (paymentFrame.isVisible()) {
            System.out.println("Окно оплаты успешно открылось!");
        } else {
            System.out.println("Окно оплаты не открылось.");
        }

        page.waitForTimeout(3000);
        browser.close();
        playwright.close();
    }
}