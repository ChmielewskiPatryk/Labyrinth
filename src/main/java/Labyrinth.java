import java.util.*;

public class Labyrinth {

    private final int[] gin;
    private final int[] gout;
    private final int[][] matrix;
    private int[] actualPosition;
    private int [] lastOperation;
    private int counter;

    

    public Labyrinth(int [] gin, int[] gout,int[][] matrix) {
        this.gin = gin;
        this.gout = gout;
        this.actualPosition = gin;
        this.lastOperation = new int[]{0,0};
        this.counter = 0;
        this.matrix = matrix;
    }

    private final int[] up = {-1, 0};
    private final int[] down = {1, 0};
    private final int[] left = {0, -1};
    private final int[] right = {0, 1};

 private int maxMovements(){
     int maxMoves=0;
     for (int i = 0; i < matrix.length-1 ; i++) {
         for (int j = 0; j <matrix.length-1 ; j++) {
             if(matrix[i][j]== 0){
                 maxMoves++;
             }
         }
     }
     return maxMoves*2;
 }

    private boolean checkPosition() {
        return Arrays.equals(actualPosition, gout);
    }


    private void operation(int[] operation) {
        actualPosition[0] = actualPosition[0] + operation[0];
        actualPosition[1] = actualPosition[1] + operation[1];
        lastOperation = operation;
     counter ++;
    }

    private boolean possibleOperation(int[] operation) {
        int x = actualPosition[0] + operation[0];
        int y = actualPosition[1] + operation[1];
        if (matrix[x][y] == 1) {
            return false;
        }
        return true;
    }
    private boolean lastOperation(int [] operation){
        if (Arrays.equals(lastOperation, operation)) {
            return true;
        }else {
            return false;
        }
    }

    private boolean move() {
     if(maxMovements() <counter){
         return false;
        }
        if (possibleOperation(down) && !lastOperation(up) ) {
            operation(down);
            return true;
        }else if(possibleOperation(right) && !lastOperation(left) ){
            operation(right);
            return true;
        }else if(possibleOperation(left) && !lastOperation(right)){

            operation(left);
            return true;
        } else if(possibleOperation(up)){
            operation(up);
            return true;
        }
        return  false;
    }


    public int howFar() {

        while (!checkPosition()){
            if(maxMovements()< counter){
                counter =-1;
                break;
            }
                move();
        }

        return counter;
    }
}
