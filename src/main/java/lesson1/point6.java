//6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
// положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
package lesson1;
  public class point6 {

public static void main(String[] args) {
    checkNumber(8);
    checkNumber(-7);
    checkNumber(9);
    checkNumber(-199);
    checkNumber(0);
}

public static void checkNumber(int number) {
    if (number >= 0) {
        System.out.println("Положительное");
    } else {
        System.out.println("Отрицательное");
    }
  }
}