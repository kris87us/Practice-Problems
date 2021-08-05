package models;

import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer>[] adjList;

    public Graph(int size) {
        V = size;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // Only needed for undirected Graph
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }
}
