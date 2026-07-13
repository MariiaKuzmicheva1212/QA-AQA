package lesson3;
public class Cat extends Animal1 {
    private static int catCount = 0;

    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        this.runLimit = 200;
        this.swimLimit = 0;
        catCount++;
    }

    public void eatFromBowl(Bowl bowl, int amount) {
        if (bowl.getFoodAmount() >= amount) {
            bowl.decreaseFood(amount);
            this.isFull = true;
            System.out.println(name + " съел " + amount + " еды и теперь сыт!");
        } else {
            System.out.println(name + " не стал есть (в миске только " + bowl.getFoodAmount() + " еды, а нужно " + amount + ")");
            this.isFull = false;
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }
}
