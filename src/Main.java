public class Main {

    public static void main(String[] args) {
        //Задание 1
        printThreeWords();
        //Задание 2
        checkSumSign();
        //Задание 3
        printColor();
        //Задание 4
        compareNumbers();
        //Задание 5
        System.out.println(isSumInRange(5, 15));
        //Задание 6
        printPositiv(-10);
        //Задание 7
        System.out.println(Negative(8));
        //Задание 8
        printStr("Привет! Как дела ?", 2 * 3);
        //Задание 9
        System.out.println(LeapYear(1984));
        //Задание 10
        int[] Array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        flipBinaryArray(Array);
        //Задание 11
        int[] nums = new int[100];
        fillArrayValues(nums);
        //Задание 12
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        modifyArrayValues(array, 6);
        //Задание 13
        int[][] massiv = new int[5][5];
        fillDiagonalOnes(massiv);
        //Задание 14
        createIntArray(3 * 3, 9);

    }

    //      Печатаем в столбец три слова: Orange, Banana, Apple.

    public static void printThreeWords() {
        System.out.println("\n Ответ № 1");
        System.out.println("\nOrange \nBanana \nApple  ");
    }

    //Суммируем  две переменные и выводит сообщение о знаке суммы.

    public static void checkSumSign() {
        System.out.println("\n Ответ № 2");
        int a, b, c;
        a = 46;
        b = -47;
        c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");

        } else {
            System.out.println("Сумма  отрицательная");
        }

    }

    //Задаем переменную value и выводит сообщение о цвете в зависимости от значения переменной.

    public static void printColor() {
        System.out.println("\n Ответ № 3");
        int value = -30; // задаем отриц значение

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

    }

    //Сравниваем две переменные и выводит сообщение о результате сравнения.

    public static void compareNumbers() {
        System.out.println("\n Ответ № 4");
        int a, b;
        a = 12;
        b = 5;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


    //Проверка находится ли сумма двух чисел в диапазоне от 10 до 20 включительно.
    /*
     @param a1 первое число
      @param b1 второе число
     @return true, если сумма лежит в заданном диапазоне, иначе false
     */
    public static boolean isSumInRange(int a1, int b1) {
        System.out.println("\n Ответ № 5");
        int c1 = a1 + b1;
        return (c1 >= 10 && c1 <= 20);
    }

    /*Проверяем является ли число положительным или отрицательным.
     при этом ноль считаем положительным числом.
          * @param number число для проверки
     */
    public static void printPositiv(int number) {
        System.out.println("\n Ответ №  6");
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean Negative(int number) {
        System.out.println("\n Ответ №  7");
        if (number >= 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

        return number <= -10;
    }



    /*

     * @param str Строка для печати
     * @param a   Количество раз для печати строки
     */
    public static void printStr(String str, int a) {
        System.out.println("\n Ответ №  8 Печатаем строку указанное количество раз.");
        for (int i = 0; i < a; i++) {
            System.out.println(str);

        }
    }


    /*Определяем, является ли заданный год високосным.
     *
     * @param year Год для проверки
     * @return true, если год високосный, иначе false
     */
    public static boolean LeapYear(int year) {
        System.out.println("\n Ответ №  9");
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /* Меняем значения 0 на 1 и 1 на 0 в заданном массиве.
     *
     * @param args Массив, в котором происходит замена
     */
    public static void flipBinaryArray(int[] args) {
        System.out.println("\n Ответ №  10");
        for (int i = 0; i < args.length; i++) {
            if (args[i] == 0) {
                args[i] = 1;
            } else {
                args[i] = 0;
            }
            System.out.print((args[i]) + "     ");
        }
    }

    /**
     * Заполняем массив значениями от 1 до 100 длины массива.
     *
     * @param array Массив, который нужно заполнить
     */
    public static void fillArrayValues(int[] array) {
        System.out.println("\n\nОтвет №  11");
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        } for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


    }
    /**
     * Метод умножает на 2 числа, которые меньшие 6 в  массиве.
     *
     * @param array Массив для обработки
     * @param count Пороговое значение для умножения
     */

    public static void modifyArrayValues(int[] array, int count) {
        System.out.println("\n\n Ответ №  12");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < count) {
                System.out.print((array[i] *= 2) + " ");
            } else {
                System.out.print((array[i]) + " ");
            }
        }

    }

    /**
     * Заполняем диагональные элементы в квадратном массиве единицами1.
     *
     * @param array Квадратный двумерный массив
     */
    public static void fillDiagonalOnes(int[][] array) {
        System.out.println("\n\n Ответ №  13");
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Создаем новый одномерный массив с указанной длиной и каждой ячейкой равной initialValue.
     *
     * @param len          Длина нового массива
     * @param initialValue Значение для каждой ячейки массива
     * @return Создан одномерный массив
     */
    public static int[] createIntArray(int len, int initialValue) {
        System.out.println("\n  Ответ №  14");
        int[] newsArr = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.print(newsArr[i] = initialValue);

        }
        return newsArr;
    }


}