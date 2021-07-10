package learn.sorting;

import java.util.*;

class MyComparator implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        String word1 = e1.getKey();
        int freq1 = e1.getValue();
        String word2 = e2.getKey();
        int freq2 = e2.getValue();
        if (freq1 != freq2) {
            return freq1 - freq2;
        } else {
            return word2.compareTo(word1);
        }
    }
}

public class Top_K_Frequent_Words {

    public static void main(String[] args) {
        System.out.print(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
    }

    @SuppressWarnings("unchecked")
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>((a, b) -> b.compareTo(a));
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Map.Entry<String, Integer>[] entries = new Map.Entry[map.size()];
        int index = 0;
        for(Map.Entry<String, Integer> e:map.entrySet()){
            entries[index] = e;
            index++;
        }

        MyComparator myComparator = new MyComparator();

        // Run Quickselect to find Kth index
        quickSelectHelper(entries, 0, entries.length - 1, entries.length - k, myComparator);

        // Construct output
        List<String> res = new ArrayList<>();
        int i = entries.length - 1;
        int count = 0;
        while (count < k) {
            res.add(entries[i].getKey());
            i--;
            count++;
        }
        return res;
    }

    public static void quickSelectHelper(Map.Entry<String, Integer>[] uniqueWords, int start, int end, int k, MyComparator myComparator) {
        if (start == end) return;
        int pivot = (start + end) / 2;
        swap(uniqueWords, start, pivot);
        Map.Entry<String, Integer> pivotFreq = uniqueWords[start];

        int smaller = start;
        int bigger = start + 1;
        while (bigger <= end) {
            if (myComparator.compare(uniqueWords[bigger], pivotFreq) < 0) {
                smaller++;
                swap(uniqueWords, smaller, bigger);
            }
            bigger++;
        }
        swap(uniqueWords, start, smaller);

        if (k == smaller) return;
        else if (k < smaller) {
            quickSelectHelper(uniqueWords, start, smaller - 1, k, myComparator);
        } else if (k > smaller) {
            quickSelectHelper(uniqueWords, smaller + 1, end, k, myComparator);
        }
    }

    private static void swap(Map.Entry<String, Integer>[] entries, int i, int j){
        Map.Entry<String, Integer> a = entries[i];
        entries[i] = entries[j];
        entries[j] = a;
    }
}
