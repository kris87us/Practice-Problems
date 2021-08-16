package learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CourseScheduleII {
    static boolean[] visited;
    static List<Integer> departure;
    static List<Integer> topsort;
    static int timestamp = 0;
    static List<List<Integer>> adjList;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        departure = new ArrayList<>(Collections.nCopies(numCourses, null));
        adjList = new ArrayList<>();
        topsort = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(i, new ArrayList<>());
        }
        // Build adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adjList.get(v).add(u);
        }

        // Outer Loop
        // Run DFS on entire graph to make sure there are no back edges/cycles
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false) {
                if (DFS(i)) {
                    return new int[] {};
                }
            }
        }
        Collections.reverse(topsort);
        return topsort.stream().mapToInt(i -> i).toArray();
    }

    private static boolean DFS(int source) {
        visited[source] = true;
        for (int neighbor : adjList.get(source)) {
            if (visited[neighbor] == false) { // Newly visiting this node
                visited[neighbor] = true;
                if (DFS(neighbor)) {
                    return true;
                }
            } else { // Already visited
                if (departure.get(neighbor) == null) { // Back edge | If there is a cycle all course pre-requisites can never
                                                // be satisfied
                    return true;
                }
            }
        }
        topsort.add(source);
        departure.set(source, timestamp++);
        return false; // No cycles
    }
}
