package learn.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time : O(m + n)
// Space: O(n)
public class GraphValidTree {
    static List<List<Integer>> adjList;
    static List<Boolean> visited;
    static List<Integer> parent;

    public static void main(String[] args) {
        System.out.println(validTree(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } }));
    }

    public static boolean validTree(int n, int[][] edges) {
        // Build adjacency list from the edges
        adjList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        visited = new ArrayList<>(Collections.nCopies(n, false));
        parent = new ArrayList<>(Collections.nCopies(visited.size(), -1));
        // Outer Loop
        int components = 0;
        for (int v = 0; v < n; v++) {
            if (visited.get(v) == false) {
                components += 1;
                if (components > 1) {
                    return false; // More than 1 connected components is not a valid tree
                }
                if (BFS(v)) { // Found a cycle, NOT a Tree
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean BFS(int source) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        // Set source as visited
        visited.set(source, true);
        while (!q.isEmpty()) {
            int node = q.poll(); // Pop the node

            for (int neighbor : adjList.get(node)) {
                if (visited.get(neighbor) == false) { // Not visited before
                    visited.set(neighbor, true);
                    parent.set(neighbor, node);
                    q.offer(neighbor);
                } else { // Visited before
                    if (neighbor != parent.get(node)) { // Check if cross-edge is not to parent
                        return true; // Cross-edge indicates a cycle, NOT a tree
                    }
                }
            }
        }
        return false; // No Cycles, Valid TREE
    }

    @SuppressWarnings("unused")
    private static boolean DFS(int source) {
        visited.set(source, true);
        for (int neighbor : adjList.get(source)) {
            if (visited.get(neighbor) == false) {
                parent.set(neighbor, source);
                if (DFS(neighbor) == true) { // Found cycle, NOT a Tree
                    return true;
                }
            } else {
                if (neighbor != parent.get(source)) {
                    return true; // Found cycle, NOT A TREE
                }
            }
        }
        return false; // No Cycles, VALID TREE
    }
}
