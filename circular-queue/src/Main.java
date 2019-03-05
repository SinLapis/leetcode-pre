import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {
    private List<Integer> circularQueue;
    private int head = 0;
    private int tail = 0;
    private int length;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        circularQueue = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            circularQueue.add(-1);
        }
        length = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (circularQueue.get(tail) == -1) {
            circularQueue.set(tail, value);
            tail = (tail + 1) % length;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (circularQueue.get(head) != -1) {
            circularQueue.set(head, -1);
            head = (head + 1) % length;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return circularQueue.get(head);
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return circularQueue.get((tail - 1 + length) % length);
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return circularQueue.get(head) == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return circularQueue.get(tail) != -1;
    }
}

/*
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
public class Main {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.deQueue();
        int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
    }
}