package learn.other;

public class PushAllZeroesToEnd {
    public static void main(String[] args) {
        pushAllZeroes(new int[]{1, 2, 0, 4, 0, 6, 0});
    }

    public static void pushAllZeroes(int[] input) {
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                input[count++] = input[i];
            }
        }
        while (count < input.length) {
            input[count++] = 0;
        }
    }
}
