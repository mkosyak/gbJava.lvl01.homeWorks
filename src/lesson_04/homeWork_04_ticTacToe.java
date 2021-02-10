package lesson_04;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class homeWork_04_ticTacToe {
    public static final char cc_crossSym = 'X';
    public static final char cc_zeroSym = 'O';
    public static final char cc_initTicTacSym = '.';
    public static final int ci_fieldDimDft = 3;
    public static final int ci_fieldDimMin = 2;
    public static final int ci_fieldDimMax = 9;
    public static int gi_fieldDim;
    public static boolean gb_playerAiRun;
    public static boolean gb_playerRun;


    public static void main(String[] args) {
// -- Start Message
        System.out.println("<<< -== Tic-Tac Toe Game ==- >>> \n");

// -- Initialization:
        Scanner input = new Scanner(System.in);

// ---- ... define field dimension
        gi_fieldDim = initFieldDim(input);
        char[][] field = new char[gi_fieldDim][gi_fieldDim];

// ---- ... field's cell initial value
        initPlayingField(field);

// ---- ... assignment playing symbol for the players
        char playerSymbol = assgnPlayerSymb(input);
        char aiSymbol = assgnAiSymb(playerSymbol);

// ---- ... who moves the first: Player/AI
        gb_playerRun = true;        // default: Player starts first
        gb_playerAiRun = false;

// -- Game Move
// ---- ... first step
        boolean keepOnPlay = true;
        int moveCount = 0;                  // the moveCount number
        outputField(field, moveCount, ' ');

// ---- ... moveCount cycle
        String cv_prtf_winnerMsg = "--==<< Congratulations! %s has won! >>==--";
        do {
            keepOnPlay = !chkDIsDraw(field);
            moveCount++;
            if (gb_playerRun && keepOnPlay) {
                movePlayer(input, field, playerSymbol);
                outputField(field, moveCount, playerSymbol);
                if (chkIsWinner(field, playerSymbol)) {
                    System.out.printf(cv_prtf_winnerMsg, "Player");
                    break;
                }
                gb_playerRun = false;
                gb_playerAiRun = true;
            } else if (gb_playerAiRun && keepOnPlay) {
                moveAiPlayerRnd(input, field, aiSymbol);
                outputField(field, moveCount, aiSymbol);
                if (chkIsWinner(field, aiSymbol)) {
                    System.out.printf(cv_prtf_winnerMsg, "AI");
                    break;
                }
                gb_playerRun = true;
                gb_playerAiRun = false;
            }
        } while (keepOnPlay);
    }

    /*    =================== P R O C E D U R E S ==============================
     */
    public static boolean chkIsWinner(char pa_field[][], char chkSymbol) {
//  ------------------------------------------------
        if (chkMainDiag4Win(pa_field, chkSymbol) || chkCollatDiag4Win(pa_field, chkSymbol)) {
            return true;
        } else {
            for (int i = 0; i < pa_field.length; i++) {
                if (chkHrzLine4Win(pa_field, chkSymbol, i) || chkVertLine4Win(pa_field, chkSymbol, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean chkMainDiag4Win(char pa_field[][], char chkSymbol) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            if (pa_field[i][i] != chkSymbol) return false;
        }
        return true;
    }

    public static boolean chkCollatDiag4Win(char pa_field[][], char chkSymbol) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            if (pa_field[i][pa_field.length - 1 - i] != chkSymbol) return false;
        }
        return true;
    }

    public static boolean chkVertLine4Win(char pa_field[][], char chkSymbol, int idx) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            if (pa_field[idx][i] != chkSymbol) return false;
        }
        return true;
    }

    public static boolean chkHrzLine4Win(char pa_field[][], char chkSymbol, int idx) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            if (pa_field[i][idx] != chkSymbol) return false;
        }
        return true;
    }

    public static void moveAiPlayerRnd(Scanner input, char pa_field[][], char moveSymbol) {
//  ------------------------------------------------
        boolean cellIsAvail = false;
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(pa_field.length);
            y = random.nextInt(pa_field.length);
        } while (!chkCellIsFree(pa_field, x, y, false));

        updField(pa_field, x, y, moveSymbol);
    }

    public static void movePlayer(Scanner input, char pa_field[][], char moveSymbol) {
//  ------------------------------------------------
        String cv_runNextMovMsg = "Please, enter the coordinates of the next move (X=[%d...%d]| Y=[%d...%d])%n";
        int x, y;

        System.out.printf(cv_runNextMovMsg, 1, pa_field[0].length, 1, pa_field[0].length);
        do {
            x = inputCoordinate('X', input, pa_field) - 1;
            y = inputCoordinate('Y', input, pa_field) - 1;
        } while (!chkCellIsFree(pa_field, x, y, true));

        updField(pa_field, x, y, moveSymbol);
    }

    public static boolean chkCellIsFree(char pa_field[][], int x, int y, boolean suprsOutMsg) {
//  ------------------------------------------------
        if (pa_field[y][x] == cc_initTicTacSym) {
            return true;
        } else {
            if (suprsOutMsg) {
                System.out.println(" >> Cell already used, please redo.");
            }
            return false;
        }
    }

    public static boolean chkDIsDraw(char pa_field[][]) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            for (int j = 0; j < pa_field[i].length; j++) {
                if (pa_field[i][j] == cc_initTicTacSym) {
                    return false;
                }
            }
        }
        System.out.println(" >> No free cells to next move - it's a Draw!");
        return true;
    }

    public static void updField(char pa_field[][], int x, int y, char moveSymbol) {
//  ------------------------------------------------
        pa_field[y][x] = moveSymbol;
    }

    public static int inputCoordinate(char crdName, Scanner input, char pa_field[][]) {
//  ------------------------------------------------
        String cv_wrongRng = "<<< %s-coordinate out of range [%d...%d], try again! >>>%n";
        String cv_wrongVal = "%n<<< Wrong value '%s' try again! >>>%n";
        boolean chkCrdIsCorrect = false;
        int coordinate = 0;

        do {
            try {
                System.out.print(crdName + " = ");
                coordinate = input.nextInt();
                if (coordinate < 1 || coordinate > gi_fieldDim) {
                    System.out.printf(cv_wrongRng, crdName, 1, gi_fieldDim);
                    continue;
                } else {
                    chkCrdIsCorrect = true;
                }
            } catch (InputMismatchException e) {                             //Exception or InputMismatchException
                System.out.printf(cv_wrongVal, input.next());
            }
        } while (!chkCrdIsCorrect);

        return coordinate;
    }

    public static boolean chkSellIsFree(char pa_field[][], int x, int y) {
//  ------------------------------------------------
        if (pa_field[y][x] == cc_crossSym || pa_field[y][x] == cc_zeroSym) {
            return false;
        } else {
            return true;
        }
    }

    public static char assgnPlayerSymb(Scanner input) {
//  ------------------------------------------------
        String cv_printf_inMsg_01 = "Select a symbol to play for Player_1 ('%c'/'%c'):";
        String cv_printf_retMsg_01 = " - '%c' is assigned Player_1 to play.%n";
        String cv_printf_retMsg_02 = " - Invalid input... default value '%c' is assigned to play.";
        char retVal;

        try {
            System.out.printf(cv_printf_inMsg_01, cc_crossSym, cc_zeroSym);  // 1st symbol of the string
            retVal = Character.toUpperCase(input.next().charAt(0));
            if (retVal != cc_crossSym && retVal != cc_zeroSym) {
                retVal = cc_crossSym;
            }
        } catch (Exception e) {
            retVal = cc_crossSym;
            System.out.printf(cv_printf_retMsg_02, retVal);
            return retVal;
        }
        System.out.printf(cv_printf_retMsg_01, retVal);
        return retVal;
    }

    public static char assgnAiSymb(char playerSymbol) {
//  ------------------------------------------------
        char retVal;
        String cv_printf_retMsg_01 = " - '%c' is assigned for Player_AI to play.%n";

        switch (playerSymbol) {
            case cc_crossSym:
                retVal = cc_zeroSym;
                break;
            default:                    // cc_zeroSym
                retVal = cc_crossSym;
        }
        System.out.printf(cv_printf_retMsg_01, retVal);
        return retVal;
    }

    public static int initFieldDim(Scanner input) {
//  ------------------------------------------------
        String cv_printf_inMsg_01 = "Please specify the field dimension X=Y in range %d...%d: ";
        String cv_printf_retMsg_01 = "Input number is out of range... assigning default value '%d'%n";
        String cv_printf_retMsg_02 = "Invalid value entered... assigning default value '%d'%n";
        int fieldDim = ci_fieldDimDft;

        System.out.printf(cv_printf_inMsg_01, ci_fieldDimMin, ci_fieldDimMax);
        try {
            fieldDim = input.nextInt();                 // Dimension:  X = Y
            if (fieldDim > ci_fieldDimMax || fieldDim < ci_fieldDimMin) {
                fieldDim = ci_fieldDimDft;
                System.out.printf(cv_printf_retMsg_01, fieldDim);
            }
        } catch (Exception e) {
            System.out.printf(cv_printf_retMsg_02, fieldDim);
        }

        return fieldDim;
    }

    public static void initPlayingField(char[][] pa_field) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            for (int j = 0; j < pa_field[i].length; j++) {
                pa_field[i][j] = cc_initTicTacSym;
            }
        }
    }

    public static void outputField(char[][] pa_field, int pi_move, char playerSymbol) {
//  ------------------------------------------------
        outputFieldHdr(pa_field, pi_move, playerSymbol);

        for (int i = 0; i < pa_field.length; i++) {            // Loop by rows
            String outLine = "";

            for (int j = 0; j < pa_field[i].length; j++) {     // Loop by columns
                outLine = outLine + ' ' + pa_field[i][j];
            }
            System.out.println(outLine);
        }
    }

    public static void outputFieldHdr(char[][] pa_field, int pi_move, char playerSymbol) {
//  ------------------------------------------------
        String outLine = "";
        for (int i = 0; i < pa_field.length; i++) {           // output horizontal separator
            outLine = outLine + "--";
        }
        System.out.println("\n" + outLine + "--" + " {MOVE-'" + playerSymbol + "': " + pi_move + "} " + "--");
    }
}
