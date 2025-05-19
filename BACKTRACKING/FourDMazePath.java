package BACKTRACKING;

public class FourDMazePath {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        boolean[][] isVisited = new boolean[rows][cols];
        
        // Calculate the number of ways to reach the destination
        int count = maze(0, 0, rows - 1, cols - 1, isVisited);
        System.out.println("Number of ways: " + count);
        
        // Print all possible paths
        System.out.println("Paths:");
        print(0, 0, rows - 1, cols - 1, "", isVisited);
    }

    private static int maze(int sr, int sc, int er, int ec, boolean[][] isVisited) {
        // Out of bounds or already visited check
        if (sr < 0 || sc < 0 || sr > er || sc > ec || isVisited[sr][sc]) {
            return 0;
        }
        // Destination reached
        if (sr == er && sc == ec) {
            return 1;
        }

        // Mark the cell as visited
        isVisited[sr][sc] = true;

        // Explore all four directions
        int rightWays = maze(sr, sc + 1, er, ec, isVisited); // Right
        int downWays = maze(sr + 1, sc, er, ec, isVisited);  // Down
        int leftWays = maze(sr, sc - 1, er, ec, isVisited);  // Left
        int upWays = maze(sr - 1, sc, er, ec, isVisited);    // Up

        // Unmark the cell for backtracking
        isVisited[sr][sc] = false;

        // Return the total ways from the current cell
        return rightWays + downWays + leftWays + upWays;
    }

    private static void print(int sr, int sc, int er, int ec, String path, boolean[][] isVisited) {
        // Out of bounds or already visited check
        if (sr < 0 || sc < 0 || sr > er || sc > ec || isVisited[sr][sc]) {
            return;
        }
        // Destination reached
        if (sr == er && sc == ec) {
            System.out.println(path);
            return;
        }

        // Mark the cell as visited
        isVisited[sr][sc] = true;

        // Explore all directions with respective path markers
        print(sr + 1, sc, er, ec, path + "D", isVisited); // Down
        print(sr, sc + 1, er, ec, path + "R", isVisited); // Right
        print(sr, sc - 1, er, ec, path + "L", isVisited); // Left
        print(sr - 1, sc, er, ec, path + "U", isVisited); // Up

        // Unmark the cell for backtracking
        isVisited[sr][sc] = false;
    }
}
 