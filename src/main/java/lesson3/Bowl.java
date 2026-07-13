package lesson3;

public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {

        if (initialFood < 0) {
            this.foodAmount = 0;
            System.out.println("Внимание: начальное количество еды не может быть отрицательным. Установлено 0.");
        } else {
            this.foodAmount = initialFood;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
        } else {
            System.out.println("Невозможно добавить отрицательное или нулевое количество еды!");
        }
    }

    public void decreaseFood(int amount) {
        if (amount > 0 && amount <= foodAmount) {
            foodAmount -= amount;
        } else if (amount <= 0) {
            System.out.println("Ошибка: нельзя съесть отрицательное количество еды!");
        } else {
            System.out.println("Ошибка: в миске недостаточно еды! (нужно " + amount + ", есть " + foodAmount + ")");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void showInfo() {
        System.out.println("В миске " + foodAmount + " еды.");
    }
}
