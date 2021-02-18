package lesson_06;


import java.util.Random;

public class Dog extends Animal {
    private String name;

    final public int jmpLimDog = 7;
    final public int flyLimDog = 0;
    final public int swmLimDog = 10;
    final public int runLimDog = 500;

    public Dog(String name) {
        super("DOG");
        this.name = name;
        setJmpLim(jmpLimDog);
        setFlyLim(flyLimDog);
        setRunLim(runLimDog);
        setSwmLim(swmLimDog);
    }

    @Override
    public void outInfo() {
        System.out.printf("%n>>>This is a %s --> Name: %s (color %s).%n", getSpecies(), name, getColor());
    }

    @Override
    public void jump(int length) {
        super.jump(length);
        if (getJmpLimit() == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (getJmpLimit() >= length) System.out.printf("%s '%s' has jumped %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not jump far than %d meters.%n", getSpecies(), name, getJmpLimit());
    }

    @Override
    public void run(int length) {
        super.run(length);
        if (getRunLimit() == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (getRunLimit() >= length) System.out.printf("%s '%s' has run %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not run far than %d meters.%n", getSpecies(), name, getRunLimit());
    }

    @Override
    public void swim(int length) {
        super.swim(length);
        if (getSwmLimit() == 0)
            System.out.printf("%s '%s' can't jump.%n", getSpecies(), name);
        else if (getSwmLimit() >= length) System.out.printf("%s '%s' has swum %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not swim far than %d meters.%n", getSpecies(), name, getSwmLimit());
    }

    @Override
    public void fly(int length) {
        super.fly(length);
        if (getFlyLimit() == 0)
            System.out.printf("%s '%s' can't fly.%n", getSpecies(), name);
        else if (getFlyLimit() >= length) System.out.printf("%s '%s' has flown  %d meters.%n", getSpecies(), name, length);
        else System.out.printf("%s '%s' can not fly far than %d meters.%n", getSpecies(), name, getFlyLimit());
    }

}
