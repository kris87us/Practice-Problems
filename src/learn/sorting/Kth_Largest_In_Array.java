package learn.sorting;

import java.util.List;

import static helper.Helper.*;

// Time: O(n)
// Space: O(n)
public class Kth_Largest_In_Array {
    public static void main(String[] args) {
        System.out.print(kth_largest_in_an_array(List.of(4,5,1,2,9), 2));
    }

    public static int kth_largest_in_an_array(List<Integer> numbers, int k) {
        return quickSelectHelper(numbers.stream().mapToInt(Integer::intValue).toArray(),
                0, numbers.size() - 1, numbers.size() - k);
    }

    private static int quickSelectHelper(int[] nums, int start, int end, int index) {
        if (start == end) return -1; // At-most 1 sub-problem

        int pivot = pickRandom(start, end);
        swap(nums, start, pivot);
        int newPivot = nums[start];

        int finalPivot = partition(nums, start, start + 1, newPivot, start, end);

        if (index == finalPivot) {
            return nums[index];
        } else if (index < finalPivot) {
            return quickSelectHelper(nums, 0, finalPivot - 1, index);
        } else {
            return quickSelectHelper(nums, finalPivot + 1, end, index);
        }
    }
}
