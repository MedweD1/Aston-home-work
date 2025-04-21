public class Main {
    public static void main(String[] args) {
        // Тестовые данные (пункт 3)
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Проверка работы метода (пункт 3)
        try {
            System.out.println("Сумма корректного массива: " +
                    ArrayCalculator.calculateArraySum(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Сумма массива с неверным размером: " +
                    ArrayCalculator.calculateArraySum(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Сумма массива с неверными данными: " +
                    ArrayCalculator.calculateArraySum(wrongDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Генерация ArrayIndexOutOfBoundsException (пункт 4)
        try {
            String[][] testArray = new String[4][4];
            System.out.println(testArray[4][0]); // Намеренный выход за границы
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nПоймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}