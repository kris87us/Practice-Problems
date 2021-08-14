package learn.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class StringTransformation_aka_WordLadder2 {

    static Set<String> wordSet;
    static int wordsLength = 0;

    static class Node {
        String word;
        Node parent;
        public Node(String word) {
            this.word = word;
        }
        public Node(String word, Node parent) {
            this.word = word;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        System.out.println("1: "+ Arrays.toString(string_transformation(new String[] { "aaa" }, "baa", "aab")));
        System.out.println("2: "+ Arrays.toString(string_transformation(new String[] { "cat", "hat", "bad", "had" }, "bat", "had")));
        System.out.println("3: "+ Arrays.toString(string_transformation(new String[] { }, "bbb", "bbc")));
        System.out.println("4: "+ Arrays.toString(string_transformation(new String[] { }, "zzzzzz", "zzzzzz")));
        System.out.println("5: "+ Arrays.toString(string_transformation(new String[] { "cccw", "accc", "accw" }, "cccc", "cccc")));
    }

    static String[] string_transformation(String[] words, String start, String stop) {
        wordsLength = words.length;
        // Constant time lookup
        wordSet = new HashSet<>();
        for (String s : words) {
            wordSet.add(s);
        }
        wordSet.add(start);
        wordSet.add(stop);

        List<String> res = BFS(start, stop);
        
        Collections.reverse(res);
        if (res.isEmpty()) return new String[] { "-1"};

        return res.toArray(new String[0]);
    }

    private static List<String> BFS(String start, String stop) {
        List<String> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start));

        while (!q.isEmpty()) {
            Node node = q.poll();
            Set<String> neighbors = new HashSet<>();
            // If time complexity of getNeighbors is O(m^2 * n) 
            // [ no. of words in the list is small but length of each word could be long]
            if (wordsLength <= 26 * start.length()) {
                neighbors = getNeighbors1(node.word, wordSet);
            } else {
                // If time complexity of getNeighbors is O(n^2 * m) 
                // [ no. of words in the list is big but length of each word could be short]
                neighbors = getNeighbors2(node.word, wordSet);
            }
            for (String neighbor : neighbors) {
                Node newNode = new Node(neighbor, node);
                // If start == stop, we need atleast one entry in the Set for futher processing
                if (start != stop) {
                    wordSet.remove(neighbor); // Mark processed
                }
                if (neighbor.equals(stop)) {
                    constructResult(newNode, result);
                    return result;
                }
                q.offer(newNode);
            }
        }
        return result;
    }

    private static void constructResult(Node neighbor, List<String> result) {
        while (neighbor != null) {
            result.add(neighbor.word);
            neighbor = neighbor.parent;
        }
    }

    private static Set<String> getNeighbors1(String word, Set<String> words) {
        Set<String> neighbors = new HashSet<>();
        for (String w : words) {
            int diff = 0;
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) != word.charAt(i)) {
                    diff++;
                }
            }
            if (diff == 1)
                neighbors.add(w);
        }
        return neighbors;
    }

    private static Set<String> getNeighbors2(String word, Set<String> words) {
        Set<String> neighbors = new HashSet<>();
        char[] word_arr = word.toCharArray();
        // Loop through each char of the word
        for (int i = 0; i < word_arr.length; i++) {
            // Loop through a-z to try to replace one char at a time in the word to compare
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word_arr[i]) {
                    continue;
                }
                char original_char = word_arr[i];
                word_arr[i] = c;
                String new_word = String.valueOf(word_arr);
                if (words.contains(new_word)) {
                    neighbors.add(new_word);
                }
                // Replace the char back to continue BFS on the next char
                word_arr[i] = original_char;
            }
        }
        return neighbors;
    }
}
