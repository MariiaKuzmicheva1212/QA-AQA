package lesson4;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ С ЦВЕТАМИ");
        System.out.println("==========================================\n");

        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(5.0, "Красный", "Синий"));
        shapes.add(new Rectangle(4.0, 6.0, "Зеленый", "Оранжевый"));
        shapes.add(new Triangle(3.0, 4.0, 5.0, "Желтый", "Фиолетовый"));
        shapes.add(new Rectangle(6.0, "Голубой", "Коричневый"));

        System.out.println("=== ХАРАКТЕРИСТИКИ ФИГУР ===\n");

        int count = 1;
        for (Shape shape : shapes) {
            System.out.println("Фигура #" + count + ": " + shape.toString());
            shape.printCharacteristics();
            System.out.println();
            count++;
        }

        System.out.println("✅ Программа успешно завершена!");
    }
}
