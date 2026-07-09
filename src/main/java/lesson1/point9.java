//9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean
// (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
// при этом каждый 400-й – високосный.
package lesson1;
public class point9 {
    public static void main(String[] args) {
        System.out.println("2024 - " + isLeapYear(2024));
        System.out.println("2023 - " + isLeapYear(2023));
        System.out.println("1900 - " + isLeapYear(1900));
        System.out.println("2000 - " + isLeapYear(2000));
        System.out.println("2020 - " + isLeapYear(2020));
        System.out.println("2100 - " + isLeapYear(2100));
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
