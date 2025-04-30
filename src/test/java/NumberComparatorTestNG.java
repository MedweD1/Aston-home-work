import org.example.NumberComparator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberComparatorTestNG {

    @DataProvider(name = "comparisonData")
    public Object[][] provideComparisonData() {
        return new Object[][]{
                {5, 5, "Числа равны", "5 и 5 должны быть равны"},
                {10, 5, "Первое число больше", "10 должно быть больше 5"},
                {5, 10, "Второе число больше", "5 должно быть меньше 10"},
                {-3, -5, "Первое число больше", "-3 должно быть больше -5"},
                {-5, -2, "Второе число больше", "-5 должно быть меньше -2"}
        };
    }

    @Test(dataProvider = "comparisonData",
            testName = "Проверка сравнения: {3}")
    public void testNumberComparison(int a, int b, String expectedResult, String description) {
        assertEquals(NumberComparator.compare(a, b), expectedResult);
    }

}
