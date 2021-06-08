package learn.sorting;

import java.util.*;

public class Top_K_Frequent_Elements {
    public static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(map::get));

        for (Integer n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Integer e : map.keySet()) {
            queue.add(e);
            if (queue.size() > k) queue.remove();
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        System.out.print(find_top_k_frequent_elements(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2, 4, 3, 1, 5, 5, 5, 5, 5, 6, 4, 1)), 2));
    }
}
