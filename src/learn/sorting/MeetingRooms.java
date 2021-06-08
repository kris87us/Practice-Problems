package learn.sorting;

import java.util.*;

public class MeetingRooms {
    public static void main(String[] args) {
        System.out.print(meetingRooms(Arrays.asList(List.of(5, 8), List.of(1, 5), List.of(10, 15))));
    }

    private static boolean meetingRooms(List<List<Integer>> lists) {
        lists.sort(Comparator.comparingInt((List<Integer> a) -> a.get(0)));

        for (int i = 1; i < lists.size(); i++) {
            if (lists.get(i).get(0) < lists.get(i - 1).get(1)) return false;
        }
        return true;
    }
}
