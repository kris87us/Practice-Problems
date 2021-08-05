package learn.graphs.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import models.Graph;

public class DFS {
    static List<Boolean> visited;
    static Graph graph;

    public static void main(String[] args) {
        graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);

        visited = new ArrayList<>(Collections.nCopies(5, false));

        DFS_Iterative(0);
        DFS_Recursive(0);
    }

    private static void DFS_Iterative(int source) {
        Stack<Integer> q = new Stack<Integer>();
        q.push(source);
        visited.set(source, true);

        while (!q.isEmpty()) {
            int node = q.pop();
            
            for (int neighbor : graph.getAdjList()[node]) {
                if (visited.get(neighbor) == false) {
                    visited.set(neighbor, true);
                    q.push(neighbor);
                }
            }
        }
    }

    private static void DFS_Recursive(int source) {
        visited.set(source, true);

        for (int neighbor : graph.getAdjList()[source]) {
            if (visited.get(neighbor) == false) {
                DFS_Recursive(neighbor);
            }
        }
    }
}
