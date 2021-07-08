package datastructures;

class MyCircularQueue {

    int[] arr;
    int head;
    int tail;
    public MyCircularQueue(int k) {
        arr = new int[k];
        head = -1;
        tail = -1;
    }
    
    /**
     * Insert value from the end.
     * @param value
     * @return
     * false - Failed to add element to queue.
     * true - Successfully added to the queue.
     */
    public boolean enQueue(int value) {
        // Condition to check if queue is empty
        if (head == -1 && tail == -1) {
            head = tail = 0;
            arr[tail] = value;
            return true;
        } else if ((tail + 1) % arr.length == head) { // Check if queue is full
            return false;
        } else {
            tail = (tail + 1) % arr.length; // To maintain circular queue property, index needs to be MOD value
            arr[tail] = value;
            return true;
        }
    }
    
    /**
     * Remove element from the front.
     * 
     * @return
     * false - Unable to remove element.
     * true - able to remove element from the front. Here, the array value is not deleted, only the head pointer value is changed to avoid swapping and maintain O(1)
     */
    public boolean deQueue() {
        // Check if queue is empty
        if (head == -1 && tail == -1) {
            return false;
        } else if (head == tail) { // Check if queue has only one element
            head = tail = -1;
            return true;
        } else {
            head = (head + 1) % arr.length;
            return true;
        }
    }
    
    /**
     * Peek front of queue
     * 
     * @return front element in the queue
     */
    public int Front() {
        if (head == -1 && tail == -1) {
            return -1;
        }
        return arr[head];
    }
    
    /**
     * Peek at the end of the queue
     * @return the last element in the queue
     */
    public int Rear() {
        if (head == -1 && tail == -1) {
            return -1;
        }
        return arr[tail];
    }
    
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }
    
    public boolean isFull() {
        return ((tail + 1) % arr.length == head);
    }
}
