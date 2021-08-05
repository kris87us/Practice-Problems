package learn.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindNumberOfConnectedComponents {
    static List<List<Integer>> adjList;
    static List<Boolean> visited;

    public static void main(String[] args) {
        System.out.println(countComponents(5, new int[][] { { 0, 1 }, { 1, 2 }, {2, 3}, { 3, 4 } }));
    }

    public static int countComponents(int n, int[][] edges) {
        visited = new ArrayList<>(Collections.nCopies(n, false));
        adjList = new ArrayList<List<Integer>>();
        // Build adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Outer Loop
        int components = 0;
        for (int v = 0; v < n; v++) {
            if (visited.get(v) == false) {
                components += 1;
                DFS_Recursive(v);
            }
        }
        return components;
    }

    private static void DFS_Recursive(int vertex) {
        visited.set(vertex, true);
        for (int neighbor : adjList.get(vertex)) {
            if (visited.get(neighbor) == false) {
                DFS_Recursive(neighbor);
            }
        }
    }
}
