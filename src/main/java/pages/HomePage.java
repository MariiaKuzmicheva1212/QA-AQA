package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    // Локаторы
    private final Locator acceptCookiesButton;
    private final Locator connectionPhoneInput;
    private final Locator connectionSumInput;
    private final Locator connectionEmailInput;
    private final Locator continueButton;

    public HomePage(Page page) {
        super(page);

        this.acceptCookiesButton = page.locator("button:has-text('Принять')");
        this.connectionPhoneInput = page.locator("#connection-phone");
        this.connectionSumInput = page.locator("#connection-sum");
        this.connectionEmailInput = page.locator("#connection-email");
        this.continueButton = page.locator("//*[@id = 'pay-connection']//button[text() = 'Продолжить']");
    }

    // Методы действий
    public HomePage open() {
        page.navigate("https://www.mts.by/");
        page.waitForTimeout(3000);
        return this;
    }

    public HomePage acceptCookies() {
        try {
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Принять' не найдена или уже была нажата");
        }
        return this;
    }

    // Геттеры для получения значений placeholder'ов
    public String getPhonePlaceholder() {
        return connectionPhoneInput.getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return connectionSumInput.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return connectionEmailInput.getAttribute("placeholder");
    }

    // Методы заполнения
    public HomePage fillPhoneNumber(String phone) {
        connectionPhoneInput.scrollIntoViewIfNeeded();
        page.waitForTimeout(500);
        connectionPhoneInput.fill(phone);
        return this;
    }

    public HomePage fillSum(String sum) {
        connectionSumInput.fill(sum);
        return this;
    }

    public HomePage fillEmail(String email) {
        connectionEmailInput.fill(email);
        return this;
    }

    public PaymentPage clickContinue() {
        continueButton.click();
        System.out.println("Нажали 'Продолжить'");
        return new PaymentPage(page);
    }
}