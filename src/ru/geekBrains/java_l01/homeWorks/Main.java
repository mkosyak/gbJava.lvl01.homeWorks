package ru.geekBrains.java_l01.homeWorks;

public class Main {

    public static void main(String[] args) {
	    System.out.println("this is Main class");
        int[][] Array = new int[][]{
                {1,2,3,4},
                {4,5,6,7}
        };
        System.out.println("Rows: " + Array.length);
        System.out.println("Columns: " + Array[0].length);

    }
}
