package learn.linkedlist;

import models.ListNode;

public class AddTwoNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0L;
        long num2 = 0L;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        int i = 0;
        while (l1 != null) {
            long power = (long) Math.pow(10, i);
            num1 += l1.val * power;
            i++;
            l1 = l1.next;
        }
        int j = 0;
        while (l2 != null) {
            long power = (long) Math.pow(10, j);
            num2 += l2.val * power;
            j++;
            l2 = l2.next;
        }
        long sum = num1 + num2;

        if (sum == 0) return new ListNode(0);
        while (sum > 0) {
            long temp = sum % 10;
            result.next = new ListNode((int) temp);
            result = result.next;
            sum /= 10;
        }
        return dummy.next;
    }
}
