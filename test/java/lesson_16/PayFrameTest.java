package test.java.lesson_16;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
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

@Epic("Платежный модуль")
@Feature("Тестирование формы оплаты")
public class PayFrameTest {
    public static WebDriver driver;
    public static test.java.lesson_16.MtsHomePage mtsHomePage;
    public static test.java.lesson_16.PayFrame payFrame;
    public static final String PAGE_URL = "https://mts.by";
    public static final String TEST_PHONE_NUMBER = "297777777";
    public static final String TEST_SUM = "50.00";

    @BeforeAll
    @Step("Инициализация WebDriver и подготовка тестовой страницы")
    static void before() {
        driver = new ChromeDriver();
        mtsHomePage = new test.java.lesson_16.MtsHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mtsHomePage.clickCookieCancelBtn();
        mtsHomePage.setConnectionPhone(TEST_PHONE_NUMBER);
        mtsHomePage.setСonnectionSum(TEST_SUM);
        mtsHomePage.clickPayBtn();
        payFrame = new test.java.lesson_16.PayFrame(driver, mtsHomePage.payFrame);
    }

    @AfterAll
    @Step("Закрытие WebDriver")
    static void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Сумма в заголовке")
    @Description("Проверка отображения суммы в заголовке платежной формы")
    void descriptionCost() {
        String name = "Текст описания суммы в заголовке";
        Allure.step("Проверка текста суммы в заголовке");
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
    @Description("Проверка текста кнопки оплаты")
    void btnText() {
        String name = "Текст кнопки";
        Allure.step("Проверка текста кнопки оплаты");
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
    @Description("Проверка номера телефона в платежной форме")
    void descriptionPhone() {
        String name = "Номер телефона в заголовке";
        Allure.step("Проверка номера телефона в платежной форме");
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
    @Description("Проверка отображения логотипов платежных систем")
    @ValueSource(strings = {"mastercard-system.svg", "visa-system.svg", "belkart-system.svg", "mir-system-ru.svg", "maestro-system.svg"})
    void payPics(String src) {
        Allure.step("Проверка отображения картинки: " + src);
        try {
            assertTrue(payFrame.isDisplayedImg(src), "Картинка " + src + " не отображается");
            System.out.println("Картинка " + src + " отображается");
        } catch (NoSuchElementException e) {
            assertTrue(false, "Картинка " + src + " не найдена");
        }
    }

    @ParameterizedTest
    @DisplayName("Плейсхолдеры реквизитов карты")
    @Description("Проверка правильности заполнения плейсхолдеров реквизитов карты")
    @CsvSource({
            "Поле ввода номера карты, Номер карты",
            "Поле ввода срока действия карты, Срок действия",
            "Поле ввода CVC, CVC",
            "Поле ввода имени держателя, Имя и фамилия на карте"})
    void checkPlaceholders(String name, String expectedPlaceholder) {
        Allure.step("Проверка плейсхолдера для: " + name);
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