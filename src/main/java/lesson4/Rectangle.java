package lesson4;
    public class Rectangle implements Shape {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height, String fillColor, String borderColor) {

            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException("Ширина и высота должны быть положительными числами!");
            }
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        public Rectangle(double width, double height) {
            this(width, height, "Белый", "Черный");
        }

        public Rectangle(double side, String fillColor, String borderColor) {
            this(side, side, fillColor, borderColor);
        }

        public Rectangle(double side) {
            this(side, side, "Белый", "Черный");
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
            return width * height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            if (width <= 0) {
                throw new IllegalArgumentException("Ширина должна быть положительным числом!");
            }
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            if (height <= 0) {
                throw new IllegalArgumentException("Высота должна быть положительным числом!");
            }
            this.height = height;
        }

        @Override
        public String toString() {
            if (width == height) {
                return "Квадрат со стороной " + width;
            }
            return "Прямоугольник " + width + "x" + height;
        }
}
