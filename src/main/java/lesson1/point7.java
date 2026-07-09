package lesson1;

//7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное,
// и вернуть false если положительное.
//Замечание: ноль считаем положительным числом.
public class point7 {
public static void main(String[] args) {
    System.out.println(isNegative(0));
    System.out.println(isNegative(-9));
    System.out.println(isNegative(88));
    System.out.println(isNegative(-108));
    System.out.println(isNegative(10));
}

public static boolean isNegative(int number) {
    if (number < 0) {
        return true;
    } else {
        return false;
    }
  }
}