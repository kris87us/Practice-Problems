package learn.linkedlist;

import models.ListNode;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {

        reversePrint(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    static void reversePrint(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            // increment
            prev = curr;
            curr = temp;
        }
        ListNode newList = prev;

        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
}
