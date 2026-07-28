package lesson7;
import java.util.Scanner;

public class FactorialCalculator {
    public static long calculateFactorial(int n) {
        if (n < 0) {
            return -1; // Ошибка: отрицательное число
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ввод числа
            System.out.print("Введите число a: ");
            int a = scanner.nextInt();

            if (a < 0) {
                System.out.println("Ошибка: Факториал определён только для неотрицательных чисел!");
            } else {

                long factorial = 1;

                for (int i = 1; i <= a; i++) {
                    factorial *= i;
                }

                System.out.println(a + "! = " + factorial);
            }
        } catch (Exception e) {
            System.out.println("Ошибка: Введите корректное целое число!");
        } finally {
            scanner.close();
        }
    }
}




