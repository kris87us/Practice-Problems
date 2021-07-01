package learn.sorting;

public class DutchNationalFlag {
    public static void main(String[] args) {
        System.out.print(dutch_flag_sort(new char[]{'R', 'G', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'R', 'R', 'R', 'R', 'R', 'R', 'R'}));
    }

    public static char[] dutch_flag_sort(char[] balls) {
        int start = 0;
        int end = balls.length - 1;

        int i = 0; // Running pointer
        while (i <= end) {
            if (balls[i] == 'R') {
                swap(balls, i, start);
                start++;
                i++;
            } else if (balls[i] == 'G') {
                i++;
            } else {
                swap(balls, i, end);
                end--;
            }
        }
        return balls;
    }

    private static void swap(char[] balls, int i, int j) {
        char temp = balls[i];
        balls[i] = balls[j];
        balls[j] = temp;
    }
}
