package test.java;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Проверка формы оплаты на главной странице")
@Feature("Плейсхолдеры полей формы оплаты")
public class PaySectionTest {

    private WebDriver driver;
    private test.java.MtsHomePage mtsHomePage;
    public static final String PAGE_URL = "https://mts.by";

    @BeforeEach
    @Step("Инициализация WebDriver и подготовка страницы")
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mtsHomePage = new test.java.MtsHomePage(driver);
        mtsHomePage.clickCookieCancelBtn();
    }

    @AfterEach
    @Step("Закрытие WebDriver")
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest(name = "Проверка плейсхолдера для поля с id: {0}")
    @DisplayName("Тест 1: Проверка плейсхолдеров формы оплаты на главной странице")
    @Description("Проверка соответствия ожидаемых плейсхолдеров полей формы оплаты")
    @CsvSource({
            "connection-phone, Номер телефона",
            "connection-sum, Сумма",
            "connection-email, E-mail для отправки чека",
            "internet-phone, Номер абонента",
            "internet-sum, Сумма",
            "internet-email, E-mail для отправки чека",
            "score-instalment, Номер счета на 44",
            "instalment-sum, Сумма",
            "instalment-email, E-mail для отправки чека",
            "score-arrears, Номер счета на 2073",
            "arrears-sum, Сумма",
            "arrears-email, E-mail для отправки чека"
    })
    public void checkPlaceholders(String idSuffix, String expectedPlaceholder) {
        Allure.step("Проверка плейсхолдера для поля с id: " + idSuffix);
        String actualPlaceholder = getPlaceholderById(idSuffix);
        assertEquals(expectedPlaceholder, actualPlaceholder,
                String.format("Плейсхолдер для '%s' не соответствует ожидаемому", idSuffix));
        System.out.println(idSuffix + " плейсхолдер соответствует");
    }

    private String getPlaceholderById(String idSuffix) {
        switch (idSuffix) {
            case "connection-phone":
                return mtsHomePage.getConnectionPhonePlaceholder();
            case "connection-sum":
                return mtsHomePage.getConnectionSumPlaceholder();
            case "connection-email":
                return mtsHomePage.getConnectionEmailPlaceholder();
            case "internet-phone":
                return mtsHomePage.getInternetPhonePlaceholder();
            case "internet-sum":
                return mtsHomePage.getInternetSumPlaceholder();
            case "internet-email":
                return mtsHomePage.getInternetEmailPlaceholder();
            case "score-instalment":
                return mtsHomePage.getInstalmentScorePlaceholder();
            case "instalment-sum":
                return mtsHomePage.getInstalmentSumPlaceholder();
            case "instalment-email":
                return mtsHomePage.getInstalmentEmailPlaceholder();
            case "score-arrears":
                return mtsHomePage.getArrearsScorePlaceholder();
            case "arrears-sum":
                return mtsHomePage.getArrearsSumPlaceholder();
            case "arrears-email":
                return mtsHomePage.getArrearsEmailPlaceholder();
            default:
                throw new NoSuchElementException("Элемент с id: '" + idSuffix + "' не найден");
        }
    }
}