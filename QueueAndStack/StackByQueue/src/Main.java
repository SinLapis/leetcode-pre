import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int queueLen = q.size();
        int[] temp = new int[queueLen - 1];
        int i = 0;
        for (; i < queueLen - 1; i++) {
            if (!q.isEmpty()) {
                temp[i] = q.poll();
            }
        }
        int result;
        if (!q.isEmpty()) {
            result = q.poll();
        } else {
            return -1;
        }
        for (i = 0; i < queueLen - 1; i++) {
            q.add(temp[i]);
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int result = pop();
        q.add(result);
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}

public class Main {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(2);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
