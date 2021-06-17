package learn.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms_II {
    public static void main(String[] args) {
        System.out.print(meetingRoomsII(new int[][]{{1, 5}, {8, 9}, {8, 9}}));
    }

    private static int meetingRoomsII(int[][] ints) {
        Arrays.sort(ints, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(ints[0][1]);

        for (int i = 1; i < ints.length; i++) {
            int startTime = ints[i][0];
            int prevEndTime = minHeap.peek();
            if (startTime < prevEndTime) {
                minHeap.add(ints[i][1]);
            }
        }

        return minHeap.size();
    }
}
