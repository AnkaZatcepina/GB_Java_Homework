package lesson5;
/*
    На шахматной доске расставить 8 ферзей так, 
    чтобы они не били друг друга. 
*/
public class EightQueensOnChessBoard {
    public static final int SIZE = 8;
    public static int countQueens = 0;
    public static boolean[][] queens = new boolean[SIZE][SIZE];
    public static void main( String[] args )
    {
        countQueens = 0;
        boolean success = false;  
        System.out.println(queens);
        while (!success){
            success = fillQueen();
        }
        printBoard();
    }

    public static boolean fillQueen(){
        boolean success = false;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (isAllowed(i,j)) {
                    queens[i][j] = true;
                    countQueens++;
                    success = fillQueen();
                    if (!success)
                    {
                        queens[i][j] = false;
                        countQueens--;
                    }
                    
                }
            }
        }
        if (countQueens == 8)
            success = true;
        return success;
    }

    public static boolean isAllowed(int x, int y){
        if (queens[x][y] == true)
            return false; 
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (queens[x][j] == true)
                    return false; 
                if (queens[i][y] == true)
                    return false;  
                if (queens[i][j] == true)
                {   
                    int xDiff = Math.abs(x - i);
                    int yDiff = Math.abs(y - j);
                    if (xDiff == yDiff)
                        return false;  
                }  
            }
        }
        return true;
    }

    public static void printBoard(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (j==0)
                System.out.println();
                System.out.print(queens[i][j] ? "*" : "-");
            }
        }
        System.out.println();
    }

}
