package lesson_05;

public class Employee {
    /* ФИО, должность, email, телефон, зарплата, возраст.
     * */
    private String firstName;           // 1.ФИО_1
    private String secondName;          // 2.ФИО_2
    private String surname;             // 3.ФИО_3
    private String position;            // 4.должность
    private String eMail;               // 5.email
    private String mainPhone;           // 6.телефон
    private float salary;               // 7.зарплата
    public int age;                     // 8.возраст

    public Employee() {                                                    // constructor without Parameters

    }

    public Employee(String firstName, String secondName, String surName,  // constructor with Parameters
                    String position, String eMail, String mainPhone,
                    float grossFee, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surName;
        this.position = position;
        this.eMail = eMail;
        this.mainPhone = mainPhone;
        this.salary = grossFee;
        this.age = age;
    }

    public void outputList4AgeGE(int ageGE) {   // age Greater or Equal in the parameter
        if (ageGE <= this.age) {
            this.displayMainAttr();
        } else {
            System.out.println("The age of " + this.firstName + " " + this.secondName + " " + this.surname +
                    " less then " + ageGE + "." );
            System.out.println(" >>> Details are not avaliable <<<");
        }
    }

    public void displayMainAttr() {
        System.out.println("Employee . . : " + this.firstName + " " + this.secondName + " " + this.surname);
        System.out.println("  Position . . : " + this.position);
        System.out.println("  eMail  . . . : " + this.eMail);
        System.out.println("  Phone Number : " + this.mainPhone);
        System.out.println("  Salary . . . : " + this.salary);
        System.out.println("  Age. . . . . : " + this.age);

    }
}