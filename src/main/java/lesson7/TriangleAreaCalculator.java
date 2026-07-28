
package lesson7;
import java.util.Scanner;

public class TriangleAreaCalculator {

    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static double calculateArea(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину стороны треугольника a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите длину стороны треугольника b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите длину стороны треугольника c: ");
        double c = scanner.nextDouble();

        double area = calculateArea(a, b, c);

        if (area == -1) {
            System.out.println("Ошибка: Треугольник с такими сторонами не существует!");
            System.out.println("Сумма любых двух сторон должна быть больше третьей стороны.");
        } else {
            System.out.printf("Площадь треугольника со сторонами %.2f, %.2f, %.2f = %.2f\n", a, b, c, area);
        }

        scanner.close();
    }
}

