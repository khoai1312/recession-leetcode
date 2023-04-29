package main;

import java.util.*;


public class PacificAtlanticWaterFlow {
    private int numRows;
    private int numCols;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> output = new ArrayList<>();

        if (heights == null || heights.length == 0) {
            return output;
        }

        numRows = heights.length;
        numCols = heights[0].length;
        this.heights = heights;

        Queue<int[]> adjacentToPacific = new LinkedList<>();
        Queue<int[]> adjacentToAtlantic = new LinkedList<>();

        for (int i = 0; i < heights.length; i++) {
            adjacentToPacific.add(new int[] {i, 0});
            adjacentToAtlantic.add(new int[] {i, numCols - 1});
        }

        for (int i = 0; i < heights[0].length; i++) {
            adjacentToPacific.add(new int[] {0, i});
            adjacentToAtlantic.add(new int[] {numRows - 1, i});
        }

        // find all cells accessible to each ocean
        boolean[][] pacificAccess = bfs(adjacentToPacific);
        boolean[][] atlanticAccess = bfs(adjacentToAtlantic);

        // find the common cells between these 2 boolean[][]
        // those are accessible to both oceans
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificAccess[i][j] && atlanticAccess[i][j]) {
                    output.add(List.of(i, j));
                }
            }
        }
        return output;
    }

    public List<List<Integer>> getNeighbors (int row, int column, boolean[][] grid) {
        int[][] coordinates = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<List<Integer>> neighbors = new ArrayList<>();

        for (int[] coordinate : coordinates) {
            int newRow = row + coordinate[0];
            int newCol = column + coordinate[1];

            if (newRow < 0 || newCol < 0 ||
                    newRow >= grid.length || newCol >= grid[0].length) {
                continue;
            }
            neighbors.add(Arrays.asList(newRow, newCol));
        }
        return neighbors;
    }

    public boolean[][] bfs (Queue<int[]> queue) {
        boolean[][] reachableCells = new boolean[numRows][numCols];

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int currentRow = cell[0];
            int currentCol = cell[1];
            // once the cell in reachableCells is already in the queue, it's reachable
            reachableCells[currentRow][currentCol] = true;

            for (List<Integer> neighbor : getNeighbors(currentRow, currentCol, reachableCells)) {
                int neighborRow = neighbor.get(0);
                int neighborCol = neighbor.get(1);

                // check if this cell has been visited
                if (reachableCells[neighborRow][neighborCol]) {
                    continue;
                }
                // check if the height of this cell is higher than the current one
                if (heights[neighborRow][neighborCol] < heights[currentRow][currentCol]) {
                    continue;
                }
                queue.add(new int[] {neighborRow, neighborCol});
            }
        }
        return reachableCells;
    }
}
