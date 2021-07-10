package learn.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        // Create a heap that has character and frequency as KV pair and is sorted by frequency in DESC order
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // Create map with character and frequency
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        } 
        
        // Add elements to the heap
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            heap.offer(e);
        }
        
        // Create output String
        StringBuilder res = new StringBuilder();
        
        while(!heap.isEmpty()) {
            // Poll root of heap
            Map.Entry<Character, Integer> first = heap.poll();
            // Check if result is empty OR if last added char is NOT same as this current character
            if ((res.length() == 0) || (first.getKey() != res.charAt(res.length() - 1))) {
                res.append(first.getKey()); // Add to result string
                first.setValue(first.getValue() - 1); // Decrement frequency after adding the character to the string
                
                // Re-add the Map back to the heap if the frequency is not 0
                if (first.getValue() != 0) {
                    heap.offer(first);
                }
            } else {
                // Poll root of heap
                Map.Entry<Character, Integer> second = heap.poll();
                if (second == null) {
                    return ""; // Not a valid string, cannot be arranged uniquely
                }
                res.append(second.getKey());
                second.setValue(second.getValue() - 1);
                
                // Re-add the Map back to the heap if the frequency is not 0
                if (second.getValue() != 0) {
                    heap.offer(second);
                }
                // Re-add the removed element in first/initial case on L22
                heap.offer(first); 
            }
        }
        return res.toString();
    }
}
