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
    boolean pathSum(TreeNode t, int target) {
        target -= t.val;
        boolean leftPath = false, rightPath = false;
        if (t.left == null && t.right == null) return target == 0;
        if (t.left != null) leftPath = pathSum(t.left, target);
        if (t.right != null) rightPath = pathSum(t.right, target);
        return leftPath || rightPath;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return pathSum(root, sum);
    }
}
