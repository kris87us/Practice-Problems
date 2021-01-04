package learn;

import java.util.*;

public class StacksQueue {

    // Write your code here.
    LinkedList ds;

    StacksQueue() {
        ds = new LinkedList();
    }

    void pushCharacter(char c) {
        ds.addFirst(c);
    }

    void enqueueCharacter(char c) {
        ds.addLast(c);
    }

    char popCharacter() {
        return (char) ds.remove(ds.size() - 1);
    }

    char dequeueCharacter() {
        return (char) ds.remove(0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        StacksQueue p = new StacksQueue();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }
}
