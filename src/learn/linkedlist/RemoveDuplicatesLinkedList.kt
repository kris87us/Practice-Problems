package learn.linkedlist

import models.ListNode

class RemoveDuplicatesLinkedList {

    fun removeDuplicatesFromLinkedList(linkedList: ListNode): ListNode {
        // Write your code here.
        var head: ListNode? = linkedList
        while (head != null) {
            while (head?.next != null) {
                if (head.next?.`val` == head.`val`) {
                    head.next = head.next?.next
                    head.next?.`val` = head.next?.next!!.`val`
                }
                head = head.next

            }
        }
        return linkedList
    }
}