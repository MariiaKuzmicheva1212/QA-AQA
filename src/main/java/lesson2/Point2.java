package lesson2;
public class Point2 {
public static void main(String[] args) {

    lesson2.Product[] productsArray = new lesson2.Product[5];

    productsArray[0] = new lesson2.Product("Samsung S25 Ultra", "01.02.2025",
            "Samsung Corp.", "Korea", 5599, true);

    productsArray[1] = new lesson2.Product("iPhone 16 Pro Max", "15.03.2025",
            "Apple Inc.", "USA", 6999, false);

    productsArray[2] = new lesson2.Product("Xiaomi 14 Pro", "10.01.2025",
            "Xiaomi Corporation", "China", 3999, true);

    productsArray[3] = new lesson2.Product("Google Pixel 9 Pro", "20.02.2025",
            "Google LLC", "USA", 4999, false);

    productsArray[4] = new lesson2.Product("OnePlus 12", "05.03.2025",
            "OnePlus", "China", 4499, true);


    System.out.println("=== ИНФОРМАЦИЯ О ТОВАРАХ ===\n");
    for (int i = 0; i < productsArray.length; i++) {
        System.out.println("Товар #" + (i + 1));
        productsArray[i].displayInfo();
        System.out.println();
    }

    System.out.println("=== СВОБОДНЫЕ ТОВАРЫ ===\n");
    for (int i = 0; i < productsArray.length; i++) {
        if (!productsArray[i].isReserved()) {
            System.out.println("Свободен: " + productsArray[i].getName());
        }
    }
}
}