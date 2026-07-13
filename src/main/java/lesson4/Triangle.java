package lesson4;
    public class Triangle implements Shape {

        private double sideA;
        private double sideB;
        private double sideC;
        private String fillColor;
        private String borderColor;


        public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {

            if (!isValidTriangle(sideA, sideB, sideC)) {
                throw new IllegalArgumentException(
                        "Треугольник с такими сторонами не существует!\n" +
                                "Сумма двух сторон должна быть больше третьей."
                );
            }

            if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
                throw new IllegalArgumentException("Все стороны должны быть положительными числами!");
            }

            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        public Triangle(double sideA, double sideB, double sideC) {
            this(sideA, sideB, sideC, "Белый", "Черный");
        }

        public Triangle(double side, String fillColor, String borderColor) {
            this(side, side, side, fillColor, borderColor);
        }

        public Triangle(double side) {
            this(side, side, side, "Белый", "Черный");
        }


        private boolean isValidTriangle(double a, double b, double c) {

            return a > 0 && b > 0 && c > 0 &&
                    (a + b > c) && (a + c > b) && (b + c > a);
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


            double p = calculatePerimeter() / 2;
            double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
            return area;
        }

        @Override
        public double calculatePerimeter() {
            return sideA + sideB + sideC;
        }

        public double getSideA() {
            return sideA;
        }

        public double getSideB() {
            return sideB;
        }

        public double getSideC() {
            return sideC;
        }

        public void setSideA(double sideA) {
            if (isValidTriangle(sideA, this.sideB, this.sideC)) {
                this.sideA = sideA;
            } else {
                throw new IllegalArgumentException("Некорректная сторона треугольника!");
            }
        }

        public void setSideB(double sideB) {
            if (isValidTriangle(this.sideA, sideB, this.sideC)) {
                this.sideB = sideB;
            } else {
                throw new IllegalArgumentException("Некорректная сторона треугольника!");
            }
        }

        public void setSideC(double sideC) {
            if (isValidTriangle(this.sideA, this.sideB, sideC)) {
                this.sideC = sideC;
            } else {
                throw new IllegalArgumentException("Некорректная сторона треугольника!");
            }
        }

        @Override
        public String toString() {
            if (sideA == sideB && sideB == sideC) {
                return "Равносторонний треугольник со стороной " + sideA;
            }
            return "Треугольник со сторонами " + sideA + ", " + sideB + ", " + sideC;
        }
}
