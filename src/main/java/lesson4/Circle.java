package lesson4;
public class Circle implements Shape {

    private double radius;
    private String fillColor;
    private String borderColor;
    private static final double PI = Math.PI;


    public Circle(double radius, String fillColor, String borderColor) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом!");
        }
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public Circle(double radius) {
        this(radius, "Белый", "Черный");
    }


    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }


    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом!");
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Круг с радиусом " + radius;
    }
}