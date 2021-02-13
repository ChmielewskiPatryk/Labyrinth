public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1}};
        int[][] matrix2 = {{1, 1, 0, 1, 1, 1, 1, 1},
                           {1, 1, 0, 0, 1, 1, 1, 1},
                           {1, 1, 1, 0, 0, 1, 1, 1},
                           {1, 1, 1, 1, 0, 1, 1, 1},
                           {1, 1, 0, 0, 0, 1, 1, 1},
                           {1, 1, 0, 1, 0, 1, 1, 1},
                           {1, 1, 0, 1, 0, 0, 0, 1},
                           {1, 1, 0, 1, 1, 1, 1, 1}};
        Labyrinth labyrinth = new Labyrinth(new int[]{0, 2}, new int[]{6, 2}, matrix);
        Labyrinth2 labyrinth2 = new Labyrinth2(new int[]{0, 2}, new int[]{6, 2}, matrix);

        Labyrinth2 labyrinth3 = new Labyrinth2(new int[]{1, 2}, new int[]{7, 2}, matrix2);
        System.out.println("Labyrinth: " + labyrinth.howFar());
        System.out.println("Labyrinth: " + labyrinth2.solveLabyrinth());
        System.out.println("Labyrinth: " + labyrinth3.solveLabyrinth());
    }
}
