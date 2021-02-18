package lesson_06;
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия
(бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
* */


import java.util.Random;

public class RunApp_l06 {

    //  ---- C O N S T A N T S
    private static final int ci_numberOfSpeices = 3;

    public static void main(String[] args) {
        Random rnd = new Random();
        Animal[] animals = new Animal[16];
        int rndJmp = 0, rndRun = 0, rndFly = 0, rndSwim = 0;
        int dogIdx = 0, catIdx = 0, undefIdx = 0;

        for (int i = 0; i < animals.length; i++) {
            int rndSpieces = rnd.nextInt(ci_numberOfSpeices);
            switch (rndSpieces) {
                case 0:
                    rndJmp = rnd.nextInt(16);    // max 8
                    rndRun = rnd.nextInt(1000);  // max 500
                    rndSwim = rnd.nextInt(40);   // max 20
                    rndFly = rnd.nextInt(10);    // can't Fly
                    animals[i] = new Dog("Doggy_" + (i + 1));
                    dogIdx++;
                    break;
                case 1:
                    rndJmp = rnd.nextInt(10);    // max 5
                    rndRun = rnd.nextInt(400);   // max 200
                    rndSwim = rnd.nextInt(20);   // can't Swim
                    rndFly = rnd.nextInt(20);    // can't Fly
                    animals[i] = new Cat("Kitty_" + (i + 1));
                    catIdx++;
                    break;
                default:
                    undefIdx++;
                    continue;
            }
            animals[i].outInfo();
            animals[i].jump(rndJmp);
            animals[i].run(rndRun);
            animals[i].swim(rndSwim);
            animals[i].fly(rndFly);
        }
        System.out.printf("%n--------------------------------------------%n");
        System.out.printf("Total Animals . . .: %d%n", animals.length);
        System.out.printf("         Cats . . .: %d%n", catIdx);
        System.out.printf("         Dogs . . .: %d%n", dogIdx);
        System.out.printf("         Undefined : %d%n", undefIdx);
    }
}



