package learn.sorting;

import java.util.*;

public class HighFive {
    public static void main(String[] args) {
        int [][] res = highFive(new int[][] {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}});
        System.out.print(Arrays.deepToString(res));
    }

    private static int[][] highFive(int[][] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] num : nums) {
            if (map.containsKey(num[0])) {
                PriorityQueue<Integer> heap = map.get(num[0]);
                heap.add(num[1]);
                if(heap.size() > 5) heap.remove();
            } else {
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                heap.add(num[1]);

                map.put(num[0], heap);
            }
        }

        int k = 0;
        int[][] res = new int[map.size()][2];
        for (int id : map.keySet()) {
            int sum = 0;
            while(!map.get(id).isEmpty()) {
                sum += map.get(id).remove();
            }
            int[] temp = new int[2];
            temp[0] = id;
            temp[1] = sum / 5;
            res[k] = temp;
            k++;
        }
        return res;
    }
}
