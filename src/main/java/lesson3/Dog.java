package lesson3;

public class Dog extends Animal1 {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);

        this.runLimit = 500;
        this.swimLimit = 10;
        dogCount++;
    }


    public static int getDogCount() {
        return dogCount;
    }
}
