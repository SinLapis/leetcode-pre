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

class Solution1 {
    int depth(Node t, int currentDepth) {
        if (t == null) return 0;
        int leftDepth, rightDepth;
        leftDepth = depth(t.left, currentDepth + 1);
        rightDepth = depth(t.right, currentDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    void findNext(Node parent, Node current, boolean left) {
        if (left && parent.right != null) {
            current.next = parent.right;
        } else {
            Node t = parent;
            while (t.next != null) {
                t = t.next;
                if (t.left != null) {
                    current.next = t.left;
                    break;
                } else if (t.right != null) {
                    current.next = t.right;
                    break;
                }
            }
        }
    }

    void link(Node current, int currentLevel, int targetLevel) {
        if (currentLevel < targetLevel) {
            if (current.left != null) link(current.left, currentLevel + 1, targetLevel);
            if (current.right != null) link(current.right, currentLevel + 1, targetLevel);
        } else if (currentLevel == targetLevel) {
            if (current.left != null) findNext(current, current.left, true);
            if (current.right != null) findNext(current, current.right, false);
        }
    }

    public Node connect(Node root) {
        if (root != null) {
            int d = depth(root, 0);
            for (int i = 2; i <= d; i++) {
                link(root, 2, i);
            }
        }
        return root;
    }
}

class Solution {
    public Node connect(Node root) {
        Node head = root, t;
        while (true) {
            // 找头
            t = head;
            head = null;
            while (t != null) {
                if (t.left != null) {
                    head = t.left;
                    break;
                }
                if (t.right != null) {
                    head = t.right;
                    break;
                }
                t = t.next;
            }
            if (head == null) return root;
            // 兄弟连
            Node front = head;
            while (t != null) {
                if (t.left != null && t.left != head) {
                    front.next = t.left;
                    front = front.next;
                }
                if (t.right != null && t.right != head) {
                    front.next = t.right;
                    front = front.next;
                }
                t = t.next;
            }
        }
    }
}
