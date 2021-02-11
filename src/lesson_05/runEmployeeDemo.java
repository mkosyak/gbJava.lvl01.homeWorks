package lesson_05;
/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
* */

import javax.print.attribute.standard.Finishings;
import java.util.Random;

public class runEmployeeDemo {
    public static void main(String[] args) {
//  -- initialization
        //        ФИО_1 | ФИО_2 | ФИО_3| должность | email | телефон
        String inputData[][] = new String[][]{
                {"Кузнецов", "Константин", "Николаевич", "Лифтер", "kuznetsov@nowehre.no", "+7 (111) 111-11-11"},
                {"Иванов", "Иван", "Иванович", "Директор", "ivanov@nowehre.no", "+7 (222) 222-22-22"},
                {"Иванова", "Фекла", "Федосеевна", "жена Директора", "ivanova@nowehre.no", "+7 (333) 333-33-33"},
                {"Шариков", "Полиграф", "Полиграфович", "начальник очистки", "sharikov@nowehre.no", "+7 (444) 444-44-44"},
                {"Мухин", "Александр", "Александрович", "менеджер", "mukhin@nowehre.no", "+7 (555) 555-55-55"},
                {"Петрова", "Александра", "Алексеевна", "специалист отдела кадров", "petrova@nowehre.no", "+7 (666) 666-66-66"},
                {"Doe", "none", "John", "anonymous", "anonymous@nowehre.no", "+7 (777) 777-77-77"}
        };
        Random random = new Random();
//  -- Run
        Employee employeeArray[] = new Employee[inputData.length];

        for (int i = 0; i < inputData.length; i++) {
            employeeArray[i] = new Employee(inputData[i][0], inputData[i][1], inputData[i][2],
                    inputData[i][3], inputData[i][4], inputData[i][5],
                    (float) getRundomFromRange(100000, 500000),
                    getRundomFromRange(18, 66));
            System.out.println("\n ---------------------------------");
            employeeArray[i].outputList4AgeGE(40);
//            employeeArray[i].displayMainAttr();
        }

    }
    //  ===========================================
    public static int getRundomFromRange(int rangeBoundfrom, int rangeBoundTo) {
        float rndMath = (float) Math.random();
        int rndNumber = (int) ((rangeBoundTo - rangeBoundfrom) * rndMath + rangeBoundfrom);
        return rndNumber;
    }

}
