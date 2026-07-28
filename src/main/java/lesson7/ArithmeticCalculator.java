package lesson7;

import java.util.Scanner;

public class ArithmeticCalculator {
    public static double calculate(double a, char operation, double b) {
        switch (operation) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) return Double.NaN;
                return a / b;
            default: return Double.NaN;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите действие (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        System.out.print("Введите число b: ");
        double b = scanner.nextDouble();

        double result = 0;
        boolean isValidOperation = true;

        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                    isValidOperation = false;
                }
                break;
            default:
                System.out.println("Ошибка: неверное действие!");
                isValidOperation = false;
                break;
        }


        if (isValidOperation) {
            System.out.println(a + " " + operation + " " + b + " = " + result);
        }

        scanner.close();
    }
}