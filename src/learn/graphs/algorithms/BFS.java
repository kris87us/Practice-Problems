package learn.graphs.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import models.Graph;

public class BFS {
    static List<Boolean> visited;
    static List<Integer> result;
    static Graph graph;
    public static void main(String[] args) {
        graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);

        visited = new ArrayList<>(Collections.nCopies(5, false));
        result = new ArrayList<>();

        BFS(0);
        System.out.print("The BFS traversal for the Graph is: "+ result);
    }

    private static void BFS(int source) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited.set(source, true);

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int neighbor : graph.getAdjList()[node]) {
                if (visited.get(neighbor) == false) {
                    visited.set(neighbor, true);
                    q.offer(neighbor);
                }
            }
        }
    }
}
