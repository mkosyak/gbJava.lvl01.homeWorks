package lesson_06;

import java.util.Random;

public abstract class Animal {
    private String species;
    private String color;

    public Animal(String species) {
        this.species = species;

        Random rnd = new Random();
        String[] color = new String[]{"white", "red", "black","spotted","striped"};
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

}


