package learn.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    static Map<Character, Set<Character>> adjList;
    static Map<Character, Boolean> visited;
    static Map<Character, Integer> arrival;
    static Map<Character, Integer> departure;
    static int timestamp = 0;
    static StringBuilder topsort;

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
    }

    public static String alienOrder(String[] words) {
        adjList = new HashMap<>();
        visited = new HashMap<>();
        arrival = new HashMap<>();
        departure = new HashMap<>();
        topsort = new StringBuilder();
        // Add each character from words to adjList to identify unique letters as keys and build the graph
        for (String w : words) {
            for (Character c : w.toCharArray()) {
                adjList.put(c, new HashSet<>());
            }
        }
        // Find relative lexicographic order of letters from adjancent words in the input list
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            // Check that next is not a prefix of curr
            // curr is smaller if and only if curr.length < next.length
            if (curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            for (int j = 0; j < Math.min(curr.length(), next.length()); j++) {
                if (curr.charAt(j) != next.charAt(j)) {
                    adjList.get(next.charAt(j)).add(curr.charAt(j));
                    break;
                } else {
                    continue;
                }
            }
        }
        // Outer Loop - DFS
        for (Character c : adjList.keySet()) {
            if (visited.get(c) == null) {
                if (DFS(c)) {
                    return "";
                }
            }
        }

        return topsort.toString();
    }

    private static boolean DFS(Character node) {
        arrival.put(node, timestamp++);
        visited.put(node, true);
        for (Character neighbor : adjList.get(node)) {
            if (visited.get(neighbor) == null) { // New node
                if(DFS(neighbor)) {
                    return true;
                }
            } else {
                if (departure.get(neighbor) == null) { // Cycle detected
                    return true;
                }
            }
        }

        topsort.append(node);
        departure.put(node, timestamp++);
        return false; // No cycle detected
    }
}
