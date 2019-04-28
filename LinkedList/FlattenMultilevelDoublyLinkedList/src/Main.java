import java.util.Stack;

public class Main {
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

class Solution {
    public Node flatten(Node head) {
        Stack<Node> backs = new Stack<>();
        Node n = head;
        while (n != null) {
            if (n.child != null) {
                if (n.next != null) {
                    backs.push(n.next);
                }
                n.next = n.child;
                n.child.prev = n;
                n.child = null;
            } else if (n.next == null && !backs.isEmpty()) {
                Node temp = backs.pop();
                n.next = temp;
                temp.prev = n;
            }
            n = n.next;
        }
        return head;
    }
}
