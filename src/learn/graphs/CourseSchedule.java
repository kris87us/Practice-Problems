package learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CourseSchedule {
    static List<List<Integer>> adjList;
    static List<Boolean> visited;
    static List<Integer> departure;
    static int timestamp = 0;

    public static void main(String[] args) {
        System.out.println(can_be_completed(4, Arrays.asList(1, 1, 3), Arrays.asList(0, 2, 1)));
    }

    public static boolean can_be_completed(int n, List<Integer> a, List<Integer> b) {
        visited = new ArrayList<>(Collections.nCopies(n, false));
        departure = new ArrayList<>(Collections.nCopies(n, null));
        // Build Adjacency List
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < a.size(); i++) {
            int u = a.get(i);
            int v = b.get(i);
            adjList.get(v).add(u);
        }

        // Outer Loop
        for (int i = 0; i < n; i++) {
            if (visited.get(i) == false) {
                if (DFS(i) == true) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean DFS(int source) {
        visited.set(source, true);
        for (int neighbor : adjList.get(source)) {
            if (visited.get(neighbor) == false) {
                visited.set(neighbor, true);
                if (DFS(neighbor) == true) { // Found Back Edge
                    return true;
                }
            } else {
                if (departure.get(neighbor) == null) {
                    return true; // Found Back Edge
                }
            }
        }
        departure.set(source, timestamp++);
        return false; // No Cycles
    }
}
