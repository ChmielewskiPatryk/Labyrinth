import java.util.*;

public class Labyrinth {
    private final int[] UP = {-1, 0};
    private final int[] DOWN = {1, 0};
    private final int[] LEFT = {0, -1};
    private final int[] RIGHT = {0, 1};

    private final int[] gin;
    private final int[] gout;
    private int counter;
    int[][] labyrinth;
    private List<int[]> operations;


    public Labyrinth(int[] gin, int[] gout, int[][] labyrinth) {
        this.labyrinth = labyrinth;
        this.gin = gin;
        this.gout = gout;
        this.counter = 1;

        operations = new ArrayList<>();
        operations.add(UP);
        operations.add(DOWN);
        operations.add(LEFT);
        operations.add(RIGHT);
    }

    public int solveLabyrinth() {
        LinkedList<LinkedList<int[]>> list = new LinkedList<>();
        if(!checkStartAndEndPoint(gin,gout,labyrinth)){
            return -1;
        }
        list.add(returnPossiblePointsToMove(gin));
        while (!list.isEmpty()) {
            LinkedList<int[]> tempList = new LinkedList<>();
            for (int i = 0; i < list.getFirst().size(); i++) {
                if (checkPosition(list.getFirst())) {
                    return counter;
                }
                tempList.addAll(returnPossiblePointsToMove(list.getFirst().get(i)));
            }
            list.remove();
            counter++;
            if (tempList.size() != 0) {
                list.add(tempList);
            } else {
                break;
            }

        }
        return -1;
    }

    private LinkedList<int[]> returnPossiblePointsToMove(int[] actualPosition) {
        LinkedList<int[]> mapPositions = new LinkedList<>();
        for (int i = 0; i < operations.size(); i++) {
            if (possibleOperation(operations.get(i), actualPosition)) {
                int x = actualPosition[0] + operations.get(i)[0];
                int y = actualPosition[1] + operations.get(i)[1];
                mapPositions.add(new int[]{x,y});
            }
        }
        return mapPositions;
    }


    private boolean possibleOperation(int[] operation, int[] actualPosition) {
        int x = actualPosition[0] + operation[0];
        int y = actualPosition[1] + operation[1];
        boolean possible = true;
        try {
            if (labyrinth[x][y] >= 1) {
                possible = false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            possible = false;

        }
        return possible;
    }


    private boolean checkPosition(LinkedList<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int[] actualPosition = new int[]{x, y};
            if (Arrays.equals(actualPosition, gout)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkStartAndEndPoint(int[] gin, int[] gout, int[][] matrix) {
        if (gin[0] > matrix.length || gin[1] > matrix.length || gout[0] > matrix.length || gout[1] > matrix.length
                || gin[0] < 0 || gin[1] < 0 || gout[0] < 0 || gout[1] < 0) {
            return false;
        }return true;
    }


}
