class ArrayCalculator {
    public static int calculateArraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива (пункт 1)
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] row : array) {
            if (row == null || row.length != 4) {
                throw new MyArraySizeException();
            }
        }

        // Суммирование элементов (пункт 2)
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
