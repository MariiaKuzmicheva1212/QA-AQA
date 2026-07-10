package lesson2;

public class Point1 {
private String name;
private String productionDate;
private String manufacturer;
private String countryOfOrigin;
private double price;
private boolean isReserved;

public Point1(String name, String productionDate, String manufacturer,
              String countryOfOrigin, double price, boolean isReserved) {
    this.name = name;
    this.productionDate = productionDate;
    this.manufacturer = manufacturer;
    this.countryOfOrigin = countryOfOrigin;
    this.price = price;
    this.isReserved = isReserved;
}
public void displayInfo() {
    System.out.println("=");
    System.out.println("Название товара:" + name);
    System.out.println("Дата производства:" + productionDate);
    System.out.println("Производитель:" + manufacturer);
    System.out.println("Страна производства:" + countryOfOrigin);
    System.out.println("Цена:" + price + " руб.");
    System.out.println("Состояние бронирования:" + (isReserved ? "Забронирован" : "Не забронирован"));
    System.out.println("=");
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getProductionDate() {
    return productionDate;
}

public void setProductionDate(String productionDate) {
    this.productionDate = productionDate;
}

public String getManufacturer() {
    return manufacturer;
}

public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
}

public String getCountryOfOrigin() {
    return countryOfOrigin;
}

public void setCountryOfOrigin(String countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}

public boolean isReserved() {
    return isReserved;
}

public void setReserved(boolean reserved) {
    isReserved = reserved;
     }
   }