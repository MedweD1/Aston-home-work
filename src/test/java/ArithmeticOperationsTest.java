import org.example.ArithmeticOperations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArithmeticOperationsTest {

    @ParameterizedTest(name = "Тест {index}: {0} {2} {1} = {3}")
    @CsvSource({
            // Положительные числа
            "5, 3, +, 8",
            "10, 4, -, 6",
            "7, 2, *, 14",
            "15, 3, /, 5",

            // Отрицательные числа
            "-5, -3, +, -8",
            "-10, 4, *, -40",
    })
    void testValidOperations(int a, int b, String operation, int expected) {
        assertEquals(expected, ArithmeticOperations.calculate(a, b, operation));
    }

    @ParameterizedTest(name = "Деление на ноль: {0} / {1}")
    @CsvSource({
            "5, 0",
    })
    void testDivisionByZero(int a, int b) {
        assertThrows(ArithmeticException.class, () ->
                ArithmeticOperations.calculate(a, b, "/")
        );
    }

    @ParameterizedTest(name = "Недопустимая операция: {0} {2} {1}")
    @CsvSource({
            "2, 3, %",
    })
    void testInvalidOperations(int a, int b, String operation) {
        assertThrows(IllegalArgumentException.class, () ->
                ArithmeticOperations.calculate(a, b, operation)
        );
    }

}


