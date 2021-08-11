package learn.graphs;

import java.util.ArrayList;
import java.util.List;

public class FloodFill {

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, ArrayList<ArrayList<Integer>> image) {
        // Write your code here.
        int chosenColor = image.get(pixel_row).get(pixel_column);
        if (chosenColor == new_color) return image;
        DFS(pixel_row, pixel_column, chosenColor, new_color, image); 
        
        return image;
    }
    
    private static void DFS(int s, int d, int chosenColor, int new_color, ArrayList<ArrayList<Integer>> image) {
        image.get(s).set(d, new_color);
        for (Pair neighbor : getNeighbors(s, d, image)) {
            if (image.get(neighbor.a).get(neighbor.b) == chosenColor) {
                DFS(neighbor.a, neighbor.b, chosenColor, new_color, image);
            }
        }
    }
    
    private static List<Pair> getNeighbors(int r, int c, ArrayList<ArrayList<Integer>> image) {
        List<Pair> result = new ArrayList<>();
        if (r + 1 < image.size()) {
            result.add(new Pair(r + 1, c));
        }
        if (c + 1 < image.get(r).size()) {
            result.add(new Pair(r, c + 1));
        }
        if (r - 1 >= 0) {
            result.add(new Pair(r - 1, c));
        }
        if (c - 1 >= 0) {
            result.add(new Pair(r, c - 1));
        }
        return result;
    }

}
