import org.example.ArithmeticOperations;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticOperationsTestNG {
    @DataProvider(name = "operationData")
    public Object[][] provideOperationData() {
        return new Object[][]{
                {5, 3, "+", 8, "5 + 3 должно быть 8"},
                {10, 4, "-", 6, "10 - 4 должно быть 6"},
                {7, 2, "*", 14, "7 * 2 должно быть 14"},
                {15, 3, "/", 5, "15 / 3 должно быть 5"},
                {-5, -3, "+", -8, "-5 + -3 должно быть 8"},
                {-10, 4, "*", -40, "-10 * 4 должно быть -40"}
        };
    }

    @DataProvider(name = "divisionByZeroData")
    public Object[][] provideDivisionByZeroData() {
        return new Object[][]{
                {5, 0, "Деление на ноль"}
        };
    }

    @DataProvider(name = "invalidOperationData")
    public Object[][] provideInvalidOperationData() {
        return new Object[][]{
                {2, 3, "%", "Недопустимая операция"}
        };
    }

    @Test(dataProvider = "operationData",
            testName = "Проверка операции: {4}")
    public void testOperations(int a, int b, String operation, int expected, String description) {
        assertEquals(ArithmeticOperations.calculate(a, b, operation), expected);
    }

    @Test(dataProvider = "divisionByZeroData",
            expectedExceptions = ArithmeticException.class,
            testName = "Проверка деления на ноль: {2}")
    public void testDivisionByZero(int a, int b, String expectedMessage) {
        ArithmeticOperations.calculate(a, b, "/");
    }

    @Test(dataProvider = "invalidOperationData",
            expectedExceptions = IllegalArgumentException.class,
            testName = "Проверка недопустимой операции: {3}")
    public void testInvalidOperations(int a, int b, String operation, String expectedMessage) {
        ArithmeticOperations.calculate(a, b, operation);
    }
}

