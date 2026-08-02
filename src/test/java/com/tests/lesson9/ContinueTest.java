package com.tests.lesson9;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import pages.HomePage;
import pages.PaymentPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("MTS Payment Tests")
@Feature("Payment Process")
public class ContinueTest {

    private Playwright playwright;
    private Browser browser;
    private Page page;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
        homePage = new HomePage(page);
    }

    @AfterMethod
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @Test
    @Description("Проверка процесса оплаты через форму на сайте MTS")
    @Story("Проверка платежного виджета")
    @Severity(SeverityLevel.CRITICAL)
    public void testContinueMts() {
        homePage.open();

        homePage.acceptCookies();

        Assert.assertEquals(homePage.getPhonePlaceholder(), "Номер телефона",
                "Placeholder для телефона не соответствует");
        Assert.assertEquals(homePage.getSumPlaceholder(), "Сумма",
                "Placeholder для суммы не соответствует");
        Assert.assertEquals(homePage.getEmailPlaceholder(), "E-mail для отправки чека",
                "Placeholder для email не соответствует");

        System.out.println("✓ Все placeholder'ы проверены");

        homePage.fillPhoneNumber("297777777")
                .fillSum("123")
                .fillEmail("rewffa@yandex.ru");

        PaymentPage paymentPage = homePage.clickContinue();

        Assert.assertTrue(paymentPage.isPaymentFrameVisible(),
                "Окно оплаты не открылось");

        Assert.assertTrue(paymentPage.verifyAllPaymentDetails(),
                "Не все детали оплаты отображаются корректно");

        Assert.assertTrue(paymentPage.isPhoneNumberDisplayed(),
                "Номер телефона не отображается");
        Assert.assertTrue(paymentPage.areAllSumElementsDisplayed(),
                "Сумма отображается не во всех местах");
        Assert.assertTrue(paymentPage.areAllCardLabelsCorrect(),
                "Лейблы полей карты не соответствуют ожидаемым");

        page.waitForTimeout(3000);

        System.out.println("✅ Тест успешно завершен!");
    }
}