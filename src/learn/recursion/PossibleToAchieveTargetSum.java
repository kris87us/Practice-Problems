package learn.recursion;

public class PossibleToAchieveTargetSum {
    public static void main(String[] args) {
        System.out.println(check_if_sum_possible(new long[] { 1000000000000L, 1000000000000L, 1000000000000L }, 1000000000000L));
    }

    static boolean check_if_sum_possible(long[] arr, long k) {
        int count = 0;
        return helper(arr, 0, k, 0, count);
    }

    // Time: O(n * 2^n)
    // Space: O(n * 2^n)
    // Can be optimized to NOT use result or slate
    /* private static void helper(long[] arr, int index, List<Long> slate, long target, List<List<Long>> result) {
        // Base case
        if (result.size() > 0) {
            return;
        }

        Long sum = slate.stream().mapToLong(Long::longValue).sum();
        if (sum == target && slate.size() > 0) {
            result.add(new ArrayList<>(slate));
            return;
        } else if (index == arr.length) {
            return;
        }
        // Recursive case
        int count = 0;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                break;
            }
            count++;
        }
        // Exclude
        helper(arr, index + count, slate, target, result);
        // Include
        for (int i = 0; i < count; i++) {
            slate.add(arr[index]);
            helper(arr, index + count, slate, target, result);
        }
        for (int i = 0; i < count; i++) {
            slate.remove(slate.size() - 1);
        }
    } */

    // Time: O(n * 2^n)
    // Space: O(n)
    private static boolean helper(long[] arr, int index, long target, long runningSum, int count) {
        // Backtracking case
        if (runningSum == target && count > 0) {
            return true;
        }
        // Base case
        if (index == arr.length) {
            return false;
        }

        // Include
        if(helper(arr, index + 1, target, runningSum + arr[index], count + 1)) {
            return true;
        }

        // Exclude
        return helper(arr, index + 1, target, runningSum, count);
    }
}
