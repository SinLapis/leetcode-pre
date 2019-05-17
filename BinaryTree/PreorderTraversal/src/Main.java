
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer>
        TreeNode next;
        queue.add(root);
        while (!queue.isEmpty()) {

        }
    }
}