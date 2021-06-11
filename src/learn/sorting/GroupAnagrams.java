package learn.sorting;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.print(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String s : strs) {
            String key = sortChars(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else map.put(key, new ArrayList<>(Collections.singletonList(s)));
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    private static String sortChars(String s) {
        char[] strArr = s.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}
