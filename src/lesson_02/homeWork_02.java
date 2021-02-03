package lesson_02;

import java.util.*;

//   Pull request URL: https://github.com/mkosyak/gbJava.lvl01.homeWorks/pull/2
public class homeWork_02 {
    /*
    Урок 2. Основные конструкции * */
    public static void main(String[] args) {

// ----------------------------------------------------------------------------------------------------
// 1.   Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//      С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("\n\r" + " === Task_01.");
        int array_01[] = new int[]{1, 1, 0, 1, 0, 0, 1, 1, 0, 0};

        System.out.println("Array before: " + Arrays.toString(array_01));
        array_01 = calcArray_01(array_01);
        System.out.println("Array after:  " + Arrays.toString(array_01));

// ----------------------------------------------------------------------------------------------------
// 2.   Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("\n\r" + " === Task_02.");
        int array_02[] = new int[8];

        System.out.println("Array before: " + Arrays.toString(array_02));
        array_02 = fillArray_02(array_02);
        System.out.println("Array after:  " + Arrays.toString(array_02));

// ----------------------------------------------------------------------------------------------------
// 3.   Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4,  8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("\n\r" + " === Task_03.");
        int array_03[] = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Array before: " + Arrays.toString(array_03));
        array_03 = multpArrayGT6_03(array_03);
        System.out.println("Array after:  " + Arrays.toString(array_03));

// ----------------------------------------------------------------------------------------------------
// 4.   Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов)
//      заполнить его диагональные элементы единицами;
        System.out.println("\n\r" + " === Task_04.");
        final byte cIntOutTempl_2 = 2;
        final byte arrayDim = 19;
        int array_04[][] = new int[arrayDim][arrayDim];

        System.out.println("Array before");
        for (int i = 0; i < array_04.length; i++) {
            System.out.println("[" + convInt2StringLead0(i, cIntOutTempl_2) + "] " + Arrays.toString(array_04[i]));
        }
        array_04 = fillArray_04(array_04);      //     ---- Fill array

        System.out.println("Array after");
        for (int i = 0; i < array_04.length; i++) {
            System.out.println("[" + convInt2StringLead0(i, cIntOutTempl_2) + "] " + Arrays.toString(array_04[i]));
        }

// ----------------------------------------------------------------------------------------------------
// 5.**  Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
        System.out.println("\n\r" + " === Task_05.(**)");
        int array_05[] = new int[]{99, 44, 31, 1, 4, -55, 88, 89, 2345, 5, 23, 05, 909, 1024, 512, 128, 256, 2048};
        int minMax_05[] = new int[2];

        System.out.println("Array Values: " + Arrays.toString(array_05));
        minMax_05 = getBoundaryValues_05(array_05);
        System.out.println("min Value: " + minMax_05[0]);
        System.out.println("Max Value: " + minMax_05[1]);

// ----------------------------------------------------------------------------------------------------
// 6.**  Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//    если в массиве есть место, в котором сумма левой и правой части массива равны.
//    Примеры:  checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) --> true,
//              checkBalance([1, 1, 1, || 2, 1]) --> true,
//    граница показана символами ||, эти символы в массив не входят.
        System.out.println("\n\r" + " === Task_06.(**)");
        int array_06[] = new int[]{2, 2, 2, 2, 6, 1, 2, 10, 1};
//        int array_06[] = new int[]{2, 2, 2, 2, 1, 2, 10, 1};
//        int array_06[] = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};

        System.out.println("Array for check: " + Arrays.toString(array_06));
        boolean arrayBalanced = checkBalance_A(array_06);
        System.out.println(">>>> Checking result->" + arrayBalanced);

// ----------------------------------------------------------------------------------------------------
// 7.****   Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//      или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются
//      циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//   Примеры:    [ 1, 2, 3 ]   при n =  1 (на один вправо) -> [ 3, 1, 2 ];
//               [ 3, 5, 6, 1] при n = -2 (на два влево)   -> [ 6, 1, 3, 5 ].
//      При каком n в какую сторону сдвиг можете выбирать сами.
        System.out.println("\n\r" + " === Task_07.(****)");
        int array_07[] = new int[]{0, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        final int ci_shiftPos = 6;  // negative:-> shift left | positive:-> right

        System.out.println("Array for shift: " + Arrays.toString(array_07));
        array_07 = shiftArrayByN_Positions(ci_shiftPos, array_07);
        System.out.println("Array after shift: " + Arrays.toString(array_07));
    }

    // ========================================
    public static int[] calcArray_01(int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            switch (inArray[i]) {
                case 0:
                    inArray[i] = 1;
                    break;
                case 1:
                    inArray[i] = 0;
                    break;
                default:
                    continue;
            }
        }

        return inArray;
    }

    // ========================================
    public static int[] fillArray_02(int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            if (i == 0) {
                inArray[i] = 0;
            } else {
                inArray[i] = inArray[i - 1] + 3;
            }
        }
        return inArray;
    }

    // ========================================
    public static int[] multpArrayGT6_03(int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] > 6) {
                inArray[i] = inArray[i] * 2;
            }
        }
        return inArray;
    }

    // ========================================
    private static String convInt2StringLead0(int intValue, byte outLength) {
        byte li_outLength = outLength;

// -- get format expression: '%<NN>d'
        if (outLength > 99) {
            li_outLength = 99;
        } else if (outLength == 0) {
            li_outLength = 1;
        }

        String format = new String();
        if (li_outLength >= 1 && li_outLength <= 9) {
            format = "%0" + li_outLength + "d";
        } else {
            format = "%" + li_outLength + "d";
        }

// -- get converted number to string respective with the leading zeros
        String str = String.format(format, intValue);
        return str;
    }

    // ========================================
    public static int[][] fillArray_04(int[][] inArray) {
        final int ci_fillInValue = 1;

        for (int i = 0; i < inArray.length; i++) {
            inArray[i][i] = ci_fillInValue;
            inArray[i][inArray.length - 1 - i] = ci_fillInValue;
        }
        return inArray;
    }

    // ========================================
    public static int[] getBoundaryValues_05(int[] inArray) {
        int[] minMaxValues = new int[]{inArray[0], inArray[0]};

//   minMaxValues[0] - minimum Val; minMaxValues[1] - MAXimum Val;
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] < minMaxValues[0]) {         // get Minimum Value
                minMaxValues[0] = inArray[i];
            }

            if (inArray[i] > minMaxValues[1]) {         // get Maximum Value
                minMaxValues[1] = inArray[i];
            }
        }
        return minMaxValues;
    }

    // ========================================
    public static boolean checkBalance_A(int[] inArray) {
        int sumLeft_1, sumRight_1;
        int sumLeft_2, sumRight_2;
        int chkRange = inArray.length / 2 + inArray.length % 2;
        int iterationCount = 0;

        for (int i = 1; i <= chkRange; i++) {
            iterationCount = i;
            System.out.println("+++++ Current iteration: " + i);

//    the 1st boundary is counted from the left
            sumLeft_1 = getArraySum(inArray, 0, i);
            sumRight_1 = getArraySum(inArray, i, inArray.length);
            System.out.println("  leftBoundary: (leftSum: " + sumLeft_1 + "; " + "righttSum: " + sumRight_1);

//    the 2nd boundary is counted from the right
            sumLeft_2 = getArraySum(inArray, 0, inArray.length - i);
            sumRight_2 = getArraySum(inArray, inArray.length - i, inArray.length);
            System.out.println("  rightBoundary: (leftSum: " + sumLeft_2 + "; " + "righttSum: " + sumRight_2);

            if (sumLeft_1 == sumRight_1) {
                System.out.println("Found successfully at iteration: " + i);
                return true;
            } else if (sumLeft_2 == sumRight_2) {
                System.out.println("Found successfully at iteration: " + i);
                return true;
            }
        }

        System.out.println("No matching found, iterations: " + iterationCount);
        return false;
    }

    // ========================================
    public static int getArraySum(int[] inArray, int offSet, int lengthArray) {
        int sumOfElements = 0;

        for (int i = offSet; i < lengthArray; i++) {
            sumOfElements = sumOfElements + inArray[i];
        }
        return sumOfElements;
    }

    // ========================================
    public static int[] shiftArrayByN_Positions(int shiftPos, int[] inArray) {
        int shiftTimes = Math.abs(shiftPos);
        int i = 1;

        if (shiftPos > 0) {                                                                 // shift RIGHT
            System.out.println("Shift RIGHT by " + shiftTimes + " positions");
            while (i <= shiftTimes) {
                inArray = shiftRightOnce(inArray);
                i++;
            }

        } else if (shiftPos < 0) {                                                          // shift LEFT
            System.out.println("Shift LEFT by " + shiftTimes + " positions");
            while (i <= shiftTimes) {
                inArray = shiftLeftOnce(inArray);
                i++;
            }

        } else {                                                                            // 0 - NO shift
            System.out.println(">>No shift performed");
        }

        return inArray;
    }

    // ========================================
    public static int[] shiftRightOnce(int[] inArray) {
        int arrayIdxLastElem = inArray.length - 1;
        int dropDownArrayElement = inArray[arrayIdxLastElem];

        for (int i = 0; i < arrayIdxLastElem; i++) {
            inArray[arrayIdxLastElem - i] = inArray[arrayIdxLastElem - i - 1];
        }
        inArray[0] = dropDownArrayElement;

        return inArray;
    }

    // ========================================

    public static int[] shiftLeftOnce(int[] inArray) {
        int arrayIdxLastElem = inArray.length - 1;
        int dropDownArrayElement = inArray[0];

        for (int i = 1; i < inArray.length; i++) {
            inArray[i - 1] = inArray[i];
        }
        inArray[arrayIdxLastElem] = dropDownArrayElement;

        return inArray;
    }
}