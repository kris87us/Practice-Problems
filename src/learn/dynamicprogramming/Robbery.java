package learn.dynamicprogramming;

public class Robbery {
    public static void main(String[] args) {
        System.out.println(maxStolenValue(new int[] {6, 1, 2, 7}));
    }

    private static int maxStolenValue(int[] values) {
        int[] table = new int[values.length + 1];
        // Base case
        table[0] = 0;
        // Till second house, the max stolen value will be value of the house itself 
        // (Since two adjacent house can't be stolen)
        for (int i = 1; i <= 2; i++) {
            // Edge case if length of input is 1
            if (i <= values.length) {
                table[i] = values[i - 1];
            }
        }

        // DP case
        for (int i = 3; i < table.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - 2; j >= 0; j--) {
                max = Math.max(max, table[j]);
            }
            table[i] = max + values[i - 1];
        }

        // Calculate maximum value from the table array.
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < table.length; j++) {
            if (table[j] > max) {
                max = table[j];
            }    
        }
        return max;
    }
}
