import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;
        Solution s = new Solution();
        Node r = s.copyRandomList(n1);
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newList = new Node();
        newList.val = head.val;
        Node newPoint = newList;
        Node oldPoint = head.next;
        List<Node> oldAddr = new ArrayList<>();
        List<Node> newAddr = new ArrayList<>();
        oldAddr.add(head);
        newAddr.add(newList);
        // 复制val
        while (oldPoint != null) {
            oldAddr.add(oldPoint);
            newPoint.next = new Node();
            newAddr.add(newPoint.next);
            newPoint.next.val = oldPoint.val;
            newPoint = newPoint.next;
            oldPoint = oldPoint.next;
        }
        // 找random index
        oldPoint = head;
        newPoint = newList;
        while (oldPoint != null) {
            if (oldPoint.random != null) {
                newPoint.random = newAddr.get(oldAddr.indexOf(oldPoint.random));
            }
            oldPoint = oldPoint.next;
            newPoint = newPoint.next;
        }
        return newList;
    }
}