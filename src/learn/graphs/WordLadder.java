package learn.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        
        return BFS(beginWord, endWord, wordList, set);
    }

    private static int BFS(String beginWord, String endWord, List<String> wordList, Set<String> set) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            // Loop through nodes at each BFS level
            for (int j = 0; j < len; j++) {
                String word = q.poll();
                char[] word_arr = word.toCharArray();
                // Loop through each char of the word
                for (int i = 0; i < word_arr.length; i++) {
                    char original_char = word_arr[i];
                    // Loop through a-z to try to replace one char at a time in the word to compare
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word_arr[i]) {
                            continue;
                        }
                        word_arr[i] = c;
                        String new_word = String.valueOf(word_arr);
                        if (new_word.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(new_word)) {
                            set.remove(new_word);
                            q.offer(new_word);
                        }
                    }
                    // Replace the char back to continue BFS on the next char
                    word_arr[i] = original_char;
                }
            }
            level++;
        }
        return 0;
    }
}
