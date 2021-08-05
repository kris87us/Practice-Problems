package learn.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphBipartite {
    static List<List<Integer>> adjList;
    static List<Boolean> visited;
    static List<Integer> parent;
    static List<Integer> distance;

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } }));
        System.out.println(isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } }));
    }

    public static boolean isBipartite(int[][] graph) {
        visited = new ArrayList<>(Collections.nCopies(graph.length, false));
        distance = new ArrayList<>(Collections.nCopies(graph.length, -1));
        parent = new ArrayList<>(Collections.nCopies(graph.length, null));
        adjList = new ArrayList<List<Integer>>();

        // Build adjacency list
        for (int i = 0; i < graph.length; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }

        // Outer Loop
        for (int v = 0; v < graph.length; v++) {
            if (visited.get(v) == false) {
                if (BFS_Iterative(v) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean BFS_Iterative(int source) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited.set(source, true);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adjList.get(node)) {
                if (visited.get(neighbor) == false) {
                    visited.set(neighbor, true);
                    parent.set(neighbor, node);
                    distance.set(neighbor, 1 + distance.get(node));
                    q.offer(neighbor);
                } else {
                    if (neighbor != parent.get(node)) {
                        // If cross-edge goes to same level, then it will have ODD number of cycles, NOT
                        // Bipartite
                        if (distance.get(node) == distance.get(neighbor)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
