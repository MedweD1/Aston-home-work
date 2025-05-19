package test.java;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
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
    public WebDriver driver;
    public test.java.MtsHomePage mtsHomePage;
    public test.java.PayFrame payFrame;
    public static final String PAGE_URL = "https://mts.by";
    public static final String TEST_PHONE_NUMBER = "297777777";
    public static final String TEST_SUM = "50.00";

    @BeforeEach
    @Step("Инициализация WebDriver и подготовка тестовой страницы")
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mtsHomePage = new test.java.MtsHomePage(driver);
        mtsHomePage.clickCookieCancelBtn();
        mtsHomePage.setConnectionPhone(TEST_PHONE_NUMBER);
        mtsHomePage.setСonnectionSum(TEST_SUM);
        mtsHomePage.clickPayBtn();
        payFrame = new test.java.PayFrame(driver, mtsHomePage.payFrame);
    }

    @AfterEach
    @Step("Закрытие WebDriver")
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Сумма в заголовке")
    @Description("Проверка отображения суммы в заголовке платежной формы")
    void descriptionCost() {
        String name = "Текст описания суммы в заголовке";
        Allure.step("Проверка текста суммы в заголовке");
        String actualValue = payFrame.getPayFrameDescriptionCost();
        assertEquals(TEST_SUM + " BYN", actualValue, name + " не совпадает");
        System.out.println(name + " совпадает: " + actualValue);
    }

    @Test
    @DisplayName("Текст кнопки оплаты")
    @Description("Проверка текста кнопки оплаты")
    void btnText() {
        String name = "Текст кнопки";
        Allure.step("Проверка текста кнопки оплаты");
        String actualValue = payFrame.getPayFrameBtnText();
        assertEquals("Оплатить " + TEST_SUM + " BYN", actualValue, name + " не совпадает");
        System.out.println(name + " совпадает: " + actualValue);
    }

    @Test
    @DisplayName("Номер телефона в заголовке")
    @Description("Проверка номера телефона в платежной форме")
    void descriptionPhone() {
        String name = "Номер телефона в заголовке";
        Allure.step("Проверка номера телефона в платежной форме");
        String actualValue = payFrame.getPayFrameDescriptionPhone();
        assertEquals("Оплата: Услуги связи Номер:375" + TEST_PHONE_NUMBER, actualValue, name + " не совпадает");
        System.out.println(name + " совпадает: " + actualValue);
    }

    @ParameterizedTest
    @DisplayName("Картинки платежных систем")
    @Description("Проверка отображения логотипов платежных систем")
    @ValueSource(strings = {"mastercard-system.svg", "visa-system.svg", "belkart-system.svg", "mir-system-ru.svg", "maestro-system.svg"})
    void payPics(String src) {
        Allure.step("Проверка отображения картинки: " + src);
        assertTrue(payFrame.isDisplayedImg(src), "Картинка " + src + " не отображается");
        System.out.println("Картинка " + src + " отображается");
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
            default:
                throw new AssertionError("Неизвестное имя поля: " + name);
        }
        assertEquals(expectedPlaceholder, actualPlaceholder, name + " не совпадает");
        System.out.println(name + " совпадает: " + actualPlaceholder);
    }
}










