package learn.linkedlist;

import models.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortLinkedList {
    public static void main(String[] args) {
        sortList(new ListNode(
                4, new ListNode(2, new ListNode(1, new ListNode(3, null)))
        ));
    }

    public static ListNode sortList(ListNode head) {

        ListNode curr = head;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        while (curr != null) {
            queue.add(curr);
            curr = curr.next;
        }

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            curr.next = null;
            prev.next = curr;
            prev = curr;
        }
        return dummy.next;
    }
}
