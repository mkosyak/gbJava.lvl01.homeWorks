package lesson_07;

public class Plate {
    private int foodLeftOnPlate;
    private int foodVolMax = 10;

    public Plate(int food) {
        addNewCan2Plate(food);
    }

    public void addNewCan2Plate(int can) {
        if (can == 0) {
            this.foodLeftOnPlate = foodVolMax;
        } else {
            this.foodLeftOnPlate = can;
        }
    }

    public int decreaseFood(int n) {
        int i = foodLeftOnPlate - n;
        if (i < 0) {
            foodLeftOnPlate = 0;
            return Math.abs(i);
        } else {
            foodLeftOnPlate = i;
            return 0;
        }
    }

    public void info() {
        System.out.printf("%n ===> Food left on plate: " + foodLeftOnPlate);
    }

    public int getFoodVolMax() {
        return foodVolMax;
    }

    public int getFoodVolCurr() {
        return foodLeftOnPlate;
    }
}
