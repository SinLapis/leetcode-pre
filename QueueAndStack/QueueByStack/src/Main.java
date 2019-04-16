import java.util.Stack;

class MyQueue {
    Stack<Integer> s = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int temp = s.pop();
        int result;
        if (s.isEmpty()) {
            return temp;
        } else {
            result = pop();
            s.push(temp);
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int temp = s.pop();
        int result;
        if (s.isEmpty()) {
            s.push(temp);
            return temp;
        } else {
            result = peek();
            s.push(temp);
        }
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s.isEmpty();
    }
}

public class Main {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.push(3);
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}
