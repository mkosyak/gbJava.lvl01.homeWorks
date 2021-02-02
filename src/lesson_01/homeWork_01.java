package lesson_01;
//  Pull request URL: https://github.com/mkosyak/gbJava.lvl01.homeWorks/pull/1

public class homeWork_01 {
    /*
    Урок 1. Java. Введение * */
    public static void main(String[] args) {

// ----------------------------------------------------------------------------------------------------
// Task_02.
//   -  Создать переменные всех пройденных типов данных и инициализировать их значения.
        System.out.println("\n\r" + " === Task_02.");

        byte li_byte = 127;                             // 8bit: -128        ...  127
        System.out.println("Byte = " + li_byte);

        short li_short = 32767;                         // 16bit= -32768      ...  32767
        System.out.println("Short = " + li_short);

        int li_var = -2147483648;                       // 32bit= -2147483648 ...  2147483647
        System.out.println("Integer = " + li_var);

        long li_long = -9223372036854775808L;           // 65bit= -9223372036854775808 ... 9223372036854775807
        System.out.println("Long = " + li_long);

        float lf_var = 3.141592653589793238462643F;     // 32 bit= 1.4e-45f до 3.4e+38f
        System.out.println("Float 'pi' = " + lf_var);

        double lf_double = 2.7182818284590452353602874713527D; // 64 bit= от 4.9e-324 до 1.7e+308
        System.out.println("Double 'e' = " + lf_double);

        char lc_var = 'K';                              // 16 bit= single character
        System.out.println("character 'K'= " + lc_var);

        boolean lb_var = true;                          // true | false
        System.out.print("Boolean = " + lb_var + "/");
        lb_var = false;
        System.out.println(lb_var);

// ----------------------------------------------------------------------------------------------------
// Task_03.
//   -   Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//       где a, b, c, d – аргументы этого метода, имеющие тип float..
        System.out.println("\n\r" + " === Task_03.");
        float lf_pi = 3.14f;
        float lf_exp = 2.71f;
        float lf_fsc = 0.00729735256f;
        float lf_g = 9.81f;
        float lf_03_result = calc_03(lf_pi, lf_exp, lf_fsc, lf_g);
        System.out.println("Calc_03 result = " + lf_03_result);

// ----------------------------------------------------------------------------------------------------
// Task_4.
//   -  Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
//   (включительно), если да – вернуть true, в противном случае – false.
        System.out.println("\n\r" + " === Task_04.");
        float lf_04_a = 8.9f;
        float lf_04_b = 11.2f;
        boolean lb_04_result = check_sum_between_04(lf_04_a, lf_04_b);
        System.out.println("The sum of " + lf_04_a + " and " + lf_04_b + " belongs to range between 10...20 is " +
                lb_04_result);

// ----------------------------------------------------------------------------------------------------
// Task_5.
//   - Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
//     положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
        System.out.println("\n\r" + " === Task_05.");
        int li_05_a = -999;
        System.out.print("Number \'" + li_05_a + "\' ");
        print_check_int_nega(li_05_a); // print out checking result

// ----------------------------------------------------------------------------------------------------
// Task_6.
//   - Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
//  отрицательное, и вернуть false если положительное.
        System.out.println("\n\r" + " === Task_06.");
        int li_06_a = -137;
        System.out.println("Checking of the number \'" + li_06_a + "\'  result is: " +
                check_int_sign(li_06_a));

// ----------------------------------------------------------------------------------------------------
// Task_7.
//   - Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль
//   сообщение «Привет, указанное_имя!».
        System.out.println("\n\r" + " === Task_07.");
        String lv_07_name = "Евлампий";
        System.out.println("Имя \'" + lv_07_name + "\'");
        print_out_hi(lv_07_name);

// ----------------------------------------------------------------------------------------------------
// Task_ 8.
//   - Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//   Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println("\n\r" + " === Task_08.");
        int li_08_start_year = 1899;
        int li_08_end_year = 2024;
        System.out.println("A leap year is being checked for the range from " + li_08_start_year +
                " to " + li_08_end_year + "...");
        for (int li_08_year = li_08_start_year; li_08_year <= li_08_end_year; li_08_year++) {
            System.out.println("\'" + li_08_year + "\' " + check_leap_year_string(li_08_year));
        }
    }


    // ========================================
    public static String check_leap_year_string(int year) {
        boolean lb_leap = false;

        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            lb_leap = true;
            return "is a leap year";
        } else {
            return "is NOT a leap year";
        }
    }

    // ========================================
    public static float calc_03(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // ========================================
    public static boolean check_sum_between_04(float a, float b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // ========================================
    public static String print_check_int_nega(int a) {
        String lv_result;

        if (a >= 0) {
            lv_result = "is Positive";
        } else {
            lv_result = "is Negative";
        }

        System.out.println(lv_result);
        return lv_result;
    }

    // ========================================
    public static boolean check_int_sign(int a) {

        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    // ========================================
    public static void print_out_hi(String name) {

        System.out.println("--->Привет " + name);
    }

}
