package learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightsTourOnAChessBoard {
    public static void main(String[] args) {
        System.out.println(find_minimum_number_of_moves(5, 5, 0, 0, 4, 1));
    }
    
    static int[][] distance;
    static boolean possible = false;

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        distance = new int[rows][cols];
        
        // Build the Adjacency List
        int[][] graph = new int[rows][cols];

        // BFS
        BFS(start_row, start_col, graph, end_row, end_col);

        if (!possible) {
            return -1;
        }
        return distance[end_row][end_col];
    }

    private static void BFS(int s, int d, int[][] graph, int end_row, int end_col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { s, d});
        graph[s][d] = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (node[0] == end_row && node[1] == end_col) {
                // If the target vertices are reached, current node will be equal to end row/col
                distance[end_row][end_col] = distance[node[0]][node[1]];
                possible = true;
                break;
            }
            for (List<Integer> neighbor : getNeighbors(node[0], node[1], graph)) {
                if (graph[neighbor.get(0)][neighbor.get(1)] == 0) {
                    graph[neighbor.get(0)][neighbor.get(1)] = 1;
                    // Increment distance
                    distance[neighbor.get(0)][neighbor.get(1)] = 1 + distance[node[0]][node[1]];
                    q.offer(new int[] { neighbor.get(0), neighbor.get(1)});
                }
            }
        }
    }

    private static List<List<Integer>> getNeighbors(int r, int c, int[][] graph) {
        List<List<Integer>> neighbors = new ArrayList<>();
        if (r - 2 >= 0 && c - 1 >= 0) {
            neighbors.add(new ArrayList<>(Arrays.asList(r - 2, c - 1)));
        }
        if (r - 2 >= 0 && c + 1 < graph[0].length) {
            neighbors.add(new ArrayList<>(Arrays.asList(r - 2, c + 1)));
        }
        if (r - 1 >= 0 && c + 2 < graph[0].length) {
            neighbors.add(new ArrayList<>(Arrays.asList(r - 1, c + 2)));
        }
        if (r + 1 < graph.length && c + 2 < graph[0].length) {
            neighbors.add(new ArrayList<>(Arrays.asList(r + 1, c + 2)));
        }
        if (r + 2 < graph.length && c + 1 < graph[0].length) {
            neighbors.add(new ArrayList<>(Arrays.asList(r + 2, c + 1)));
        }
        if (r + 2 < graph.length && c - 1 >= 0) {
            neighbors.add(new ArrayList<>(Arrays.asList(r + 2, c - 1)));
        }
        if (r + 1 < graph.length && c - 2 >= 0) {
            neighbors.add(new ArrayList<>(Arrays.asList(r + 1, c - 2)));
        }
        if (r - 1 >= 0 && c - 2 >= 0) {
            neighbors.add(new ArrayList<>(Arrays.asList(r - 1, c - 2)));
        }
        return neighbors;
    }
}
