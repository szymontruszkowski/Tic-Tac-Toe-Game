import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = {{'_','|','_','|','_'}, {'_','|','_','|','_'}, {'_','|','_','|','_'}};


        //Testing
        printBoard(board);
        updateBoard(board, 1, 1);
        updateBoard(board, 2, 2);

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

        int userMove = scanner.nextInt();
        updateBoard(board, 1, userMove);
    }
}
