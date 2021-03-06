import org.junit.Test;

import static org.junit.Assert.*;

public class LabyrinthTest {

    @Test
    public void solveLabyrinth() {
            int gin[] = new int[]{0, 2};
            int gout[] = new int[]{6, 2};
            int[][] matrix2 = {{1, 1, 0, 1, 1, 1, 1, 1},
                    {1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 1, 1, 0, 0, 1, 1, 1},
                    {1, 1, 1, 1, 0, 1, 1, 1},
                    {1, 1, 0, 0, 0, 1, 1, 1},
                    {1, 1, 0, 1, 0, 1, 1, 1},
                    {1, 1, 0, 1, 0, 0, 0, 1},
                    {1, 1, 0, 1, 1, 1, 1, 1}};

            assertEquals(10, new Labyrinth(gin, gout, matrix2).solveLabyrinth());
            assertEquals(-1, new Labyrinth(new int []{0,0}, gout, matrix2).solveLabyrinth());
            assertEquals(-1, new Labyrinth(new int []{-1,0}, gout, matrix2).solveLabyrinth());
    }
}