package main;

import java.util.*;


public class AllPathsFromSourceToTarget {

    private int target;
    private int[][] graph;
    private List<List<Integer>> possiblePaths;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length - 1;
        this.graph = graph;
        this.possiblePaths = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(0);

        this.backtrack(0, path);
        return this.possiblePaths;

    }

    public void backtrack (int currentNode, List<Integer> path) {
        if (currentNode == this.target) {
            this.possiblePaths.add(new ArrayList<>(path));
            return;
        }

        // check adjacent nodes of this current node until destination found
        int[] adjacentNodes = graph[currentNode];
        for(int nextAdjacentNode : adjacentNodes) {
            // add the adjacent node to the current path
            path.add(nextAdjacentNode);
            this.backtrack(nextAdjacentNode, path);
            path.remove(path.size() - 1);
        }
    }
}
