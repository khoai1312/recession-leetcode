package main;

import java.util.*;


public class ShortestPathInBinaryMatrix {


    private static final int[][] coordinates = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        // check if start node and end node are clear, if not return -1 (invalid)
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        /*
        set up BFS by initializing a queue of coordinates and add the first node to the queue
        and set the content to 1 to mark that it's already visited
        */
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;

        // execute BFS. For every neighbour of the current node, + 1 in the distance
        while (!queue.isEmpty()) {
            int[] currentNode = queue.remove();
            int x = currentNode[0];
            int y = currentNode[1];

            /*
            distance can start with 1. Even if there's only 1 cell, distance = 1
            because distance = number of visited cells
            */
            int distance = grid[x][y];

            // check if this node is the end node
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return distance;
            }

            // if it's not the end node, search for its clear neighbours and put in the queue
            List<int[]> neighbours = getNeighbours(x, y, grid);
            for (int[] neighbour : neighbours) {
                queue.add(neighbour);
                int neighbourX = neighbour[0];
                int neighbourY = neighbour[1];
                grid[neighbourX][neighbourY] = distance + 1;
            }
        }

        return -1;
    }

    // this function returns all the neighbouring coordinates of a given node
    // if the neighbour is not clear (aka its content != 0), then skip it
    private List<int[]> getNeighbours(int row, int col, int[][] grid) {

        List<int[]> neighbours = new ArrayList<>();

        for (int i = 0; i < coordinates.length; i++) {
            int newRowCoord = row + coordinates[i][0];
            int newColCoord = col + coordinates[i][1];

            if (newRowCoord < 0 || newColCoord < 0 ||
                    newRowCoord >= grid.length || newColCoord >= grid[0].length ||
                    grid[newRowCoord][newColCoord] != 0) {
                continue;
            }

            neighbours.add(new int[]{newRowCoord, newColCoord});
        }

        return neighbours;
    }
}

