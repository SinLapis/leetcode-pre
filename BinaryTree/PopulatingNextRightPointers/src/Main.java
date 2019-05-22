public class Main {
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {

    void link(Node current) {
        if (current.left != null) {
            current.left.next = current.right;
            if (current.next != null) {
                current.right.next = current.next.left;
            }
        } else return;
        link(current.left);
        link(current.right);
    }

    public Node connect(Node root) {
        if (root != null) {
            link(root);
        }
        return root;
    }
}
