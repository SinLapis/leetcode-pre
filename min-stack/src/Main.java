import java.util.ArrayList;
import java.util.List;

class MinStack {

    /**
     * initialize your data structure here.
     */
    private List<Integer> stack = new ArrayList<>();
    private int topPointer = -1;

    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
        topPointer++;
    }

    public void pop() {
        if (topPointer >= 0) {
            stack.remove(topPointer);
            topPointer--;
        }
    }

    public int top() {
        return stack.get(topPointer);
    }

    public int getMin() {
        int min = stack.get(0);
        for (int i = 1; i <= topPointer; i++) {
            if (stack.get(i) < min) {
                min = stack.get(i);
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class Main {

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(1);
        m.push(-2);
        m.push(3);
        m.getMin();
        m.pop();
        m.pop();
        m.getMin();
    }
}
