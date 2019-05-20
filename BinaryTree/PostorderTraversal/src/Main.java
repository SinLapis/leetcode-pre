import java.util.*;

public class Main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    void traverse(TreeNode node, List<Integer> l) {
        if (node.left != null) traverse(node.left, l);
        if (node.right != null) traverse(node.right, l);
        l.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root != null) traverse(root, l);
        return l;
    }
}

class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> visited = new ArrayList<>();
        TreeNode next;
        stack.push(root);
        while (!stack.isEmpty()) {
            next = stack.peek();
            if (!visited.contains(next)) {
                visited.add(next);
                if (next.left != null) {
                    stack.push(next.left);
                }
            } else {
                if (next.right != null && !visited.contains(next.right)) {
                    stack.push(next.right);
                } else {
                    result.add(next.val);
                    stack.pop();
                }
            }
        }
        return result;
    }
}