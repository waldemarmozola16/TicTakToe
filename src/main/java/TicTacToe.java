

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private final static int BOARDSIZE = 6;
    private static char board[][] = new char[BOARDSIZE][BOARDSIZE];

    // 1. fill the board with empty char ' '
    public static void initBoard() {
        for (int i = 0; i < BOARDSIZE; i++) {
            for (int j = 0; j < BOARDSIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }


    //2. fill the board with a pattern
    public static void printBoard() {

        System.out.println();
        for (int i = 0; i < BOARDSIZE; i++) {
            for (int j = 0; j < BOARDSIZE; j++) {
                if(j==BOARDSIZE-1){
                    System.out.print(" "+ board[i][j] +" \n");
                }
                else{
                    System.out.print(" "+ board[i][j] +" |");
                }
            }

            if(i<BOARDSIZE-1){
                System.out.print("---");
                int k=1;
                while(k<=BOARDSIZE-1){
                    System.out.print("+---");
                    k++;
                }
                System.out.println();
            }
        }
    }


    //3. the game
    public static void gameXO() {

        howToPlay();
        // printBoard();


        char currentPlayer = 'X';
        System.out.println("give the X position: ");

        while (true) {
            Scanner scan = new Scanner(System.in);
            try{
                int x = scan.nextInt();
                int o = scan.nextInt();

                if (board[x][o] != 'X' && board[x][o] != 'O') {
                    board[x][o] = currentPlayer;
                } else{
                    System.out.println("this field is busy, try another");
                    continue;
                }

                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                    System.out.println("give the O position: ");
                } else {
                    currentPlayer = 'X';
                    System.out.println("give the X position: ");
                }
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("field position is out of bounds, try another");
            }  catch(InputMismatchException e){
                System.out.println("insert number");
            }

            printBoard();

            //check winner for rows
            if(checkWinnerRows() == 'X') {
                System.out.println("The winner is X" );
                break;
            } else if(checkWinnerRows() == 'O'){
                System.out.println("The winner is O");
                break;
            }

            //check winner for cols
            if(checkWinnerCols() == 'X') {
                System.out.println("The winner is X" );
                break;
            } else if(checkWinnerCols() == 'O'){
                System.out.println("The winner is O");
                break;
            }

            //check winner for right diagonal
            if(checkWinnerRightDiagonal() == 'X') {
                System.out.println("The winner is X" );
                break;
            } else if(checkWinnerRightDiagonal() == 'O'){
                System.out.println("The winner is O");
                break;
            }

            //check winner for left diagonal
            if(checkWinnerLeftDiagonal() == 'X') {
                System.out.println("The winner is X" );
                break;
            } else if(checkWinnerLeftDiagonal() == 'O'){
                System.out.println("The winner is O");
                break;
            }

            //check for death-heat
            int counter = 0;
            for(int i=0; i<BOARDSIZE; i++){
                for(int j=0; j<BOARDSIZE; j++){
                    if(board[i][j] == ' '){
                        counter++;
                    }
                }
            }
            if(counter == 0){
                System.out.println("Death-heat");
                break;
            }
        }
    }

    //4 check winner for rows
    public static char checkWinnerRows(){

        for(int i=0; i<BOARDSIZE; i++){
            int counterX = 0;
            int counterO = 0;
            for(int j=0; j<BOARDSIZE; j++){
                if(board[i][j] == 'X'){
                    counterX++;
                }   else if(board[i][j] == 'O'){
                    counterO++;
                }
            }
            if(counterX == BOARDSIZE){
                return 'X';
            }
            if(counterO == BOARDSIZE){
                return 'O';
            }
        }
        return '/';
    }

    //4 check winner for cols
    public static char checkWinnerCols(){

        for(int i=0; i<BOARDSIZE; i++){
            int counterXCols = 0;
            int counterOCols = 0;
            for(int j=0; j<BOARDSIZE; j++){
                if(board[j][i] == 'X'){
                    counterXCols++;
                }   else if(board[j][i] == 'O'){
                    counterOCols++;
                }
            }
            if(counterXCols == BOARDSIZE){
                return 'X';
            }
            if(counterOCols == BOARDSIZE){
                return 'O';
            }
        }
        return '/';
    }

    //4 check winner for right diagonal
    public static char checkWinnerRightDiagonal(){

        int counterX = 0;
        int counterY = 0;
        for(int i=0; i<BOARDSIZE; i++){
            if(board[i][BOARDSIZE-1-i] == 'X'){
                counterX++;
            }   else if(board[i][BOARDSIZE-1-i] == 'O'){
                counterY++;
            }
            if(counterX == BOARDSIZE){
                return 'X';
            }
            if(counterY == BOARDSIZE){
                return 'O';
            }
        }
        return '/';
    }

    //4 check winner for left diagonal
    public static char checkWinnerLeftDiagonal(){

        int counterX = 0;
        int counterY = 0;
        for(int i=0; i<BOARDSIZE; i++){
            if(board[i][i] == 'X'){
                counterX++;
            }   else if(board[i][i] == 'O'){
                counterY++;
            }
            if(counterX == BOARDSIZE){
                return 'X';
            }
            if(counterY == BOARDSIZE){
                return 'O';
            }
        }
        return '/';
    }

    public static void howToPlay(){

        System.out.println();
        System.out.println("HOW TP PLAY:");
        System.out.println();
        System.out.println("put the first digit e.g. '0'");
        System.out.println("ENTER");
        System.out.println("put the secound digit e.g '1'");
        System.out.println("ENTER");
        System.out.println();
        System.out.println("Possible positions:");

        for (int i = 0; i < BOARDSIZE; i++) {
            for (int j = 0; j < BOARDSIZE; j++) {
                if(j==BOARDSIZE-1){
                    System.out.print(" "+ i + j +" \n");
                }
                else{
                    System.out.print(" "+ i + j +" |");
                }
            }

            if(i<BOARDSIZE-1){
                System.out.print("----");
                int k=1;
                while(k<=BOARDSIZE-1){
                    System.out.print("+----");
                    k++;
                }
                System.out.println();
            }
        }
        System.out.println();
        /////<- end printCat positions
    }


    public static void main(String[] args) {
        initBoard();
        gameXO();

    }

}
