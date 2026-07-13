package lesson3;

public class Animal1 {
    protected static int animalCount = 0;

    protected String name;

    protected int runLimit;
    protected int swimLimit;

    public Animal1(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум " + runLimit + " м.)");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум " + swimLimit + " м.)");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
