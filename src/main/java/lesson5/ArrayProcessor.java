package lesson5;

public class ArrayProcessor {

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        private int row;
        private int col;
        private String value;

        public MyArrayDataException(int row, int col, String value) {
            super(String.format("Неверные данные в ячейке [%d][%d]: '%s' не является числом", row, col, value));
            this.row = row;
            this.col = col;
            this.value = value;
        }

        public int getRow() { return row; }
        public int getCol() { return col; }
        public String getValue() { return value; }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }

        if (array.length != 4) {
            throw new MyArraySizeException(
                    String.format("Неверное количество строк: ожидается 4, получено %d", array.length)
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new MyArraySizeException(
                        String.format("Строка %d равна null", i)
                );
            }
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("Неверная длина строки %d: ожидается 4, получено %d",
                                i, array[i].length)
                );
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {

                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {

                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы с исключениями ===\n");


        System.out.println("Тест 1: Корректный массив");
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        testArray(validArray);

        System.out.println("\nТест 2: Массив с неверным размером (3x4)");
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };
        testArray(wrongSizeArray);

        System.out.println("\nТест 3: Массив с неверными данными");
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "abc", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        testArray(invalidDataArray);


        System.out.println("\nТест 4: Массив с null строкой");
        String[][] nullRowArray = {
                {"1", "2", "3", "4"},
                null,
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        testArray(nullRowArray);

        System.out.println("\n=== Генерация и обработка ArrayIndexOutOfBoundsException ===");
        demonstrateArrayIndexOutOfBounds();
    }

    private static void testArray(String[][] array) {
        try {
            int result = processArray(array);
            System.out.println("✅ Результат суммирования: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("❌ Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("❌ Ошибка данных: " + e.getMessage());
            System.err.println("   Детали: строка=" + e.getRow() +
                    ", колонка=" + e.getCol() +
                    ", значение='" + e.getValue() + "'");
        }
    }

    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n--- Пример 1: Обращение к несуществующему индексу ---");

        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.println("Попытка получить элемент по индексу 10...");
            int value = numbers[10];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Поймано исключение: " + e);
            System.err.println("Сообщение: " + e.getMessage());
            System.err.println("Длина массива: " + numbers.length);
            System.err.println("Индекс 10 выходит за допустимые пределы (0-" + (numbers.length - 1) + ")");
        }

        System.out.println("\n--- Пример 2: Обращение к отрицательному индексу ---");

        try {
            System.out.println("Попытка получить элемент по индексу -1...");
            int value = numbers[-1];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Поймано исключение: " + e);
            System.err.println("Индекс -1 недопустим");
        }

        System.out.println("\n--- Пример 3: Обращение в двумерном массиве ---");

        String[][] grid = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };

        try {
            System.out.println("Попытка получить элемент [5][2]...");
            String value = grid[5][2];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Поймано исключение: " + e);
            System.err.println("Двумерный массив имеет размеры: строк=" + grid.length +
                    ", колонок=" + grid[0].length);
            System.err.println("Индекс 5 выходит за пределы строк (0-" + (grid.length - 1) + ")");
        }

        try {
            System.out.println("\nПопытка получить элемент [2][10]...");
            String value = grid[2][10];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Поймано исключение: " + e);
            System.err.println("Двумерный массив имеет размеры: строк=" + grid.length +
                    ", колонок=" + grid[2].length);
            System.err.println("Индекс 10 выходит за пределы колонок (0-" + (grid[2].length - 1) + ")");
        }

        System.out.println("\n--- Пример 4: Безопасный доступ к массиву (как правильно) ---");

        int[] safeArray = {1, 2, 3, 4, 5};
        int index = 2;

        if (index >= 0 && index < safeArray.length) {
            System.out.println("Элемент с индексом " + index + " = " + safeArray[index]);
        } else {
            System.err.println("Индекс " + index + " недопустим");
        }

        System.out.println("\n--- Пример 5: Использование цикла для безопасного обхода ---");

        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\n--- Пример 6: Обработка с сохранением стека вызовов ---");

        try {
            methodThatThrowsArrayException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Исключение поймано в main:");
            System.err.println("   Тип: " + e.getClass().getSimpleName());
            System.err.println("   Сообщение: " + e.getMessage());
            System.err.println("   Стек вызовов:");
            for (StackTraceElement element : e.getStackTrace()) {
                System.err.println("      " + element);
            }
        }
    }

    public static void methodThatThrowsArrayException() {
        System.out.println("Вход в methodThatThrowsArrayException()");
        int[] arr = {100, 200, 300};
        try {
            System.out.println("Вызов riskyMethod()...");
            riskyMethod(arr, 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("   Исключение перехвачено в methodThatThrowsArrayException()");
            System.err.println("   Пробрасываем дальше...");
            throw e;
        }
    }

    public static void riskyMethod(int[] array, int index) {
        System.out.println("   Вход в riskyMethod(), пытаемся получить элемент [" + index + "]");
        int value = array[index];
        System.out.println("   Значение: " + value);
    }
}

