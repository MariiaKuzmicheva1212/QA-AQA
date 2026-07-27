package lesson7;
import java.util.Scanner;

public class NumberComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число a: ");
        int a = scanner.nextInt();

        System.out.print("Введите число b: ");
        int b = scanner.nextInt();

        String sign;
        if (a < b) {
            sign = "<";
        } else if (a > b) {
            sign = ">";
        } else {
            sign = "=";
        }

        System.out.println(a + " " + sign + " " + b);

        scanner.close();
    }
}




