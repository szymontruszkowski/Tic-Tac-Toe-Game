import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = {{'_','|','_','|','_'}, {'_','|','_','|','_'}, {'_','|','_','|','_'}};


        //Testing
        printBoard(board);
        updateBoard(board, 1, 1);
        updateBoard(board, 2, 2);

        userTurn(board);
        userTurn(board);
        userTurn(board);
        userTurn(board);

    }

    public static void printBoard(char[][] board) {

        for(char[] row : board) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void updateBoard(char[][] board, int player, int move) {

        char symbol = player == 1 ? 'X' : 'O';

        switch (move) {
            case 1 -> {
                board[0][0] = symbol;
                printBoard(board);
            }
            case 2 -> {
                board[0][2] = symbol;
                printBoard(board);
            }
            case 3 -> {
                board[0][4] = symbol;
                printBoard(board);
            }
            case 4 -> {
                board[1][0] = symbol;
                printBoard(board);
            }
            case 5 -> {
                board[1][2] = symbol;
                printBoard(board);
            }
            case 6 -> {
                board[1][4] = symbol;
                printBoard(board);
            }
            case 7 -> {
                board[2][0] = symbol;
                printBoard(board);
            }
            case 8 -> {
                board[2][2] = symbol;
                printBoard(board);
            }
            case 9 -> {
                board[2][4] = symbol;
                printBoard(board);
            }
            default -> {
            }
        }
    }

    public static void userTurn(char[][] board) {

        System.out.println("Where would you like to play? (1-9)");

        Scanner scanner = new Scanner(System.in);

        int userMove;

        do {
            userMove = scanner.nextInt();
            System.out.println("That slot is taken! Try another one.");
        } while (!isValidMove(board, userMove));

        updateBoard(board, 1, userMove);
    }

    public static boolean isValidMove(char[][] board, int move) {

        switch (move) {
            case 1 -> {
                return board[0][0] == '_';
            }
            case 2 -> {
                return board[0][2] == '_';
            }
            case 3 -> {
                return board[0][4] == '_';
            }
            case 4 -> {
                return board[1][0] == '_';
            }
            case 5 -> {
                return board[1][2] == '_';
            }
            case 6 -> {
                return board[1][4] == '_';
            }
            case 7 -> {
                return board[2][0] == '_';
            }
            case 8 -> {
                return board[2][2] == '_';
            }
            case 9 -> {
                return board[2][4] == '_';
            }
            default -> {
                return false;
            }
        }
    }
}
