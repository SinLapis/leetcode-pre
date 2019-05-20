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
    int depth(TreeNode t, int currentDepth) {
        if (t == null) return 0;
        int leftDepth, rightDepth;
        leftDepth = depth(t.left, currentDepth + 1);
        rightDepth = depth(t.right, currentDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }
}
