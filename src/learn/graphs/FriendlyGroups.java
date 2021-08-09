package learn.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendlyGroups {
    static List<List<Integer>> adjList;
    static List<Boolean> visited;
    static List<Integer> parent;
    static List<Integer> distance;
    
    public static boolean can_be_divided(int num_of_people, List<Integer> dislike1, List<Integer> dislike2){
        visited = new ArrayList<>(Collections.nCopies(num_of_people, false));
        distance = new ArrayList<>(Collections.nCopies(num_of_people, -1));
        parent = new ArrayList<>(Collections.nCopies(num_of_people, null));
        adjList = new ArrayList<List<Integer>>();

        // Build adjacency list
        for (int i = 0; i < num_of_people; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < dislike1.size(); i++) {
            int u = dislike1.get(i);
            int v = dislike2.get(i);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Outer Loop
        for (int v = 0; v < num_of_people; v++) {
            if (visited.get(v) == false) {
                if (BFS(v) == false) {
                    return false;
                }
            }
        }
        return true; 
    }
    
    private static boolean BFS(int source) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(source);
        visited.set(source, true);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int neighbor : adjList.get(node)) {
                // Not visited already
                if (visited.get(neighbor) == false) {
                    visited.set(neighbor, true);
                    parent.set(neighbor, node);
                    distance.set(neighbor, 1 + distance.get(node));
                    q.offer(neighbor);
                } else { // Visited already
                    // Make sure node already visited is not going back to parent
                    if (neighbor != parent.get(node)) {
                        if (distance.get(neighbor) == distance.get(node)) {
                            return false; // Cross edge at same level, ODD number of cycles, NOT Bipartite
                        }
                    }
                }
            }
        }
        return true;
    }
}
