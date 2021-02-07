package lesson_03;

//   Pull request URL: https://github.com/mkosyak/gbJava.lvl01.homeWorks/pull/...

import java.util.Scanner;

public class homeWork_03 {
    public static void main(String[] args) {
    /*
      Урок 3. Практика **/
// ---- Initilization
        Scanner consInput = new Scanner(System.in);
        String[] menu = new String[]{
                "Select task to run:\n",
                "1. Run the Game 'Guess the Number' \n",
                "2. Run the Game 'Guess the Fruit/Vegetable' \n",
                "3. Exit \n"
        };
        String printf_playNew = "Do you wanna play again? ('Y'/'N') \n";
        boolean playAgain = true;
        String ask4Replay = null;

        while (playAgain == true) {
// ---- Display Menu
            for (int i = 0; i < menu.length; i++) {
                System.out.printf(menu[i]);
            }
            int menuItem = consInput.nextInt();

// ---- Run the Game
            switch (menuItem) {
                case 1:
                    runGuessNumber(consInput);              // Run the Game 1
                    break;
                case 2:
                    runGuessWord(consInput);                // Run the Game 2
                    break;
                default:
                    System.out.println("Bye-bye...");       // Exit
                    return;
            }

// ---- Ask for Play new round
            System.out.printf(printf_playNew);
            ask4Replay = consInput.next();
            if ((ask4Replay.charAt(0) == 'Y') || (ask4Replay.charAt(0) == 'y')) {
                playAgain = true;
                continue;
            } else {
                playAgain = false;
            }
        }
    }


    /*  ----------------------------------------------------------------------------------------------------
        1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать
           это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем
           загаданное, или меньше. После победы или проигрыша выводится запрос:
                «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    */
    public static void runGuessNumber(Scanner consInput) {
        System.out.println("\n === Task_01.");
        System.out.println(" <<<<  Game 'GUESS THE NUMBER'  >>>>");

// ---- Initilization
        String printf_Enter = "Try to guess an integer number from %d to %d \n";
        String printf_guessYes = "YOU GUESS: ==> %d !!!\n";
        String printf_InpGt = "-- The entered number %d is greater than intended. \n";
        String printf_InpLt = "-- The entered number %d is less than intended. \n";
        String printf_Attempt = "Attempt %d/ %d. Your choice? :\\> ";
        final int ci_number_from = -5;
        final int ci_number_to = 9;
        int maxLoops = (java.lang.Math.abs(ci_number_to - ci_number_from) * 1 / 3);

// ---- Generate random Number
        int rndNumber = getRundomFromRange(ci_number_from, ci_number_to);
        System.out.printf(printf_Enter, ci_number_from, ci_number_to);
        boolean numberIsGuessed = false;
        int currLoop = 1;

// ---- a Loop of attempts to find a hidden number
        while (currLoop <= maxLoops && numberIsGuessed == false) {
            System.out.printf(printf_Attempt, currLoop, maxLoops);
            int inpNumber = consInput.nextInt();
            if (inpNumber == rndNumber) {
                numberIsGuessed = true;
                System.out.printf(printf_guessYes, inpNumber);
                break;
            } else if (inpNumber < rndNumber) {
                System.out.printf(printf_InpLt, inpNumber);
            } else if (inpNumber > rndNumber) {
                System.out.printf(printf_InpGt, inpNumber);
            }
            currLoop++;
        }
// ---- Game Over / Exit ----
        if (currLoop >= maxLoops) {
            System.out.println("You reached the Max.available attempts -> GAME OVER!");
        }
    }

    /* ----------------------------------------------------------------------------------------------------
     2. * Создать массив из слов
          String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
          "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
          "pepper", "pineapple", "pumpkin", "potato"}.
      При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
      словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые
      стоят на своих местах.
        пример:   apple – загаданное
                  apricot - ответ игрока
                  ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
                  Для сравнения двух слов посимвольно можно пользоваться:
                      String str = "apple";
                      char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
                  Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
    */
    public static void runGuessWord(Scanner consInput) {
        System.out.println("\n === Task_02.");
        System.out.println(" <<<<  Game 'GUESS FRUIT// VEGETABLE NAME'  >>>>");

        String printf_Enter = "Try to guess a name of Fruit/Vegetable  \n";
        String printf_reEnter = " >> Empty value is inadmissible! << \n";
        String printf_stepResult = " Your current result >> %s. Try again! \n";
        String printf_guessYes = "YOU GUESS: ==> %s !!!\n";
        String[] wordArray = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        boolean wordGuessed = false;
        String maskWord = null;

        int idxArray = getRundomFromRange(0, wordArray.length) - 1;
        String rndWord = wordArray[idxArray];
//        System.out.println("Intended Word:>" + rndWord);

        while (wordGuessed == false) {
            System.out.printf(printf_Enter);
            String inpWord = consInput.next();

            if (inpWord == null) {
                System.out.printf(printf_reEnter);
                continue;
            } else if (rndWord.equalsIgnoreCase(inpWord)) {
                System.out.printf(printf_guessYes, rndWord);
                wordGuessed = true;
            } else {
                maskWord = replaceByMask(rndWord, inpWord);
                System.out.printf(printf_stepResult, maskWord);
                continue;
            }
        }

    }

    //  ===========================================
    public static String replaceByMask(String etalon, String compared) {
        StringBuilder sb = new StringBuilder("###############");
        int retValLen = sb.toString().length();

        for (int i = 0; i < compared.length(); i++) {
            if (i <= etalon.length()) {
                for (int j = 0; j < etalon.length() && j <= retValLen; j++) {
                    if (etalon.charAt(j) == Character.toLowerCase(compared.charAt(i))) {
                        sb.setCharAt(j, Character.toUpperCase(etalon.charAt(j)));
                    }
                }
            } else break;
        }
        return sb.toString();
    }


    //  ===========================================
    public static int getRundomFromRange(int rangeBoundfrom, int rangeBoundTo) {
        float rndMath = (float) Math.random();
        int rndNumber = (int) ((rangeBoundTo + rangeBoundfrom) * rndMath - rangeBoundfrom);
        return rndNumber;
    }
}

