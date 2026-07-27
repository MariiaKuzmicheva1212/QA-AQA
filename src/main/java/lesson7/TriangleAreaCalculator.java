
package lesson7;
import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину стороны треугольника a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите длину стороны треугольника b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите длину стороны треугольника c: ");
        double c = scanner.nextDouble();

        if (a + b > c && a + c > b && b + c > a) {

            double p = (a + b + c) / 2;

            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

            System.out.printf("Площадь треугольника со сторонами %.2f, %.2f, %.2f = %.2f\n", a, b, c, area);
        } else {
            System.out.println("Ошибка: Треугольник с такими сторонами не существует!");
            System.out.println("Сумма любых двух сторон должна быть больше третьей стороны.");
        }

        scanner.close();
    }
}

