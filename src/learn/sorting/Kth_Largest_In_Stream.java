package learn.sorting;

import java.util.*;

import static helper.Helper.*;

public class Kth_Largest_In_Stream {
    public static void main(String[] args) {
        System.out.print(kth_largest_In_A_Stream_Using_Heap(3, List.of(3, 2, 1), List.of(4,4,5)));
    }

    public static List<Integer> kth_largest_In_A_Stream_Using_Heap(int k, List<Integer> initial_stream, List<Integer> append_Stream) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        List<Integer> result = new ArrayList<>();

        // Add initial_stream to minHeap
        for (int n : initial_stream) {
            minHeap.add(n);
            if (minHeap.size() > k) minHeap.remove();
        }

        // Add append_stream to queue
        Queue<Integer> queue = new LinkedList<>(append_Stream);

        while (!queue.isEmpty()) {
            minHeap.add(queue.remove());
            if (minHeap.size() > k) {
                minHeap.remove();
            }
            result.add(minHeap.peek());
        }
        Collections.sort(result);
        return result;
    }

    public static List<Integer> kth_largest_in_a_stream(int k, List<Integer> initial_stream, List<Integer> append_Stream) {
        List<Integer> input = new ArrayList<>(initial_stream);
        List<Integer> result = new ArrayList<>();
        for (int n : append_Stream) {
            input.add(n);
            Integer runningKthLargest = quickSelect(input.stream().mapToInt(Integer::intValue).toArray(),
                    0, input.size() - 1, input.size() - k);
            result.add(runningKthLargest);
        }
        return result;
    }

    private static int quickSelect(int[] nums, int start, int end, int index) {
        if (start > end) return -1; // At-most 1 sub-problem

        int pivot = pickRandom(start, end);
        swapArray(nums, start, pivot);
        int newPivot = nums[start];

        int finalPivot = twoWayPartition(nums, start, start + 1, newPivot, start, end);

        if (index == finalPivot) {
            return nums[index];
        } else if (index < finalPivot) {
            return quickSelect(nums, 0, finalPivot - 1, index);
        } else {
            return quickSelect(nums, finalPivot + 1, end, index);
        }
    }
}
