package helper;

import java.util.List;
import java.util.Random;

public class Helper {
    public static int[] convertIntegerListToArray(final List<Integer> list)
    {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int pickRandom(int start, int end) {
        Random rand = new Random();
        return rand.nextInt((end - start) + 1) + start;
    }

    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static int partition(int[] nums, int smallerIndex, int biggerIndex, int pivotElement, int start, int end) {
        for (int i = biggerIndex; i <= end;) {
            if (nums[i] <= pivotElement) {
                smallerIndex++;
                swap(nums, i, smallerIndex);
            }
            i++;
        }
        swap(nums, smallerIndex, start);
        return smallerIndex;
    }
}
