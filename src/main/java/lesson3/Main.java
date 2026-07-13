package lesson3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЧАСТЬ 1: Демонстрация работы животных ===\n");

        Dog dogBobik = new Dog("Бобик");
        Dog dogRex = new Dog("Рекс");
        Cat catMurka = new Cat("Мурка");
        Cat catBarsik = new Cat("Барсик");
        Cat catPushok = new Cat("Пушок");

        System.out.println("--- Бег ---");
        dogBobik.run(150);
        dogRex.run(600);
        catMurka.run(150);
        catBarsik.run(250);

        System.out.println("\n--- Плавание ---");
        dogBobik.swim(5);
        dogRex.swim(15);
        catMurka.swim(3);
        System.out.println("\n=== Статистика ===");
        System.out.println("Всего животных: " + Animal1.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());

        System.out.println("\n\n=== ЧАСТЬ 2: Коты и миска с едой ===\n");

        Bowl bowl = new Bowl(15);
        System.out.println("Создана миска с начальным количеством еды: 15");

        Cat[] cats = {
                new Cat("Вася"),
                new Cat("Петя"),
                new Cat("Мурзик"),
                new Cat("Снежок"),
                new Cat("Рыжик")
        };

        System.out.println("\nНачальное состояние:");
        bowl.showInfo();

        int[] eatAmounts = {5, 4, 3, 6, 8};

        System.out.println("\n--- Процесс кормления ---");
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + cats[i].name + " хочет съесть " + eatAmounts[i] + " еды:");
            cats[i].eatFromBowl(bowl, eatAmounts[i]);
            System.out.println("Остаток в миске: " + bowl.getFoodAmount());
            System.out.println();
        }

        System.out.println("=== Информация о сытости котов ===");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isFull() ? "СЫТ" : "ГОЛОДЕН"));
        }

        System.out.println("\n=== Добавление еды в миску ===");
        bowl.showInfo();
        bowl.addFood(10);
        bowl.showInfo();
        bowl.addFood(5);
        bowl.showInfo();

        System.out.println("\nПопытка добавить отрицательное количество:");
        bowl.addFood(-3);
        bowl.showInfo();

        System.out.println("\n=== Проверка защиты от отрицательной еды ===");
        Bowl bowl2 = new Bowl(-10);
        System.out.println("Попытка создать миску с -10 еды: в миске " + bowl2.getFoodAmount() + " еды");

        System.out.println("\n=== Демонстрация отказа от еды при недостатке ===");
        Bowl smallBowl = new Bowl(3);
        Cat testCat = new Cat("Тестовый");
        System.out.println("Создана миска с 3 еды и голодный кот Тестовый:");
        smallBowl.showInfo();
        testCat.eatFromBowl(smallBowl, 5); // Кот не ест, так как мало
        System.out.println("Сытость Тестового: " + (testCat.isFull() ? "СЫТ" : "ГОЛОДЕН"));
        System.out.println("В миске осталось: " + smallBowl.getFoodAmount() + " еды");

        System.out.println("\nДобавляем 5 еды в миску:");
        smallBowl.addFood(5);
        smallBowl.showInfo();
        testCat.eatFromBowl(smallBowl, 5);
        System.out.println("Сытость Тестового: " + (testCat.isFull() ? "СЫТ" : "ГОЛОДЕН"));
        System.out.println("В миске осталось: " + smallBowl.getFoodAmount() + " еды");
    }
}
