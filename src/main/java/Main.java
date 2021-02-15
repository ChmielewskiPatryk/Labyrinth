public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 0, 1, 1, 1, 1, 1},
                           {1, 1, 0, 0, 1, 1, 1, 1},
                           {1, 1, 1, 0, 0, 1, 1, 1},
                           {1, 1, 1, 1, 0, 1, 1, 1},
                           {1, 1, 0, 0, 0, 1, 1, 1},
                           {1, 1, 0, 1, 0, 1, 1, 1},
                           {1, 1, 0, 1, 0, 0, 0, 1},
                           {1, 1, 0, 1, 1, 1, 1, 1}};
        Labyrinth labyrinth = new Labyrinth(new int[]{1, 2}, new int[]{7, 2}, matrix);
        System.out.println("Labyrinth: " + labyrinth.solveLabyrinth());
    }
}
