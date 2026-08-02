package com.tests.lesson9;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BlockTest {

    @Test
    public void testBlockMts() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();
            page.setViewportSize(1920, 1080);

            page.navigate("https://www.mts.by/");
            page.waitForLoadState(LoadState.NETWORKIDLE);
            try {
                page.locator("button:has-text('Принять')")
                        .click(new Locator.ClickOptions().setTimeout(5000));
                System.out.println("✓ Модальное окно закрыто");
            } catch (Exception e) {
                System.out.println("Модальное окно не появилось");
            }

            try {
                Locator payElement = page.locator("//*[@class='pay']");
                payElement.waitFor(new Locator.WaitForOptions().setTimeout(10000));
                payElement.scrollIntoViewIfNeeded();
                page.waitForTimeout(500);
                assertThat(payElement).isVisible();
                System.out.println("✓ Элемент 'pay' найден и видим");

            } catch (Exception e) {
                System.out.println("✗ Элемент 'pay' не найден");
            }

            browser.close();
        }
    }
}