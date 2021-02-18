package lesson_06;


public class Cat extends Animal {
    private String name;

    final public int jmpLim = 4;
    final public int swmLim = 0;
    final public int runLim = 200;
    final public int flyLim = 0;

    public Cat(String name) {
        super("CAT");
        this.name = name;
    }

    @Override
    public void outInfo() {
        System.out.printf("%n>>>This is a %s --> Name: %s (color %s).%n", getSpecies(), name, getColor());
    }

    @Override
    public void jump(int length) {
        super.jump(length);
        if (jmpLim == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (jmpLim >= length) System.out.printf("%s '%s' has jumped %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not jump far than %d meters.%n", getSpecies(), name, jmpLim);
    }

    @Override
    public void run(int length) {
        super.run(length);
        if (runLim == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (runLim >= length) System.out.printf("%s '%s' has run %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not run far than %d meters.%n", getSpecies(), name, runLim);
    }

    @Override
    public void swim(int length) {
        super.swim(length);
        if (swmLim == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (swmLim >= length) System.out.printf("%s '%s' has swum %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not swim far than %d meters.%n", getSpecies(), name, swmLim);
    }

    @Override
    public void fly(int length) {
        super.fly(length);
        if (flyLim == 0)
            System.out.printf("%s '%s' can't fly.%n", getSpecies(), name);
        else if (flyLim >= length) System.out.printf("%s '%s' has flown  %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not fly far than %d meters.%n", getSpecies(), name, flyLim);
    }
}
