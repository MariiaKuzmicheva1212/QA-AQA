//11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
// значениями 1 2 3 4 5 6 7 8 ... 100
package lesson1;
public class point11 {
    public static void main(String[] args) {
        int[] array = new int[100];
        fillArray(array);
        printArray(array);
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
