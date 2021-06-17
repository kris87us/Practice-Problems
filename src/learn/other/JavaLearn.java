package learn.other;

import java.util.*;

public class JavaLearn {
    public static void main(String[] args) {

        int num = 5;
        int people = 5;
        int sum = 0;

        for (int i = 0; i < num; i++) {
            people = (int) Math.floor(people / 2);
            sum += people;
            people *= 3;
        }
        System.out.println(destCity(Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sau Paulo"))));
    }

    public static String destCity(List<List<String>> paths) {
        if (paths == null || paths.size() == 0) return "";
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        for (String city : map.values()) {
            if (!map.containsKey(city)) {
                return city;
            }
        }
        return "";
    }

    public static String reverse(String s) {
        StringBuilder string = new StringBuilder();
        List<String> f = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            string.append(s.charAt(i));
        }
        return string.toString();
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        char[] arr1 = a.toLowerCase().toCharArray();
        char[] arr2 = b.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        SortedSet<String> sets = new TreeSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            sets.add(s.substring(i, i + k));
        }
        return sets.first() + "\n" + sets.last();
    }

    public static Character firstNonRepeatedCharacter(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character s : str.toCharArray()) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Character s : str.toCharArray()) {
            if (map.get(s) == 1) return s;
        }
        return null;
    }
}
