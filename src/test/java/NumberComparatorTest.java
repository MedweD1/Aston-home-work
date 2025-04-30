import org.example.NumberComparator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComparatorTest {
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void testCompare(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(5, 5, "Числа равны"),
                Arguments.of(10, 5, "Первое число больше"),
                Arguments.of(5, 10, "Второе число больше"),
                Arguments.of(-1, -5, "Первое число больше"),
                Arguments.of(-5, -1, "Второе число больше")
        );
    }
}