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
    boolean result = true;
    int balancedDepth(TreeNode t) {
        int left, right;
        if (t.left == null) left = 0;
        else left = balancedDepth(t.left) + 1;
        if (t.right == null) right = 0;
        else right = balancedDepth(t.right) + 1;
        if (Math.abs(left - right) > 1) result = false;
        return left > right? left : right;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        balancedDepth(root);
        return result;
    }
}
