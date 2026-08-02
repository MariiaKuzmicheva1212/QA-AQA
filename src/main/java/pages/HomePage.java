package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage extends BasePage {

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

    @Step("Открыть главную страницу MTS")
    public HomePage open() {
        page.navigate("https://www.mts.by/");
        page.waitForTimeout(3000);
        return this;
    }

    @Step("Принять куки")
    public HomePage acceptCookies() {
        try {
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Принять' не найдена или уже была нажата");
        }
        return this;
    }

    @Step("Получить placeholder поля 'Номер телефона'")
    public String getPhonePlaceholder() {
        return connectionPhoneInput.getAttribute("placeholder");
    }

    @Step("Получить placeholder поля 'Сумма'")
    public String getSumPlaceholder() {
        return connectionSumInput.getAttribute("placeholder");
    }

    @Step("Получить placeholder поля 'E-mail'")
    public String getEmailPlaceholder() {
        return connectionEmailInput.getAttribute("placeholder");
    }

    @Step("Заполнить поле 'Номер телефона': {phone}")
    public HomePage fillPhoneNumber(String phone) {
        connectionPhoneInput.scrollIntoViewIfNeeded();
        page.waitForTimeout(500);
        connectionPhoneInput.fill(phone);
        return this;
    }

    @Step("Заполнить поле 'Сумма': {sum}")
    public HomePage fillSum(String sum) {
        connectionSumInput.fill(sum);
        return this;
    }

    @Step("Заполнить поле 'E-mail': {email}")
    public HomePage fillEmail(String email) {
        connectionEmailInput.fill(email);
        return this;
    }

    @Step("Нажать кнопку 'Продолжить'")
    public PaymentPage clickContinue() {
        continueButton.click();
        System.out.println("Нажали 'Продолжить'");
        return new PaymentPage(page);
    }
}