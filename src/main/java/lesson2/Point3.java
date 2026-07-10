package lesson2;

public class Point3 {
    public static void main(String[] args) {
        lesson2.Park park1 = new lesson2.Park("Парк Победы");
        lesson2.Park park2 = new lesson2.Park("Зеленый парк");

        park1.addAttraction("Колесо обозрения", "10:00-22:00", 300);
        park1.addAttraction("Американские горки", "11:00-21:00", 500);

        park2.addAttraction("Детская площадка", "09:00-20:00", 100);
        park2.addAttraction("Бассейн с шарами", "10:00-19:00", 200);

        System.out.println("=== ВСЕ ПАРКИ ===\n");
        park1.displayAllAttractions();
        System.out.println();
        park2.displayAllAttractions();

        lesson2.Park.Attraction attr = park1.findAttractionByName("Колесо обозрения");
        if (attr != null) {
            park2.addAttraction(
                    attr.getName() + " (копия)",
                    attr.getWorkTime(),
                    attr.getPrice() * 0.8 // Скидка 20%
            );
            System.out.println("\n✅ Аттракцион скопирован в парк " + park2.getParkName());
        }
    }
}