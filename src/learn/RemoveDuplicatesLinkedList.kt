package learn

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

class RemoveDuplicatesLinkedList {

    fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
        // Write your code here.
        var head: LinkedList? = linkedList
        while (head != null) {
            while (head?.next != null) {
                if (head.next?.value == head.value) {
                    head.next = head.next?.next
                    head.next?.value = head.next?.next!!.value
                }
                head = head.next

            }
        }
        return linkedList
    }
}