package BACKTRACKING;

public class N_Queens {
    public static void main(String[] args) {
        int n = 5; // Define the size of the chessboard
        char[][] board = new char[n][n];

        // Initialize the board with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Start solving the N-Queens problem
        nqueens(board, 0);
    }

    private static void nqueens(char[][] board, int row) {
        int n = board.length;

        // Base case: If all queens are placed, print the board
        if (row == n) {
            printBoard(board);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                nqueens(board, row + 1); // Recurse for the next row
                board[row][col] = 'X'; // Backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        //check the same row
        for (int i = 0; i < row; i++) {
            if (board[row][i] == 'Q') return false;
        }
        // Check the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
    
        // Check the upper-left diagonal  [north-west]
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
    
        // Check the upper-right diagonal  [norht-east]
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        //check the lower-left diagonal     [south-west]
        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        
        //check the lower-right diagonal    [south-east]
        i = row;
        j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q') return false;
            i++;
            j++;
        }
    
        return true;
    }
    

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
