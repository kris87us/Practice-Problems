package learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForLargestIsland {
    static List<List<Integer>> grid;
    static int count = 0;
    static int max = 0;

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        grid = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            grid.add(new ArrayList<>());
        }
        grid.get(0).addAll(new ArrayList<>(Arrays.asList(1, 1, 0)));
        grid.get(1).addAll(new ArrayList<>(Arrays.asList(1, 1, 0)));
        grid.get(2).addAll(new ArrayList<>(Arrays.asList(0, 0, 1)));

        System.out.println(max_island_size(grid));
    }

    public static int max_island_size(List<List<Integer>> grid) {
        // * Outer Loop
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (grid.get(i).get(j) != 0) {
                    count = 0;
                    DFS(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    private static void DFS(int s, int d) {
        grid.get(s).set(d, 0);
        count++;
        for (Pair neighbor : getNeighbors(s, d)) {
            if (grid.get(neighbor.a).get(neighbor.b) != 0) {
                DFS(neighbor.a, neighbor.b);
            }
        }
    }

    // * Build Neighbors
    private static List<Pair> getNeighbors(int row, int col) {
        List<Pair> neighbors = new ArrayList<>();
        if (row + 1 < grid.size()) {
            neighbors.add(new Pair(row + 1, col));
        }
        if (col + 1 < grid.get(0).size()) {
            neighbors.add(new Pair(row, col + 1));
        }
        if (row - 1 >= 0) {
            neighbors.add(new Pair(row - 1, col));
        }
        if (col - 1 >= 0) {
            neighbors.add(new Pair(row, col - 1));
        }
        return neighbors;
    }
}
