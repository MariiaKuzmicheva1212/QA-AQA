//5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
// (включительно), если да – вернуть true, в противном случае – false
package lesson1;
   public class point5 {
public static void main(String[] args) {
    System.out.println(checkSum(7, 7));
    System.out.println(checkSum(6, 3));
    System.out.println(checkSum(155, 777));
    System.out.println(checkSum(5687, 8));
    System.out.println(checkSum(0, 10));
}

public static boolean checkSum(int a, int b) {
    int sum = a + b;

    if (sum >= 10 && sum <= 20) {
        return true;
    } else {
        return false;
    }
  }
}