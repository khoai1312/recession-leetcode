package main;

import java.util.*;


class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        // create a queue to store only rotten oranges
        Queue<int[]> queue = new LinkedList<>();
        /*
        add a list of rotten oranges into the queue
        and start checking their neighbors using BFS
        */
        int gridRows = grid.length;
        int gridCols = grid[0].length;
        int freshOranges = 0;
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        queue.add(null); // to count number of layers

        int minuteLapsed = -1;
        // start BFS below
        while (!queue.isEmpty()) {
            int[] currentOrange = queue.remove();
            if (currentOrange == null) {
                minuteLapsed++;
                if (queue.peek() != null) {
                    queue.add(null);
                }
            } else {
                for (List<Integer> neighbor : getNeighbors(grid, currentOrange[0], currentOrange[1])) {
                    if (grid[neighbor.get(0)][neighbor.get(1)] == 1) { // if the orange is still fresh, make it rot
                        grid[neighbor.get(0)][neighbor.get(1)] = 2;
                        freshOranges--;
                        queue.add(new int[]{neighbor.get(0), neighbor.get(1)});
                    }
                }

            }
        }
        if (freshOranges == 0) {
            return minuteLapsed;
        }
        return -1;
    }

    public List<List<Integer>> getNeighbors (int[][] grid, int row, int col) {
        int[][] coordinates = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<List<Integer>> neighbors = new ArrayList<>();

        for (int[] coordinate : coordinates) {
            int newRow = row + coordinate[0];
            int newCol = col + coordinate[1];

            if (newRow < 0 || newCol < 0 ||
                    newRow >= grid.length || newCol >= grid[0].length) {
                continue;
            }

            neighbors.add(List.of(newRow, newCol));
        }
        return neighbors;
    }
}
