import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final Scanner scanner = new Scanner(System.in);
    private static int userScore;
    private static int botScore;

    /**
     * Entry point of game
     */
    public static void main(String[] args) {

        char[][] board = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};

        //Game loop
        printBoard(board);

        while (true) {

            while (!isGameFinished(board)) {
                userTurn(board);
                if (isGameFinished(board)) {
                    break;
                }
                botTurn(board);
                if (isGameFinished(board)) {
                    break;
                }
            }

            System.out.println("User score is now: " + userScore);
            System.out.println("Bot score is now: " + botScore);
            System.out.println("Do you want to play again? Press Y button to continue.");

            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Good luck!");
                clearBoard(board);
                printBoard(board);
            } else {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    /**
     * Print the game board in the console
     * @param board the board to be printed
     */
    private static void printBoard(char[][] board) {

        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] );
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2] );
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2] );
    }

    /**
     * Update the board with X or O
     * @param board     the board to be updated
     * @param player    the player who makes a move
     * @param move      the move (chosen slot of the board)
     */
    private static void updateBoard(char[][] board, int player, int move) {

        char symbol = player == 1 ? 'X' : 'O';

        switch (move) {
            case 1 -> {
                board[0][0] = symbol;
                printBoard(board);
            }
            case 2 -> {
                board[0][1] = symbol;
                printBoard(board);
            }
            case 3 -> {
                board[0][2] = symbol;
                printBoard(board);
            }
            case 4 -> {
                board[1][0] = symbol;
                printBoard(board);
            }
            case 5 -> {
                board[1][1] = symbol;
                printBoard(board);
            }
            case 6 -> {
                board[1][2] = symbol;
                printBoard(board);
            }
            case 7 -> {
                board[2][0] = symbol;
                printBoard(board);
            }
            case 8 -> {
                board[2][1] = symbol;
                printBoard(board);
            }
            case 9 -> {
                board[2][2] = symbol;
                printBoard(board);
            }
            default -> {
            }
        }
    }

    /**
     * Make a user's move by first check if the move is valid and if it is then
     * mark a picked slot on the board. If the move is invalid prompt the user to
     * make another move.
     * @param board     the board to be updated
     */
    private static void userTurn(char[][] board) {

        System.out.println("Where would you like to play? (1-9)");

        String userMove;

        while (true) {
            userMove = scanner.nextLine();
            if (isValidMove(board, userMove)) {
                break;
            } else {
                System.out.println("Invalid move! Mark another slot.");
            }
        }

        System.out.println("User marked a slot number " + userMove);
        updateBoard(board, 1, Integer.parseInt(userMove));
    }

    /**
     * Check if the move is valid by check if picked slot is marked as '_' which
     * means that is empty.
     * @param board     the board to be checked
     * @param move      the move (slot on the board) to be checked
     * @return          true if the move is valid or false if it is not
     */
    private static boolean isValidMove(char[][] board, String move) {

        switch (move) {
            case "1" -> {
                return board[0][0] == '_';
            }
            case "2" -> {
                return board[0][1] == '_';
            }
            case "3" -> {
                return board[0][2] == '_';
            }
            case "4" -> {
                return board[1][0] == '_';
            }
            case "5" -> {
                return board[1][1] == '_';
            }
            case "6" -> {
                return board[1][2] == '_';
            }
            case "7" -> {
                return board[2][0] == '_';
            }
            case "8" -> {
                return board[2][1] == '_';
            }
            case "9" -> {
                return board[2][2] == '_';
            }
            default -> {
                return false;
            }
        }
    }

    private static void botTurn(char[][] board) {

        Random random = new Random();

        int botMove;

        do {
            botMove = random.nextInt(1, 10);
        } while (!isValidMove(board, Integer.toString(botMove)));

        System.out.println("Bot marked a slot number " + botMove);
        updateBoard(board, 2, botMove);
    }

    private static boolean isGameFinished(char[][] board) {

        // Board is full
        if (board[0][0] != '_' && board[0][1] != '_' && board[0][2] != '_' &&
            board[1][0] != '_' && board[1][1] != '_' && board[1][2] != '_' &&
            board[2][0] != '_' && board[2][1] != '_' && board[2][2] != '_') {

            System.out.println("Game Over");
            return true;
        }

        //User wins
        if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
            (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
            (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||

            (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
            (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
            (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||

            (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
            (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {

            System.out.println("User Wins");
            userScore++;
            return true;
        }

        //Bot wins
        if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
            (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
            (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||

            (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
            (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
            (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||

            (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
            (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {

            System.out.println("Bot Wins");
            botScore++;
            return true;
        }
        return false;
    }

    private static void clearBoard(char[][] board) {

        for (char[] row : board) {
            Arrays.fill(row, '_');
        }
    }
}
