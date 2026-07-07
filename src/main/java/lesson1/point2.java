package lesson1;


// 2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте
// их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные,
// и если их сумма больше или равна 0, то вывести в
// консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;

public class point2 {

    public static void main(String[] args) {
        checkSumSign();
    }
    public static void checkSumSign() {
        int a = 10;
        int b = -3;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}

