package BACKTRACKING;

public class FourDRatInADeadMaze {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 5;
        int [][] maze =   {{1,1,0,1,0},
                           {0,1,1,1,1},
                           {1,1,0,0,1},
                           {1,1,0,0,1}};
        print(0,0,rows-1,cols-1,"",maze);
    }
    private static void print(int sr,int sc,int er,int ec,String s,int maze[][]){
        if(sr<0 || sc<0 ) return;
        if(sr>er || sc>ec) return;
        if(sr==er &&sc==ec){
            System.out.println(s);
            return;
        }
        if(maze[sr][sc] == 0) return;
        if(maze[sr][sc] == -1) return;
        maze[sr][sc] = -1;
        
        //go down
        print(sr+1, sc, er, ec, s+"D",maze);
        //go right
        print(sr, sc+1, er, ec, s+"R",maze);
        //go left
        print(sr, sc-1, er, ec, s+"L", maze);
        //go up
        print(sr-1, sc, er, ec, s+"U", maze);
        
        //BackTracking
        maze[sr][sc] = 1;
    }

    // public static void main(String[] args) {
    //     int rows = 4;
    //     int cols = 5;
    //     boolean [][] isVisited = new boolean[rows][cols];
    //     int [][] maze =   {{1,1,0,1,0},
    //                        {0,1,1,1,1},
    //                        {1,1,0,0,1},
    //                        {1,1,0,0,1}};
    //     print(0,0,rows-1,cols-1,"",maze,isVisited);
    // }
    // private static void print(int sr,int sc,int er,int ec,String s,int maze[][],boolean[][] isVisited){
    //     if(sr<0 || sc<0 ) return;
    //     if(sr>er || sc>ec) return;
    //     if(sr==er &&sc==ec){
    //         System.out.println(s);
    //         return;
    //     }
    //     if(maze[sr][sc] == 0) return;
    //     if(isVisited[sr][sc] == true) return;
    //     isVisited[sr][sc] = true;
        
    //     //go down
    //     print(sr+1, sc, er, ec, s+"D",maze,isVisited);
    //     //go right
    //     print(sr, sc+1, er, ec, s+"R",maze,isVisited);
    //     //go left
    //     print(sr, sc-1, er, ec, s+"L", maze, isVisited);
    //     //go up
    //     print(sr-1, sc, er, ec, s+"U", maze, isVisited);
        
    //     //BackTracking
    //     isVisited[sr][sc] = false;
    // }
}
