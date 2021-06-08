package learn.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static List<Integer> two_sum(List<Integer> numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) { // 5, 4, 10, 15,
            int num2 = target - numbers.get(i); // 1, 2, -4, -9
            if (map.containsKey(num2)) { // No, No, No, No
                result.add(i);
                result.add(map.get(num2));
                map.remove(num2);
                return result;
            } else {
                map.put(numbers.get(i), i); // 5, 0 | 4, 1 | 10, 2 | 15, 3 |
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        System.out.print(two_sum(List.of(5,4,10,15,25, 1), 6));
    }

}
