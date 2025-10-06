import java.util.Scanner;

public class TicTacToe {
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static char currentPlayer = 'X';
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Tic Tac Toe ===");
        printBoard();

        while (true) {
            playerMove();
            printBoard();

            if (checkWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }

            switchPlayer();
        }

        input.close();
    }

    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static void playerMove() {
        int move;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            move = input.nextInt();
            if (move < 1 || move > 9) {
                System.out.println("Invalid move. Try again.");
            } else if (board[move - 1] != ' ') {
                System.out.println("That spot is already taken.");
            } else {
                board[move - 1] = currentPlayer;
                break;
            }
        }
    }

    static boolean checkWinner() {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] line : winConditions) {
            if (board[line[0]] == currentPlayer &&
                board[line[1]] == currentPlayer &&
                board[line[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    static boolean isBoardFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
