package lesson_07a;

public class Cat {
    private String name;
    private int appetiteAll;
    private int appetiteCurrent;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetiteAll = appetite;
        this.appetiteCurrent = appetite;
    }

    public void eat(Plate plate) {
        System.out.printf("%n  - %d will be eaten...", appetiteCurrent);
        int foodDeficit = plate.decreaseFood(appetiteCurrent);      // return 0 if Cat is full

        if (foodDeficit == 0) {                                                     // cat is full
            appetiteCurrent = 0;
            fullness = true;
        } else {                                                                    // cat is still hungry
            appetiteCurrent = foodDeficit;
            fullness = false;
            askNewCan(plate);                                                       // put a new Can on the plate
        }
    }

    public void askNewCan(Plate plate) {
        System.out.printf("%n  == Meow!! I have eaten all and still hungry, feed me!");

        plate.addNewCan2Plate(plate.getFoodVolMax());
        System.out.printf("%n  - A new can (vol.%d) was added on plate - now there %d",
                plate.getFoodVolMax(), plate.getFoodVolCurr());
    }

    public String getName() {
        return name;
    }

    public int getAppetiteCurrent() {
        return appetiteCurrent;
    }

    public boolean isFullness() {
        return fullness;
    }
}
