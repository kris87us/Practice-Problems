package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(can_reach_last_house(new ArrayList<>(Arrays.asList(2, 3, 1, 0, 4, 7))));
    }

    // Time: O(n)
    // Space: O(1)
    static Boolean can_reach_last_house(ArrayList<Integer> maximum_jump_lengths) {
        int size = maximum_jump_lengths.size();
        int reachableIndex = 0;

        for (int i = 0; i < size; i++) {
            if (reachableIndex < i) { // If reachable index is less than the current index, then we know we can't go
                                      // ahead. Return false
                return false;
            }
            // Calculate MAX of the current reachableIndex and the maximum jump value from
            // current index.
            reachableIndex = Math.max(reachableIndex, i + maximum_jump_lengths.get(i));
        }
        return true;
    }

    // Bottom-up tabulation
    // Time: O(n^2)
    // Space: O(n)
    static Boolean can_reach_last_house_DP(ArrayList<Integer> maximum_jump_lengths) {
        int numberOfHouses = maximum_jump_lengths.size();
        boolean[] table = new boolean[numberOfHouses];

        // Base Case
        table[0] = true;

        // Recursive Case
        for (int houseNumber = 1; houseNumber < numberOfHouses; houseNumber++) {
            for (int i = houseNumber - 1; i >= 0; i--) {
                int houseDifference = houseNumber - i;
                if (table[i] && (maximum_jump_lengths.get(i) >= houseDifference)) {
                    table[houseNumber] = true;
                    break;
                }
            }
        }

        return table[numberOfHouses - 1];
    }
}
