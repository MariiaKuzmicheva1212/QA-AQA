package com.tests.lesson9;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LinkTest {

    @Test
    public void testLinkMts() {
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

            Locator link = page.locator("//*[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
            link.waitFor(new Locator.WaitForOptions().setTimeout(10000));
            link.scrollIntoViewIfNeeded();
            link.click();
            System.out.println("✓ Кликнули по ссылке");

            page.waitForLoadState(LoadState.NETWORKIDLE);

            assertThat(page).hasURL("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
            System.out.println("✓ URL правильный: " + page.url());

            browser.close();
        }
    }
}