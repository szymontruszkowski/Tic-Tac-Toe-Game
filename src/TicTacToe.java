public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = {{'_','|','_','|','_'}, {'_','|','_','|','_'}, {'_','|','_','|','_'}};

        printBoard(board);
    }

    public static void printBoard(char[][] board) {

        for(char[] row : board) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
