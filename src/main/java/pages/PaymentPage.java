package pages;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class PaymentPage extends BasePage {

    private final Locator paymentFrameLocator;
    private Frame paymentFrame;

    public PaymentPage(Page page) {
        super(page);
        this.paymentFrameLocator = page.locator(".payment-widget-iframe");
    }

    @Step("Получить iframe оплаты")
    private Frame getPaymentFrame() {
        if (paymentFrame == null) {
            try {
                paymentFrameLocator.waitFor(new Locator.WaitForOptions().setTimeout(15000));

                com.microsoft.playwright.ElementHandle iframeElement = paymentFrameLocator.elementHandle();
                if (iframeElement != null) {
                    paymentFrame = iframeElement.contentFrame();
                }

                if (paymentFrame == null) {
                    for (Frame frame : page.frames()) {
                        if (frame.url().contains("checkout.bepaid.by") ||
                                frame.url().contains("bepaid") ||
                                frame.url().contains("payment")) {
                            paymentFrame = frame;
                            break;
                        }
                    }
                }
                System.out.println("✓ Iframe получен: " + (paymentFrame != null ? paymentFrame.url() : "null"));
            } catch (Exception e) {
                System.out.println("✗ Не удалось получить iframe: " + e.getMessage());
            }
        }
        return paymentFrame;
    }

    @Step("Проверить, что окно оплаты отобразилось")
    public boolean isPaymentFrameVisible() {
        System.out.println("Ждем появления окна оплаты...");
        try {
            paymentFrameLocator.waitFor(new Locator.WaitForOptions().setTimeout(15000));
            if (paymentFrameLocator.isVisible()) {
                System.out.println("Окно оплаты успешно открылось!");
                getPaymentFrame();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Окно оплаты не открылось: " + e.getMessage());
        }
        return false;
    }

    @Step("Проверить отображение номера телефона 375297777777")
    public boolean isPhoneNumberDisplayed() {
        try {
            Frame frame = getPaymentFrame();
            if (frame == null) return false;

            Locator phoneElement = frame.locator("//*[contains(text(), '375297777777')]");
            boolean isDisplayed = phoneElement.isVisible();
            if (isDisplayed) {
                System.out.println("✓ Номер телефона 375297777777 отображается");
            }
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("✗ Номер телефона не найден");
            return false;
        }
    }

    @Step("Проверить отображение суммы 123.00")
    public boolean areAllSumElementsDisplayed() {
        try {
            Frame frame = getPaymentFrame();
            if (frame == null) return false;

            System.out.println("Поиск суммы 123.00 в iframe...");

            String[] sumSelectors = {
                    "//*[contains(text(), '123.00')]",
                    "//span[contains(text(), '123.00')]",
                    "//div[contains(text(), '123.00')]",
                    "//p[contains(text(), '123.00')]",
                    "//b[contains(text(), '123.00')]",
                    "//*[contains(., '123.00')]",
                    "//*[@class*='price' and contains(text(), '123.00')]",
                    "//*[@class*='amount' and contains(text(), '123.00')]",
                    "//*[contains(@class, 'total') and contains(text(), '123.00')]",
                    "text=123.00",
                    "text=123,00"
            };

            int totalFound = 0;
            for (String selector : sumSelectors) {
                try {
                    Locator elements = frame.locator(selector);
                    int count = elements.count();
                    if (count > 0) {
                        System.out.println("  По селектору '" + selector + "' найдено: " + count);
                        totalFound += count;
                    }
                } catch (Exception e) {
                }
            }
            try {
                Locator numberElements = frame.locator("//*[contains(text(), '123')]");
                int numberCount = numberElements.count();
                if (numberCount > 0) {
                    System.out.println("  Найдено элементов с числом 123: " + numberCount);
                    for (int i = 0; i < numberCount; i++) {
                        try {
                            String text = numberElements.nth(i).textContent();
                            if (text != null && (text.contains("123.00") || text.contains("123,00"))) {
                                System.out.println("    Найден элемент с суммой: " + text);
                                totalFound++;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (Exception e) {
            }

            System.out.println("Всего найдено элементов с суммой 123.00: " + totalFound);

            if (totalFound >= 1) {
                System.out.println("✓ Сумма 123.00 отображается (" + totalFound + " раз)");
                return true;
            } else {
                System.out.println("✗ Сумма 123.00 не найдена");
                return false;
            }
        } catch (Exception e) {
            System.out.println("✗ Ошибка при проверке суммы: " + e.getMessage());
            return false;
        }
    }

    @Step("Проверить лейблы полей карты")
    public boolean areAllCardLabelsCorrect() {
        try {
            Frame frame = getPaymentFrame();
            if (frame == null) return false;

            frame.waitForSelector("#cc-number", new Frame.WaitForSelectorOptions().setTimeout(10000));

            String actualCardNumber = frame.locator("#cc-number").locator("xpath=..").locator("label").textContent().trim();
            String actualExpiryDate = frame.locator("[placeholder='ММ / ГГ']").locator("xpath=..").locator("label").textContent().trim();
            String actualCvc = frame.locator("[name='verification_value']").locator("xpath=..").locator("label").textContent().trim();
            String actualCardHolder = frame.locator("[autocomplete='cc-name']").locator("xpath=..").locator("label").textContent().trim();

            boolean isCardNumberCorrect = "Номер карты".equals(actualCardNumber);
            boolean isExpiryDateCorrect = "Срок действия".equals(actualExpiryDate);
            boolean isCvcCorrect = "CVC".equals(actualCvc);
            boolean isCardHolderCorrect = "Имя и фамилия на карте".equals(actualCardHolder);

            System.out.println("Проверка лейблов полей карты:");
            System.out.println("  - Номер карты: '" + actualCardNumber + "' → " + (isCardNumberCorrect ? "✓" : "✗"));
            System.out.println("  - Срок действия: '" + actualExpiryDate + "' → " + (isExpiryDateCorrect ? "✓" : "✗"));
            System.out.println("  - CVC: '" + actualCvc + "' → " + (isCvcCorrect ? "✓" : "✗"));
            System.out.println("  - Имя и фамилия: '" + actualCardHolder + "' → " + (isCardHolderCorrect ? "✓" : "✗"));

            return isCardNumberCorrect && isExpiryDateCorrect && isCvcCorrect && isCardHolderCorrect;
        } catch (Exception e) {
            System.out.println("✗ Ошибка при проверке лейблов: " + e.getMessage());
            return false;
        }
    }

    @Step("Проверить все детали оплаты")
    public boolean verifyAllPaymentDetails() {
        boolean allChecksPassed = true;

        System.out.println("\n=== Проверка деталей оплаты ===");
        System.out.println("Всего фреймов: " + page.frames().size());

        if (!isPhoneNumberDisplayed()) {
            allChecksPassed = false;
        }

        if (!areAllSumElementsDisplayed()) {
            allChecksPassed = false;
        }

        if (!areAllCardLabelsCorrect()) {
            allChecksPassed = false;
        }

        System.out.println("=== Результат: " + (allChecksPassed ? "ВСЕ ПРОВЕРКИ ПРОЙДЕНЫ ✓" : "ЕСТЬ ОШИБКИ ✗") + " ===\n");

        return allChecksPassed;
    }
}