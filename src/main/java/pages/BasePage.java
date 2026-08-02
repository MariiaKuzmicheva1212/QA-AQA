package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import io.qameta.allure.Step;

public class BasePage {
    protected Page page;
    protected Playwright playwright;
    protected Browser browser;

    public BasePage(Page page) {
        this.page = page;
    }

    @Step("Инициализация браузера")
    public void initBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
    }

    @Step("Закрытие браузера")
    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}