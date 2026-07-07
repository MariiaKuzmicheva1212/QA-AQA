//14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
// типа int длиной len, каждая ячейка которого равна initialValue.
package lesson1;
public class point14 {
    public static void main(String[] args) {
        int[] array1 = createArray(7, 9);
        System.out.print("Массив длиной 7, все элементы = 9: ");
        printArray(array1);

        int[] array2 = createArray(3, 7);
        System.out.print("Массив длиной 3, все элементы = 7: ");
        printArray(array2);

        int[] array3 = createArray(2, 0);
        System.out.print("Массив длиной 2, все элементы = 0: ");
        printArray(array3);
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
