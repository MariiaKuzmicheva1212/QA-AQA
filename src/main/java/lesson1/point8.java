//8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
// указанную строку, указанное количество раз;
package lesson1;
public class point8 {
public static void main(String[] args) {
    printString("Hello", 9);
    printString("Java", 8);
    printString("Test", 7);
}

public static void printString(String text, int count) {
    for (int i = 0; i < count; i++) {
        System.out.println(text);
    }
  }
}