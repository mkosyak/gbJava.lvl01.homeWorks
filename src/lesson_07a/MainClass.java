package lesson_07a;
/*
---------------------------------------------------------------------
1. Расширить задачу про котов и тарелки с едой. (брать из методички)
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть
    не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
    и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

изменение - в логике программы:
 - цикл по всем котам из массива;
 - коты по очереди едят из тарелки, если в тарелке недостаточно еды, они просят и ее туда докладывают до полной (MaxVolume)
* */

public class MainClass {

    public static void main(String[] args) {
//   ---- v.1.0
  /*    Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        plate.info();
 */

//   ---- v.2.0

        Cat cats[] = new Cat[]{
                new Cat("Barsik", 10),
                new Cat("Murzik", 15),
                new Cat("Pushok", 20),
                new Cat("Xavier", 11)};
        Plate plate = new Plate(12);                            // initial volume in the plate

        for (int i = 0; i < cats.length; i++) {
            System.out.printf("%n%n --> Cat %s is starting to eat with the appetite %d ",
                    cats[i].getName(), cats[i].getAppetiteCurrent());
            int j = 0;
            do {
                j++;
                System.out.printf("%n > step %d, on plate: %d", j, plate.getFoodVolCurr());
                cats[i].eat(plate);
                plate.info();
            }
            while (!cats[i].isFullness());
        }
    }
}
