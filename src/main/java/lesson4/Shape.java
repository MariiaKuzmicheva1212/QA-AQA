package lesson4;

public interface Shape extends Colorable {
    double calculateArea();
    double calculatePerimeter();

    default void printCharacteristics() {
        System.out.println("=== Характеристики фигуры ===");
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("Площадь: " + String.format("%.2f", calculateArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("===============================");
    }

    default String getShapeName() {
        return this.getClass().getSimpleName();
    }

}
