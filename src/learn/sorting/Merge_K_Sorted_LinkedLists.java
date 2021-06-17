package learn.sorting;

import models.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Merge_K_Sorted_LinkedLists {
    public static void main(String[] args) {
        SinglyLinkedListNode res = merge_k_lists(List.of(
                new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, new SinglyLinkedListNode(5))),
                new SinglyLinkedListNode(3, new SinglyLinkedListNode(4)),
                new SinglyLinkedListNode(7))
        );
        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add head element of each LL
        for (ListNode list : lists) {
            if (list != null) heap.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (!heap.isEmpty()) {
            ListNode smallest = heap.remove();
            head.next = new ListNode(smallest.val);

            smallest = smallest.next;
            if (smallest != null) {
                heap.add(smallest);
            }
            head = head.next;
        }

        return dummy.next;
    }

    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode head = dummy;

        for (SinglyLinkedListNode list : lists) {
            while (list != null) {
                heap.add(list.data);
                list = list.next;
            }
        }

        while (!heap.isEmpty()) {
            int smallest = heap.remove();
            head.next = new SinglyLinkedListNode(smallest);
            head = head.next;
        }

        return dummy.next;
    }

    static class SinglyLinkedListNode {
        public final int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
