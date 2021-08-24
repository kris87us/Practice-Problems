package learn.graphs;

import java.util.HashMap;
import java.util.Map;

import models.StronglyConnectedGraph;

public class ReverseAGraph {

    static Map<Integer, StronglyConnectedGraph> map;
    public static void main(String[] args) {
        map = new HashMap<>();

        StronglyConnectedGraph node1 = new StronglyConnectedGraph(1);
        StronglyConnectedGraph node2 = new StronglyConnectedGraph(2);
        StronglyConnectedGraph node3 = new StronglyConnectedGraph(3);
        node1.neighbours.add(node2);
        node2.neighbours.add(node3);
        node3.neighbours.add(node1);

        build_other_graph(node1);
    }

    static StronglyConnectedGraph build_other_graph(StronglyConnectedGraph node) {
        dfs(node);
        return map.get(1);
    }

    private static void dfs(StronglyConnectedGraph node) {
        // Create the node
        map.put(node.val, new StronglyConnectedGraph(node.val));
        for (StronglyConnectedGraph neighbor : node.neighbours) {
            if (!map.containsKey(neighbor.val)) {
                dfs(neighbor);
            }
            // Reverse it
            // Get the neighbor's value and add the node
            map.get(neighbor.val).neighbours.add(map.get(node.val));
        }
    }
}
