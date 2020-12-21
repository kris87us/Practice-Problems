package learn;

import java.util.*;

public class JavaLearn {
    public static void main(String[] args) {

        int num = 5;
        int people = 5;
        int sum = 0;

        for(int i = 0; i < num; i++){
            people = (int) Math.floor(people/2);
            sum += people;
            people *= 3;
        }
        System.out.println(isAnagram( "madam", "adamm"));
        String s = "He is a very very good boy, isn't he?";
        String[] split = s.split("[A-Za-z !,?._'@]+");
        System.out.println(split.length);
        for (String each: split) {
            System.out.println(each);
        }
    }

    public static String reverse(String s) {
        StringBuilder string = new StringBuilder();
        for (int i=s.length() - 1; i>=0 ; i--) {
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
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        return false;
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        SortedSet<String> sets=new TreeSet<String>();
        for(int i=0;i<=s.length()-k;i++){
            sets.add(s.substring(i,i+k));
        }
        return sets.first() + "\n" + sets.last();
    }

    public static int[] bubbleSortArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    public static Character firstNonRepeatedCharacter(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character s : str.toCharArray()) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Character s : str.toCharArray()) {
            if (map.get(s) == 1) return s;
        }
        return null;
    }
}
