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

class Solution2 {
    void traverse(TreeNode node, List<Integer> l) {
        l.add(node.val);
        if (node.left != null) traverse(node.left, l);
        if (node.right != null) traverse(node.right, l);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root != null) traverse(root, l);
        return l;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> visited = new ArrayList<>();
        TreeNode next;
        stack.push(root);
        while (!stack.isEmpty()) {
            next = stack.peek();
            if (!visited.contains(next)) {
                result.add(next.val);
                visited.add(next);
                if (next.left != null) {
                    stack.push(next.left);
                }
            } else {
                stack.pop();
                if (next.right != null) {
                    stack.push(next.right);
                }
            }
        }
        return result;
    }
}