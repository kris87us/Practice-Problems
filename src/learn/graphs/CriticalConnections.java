package learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {
    static int timestamp = 0;
    static List<List<Integer>> result = new ArrayList<List<Integer>>();

    public static List<List<Integer>> find_critical_connections(int number_of_servers,
            List<List<Integer>> connections) {
        // Build the Adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < number_of_servers; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // build a graph
        for (List<Integer> edge : connections) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }
        int latestarrival = Integer.MIN_VALUE;

        int[] visited = new int[number_of_servers];
        int[] arrival = new int[number_of_servers];
        int[] parent = new int[number_of_servers];
        Arrays.fill(visited, -1);
        Arrays.fill(arrival, -1);
        Arrays.fill(parent, -1);

        // DFS
        DFS(0, adjList, visited, arrival, latestarrival, parent);

        if (result.isEmpty()) {
            List<Integer> conn = new ArrayList<>();
            conn.add(-1);
            conn.add(-1);

            result.add(conn);
        }
        return result;
    }

    private static int DFS(int node, List<List<Integer>> adjList, int[] visited, int[] arrival, int latestarrival,
            int[] parent) {
        arrival[node] = timestamp++;
        visited[node] = 1;
        latestarrival = arrival[node]; // Initialize with arrival, update later if lower found

        for (int neighbor : adjList.get(node)) {
            // New node
            if (visited[neighbor] == -1) {
                parent[neighbor] = node;
                // Calculate highest reach, so MIN of arrival times
                latestarrival = Math.min(DFS(neighbor, adjList, visited, arrival, latestarrival, parent),
                        latestarrival); // Returns arrival time from subordinates

            } else if (parent[node] != neighbor) { // Already visited, Not its own parent
                latestarrival = Math.min(latestarrival, arrival[neighbor]); // It's a Back edge, calculate MIN
                                                                                        // of arrival times.
            }
        }
        // Solve local problem, determine if the edge is BRIDGE or not
        // IF the arrival time is SAME AND node is not ROOT (0), it means the edge between the node and the
        // parent is the BRIDGE
        if (arrival[node] == latestarrival && node != 0) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(node);
            ans.add(parent[node]);
            result.add(ans);
        }
        
        return latestarrival; // Return to parent
    }
}
