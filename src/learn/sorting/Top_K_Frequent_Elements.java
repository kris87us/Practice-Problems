package learn.sorting;

import java.util.*;

import static helper.Helper.*;

public class Top_K_Frequent_Elements {

    public static ArrayList<Integer> find_top_k_quickselect(ArrayList<Integer> arr, Integer k) {
        int[] nums = arr.stream().mapToInt(Integer::intValue).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] newArr = map.keySet().stream().mapToInt(Integer::intValue).toArray();

        int index = quickSelectHelper(newArr, 0, newArr.length - 1, newArr.length - k, map);
        for (int i = index; i <= newArr.length - 1; i++) {
            res.add(newArr[i]);
        }
        return res;
    }

    private static int quickSelectHelper(int[] nums, int start, int end, int index, Map<Integer, Integer> map) {
        if (start == end) return -1; // At-most 1 sub-problem

        int pivot = pickRandom(start, end);
        swapArray(nums, start, pivot);
        int newPivot = map.get(nums[start]);

        int smallerIndex = start;
        int biggerIndex = start + 1;
        for (int i = biggerIndex; i <= end;) {
            if (map.get(nums[i]) <= newPivot) {
                smallerIndex++;
                swapArray(nums, i, smallerIndex);
            }
            i++;
        }
        swapArray(nums, smallerIndex, start);

        if (index == smallerIndex) {
            return index;
        } else if (index < smallerIndex) {
            return quickSelectHelper(nums, 0, smallerIndex - 1, index, map);
        } else {
            return quickSelectHelper(nums, smallerIndex + 1, end, index, map);
        }
    }

    public static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
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
        System.out.print(find_top_k_quickselect(new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3)), 2));
    }
}
