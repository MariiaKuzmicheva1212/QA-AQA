package lesson2;
import java.util.ArrayList;
import java.util.List;
public class Park {
    private String parkName;
    private List<Attraction> attractions;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workTime, double price) {
        attractions.add(new Attraction(name, workTime, price));
    }

    public void displayAllAttractions() {
        System.out.println("=== ПАРК: " + parkName + " ===");
        if (attractions.isEmpty()) {
            System.out.println("В парке нет аттракционов.");
            return;
        }
        for (int i = 0; i < attractions.size(); i++) {
            System.out.println("\nАттракцион #" + (i + 1));
            attractions.get(i).displayInfo();
        }
    }

    public Attraction findAttractionByName(String name) {
        for (Attraction a : attractions) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    public String getParkName() {
        return parkName;
    }

    public class Attraction {
        private String name;
        private String workTime;
        private double price;

        public Attraction(String name, String workTime, double price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("  Название: " + name);
            System.out.println("  Время работы: " + workTime);
            System.out.println("  Стоимость: " + price + " руб.");
            System.out.println("  Парк: " + parkName); // Доступ к полю внешнего класса
        }

        public String getName() { return name; }
        public String getWorkTime() { return workTime; }
        public double getPrice() { return price; }
    }
}
