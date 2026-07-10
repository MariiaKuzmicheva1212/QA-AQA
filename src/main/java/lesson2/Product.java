package lesson2;

public class Product {
        private String name;
        private String date;
        private String manufacturer;
        private String country;
        private int price;
        private boolean reserved;

        public Product(String name, String date, String manufacturer,
                       String country, int price, boolean reserved) {
            this.name = name;
            this.date = date;
            this.manufacturer = manufacturer;
            this.country = country;
            this.price = price;
            this.reserved = reserved;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getCountry() {
            return country;
        }

        public int getPrice() {
            return price;
        }

        public boolean isReserved() {
            return reserved;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        public void displayInfo() {
            System.out.println("Название: " + name);
            System.out.println("Дата: " + date);
            System.out.println("Производитель: " + manufacturer);
            System.out.println("Страна: " + country);
            System.out.println("Цена: " + price + " руб.");
            System.out.println("Зарезервирован: " + (reserved ? "Да" : "Нет"));
        }
    }
