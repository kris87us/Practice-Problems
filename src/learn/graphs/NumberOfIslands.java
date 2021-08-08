package learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands {
    static List<List<Integer>> matrix;

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static int count_islands(List<List<Integer>> matrix) {
        // * Outer Loop
        int numIslands = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) != 0) {
                    numIslands++;
                    DFS(i, j);
                }
            }
        }
        return numIslands;
    }
    
    // DFS
    private static void DFS(int s, int d) {
        matrix.get(s).set(d, 0);
        for (Pair neighbor : getNeighbors(s, d)) {
            if (matrix.get(neighbor.a).get(neighbor.b) != 0) {
                DFS(neighbor.a, neighbor.b);
            }
        }
    }
    
    // * Build Neighbors
    private static List<Pair> getNeighbors(int row, int col) {
        List<Pair> neighbors = new ArrayList<>();
        if (row + 1 < matrix.size()) {
            neighbors.add(new Pair(row + 1, col));
        }
        if (col + 1 < matrix.get(0).size()) {
            neighbors.add(new Pair(row, col + 1));
        }
        if (row - 1 >= 0) {
            neighbors.add(new Pair(row - 1, col));
        }
        if (col - 1 >= 0) {
            neighbors.add(new Pair(row, col - 1));
        }
        // Diagonals
        if ((row + 1 < matrix.size()) && (col + 1 < matrix.get(0).size())) {
            neighbors.add(new Pair(row + 1, col + 1));
        }
        if ((row - 1 >= 0) && (col - 1 >= 0)) {
            neighbors.add(new Pair(row - 1, col - 1));
        }
        if ((row + 1 < matrix.size()) && (col - 1 >= 0)) {
            neighbors.add(new Pair(row + 1, col - 1));
        }
        if ((row - 1 >= 0) && (col + 1 < matrix.get(0).size())) {
            neighbors.add(new Pair(row - 1, col + 1));
        }
        return neighbors;
    }

    private static void test1() {
        matrix = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            matrix.add(new ArrayList<>());
        }
        matrix.get(0).addAll(new ArrayList<>(Arrays.asList(0)));
        matrix.get(1).addAll(new ArrayList<>(Arrays.asList(1)));

        System.out.println(count_islands(matrix));
    }

    private static void test2() {
        matrix = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            matrix.add(new ArrayList<>());
        }
        matrix.get(0).addAll(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0)));
        matrix.get(1).addAll(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1)));
        matrix.get(2).addAll(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1)));
        matrix.get(3).addAll(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)));
        matrix.get(4).addAll(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1)));

        System.out.println(count_islands(matrix));
    }
}
