package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        leftRotation(new int[]{1,2,3,4,5}, 2);
    }

    private static void leftRotation(int[] input, int d) {
        int count = 1;
        while (count <= d) {
            int temp = input[0];
            for (int i = 0; i < input.length - 1; i++) {
                input[i] = input[i + 1];
            }
            input[input.length - 1] = temp;
            count++;
        }
        System.out.println(Arrays.toString(input));
    }

    private static List<Integer> leftRotation(List<Integer> input, int d) {
        int count = 1;
        while (count <= d) {
            int temp = input.get(0);
            for (int i = 0; i < input.size() - 1; i++) {
                input.set(i, input.get(i + 1));
            }
            input.set(input.size() - 1, temp);
            count++;
        }
        return input;
    }
}
