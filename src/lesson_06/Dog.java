package lesson_06;


import java.util.Random;

public class Dog extends Animal {
    private String name;

    final public int jmpLim = 7;
    final public int swmLim = 10;
    final public int runLim = 500;
    final public int flyLim = 0;

    public Dog(String name) {
        super("DOG");
        this.name = name;
    }

    @Override
    public void outInfo() {
        System.out.printf("%n>>>This is a %s --> Name: %s; has color %s.%n", getSpecies(), name, getColor());
    }

    @Override
    public void jump(int length) {
        super.jump(length);
        if (jmpLim == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (jmpLim >= length) System.out.printf("%s '%s' has jumped %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not jump far then %d meters.%n", getSpecies(), name, jmpLim);
    }

    @Override
    public void run(int length) {
        super.run(length);
        if (runLim == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (runLim >= length) System.out.printf("%s '%s' has run %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not run far then %d meters.%n", getSpecies(), name, runLim);
    }

    @Override
    public void swim(int length) {
        super.swim(length);
        if (swmLim == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (swmLim >= length) System.out.printf("%s '%s' has swum %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not swim far then %d meters.%n", getSpecies(), name, swmLim);
    }

    @Override
    public void fly(int length) {
        super.fly(length);
        if (flyLim == 0)
            System.out.printf("%s '%s' can't fly.%n", getSpecies(), name);
        else if (flyLim >= length) System.out.printf("%s '%s' has flown  %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not fly far then %d meters.%n", getSpecies(), name, flyLim);
    }

}
