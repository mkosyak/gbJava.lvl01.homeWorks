package lesson_06;

import java.util.Random;

public abstract class Animal {
    private String species;
    private String color;
    private int jmpLimit;
    private int swmLimit;
    private int runLimit;
    private int flyLimit;

    public Animal(String species) {
        this.species = species;

        Random rnd = new Random();
        String[] color = new String[]{"white", "red", "black", "spotted", "striped"};
        for (int i = 0; i < color.length; i++) {
            int rndColor = rnd.nextInt(color.length);
            this.color = color[rndColor];
        }
    }

    public abstract void outInfo();

    public void jump(int length) {
        System.out.printf(" - Animal is jumping %d meters...%n", length);
    }

    public void run(int length) {
        System.out.printf(" - Animal is running %d meters...%n", length);
    }

    public void swim(int length) {
        System.out.printf(" - Animal is swimming %d meters...%n", length);
    }

    public void fly(int length) {
        System.out.printf(" - Animal is flying %d meters...%n", length);
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public void setJmpLim(int jmpLim) {
        jmpLimit = jmpLim;
    }

    public void setSwmLim(int swmLim) {
        swmLimit = swmLim;
    }

    public void setRunLim(int runLim) {
        runLimit = runLim;
    }

    public void setFlyLim(int flyLim) {
        flyLimit = flyLim;
    }

    public int getJmpLimit() {
        return jmpLimit;
    }

    public int getSwmLimit() {
        return swmLimit;
    }

    public int getRunLimit() {
        return runLimit;
    }

    public int getFlyLimit() {
        return flyLimit;
    }
}


