package BACKTRACKING;

public class TwoDMazePath {
    private static int maze(int sr, int sc, int er, int ec){
        if(sr>er || sc>ec) return 0;
        if(sr==er && sc==ec) return 1;
        int rightWays = maze(sr,sc+1,er,ec);
        int downWays = maze(sr+1,sc,er,ec);
        int totalWays = rightWays+downWays;
        return totalWays;
    }
    private static void print(int sr,int sc,int er,int ec,String s){
        if(sr>er || sc>ec) return;
        if(sr==er &&sc==ec){
            System.out.println(s);
            return;
        }
        //go down
        print(sr+1, sc, er, ec, s+"D");
        //go right
        print(sr, sc+1, er, ec, s+"R");
    }
    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;
        int count = maze(1,1,rows,cols);
        System.out.println("Number of ways : "+count);

        print(1,1,rows,cols,"");
    }

}
