package learn.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time : O(n^2)
// Space : O(n^2)
public class ZombieCluster {
    static List<Boolean> visited;
    public static int zombieCluster(List<String> zombies) {
        // Write your code here
        visited = new ArrayList<Boolean>(Collections.nCopies(zombies.size(), false));
        
        // Outer loop
        int zombieCount = 0;
        for (int i = 0; i< zombies.size(); i++) {
            if (visited.get(i) == false) {
                zombieCount++;
                BFS(i, zombies);
            }
        
        }
        return zombieCount;
    }
    
    // BFS
    private static void BFS(int s, List<String> zombies) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited.set(s, true);

        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int i = 0; i < zombies.size(); i++) {
                if (zombies.get(node).charAt(i) == '1' && visited.get(i) == false) {
                    visited.set(i, true);
                    q.offer(i);
                }
            }
        }
    }
}
