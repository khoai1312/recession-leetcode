package main;

import java.util.*;

public class IfPathExistsInGraph {

    public static void main (String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(3, edges, 0, 2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        // initialize a stack to store the nodes to be visited
        Stack<Integer> stackOfNodes = new Stack<>();

        // initialize a Map to store all edges in the graph
        Map<Integer, List<Integer>> mapOfEdges = new HashMap<>();
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            /* instead of manually checking if the map contains key and putting a new value in,
            use approach below so it's more efficient.
            */
            List<Integer> currentMap1 = mapOfEdges.computeIfAbsent(node1, val -> new ArrayList<>());
            currentMap1.add(node2);
            List<Integer> currentMap2 = mapOfEdges.computeIfAbsent(node2, val -> new ArrayList<>());
            currentMap2.add(node1);
        }

        System.out.println("updated map : " + mapOfEdges);

        // initialize an Array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        stackOfNodes.push(source);
        visited[source] = true;

        while (!stackOfNodes.isEmpty()) {
            int currentNode = stackOfNodes.pop();
            if (currentNode == destination) {
                return true;
            }
            for (int nextNode : mapOfEdges.get(currentNode)) {
                if (!visited[nextNode]) {
                    stackOfNodes.push(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
        return false;
    }
}
