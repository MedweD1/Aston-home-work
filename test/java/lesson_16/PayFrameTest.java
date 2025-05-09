package test.java.lesson_16;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayFrameTest {
    public static WebDriver driver;
    public static MtsHomePage mtsHomePage;
    public static PayFrame payFrame;
    public static final String PAGE_URL = "https://mts.by";
    public static final String TEST_PHONE_NUMBER = "297777777";
    public static final String TEST_SUM = "50.00";

    @BeforeAll
    static void before() {
        driver = new ChromeDriver();
        mtsHomePage = new MtsHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mtsHomePage.clickCookieCancelBtn();
        mtsHomePage.setConnectionPhone(TEST_PHONE_NUMBER);
        mtsHomePage.setСonnectionSum(TEST_SUM);
        mtsHomePage.clickPayBtn();
        payFrame = new PayFrame(driver, mtsHomePage.payFrame);
    }
    @AfterAll
    static void after() {
        driver.quit();
    }
    @Test
    @DisplayName("Сумма в заголовке")
    void descriptionCost() {
        String name = "Текст описания суммы в заголовке";
        try {
            String actualValue = payFrame.getPayFrameDescriptionCost();
            assertEquals(TEST_SUM + " BYN", actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + payFrame.getPayFrameDescriptionCost());
        } catch (NoSuchElementException e) {
            assertTrue(false, name + " не найден");
        }
    }
    @Test
    @DisplayName("Текст кнопки оплаты")
    void btnText() {
        String name = "Текст кнопки";
        try {
            String actualValue = payFrame.getPayFrameBtnText();
            assertEquals("Оплатить " + TEST_SUM + " BYN", actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            assertTrue(false, name + " не найден");
        }
    }
    @Test
    @DisplayName("Номер телефона в заголовке")
    void descriptionPhone() {
        String name = "Номер телефона в заголовке";
        try {
            String actualValue = payFrame.getPayFrameDescriptionPhone();
            assertEquals("Оплата: Услуги связи Номер:375" + TEST_PHONE_NUMBER, actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            assertTrue(false, name + " не найден");
        }
    }

    @ParameterizedTest
    @DisplayName("Картинки платежных систем")
    @ValueSource(strings = {"mastercard-system.svg", "visa-system.svg", "belkart-system.svg", "mir-system-ru.svg", "maestro-system.svg"})
    void payPics(String src) {
        try {
            assertTrue(payFrame.isDisplayedImg(src), "Картинка " + src + " не отображается");
            System.out.println("Картинка " + src + " отображается");
        } catch (NoSuchElementException e) {
            assertTrue(false, "Картинка " + src + " не найдена");
        }
    }

    @ParameterizedTest
    @DisplayName("Плейсхолдеры реквизитов карты")
    @CsvSource({
            "Поле ввода номера карты, Номер карты",
            "Поле ввода срока действия карты, Срок действия",
            "Поле ввода CVC, CVC",
            "Поле ввода имени держателя, Имя держателя (как на карте)"})
    void checkPlaceholders(String name, String expectedPlaceholder) {
        try {
            String actualPlaceholder = "";
            switch (name) {
                case ("Поле ввода номера карты"):
                    actualPlaceholder = payFrame.getCreditCardPlaceholder();
                    break;
                case ("Поле ввода срока действия карты"):
                    actualPlaceholder = payFrame.getExpirationDatePlaceholder();
                    break;
                case ("Поле ввода CVC"):
                    actualPlaceholder = payFrame.getCvcPlaceholder();
                    break;
                case ("Поле ввода имени держателя"):
                    actualPlaceholder = payFrame.getCardHolderPlaceholder();
                    break;
            }
            assertEquals(expectedPlaceholder, actualPlaceholder, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualPlaceholder);
        } catch (NoSuchElementException e) {
            assertTrue(false, name + " не найден");
        }
    }
}
