package tictactoe;
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};   // the array of the game.
        char turn = 'X';    // to player 1 or 2, take default player 1.
        printBoard(board);  // print board of game.
        while (true) {
            System.out.println("Enter the coordinates:");
            // to check if is there invalid input
            int coordinate1 = 0;
            int coordinate2 = 0;
            boolean b;
            // You should enter numbers! if the user enters non-numeric symbols in the coordinates input.
            do {
                if (scanner.hasNextInt()) {
                    coordinate1 = scanner.nextInt();
                    coordinate2 = scanner.nextInt();
                    b = true;
                } else {
                    System.out.println("You should enter numbers!");
                    System.out.println("Enter the coordinates:");
                    b = false;
                    scanner.next();
                }
            } while (!b);
            while (true) {
                // Coordinates should be from 1 to 3! if the user enters coordinates outside the game grid.
                if (coordinate1 > 3 || coordinate2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates:");
                    coordinate1 = scanner.nextInt();
                    coordinate2 = scanner.nextInt();
                    // This cell is occupied! Choose another one! if the cell is not empty.
                } else if (board[coordinate1 - 1][coordinate2 - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter the coordinates:");
                    coordinate1 = scanner.nextInt();
                    coordinate2 = scanner.nextInt();
                } else {
                    break;  // get out from the loop.
                }
            }
            // to change turn of player.
            if (turn == 'X') {
                board[coordinate1 - 1][coordinate2 - 1] = 'X';
                turn = 'O';
            }
            else if (turn == 'O') {
                board[coordinate1 - 1][coordinate2 - 1] = 'O';
                turn = 'X';
            }
            printBoard(board);  // print board after any players play.
            // to check X wins or O wins or Draw.
            int xScore = 0; // count x wins
            int oScore = 0; // count o wins
            int countX = 0; // count x;
            int countO = 0; // count o;
            //horizontal and vertical checks
            for(int i = 0; i < board.length; i++){
                if(board[i][0] == 'X' &&   board[i][1] == 'X' && board[i][2] == 'X'){
                    xScore++;
                }
                if(board[0][i] == 'X' &&   board[1][i] == 'X' && board[2][i] == 'X'){
                    xScore++;
                }
                if(board[i][0] == 'O' &&   board[i][1] == 'O' && board[i][2] == 'O'){
                    oScore++;
                }
                if(board[0][i] == 'O' &&   board[1][i] == 'O' && board[2][i] == 'O'){
                    oScore++;
                }
            }
            // check count of x & o
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 'X') {
                        countX++;
                    }
                    if (board[i][j] == 'O') {
                        countO++;
                    }
                }
            }
            //diagonal checks
            if(board[0][0] == 'X' &&   board[1][1] == 'X' && board[2][2] == 'X'){
                xScore++;
            }
            if(board[0][2] == 'X' &&   board[1][1] == 'X' && board[2][0] == 'X'){
                xScore++;
            }
            if(board[0][0] == 'O' &&   board[1][1] == 'O' && board[2][2] == 'O'){
                oScore++;
            }
            if(board[0][2] == 'O' &&   board[1][1] == 'O' && board[2][0] == 'O'){
                oScore++;
            }
            // check if the X or O wins or Draw the loop will stop.
            if (xScore == 1 && oScore == 0) {
                System.out.println("X wins");
                break;
            } else if (oScore == 1 && xScore == 0) {
                System.out.println("O wins");
                break;
            } else if (countX + countO == 9) {
                System.out.println("Draw");
                break;
            }
        }
    }
    // this method for print board
    private static void printBoard(char[][] board) {
        System.out.println("---------");
        System.out.println("|" + " " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " " + "|");
        System.out.println("|" + " " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " " + "|");
        System.out.println("|" + " " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " " + "|");
        System.out.println("---------");
    }
}