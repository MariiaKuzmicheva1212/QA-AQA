//13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
// если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких
// элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
package lesson1;
public class point13 {
    public static void main(String[] args) {
        int size = 5;
        int[][] array = new int[size][size];
        fillDiagonal(array);
        printArray(array);
    }

    public static void fillDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
