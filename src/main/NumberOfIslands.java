package main;

import java.util.*;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int num_of_islands = 0;

        // linearly scan the 2D grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                /*
                if a cell == 1 :
                num_of_islands++
                start a BFS from here
                set visited cell to 0 to not visit it again
                (because we only check cell == 1)
                */
                if (grid[i][j] == '1') {
                    num_of_islands++;
                    grid[i][j] = '0';

                    // initialize a queue to store (row, col) of cells to check
                    Queue<List<Integer>> neighbors = new LinkedList<>();
                    neighbors.add(Arrays.asList(i, j));

                    // start BFS
                    while (!neighbors.isEmpty()) {
                        List<Integer> currentCell = neighbors.remove();
                        int currentRow = currentCell.get(0);
                        int currentCol = currentCell.get(1);

                        for (List<Integer> neighbor : getPotentialNeighbors(currentRow, currentCol, grid)) {
                            int neighborRow = neighbor.get(0);
                            int neighborCol = neighbor.get(1);

                            if (grid[neighborRow][neighborCol] == '1') {
                                neighbors.add(Arrays.asList(neighborRow, neighborCol));
                                grid[neighborRow][neighborCol] = '0';

                            }
                        }
                    }
                }
            }
        }
        return num_of_islands;
    }

    public List<List<Integer>> getPotentialNeighbors (int row, int column, char[][] grid) {
        int[][] coordinates = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        List<List<Integer>> neighbors = new ArrayList<>();

        for (int i = 0; i < coordinates.length; i++) {
            int newRowCoord = row + coordinates[i][0];
            int newColCoord = column + coordinates[i][1];

            if (newRowCoord < 0 || newColCoord < 0 ||
                    newRowCoord >= grid.length || newColCoord >= grid[0].length) {
                continue;
            }

            neighbors.add(Arrays.asList(newRowCoord, newColCoord));
        }
        return neighbors;
    }
}
