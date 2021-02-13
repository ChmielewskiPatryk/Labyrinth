import java.util.*;

public class Labyrinth2 {
    private final int[] UP = {-1, 0};
    private final int[] DOWN = {1, 0};
    private final int[] LEFT = {0, -1};
    private final int[] RIGHT = {0, 1};

    private final int[] gin;
    private final int[] gout;
    private int[] actualPosition;
    private int counter;
    int[][] labyrinth;
    private List<int[]> operations;


    public Labyrinth2(int[] gin, int[] gout, int[][] labyrinth) {
        this.labyrinth = labyrinth;
        this.gin = gin;
        this.gout = gout;
        this.actualPosition = gin;
        this.counter = 1;

        operations = new ArrayList<>();
        operations.add(UP);
        operations.add(DOWN);
        operations.add(LEFT);
        operations.add(RIGHT);
    }

    public int solveLabyrinth() {
        LinkedList<LinkedList<MapPosition>> list = new LinkedList<>();
        list.add(returnPossiblePointsToMove(actualPosition));
        while (!list.isEmpty()) {
            LinkedList<MapPosition> tempList = new LinkedList<>();
            for (int i = 0; i < list.getFirst().size(); i++) {
                if (checkPosition(list.getFirst())) {
                    return counter;
                }
                tempList.addAll(returnPossiblePointsToMove(new int[]{list.getFirst().get(i).getX(), list.getFirst().get(i).getY()}));
            }
            markPosition(list.remove());
            counter++;
            if (tempList.size() != 0) {
                list.add(tempList);
            } else {
                break;
            }

        }
        return -1;
    }

    private void markPosition(LinkedList<MapPosition> listToMark) {
        for (int i = 0; i < listToMark.size(); i++) {
            int x = listToMark.get(i).getX();
            int y = listToMark.get(i).getY();
            labyrinth[x][y] = counter;
        }
    }

    private LinkedList<MapPosition> returnPossiblePointsToMove(int[] actualPosition) {
        LinkedList<MapPosition> mapPositions = new LinkedList<>();
        for (int i = 0; i < operations.size(); i++) {
            if (possibleOperation(operations.get(i), actualPosition)) {
                int x = actualPosition[0] + operations.get(i)[0];
                int y = actualPosition[1] + operations.get(i)[1];
                mapPositions.add(new MapPosition(x, y));
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


    private boolean checkPosition(LinkedList<MapPosition> list) {
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).getX();
            int y = list.get(i).getY();
            int[] actualPosition = new int[]{x, y};
            if (Arrays.equals(actualPosition, gout)) {
                return true;
            }
        }
        return false;
    }


}
