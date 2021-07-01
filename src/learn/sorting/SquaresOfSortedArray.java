package learn.sorting;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        System.out.print(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        // Find boundary of negative and positive number
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
        }

        int start = i - 1;
        int end = i;

        int j = 0;
        while (start >= 0 && end < nums.length) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];
            if (startSquare <= endSquare) {
                res[j] = startSquare;
                start--;
            } else {
                res[j] = endSquare;
                end++;
            }
            j++;
        }

        while (start >= 0) {
            res[j++] = nums[start] * nums[start];
            start--;
        }
        while (end < nums.length) {
            res[j++] = nums[end] * nums[end];
            end++;
        }
        return res;
    }
}
