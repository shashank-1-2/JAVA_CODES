package BACKTRACKING;

public class KnightTourConfiguration {

    public static boolean isSafe(int grid[][], int row, int col, int num) {
        int n = grid.length;
        if (grid[row][col] == n * n - 1) return true;

        int i, j;

        // 2 up 1 left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        // 2 up 1 right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        // 2 down 1 right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        // 2 down 1 left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        // 2 left 1 up
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        // 2 left 1 down
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        // 2 right 1 up
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        // 2 right 1 down
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1) return isSafe(grid, i, j, num + 1);

        return false;
    }

    public static void checkValidGrid(int grid[][], int row) {
        int n = grid.length;

        // If all rows are filled, print the grid and return
        if (row == n) {
            printGrid(grid);
            return;
        }

        // Try placing the knight at every column in the current row
        for (int i = 0; i < n; i++) {
            if (isSafe(grid, row, i, n)) {
                grid[row][i] = row * n + i; // Mark the current position with the knight's step number
                checkValidGrid(grid, row + 1); // Recur to place knight in the next row
                grid[row][i] = -1; // Backtrack (unmark the position)
            }
        }
    }

    public static void printGrid(int[][] grid) {
        if (grid == null) {
            System.out.println("Grid is null");
            return;
        }

        for (int i = 0; i < grid.length; i++) {
            System.out.print("{");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
                if (j < grid[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("},");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] grid = new int[n][n];

        // Initialize the grid with -1 (unvisited)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }

        // Starting position for the Knight
        grid[0][0] = 0; // Mark the starting position

        // Solve the Knight's Tour problem

        checkValidGrid(grid, 1); // Start the search from row 1
    }
}
