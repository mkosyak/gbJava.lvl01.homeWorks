package lesson_04;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class homeWork_04_ticTacToe {
    //  ---- C O N S T A N T S
    public static final char cc_initTicTacSym = '.';
    public static final int ci_fieldDimMax = 9;
    public static final int ci_playersMin = 2;
    public static final int ci_playersMax = 5;
    public static final int ci_playerTypeAi = 0;
    public static final int ci_playerTypeHuman = 1;
    public static final String cv_playerTypeAi = "AI";
    public static final String cv_playerTypeHuman = "Human";

    public static void main(String[] args) {
// -- Start Message
        System.out.println("<<< -== Tic-Tac Toe Game ==- >>> \n");

// -- Initialization:
// ---- console Input
        Scanner input = new Scanner(System.in);

// ---- set number of players
        int numOfPlayers = setNumOfPlayers(input);

// ---- set players' attributes via arrays (access by index)
        String playerName[] = new String[numOfPlayers];         // unique name of the player
        int playerType[] = new int[numOfPlayers];               // 0 = AI; 1 = Human; ...
        char playerMoveSymbol[] = new char[numOfPlayers];       // symbol to play per each player
        initPlayers(input, playerName, playerType, playerMoveSymbol);

// ---- init of the playing field
        int fieldDim = initFieldDim(input, numOfPlayers);       //  set dimension
        char[][] field = new char[fieldDim][fieldDim];
        initPlayingField(field);                                // set cells into initial value

// -- Start Game Main Cycle
        mainGameCycle(input, field, playerName, playerType, playerMoveSymbol);

// -- Final Message - Exit
        System.out.println("\n <<< -== Tic-Tac Toe - GAME IS OVER ==- >>> \n");

    }

    /*    =================== P R O C E D U R E S ==============================
     */
    public static void mainGameCycle(Scanner input, char[][] field,
                                     String[] playerName, int[] playerType, char[] playerMoveSymbol) {
//  ------------------------------------------------
// ---- ... first step
        boolean keepOnPlay = true;
        int roundIdx = 1;                   // the current Round index
        int playerMovIdx = 0;               // the current Player_Move index
        outputField(field, roundIdx, playerMovIdx, " !!! START!!!");

// ---- ... moveCount cycle
        String cv_prtfMsg_winner = "--==<< Congratulations! %s has won! >>==--";
        do {
            outputFieldHdr(field.length, roundIdx, playerMovIdx + 1,
                    playerName[playerMovIdx], playerMoveSymbol[playerMovIdx]);
            if (playerType[playerMovIdx] == ci_playerTypeHuman && keepOnPlay) {
                moveHumanPlayer(input, field, playerMoveSymbol[playerMovIdx]);
            } else if (playerType[playerMovIdx] == ci_playerTypeAi && keepOnPlay) {
                moveAiPlayerRnd(field, playerMoveSymbol[playerMovIdx]);
//            ... = getNewCoord4AiMove_01(field, playerMoveSymbol[playerMovIdx]); // not implemented
//            ... = getNewCoord4AiMove_02(field, playerMoveSymbol[playerMovIdx]); // not implemented
            }
            outputField(field, roundIdx, playerMovIdx, playerName[playerMovIdx]);

            if (chkDIsDraw(field)) {
                keepOnPlay = false;
            } else if (chkIsWinner(field, playerMoveSymbol[playerMovIdx])) {
                System.out.printf(cv_prtfMsg_winner, playerName[playerMovIdx]);
                keepOnPlay = false;
            } else {
                playerMovIdx++;
                if (playerMovIdx == playerName.length) { //check for new Round of the players
                    playerMovIdx = 0;
                    roundIdx++;
                }
            }
        }
        while (keepOnPlay);
    }

    public static void initPlayers(Scanner input, String playerName[], int playerType[], char playerMoveSymbol[]) {
//  ------------------------------------------------
        for (int i = 0; i < playerName.length; i++) {
            String cv_prtlfMsg_initPlayer = "%n  ----- Player %d";
            System.out.printf(cv_prtlfMsg_initPlayer, i + 1);

            do {
                playerName[i] = inputPlayerName(input, i);
            }
            while (!chkPlayerNamebIsUniq(playerName, playerName[i], i));

            do {
                playerMoveSymbol[i] = inputPlayerSymb(input, playerName[i]);
            }
            while (!chkPlayerSymbIsUniq(playerMoveSymbol, playerMoveSymbol[i], i));
            playerType[i] = inputPlayerType(input, playerName[i]);
        }
    }

    public static boolean chkPlayerNamebIsUniq(String pa_names[], String chkName, int playerIdx) {
//  ------------------------------------------------
        String cv_prtf_nameUsedMsg = "%n<<< Name '%s' already assigned, select another one! >>>%n";
        String cv_prtf_nameOkMsg = " >> Name '%s' is OK! %n";

        for (int i = 0; i < playerIdx; i++) {   // only previous, do not check current player
            if (pa_names[i].equals(chkName)) {
                System.out.printf(cv_prtf_nameUsedMsg, chkName);
                return false;
            }
        }
        System.out.printf(cv_prtf_nameOkMsg, chkName);
        return true;
    }

    public static boolean chkPlayerSymbIsUniq(char pa_symbols[], char chkSymb, int playerIdx) {
//  ------------------------------------------------
        String cv_prtf_symbUsedMsg = "%n<<< Symbol '%c' already assigned, select another one! >>>%n";
        String cv_prtf_symbOkMsg = " >> Symbol '%c' is OK! %n";

        for (int i = 0; i < playerIdx; i++) {   // only previous, do not check current player
            if (pa_symbols[i] == chkSymb) {
                System.out.printf(cv_prtf_symbUsedMsg, chkSymb);
                return false;
            }
        }
        System.out.printf(cv_prtf_symbOkMsg, chkSymb);
        return true;
    }

    public static char inputPlayerSymb(Scanner input, String name) {
//  ------------------------------------------------
        String cv_printfMsg_enterPlayers = "Enter the player symbol to play [any symbol] for player %s: ";

        System.out.printf(cv_printfMsg_enterPlayers, name);
        String symOfPlayer2Move = input.next();
        return symOfPlayer2Move.charAt(0);
    }

    public static int inputPlayerType(Scanner input, String name) {
//  ------------------------------------------------
        String cv_printfMsg_enterPlayers = "Enter the player type [%d=%s/ %d=%s/...] for player %s: ";
        String cv_printfMsg_wrongRng = "%n >> Value %d is out of range, please re-enter.%n";
        String cv_printfMsg_wrongVal = "%n<<< Wrong value '%s' try again! >>>%n";

        int numOfPlayers = ci_playersMin;
        boolean chkCrdIsCorrect = false;

        do {
            try {
                System.out.printf(cv_printfMsg_enterPlayers, ci_playerTypeAi, cv_playerTypeAi,
                        ci_playerTypeHuman, cv_playerTypeHuman, name);
                numOfPlayers = input.nextInt();

                if (numOfPlayers < ci_playerTypeAi || numOfPlayers > ci_playerTypeHuman) {
                    System.out.printf(cv_printfMsg_wrongRng, numOfPlayers);
                    continue;
                } else {
                    chkCrdIsCorrect = true;
                }
            } catch (InputMismatchException e) {                             //Exception or InputMismatchException
                System.out.printf(cv_printfMsg_wrongVal, input.next());
            }
        } while (!chkCrdIsCorrect);

        return numOfPlayers;
    }

    public static String inputPlayerName(Scanner input, int playerIdx) {
//  ------------------------------------------------
        String cv_printfMsg_nameOfPlayer = "%nEnter the name of Player %d: ";

        System.out.printf(cv_printfMsg_nameOfPlayer, playerIdx + 1);
        return input.next();
    }

    public static int setNumOfPlayers(Scanner input) {
//  ------------------------------------------------
        String cv_printfMsg_enterPlayers = "%nEnter the number of players [%d...%d]: ";
        String cv_printfMsg_wrongRng = "%n >> Value %d is out of range, please re-enter%n";
        String cv_printfMsg_wrongVal = "%n<<< Wrong value '%s' try again! >>>%n";
        int numOfPlayers = ci_playersMin;
        boolean chkIsCorrect = false;

        do {
            try {
                System.out.printf(cv_printfMsg_enterPlayers, ci_playersMin, ci_playersMax);
                numOfPlayers = input.nextInt();
                if (numOfPlayers < ci_playersMin || numOfPlayers > ci_playersMax) {
                    System.out.printf(cv_printfMsg_wrongRng, numOfPlayers);
                    continue;
                } else {
                    chkIsCorrect = true;
                }
            } catch (InputMismatchException e) {                             //Exception or InputMismatchException
                System.out.printf(cv_printfMsg_wrongVal, input.next());
            }
        } while (!chkIsCorrect);
        return numOfPlayers;
    }

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

    public static boolean chkVertLine4Win(char pa_field[][], char chkSymbol, int idxCol) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            if (pa_field[i][idxCol] != chkSymbol) return false;
        }
        return true;
    }

    public static boolean chkHrzLine4Win(char pa_field[][], char chkSymbol, int idxRow) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            if (pa_field[idxRow][i] != chkSymbol) return false;
        }
        return true;
    }

    public static void moveAiPlayerRnd(char pa_field[][], char moveSymbol) {
//  ------------------------------------------------
        Random random = new Random();
        int x, y;

        do {
            x = random.nextInt(pa_field.length);
            y = random.nextInt(pa_field.length);
        } while (!chkCellIsFree(pa_field, x, y, false));

        updField(pa_field, x, y, moveSymbol);
    }

    public static int[] getNewCoord4AiMove_01(char pa_field[][], char moveSymbol) {
//  ------------------------------------------------
        int coordinates[] = new int[2];
/*
    Strategy I. Find next move with the minimum movements to wiт
     - check all columns/rows and main/collateral diagonal to fill with the minimum moves
      for win
     - if diagonal moves are preferable - take the corners first)
 */

        return coordinates;
    }

    public static int[] getNewCoord4AiMove_02(char pa_field[][], char moveSymbol) {
//  ------------------------------------------------
        int coordinates[] = new int[2];
/*
    Strategy II. calculate number of movements for Win for AI vs Player:
       - if Player is going to win faster - screw out his next movement
       - if NOT find the best opportunity for AI for the next movement

 */

        return coordinates;
    }

    public static void moveHumanPlayer(Scanner input, char pa_field[][], char moveSymbol) {
//  ------------------------------------------------
        String cv_printfMsg_runNextMov = "Please, enter the coordinates of the next move (X=[%d...%d]| Y=[%d...%d])%n";
        int x, y;

        System.out.printf(cv_printfMsg_runNextMov, 1, pa_field[0].length, 1, pa_field[0].length);
        do {
            x = inputCoordinate('X', input, pa_field) - 1;
            y = inputCoordinate('Y', input, pa_field) - 1;
        } while (!chkCellIsFree(pa_field, x, y, true));

        updField(pa_field, x, y, moveSymbol);
    }

    public static boolean chkCellIsFree(char pa_field[][], int x, int y, boolean outMsg) {
//  ------------------------------------------------
        if (pa_field[y][x] == cc_initTicTacSym) {
            return true;
        } else {
            if (outMsg) {
                System.out.println("\n >> Cell already used, please redo.\n");
            }
            return false;
        }
    }

    public static boolean chkDIsDraw(char pa_field[][]) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            for (int j = 0; j < pa_field[i].length; j++) {
                if (chkCellIsFree(pa_field, j, i, false)) {
                    return false;
                }
            }
        }
        System.out.println("\n >> No free cells to next move - it's a Draw!\n");
        return true;
    }

    public static void updField(char pa_field[][], int x, int y, char moveSymbol) {
//  ------------------------------------------------
        pa_field[y][x] = moveSymbol;
    }

    public static int inputCoordinate(char crdName, Scanner input, char pa_field[][]) {
//  ------------------------------------------------
        String cv_printfMsg_wrongRng = "%n >>%s-coordinate out of range, try again!%n";
        String cv_printfMsg_wrongVal = "%n<<< Wrong value '%s' try again! >>>%n";
        boolean chkIsCorrect = false;
        int coordinate = 0;

        do {
            try {
                System.out.print(crdName + " = ");
                coordinate = input.nextInt();
                if (coordinate < 1 || coordinate > pa_field.length) {
                    System.out.printf(cv_printfMsg_wrongRng, crdName);
                    continue;
                } else {
                    chkIsCorrect = true;
                }
            } catch (InputMismatchException e) {                             //Exception or InputMismatchException
                System.out.printf(cv_printfMsg_wrongVal, input.next());
            }
        } while (!chkIsCorrect);

        return coordinate;
    }

    public static int initFieldDim(Scanner input, int numOfPlayers) {
//  ------------------------------------------------
        String cv_printfMsg_input = "%nPlease specify the field dimension X=Y in range %d...%d: ";
        String cv_printfMsg_invalidInp01 = "%n<<< Input number is out of range... assigning default value '%d'>>>%n";
        String cv_printfMsg_invalidInp02 = "%n<<< Invalid value entered... assigning default value '%d'>>>%n";
        int fieldDimMin = numOfPlayers + 1;
        int fieldDim = fieldDimMin;

        System.out.printf(cv_printfMsg_input, fieldDimMin, ci_fieldDimMax);
        try {
            fieldDim = input.nextInt();                 // Dimension:  X = Y
            if (fieldDim > ci_fieldDimMax || fieldDim < fieldDimMin) {
                fieldDim = fieldDimMin;
                System.out.printf(cv_printfMsg_invalidInp01, fieldDim);
            }
        } catch (Exception e) {
            System.out.printf(cv_printfMsg_invalidInp02, fieldDim);
        }

        return fieldDim;
    }

    public static void initPlayingField(char[][] pa_field) {
//  ------------------------------------------------
        for (int i = 0; i < pa_field.length; i++) {
            for (int j = 0; j < pa_field[i].length; j++) {
                pa_field[i][j] = cc_initTicTacSym;
//                pa_field[i][j] = Character.forDigit(i,10);
            }
        }
    }

    public static void outputField(char[][] pa_field, int roundIdx, int moveIdx, String playerName) {
//  ------------------------------------------------
//        outputFieldHdr(pa_field.length, roundIdx, moveIdx + 1, playerName);

        for (int i = 0; i < pa_field.length; i++) {            // Loop by rows
            String outLine = "";

            for (int j = 0; j < pa_field[i].length; j++) {     // Loop by columns
                outLine = outLine + ' ' + pa_field[i][j];
            }
            System.out.println(outLine);
        }
    }

    public static void outputFieldHdr(int fieldLen, int roundIdx, int moveIdx,
                                      String playerName, char playerSymb) {
//  ------------------------------------------------
        String outLine = "";
        for (int i = 0; i < fieldLen; i++) {           // output horizontal separator
            outLine = outLine + "--";
        }
        outLine = outLine + "--" + " { ";
        outLine = outLine + "ROUND: " + roundIdx + "| ";
        outLine = outLine + "Move " + moveIdx + " of player ";
        outLine = outLine + playerName + " with the chip '" + playerSymb + "'} " + "--";
        System.out.println("\n" + outLine);
    }
}
